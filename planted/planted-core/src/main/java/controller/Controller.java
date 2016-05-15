package controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import exception.NotPermittedCommandException;
import interfaces.Command;
import interfaces.FileType;
import interfaces.IController;
import interfaces.IModel;
import interfaces.IParser;
import interfaces.IProject;
import interfaces.ISourceEntityImpl;
import interfaces.ISourceFile;
import interfaces.IView;
import model.JavaSourceFile;
import model.PlantSourceFile;
import model.Project;
import net.sourceforge.plantuml.SourceStringReader;
import parser.printer.JavaPrinter;
import parser.printer.PlantPrinter;
import utils.SysKB;

/**
 * Questa classe rappresenta un controller. Implementa l'interfaccia
 * <code>IController</code>.
 * 
 * @author ashleycaselli
 *
 */
public class Controller implements IController {

    private IView view;
    private IModel model;
    private IProject activeProject;
    private static IController instance = null;

    private Controller() {
	super();
    }

    public static synchronized IController getInstance() {
	if (instance == null) {
	    instance = new Controller();
	}
	return instance;
    }

    @Override
    public void setModel(IModel model) {
	this.model = model;
    }

    @Override
    public void setView(IView view) {
	this.view = view;
    }

    /**
     * Metodo per effettuare il caricamento dei dati attraverso il model.
     */
    @SuppressWarnings("unchecked")
    private void load() {
	FileInputStream fileIn;
	try {
	    fileIn = new FileInputStream(new File(SysKB.FILE_PATH));
	    this.model.load(fileIn);
	    fileIn.close();
	} catch (ClassNotFoundException | IOException e) {
	    e.printStackTrace();
	}
	for (IProject p : ((HashMap<Integer, IProject>) this.model).values()) {
	    this.view.addOutput(p);
	}
    }

    /**
     * Metodo per effettuare il salvataggio attraverso il model.
     */
    private void save() {
	FileOutputStream fileOut;
	try {
	    fileOut = new FileOutputStream(new File(SysKB.FILE_PATH));
	    this.model.save(fileOut);
	    fileOut.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Metodo per aggiungere un progetto al modello, con conseguente
     * aggiornamento della view.
     * 
     * @param project
     */
    private void addProject(IProject project) {
	if (this.model.addData(project)) {
	    this.view.addOutput(project);
	    this.save();
	    this.selectProject(project.getName());
	    this.clearAllView();
	}
    }

    /**
     * Metodo per aggiungere un file sorgente, con conseguente aggiornamento
     * della view.
     * 
     * @param filename
     *            nome del file sorgente
     * @param fileType
     *            tipo del file sorgente
     * @param content
     *            contenuto del file sorgente
     */
    private void addSourceFile(String filename, FileType fileType, String content) {
	ISourceFile file = null;
	switch (fileType) {
	case PLANTUML:
	    file = new PlantSourceFile(filename.toLowerCase());
	    break;
	case JAVA:
	    file = new JavaSourceFile(filename);
	    break;
	}
	if (content != null && !content.isEmpty()) {
	    file.setContent(content);
	}
	if (this.activeProject != null && this.model.addData(file, activeProject)) {
	    this.view.addOutput(file);
	    this.save();
	}
    }

    /**
     * Metodo per selezionare il progetto attivo, con conseguente aggiornamento
     * della view.
     * 
     * @param proj
     *            progetto attivo
     */
    private void selectProject(String proj) {
	if (this.activeProject != null) {
	    if (!this.activeProject.getName().equals(proj)) {
		this.activeProject = new Project(proj);
		this.view.setTitle(this.activeProject.toString());
	    }
	} else {
	    this.activeProject = new Project(proj);
	    this.view.setTitle(this.activeProject.toString());
	}
	this.clearAllView();
	int tmpHash = this.activeProject.hashCode();
	@SuppressWarnings("unchecked")
	IProject p = ((HashMap<Integer, IProject>) this.model).get(tmpHash);
	p.getSrcFiles().forEach(f -> this.view.addOutput(f));
    }

    /**
     * Metodo per rimuovere un file sorgente dal modello con successivo
     * aggiornarmento della view.
     * 
     * @param entity
     *            file sorgente da rimuovere
     */
    private void removeSourceFile(ISourceEntityImpl entity) {
	this.model.removeData(entity, activeProject);
	this.clearAllView();
	int tmpHash = this.activeProject.hashCode();
	@SuppressWarnings("unchecked")
	IProject p = ((HashMap<Integer, IProject>) this.model).get(tmpHash);
	p.getSrcFiles().forEach(f -> this.view.addOutput(f));
	this.save();
    }

    /**
     * Metodo per aprire l'editor nella view.
     * 
     * @param entity
     *            entità da inserire all'interno dell'editor
     */
    private void openEditor(ISourceEntityImpl entity) {
	this.view.openEditor(entity);
    }

    @Override
    public void execCommand(Command cmd, ISourceEntityImpl entity) throws NotPermittedCommandException {
	switch (cmd) {
	case ADD_PROJECT:
	    this.addProject((IProject) entity);
	    break;
	case OPEN_EDITOR:
	    this.openEditor(entity);
	    break;
	case REMOVE_SOURCE_FILE:
	    this.removeSourceFile(entity);
	    break;
	default:
	    throw new NotPermittedCommandException();
	}
    }

    @SuppressWarnings("unchecked")
    private void removeProject() {
	this.model.removeData(activeProject);
	this.save();
	this.clearAllView();
	this.view.clearTree();
	for (IProject p : ((HashMap<Integer, IProject>) this.model).values()) {
	    this.view.addOutput(p);
	}
	this.view.setTitle(null);
    }

    @Override
    public void execCommand(Command cmd, String... params) throws NotPermittedCommandException {
	switch (cmd) {
	case SELECT_PROJECT:
	    this.selectProject(params[0]);
	    break;
	default:
	    throw new NotPermittedCommandException();
	}
    }

    @Override
    public void execCommand(Command cmd) throws NotPermittedCommandException {
	switch (cmd) {
	case LOAD:
	    this.load();
	    break;
	case SAVE:
	    this.save();
	    break;
	case REMOVE_PROJECT:
	    this.removeProject();
	    break;
	case CLEAR_DIAGRAM:
	    this.clearDiagram();
	    break;
	default:
	    throw new NotPermittedCommandException();
	}
    }

    /**
     * Metodo per pulire i diagrammi nella view.
     */
    private void clearDiagram() {
	this.view.clearDiagram();
    }

    @Override
    public void execCommand(Command cmd, ISourceEntityImpl entity, String content) throws NotPermittedCommandException {
	switch (cmd) {
	case SAVE_EDITOR:
	    this.saveEditor(entity, content);
	    break;
	default:
	    throw new NotPermittedCommandException();
	}
    }

    /**
     * Metodo per effettuare il salvataggio dell'editor.
     * 
     * @param entity
     *            entità da salvare
     * @param content
     *            contenuto da salvare
     */
    private void saveEditor(ISourceEntityImpl entity, String content) {
	((ISourceFile) entity).setContent(content);
	this.save();
    }

    @Override
    public void execCommand(Command cmd, ISourceFile srcFile) throws NotPermittedCommandException {
	switch (cmd) {
	case GENERATE_DIAGRAM:
	    this.generateDiagram(srcFile);
	    break;
	case EXPORT_DIAGRAM:
	    this.exportDiagram(srcFile);
	    break;
	default:
	    throw new NotPermittedCommandException();
	}
    }

    /**
     * Metodo per esportare il diagramma.
     * 
     * @param srcFile
     *            file sorgente
     */
    private void exportDiagram(ISourceFile srcFile) {
	OutputStream png = null;
	File f = new File(SysKB.EXPORT_PATH + activeProject.getName() + SysKB.DIR_SEPARATOR + SysKB.DIAGRAM_PATH);
	f.mkdirs();
	f = new File(f + SysKB.DIR_SEPARATOR + srcFile.getName() + ".png");
	try {
	    png = new FileOutputStream(f);
	    String source = srcFile.getContent();
	    SourceStringReader reader = new SourceStringReader(source);
	    reader.generateImage(png);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	this.view.addOutput("Diagram exported to: " + f.getPath());
    }

    /**
     * Metodo per generare il diagramma.
     * 
     * @param srcFile
     *            file sorgente
     */
    private void generateDiagram(ISourceFile srcFile) {
	OutputStream png = null;
	File f = new File("_tmp");
	try {
	    png = new FileOutputStream(f);
	    String source = srcFile.getContent();
	    SourceStringReader reader = new SourceStringReader(source);
	    String desc = reader.generateImage(png);
	    Image image = null;
	    if (desc != null && !desc.equals("(Error)")) {
		image = ImageIO.read(new File("_tmp"));
	    }
	    this.view.addOutput(image);
	    f.delete();
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
    }

    @Override
    public void execCommand(Command cmd, ISourceFile srcFile, FileType fileType) throws NotPermittedCommandException {
	switch (cmd) {
	case EXPORT_CODE:
	    this.exportCode(cmd, srcFile, fileType);
	    break;
	default:
	    throw new NotPermittedCommandException();
	}
    }

    /**
     * Metodo per esportazione del codice.
     * 
     * @param cmd
     *            comando da eseguire
     * @param srcFile
     *            file sorgente
     * @param fileType
     *            tipo del file sorgente
     * @throws NotPermittedCommandException
     */
    private void exportCode(Command cmd, ISourceFile srcFile, FileType fileType) throws NotPermittedCommandException {
	IParser parser;
	PrintWriter out = null;
	File dirProj = new File(SysKB.EXPORT_PATH + activeProject.getName());
	File f = null;
	dirProj.mkdirs();
	if (srcFile.getFileType().equals(fileType)) {
	    f = new File(dirProj + SysKB.DIR_SEPARATOR + srcFile.getName() + fileType.getExtension());
	    try {
		out = new PrintWriter(f);
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
	    out.write(srcFile.getContent());
	    out.close();
	} else {
	    switch (fileType) {
	    case JAVA:
		parser = new JavaPrinter();
		List<String> list = parser.parse(srcFile.getContent(), srcFile.getFileType());
		for (int i = 0; i < list.size(); i = i + 2) {
		    f = new File(dirProj + SysKB.DIR_SEPARATOR + list.get(i) + fileType.getExtension());
		    try {
			out = new PrintWriter(f);
		    } catch (FileNotFoundException e) {
			e.printStackTrace();
		    }
		    out.write(list.get(i + 1));
		    out.close();
		}
		break;
	    case PLANTUML:
		parser = new PlantPrinter();
		System.out.println(parser.parse(srcFile.getContent(), srcFile.getFileType()));
		List<String> list2 = parser.parse(srcFile.getContent(), srcFile.getFileType());
		for (int i = 0; i < list2.size(); i = i + 2) {
		    f = new File(dirProj + SysKB.DIR_SEPARATOR + list2.get(i).toLowerCase() + fileType.getExtension());
		    try {
			out = new PrintWriter(f);
		    } catch (FileNotFoundException e) {
			e.printStackTrace();
		    }
		    out.write(list2.get(i + 1));
		    out.close();
		}
		break;
	    default:
		throw new NotPermittedCommandException();
	    }
	}
	this.view.addOutput("Code Exported to: " + f.getPath());
    }

    @Override
    public void execCommand(Command cmd, String filename, FileType fileType, String content)
	    throws NotPermittedCommandException {
	switch (cmd) {
	case ADD_SOURCE_FILE:
	    this.addSourceFile(filename, fileType, content);
	    break;
	default:
	    throw new NotPermittedCommandException();
	}
    }

    /**
     * Metodo per pulire tutta la view.
     */
    private void clearAllView() {
	this.view.clearList();
	this.view.clearDiagram();
    }

}
