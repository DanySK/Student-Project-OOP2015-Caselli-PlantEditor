package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import exception.NotPermittedCommandException;
import filefilter.JavaFileFilter;
import filefilter.PlantFileFilter;
import interfaces.Command;
import interfaces.FileType;
import interfaces.ICommandObserver;
import interfaces.IFileFilter;
import interfaces.IObserver;
import interfaces.IProject;
import interfaces.ISourceEntityImpl;
import interfaces.ISourceFile;
import interfaces.IView;
import model.Project;
import utils.SysKB;

/**
 * Questa classe rappresenta la View. Implementa l'interfaccia
 * <code>IView</code>.
 * 
 * @author ashleycaselli
 *
 */
public class MainUI implements IView {

    private JFrame frame;
    private ICommandObserver controller;
    private JTree tree;
    private JEditorPane editorPane;
    private JScrollPane scrollPaneTree;
    private JList<ISourceEntityImpl> listSrcFile;
    private JButton buttonRemove;
    private JButton buttonSave;
    private JButton buttonExport;
    private JLabel diagramLabel;
    private JButton buttonGenerateCode;
    private JMenuItem mntmImportFile;

    private static final String MENU_ITEM_0 = "Planted";
    private static final String MENU_ITEM_0_0 = "Informazioni su " + MENU_ITEM_0;
    private static final String MENU_ITEM_0_1 = "Esci da " + MENU_ITEM_0;
    private static final String MENU_ITEM_1 = "Nuovo Progetto";
    private static final String MENU_ITEM_2 = "Nuovo File";
    private static final String MENU_ITEM_3 = "Importa";
    private static final String PROJECT_PANE_TITLE = "Inserisci il nome del progetto";
    private static final String FILE_PANE_TITLE = "Inserisci il nome del file";

    private static final String JTEXTAREA_TEXT_0_0 = "Questa applicazione permette la modellazione grafica in UML. Supporta l'import di file che contengono codice"
	    + "usato dalla libreria PlantUML e l'esportazione dell'UML in codice Java.";

    /**
     * Create the application.
     */
    public MainUI() {
	initialize();
	frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 850, 750);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JMenuBar menuBar = new JMenuBar();
	frame.setJMenuBar(menuBar);

	JMenu mnNewMenu = new JMenu(MENU_ITEM_0);
	mnNewMenu.setFont(new Font("Lucida Grande", Font.BOLD, 14));
	menuBar.add(mnNewMenu);

	JMenuItem mntmNewMenuItem = new JMenuItem(MENU_ITEM_0_0);
	mntmNewMenuItem.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		JFrame about = new JFrame();
		about.setBounds(150, 150, 350, 200);
		about.setResizable(false);
		JTextArea area = new JTextArea(JTEXTAREA_TEXT_0_0);
		area.setLineWrap(true);
		area.setBackground(Color.WHITE);
		area.setEditable(false);
		about.getContentPane().add(area);
		about.setVisible(true);
	    }
	});
	mnNewMenu.add(mntmNewMenuItem);

	JSeparator separator = new JSeparator();
	mnNewMenu.add(separator);

	JMenuItem mntmNewMenuItem_1 = new JMenuItem(MENU_ITEM_0_1);
	mntmNewMenuItem_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	mnNewMenu.add(mntmNewMenuItem_1);

	JMenuItem mntmCreateProject = new JMenuItem(MENU_ITEM_1);
	mntmCreateProject.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String pname = JOptionPane.showInputDialog(PROJECT_PANE_TITLE);
		notifyObserver(Command.ADD_PROJECT, new Project(pname));
	    }
	});
	menuBar.add(mntmCreateProject);

	JMenuItem menuItem = new JMenuItem(MENU_ITEM_2);
	menuItem.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String filename = JOptionPane.showInputDialog(FILE_PANE_TITLE);
		FileType selectedLanguage = (FileType) JOptionPane.showInputDialog(frame, null,
			"Seleziona il linguaggio", JOptionPane.QUESTION_MESSAGE, null, FileType.values(),
			FileType.values()[0]);
		notifyObserver(Command.ADD_SOURCE_FILE, filename, selectedLanguage, null);
	    }
	});
	menuBar.add(menuItem);

	mntmImportFile = new JMenuItem(MENU_ITEM_3);
	menuBar.add(mntmImportFile);
	mntmImportFile.setVisible(false);
	frame.setResizable(false);
	frame.getContentPane().setLayout(null);
	mntmImportFile.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setMultiSelectionEnabled(true);
		List<File> files = null;
		fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
		fileChooser.addChoosableFileFilter(new JavaFileFilter());
		fileChooser.addChoosableFileFilter(new PlantFileFilter());
		int n = fileChooser.showOpenDialog(null);
		if (n == JFileChooser.APPROVE_OPTION) {
		    files = Arrays.asList(fileChooser.getSelectedFiles());
		    files.forEach(f -> {
			IFileFilter curFilter = (IFileFilter) fileChooser.getFileFilter();
			String tmpName = f.getName().split(curFilter.getFilterType().getExtension())[0].trim();
			try {
			    notifyObserver(Command.ADD_SOURCE_FILE, tmpName, curFilter.getFilterType(),
				    Files.toString(f, Charsets.UTF_8));
			} catch (IOException e1) {
			    e1.printStackTrace();
			}
		    });
		}
	    }
	});

	scrollPaneTree = new JScrollPane();
	scrollPaneTree.setBounds(6, 6, 144, 424);
	frame.getContentPane().add(scrollPaneTree);

	JSplitPane splitPane = new JSplitPane();
	splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	splitPane.setResizeWeight(.5d);
	scrollPaneTree.setViewportView(splitPane);

	TreeNode rootNode = new DefaultMutableTreeNode(SysKB.WORKSPACE_NAME);
	tree = new JTree(new DefaultTreeModel(rootNode));
	tree.setShowsRootHandles(true);
	splitPane.setTopComponent(tree);

	listSrcFile = new JList<>(new DefaultListModel<>());
	listSrcFile.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
		ISourceEntityImpl ei = listSrcFile.getSelectedValue();
		notifyObserver(Command.OPEN_EDITOR, ei);
		notifyObserver(Command.CLEAR_DIAGRAM);
		if (((ISourceFile) ei).getFileType().equals(FileType.PLANTUML)) {
		    notifyObserver(Command.GENERATE_DIAGRAM, (ISourceFile) listSrcFile.getSelectedValue());
		    buttonExport.setVisible(true);
		} else {
		    buttonExport.setVisible(false);
		}
		buttonGenerateCode.setVisible(true);
	    }
	});
	splitPane.setBottomComponent(listSrcFile);

	JScrollPane scrollPaneTextEditor = new JScrollPane();
	scrollPaneTextEditor.setBounds(155, 34, 689, 396);
	frame.getContentPane().add(scrollPaneTextEditor);

	editorPane = new JEditorPane();
	editorPane.setForeground(Color.BLACK);
	editorPane.setBackground(Color.WHITE);
	editorPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
	scrollPaneTextEditor.setViewportView(editorPane);
	editorPane.setEditable(false);
	editorPane.addKeyListener(new KeyListener() {

	    @Override
	    public void keyTyped(KeyEvent e) {
		ISourceFile src = (ISourceFile) listSrcFile.getSelectedValue();
		src.setContent(editorPane.getText());
		if (src.getFileType().equals(FileType.PLANTUML)) {
		    notifyObserver(Command.GENERATE_DIAGRAM, src);
		}
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	    }
	});

	JToolBar toolbar = new JToolBar(JToolBar.HORIZONTAL);
	toolbar.setLocation(155, 0);
	toolbar.setSize(689, 30);
	toolbar.setFloatable(false);
	try {
	    // URL urlImageOpen = new
	    // URL("http://www.simplesoft.it/img/articles/java/toolBar/open.png");
	    URL urlImageSave = new URL("http://www.simplesoft.it/img/articles/java/toolBar/save.png");
	    // URL urlImageAbout = new
	    // URL("http://www.simplesoft.it/img/articles/java/toolBar/about.png");
	    URL urlImageRemove = new URL("http://www.simplesoft.it/img/articles/java/toolBar/exit.png");
	    // JButton buttonOpen = new JButton(new ImageIcon(urlImageOpen));
	    buttonSave = new JButton(new ImageIcon(urlImageSave));
	    // JButton buttonAbout = new JButton(new ImageIcon(urlImageAbout));
	    buttonRemove = new JButton(new ImageIcon(urlImageRemove));
	    // toolbar.add(buttonOpen);
	    toolbar.add(buttonSave);
	    buttonSave.setEnabled(false);
	    buttonRemove.setEnabled(false);
	    // toolbar.add(buttonAbout);
	    toolbar.add(buttonRemove);
	    buttonExport = new JButton("Export Diagram");
	    toolbar.add(buttonExport);
	    buttonExport.setVisible(false);
	} catch (MalformedURLException e1) {
	    e1.printStackTrace();
	}

	frame.getContentPane().add(toolbar);

	buttonGenerateCode = new JButton("Generate Code");
	buttonGenerateCode.setVisible(false);
	buttonGenerateCode.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (listSrcFile.getSelectedIndex() != -1) {
		    FileType selectedLanguage = (FileType) JOptionPane.showInputDialog(frame,
			    "In quale linguaggio vuoi generare il codice?", "Seleziona il linguaggio",
			    JOptionPane.QUESTION_MESSAGE, null, FileType.values(), FileType.values()[1]);
		    notifyObserver(Command.EXPORT_CODE, (ISourceFile) listSrcFile.getSelectedValue(), selectedLanguage);
		}
	    }
	});
	toolbar.add(buttonGenerateCode);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(6, 433, 838, 267);
	frame.getContentPane().add(scrollPane);

	diagramLabel = new JLabel();
	scrollPane.setViewportView(diagramLabel);
	buttonRemove.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		if (listSrcFile.getSelectedValue() != null) {
		    ISourceEntityImpl ei = listSrcFile.getSelectedValue();
		    notifyObserver(Command.REMOVE_SOURCE_FILE, ei);
		} else {
		    notifyObserver(Command.REMOVE_PROJECT);
		}
		buttonExport.setVisible(false);
		buttonGenerateCode.setVisible(false);
	    }
	});

	buttonSave.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		notifyObserver(Command.SAVE_EDITOR, listSrcFile.getSelectedValue(), editorPane.getText());
		if (((ISourceFile) listSrcFile.getSelectedValue()).getFileType().equals(FileType.PLANTUML)) {
		    notifyObserver(Command.GENERATE_DIAGRAM, (ISourceFile) listSrcFile.getSelectedValue());
		}
	    }
	});

	buttonExport.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		notifyObserver(Command.EXPORT_DIAGRAM, (ISourceFile) listSrcFile.getSelectedValue());
		// System.out.println("export clicked");
	    }
	});

	tree.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
		// if (e.getClickCount() == 2) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if (node != null && !node.isRoot()) {
		    notifyObserver(Command.SELECT_PROJECT, node.getUserObject().toString());
		    // }
		}
		buttonGenerateCode.setVisible(false);
		buttonExport.setVisible(false);
	    }
	});

    }

    @Override
    public void notifyObserver(Command cmd, ISourceFile srcFile, FileType fileType) {
	try {
	    this.controller.execCommand(cmd, srcFile, fileType);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void addOutput(ISourceEntityImpl entity) {
	if (entity instanceof IProject) {
	    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
	    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
	    model.insertNodeInto(new DefaultMutableTreeNode(entity.getName()), root, root.getChildCount());
	    tree.expandPath(new TreePath(root.getPath()));
	} else if (entity instanceof ISourceFile) {
	    DefaultListModel<ISourceEntityImpl> listModel = (DefaultListModel<ISourceEntityImpl>) listSrcFile
		    .getModel();
	    listModel.addElement(entity);
	}
    }

    @Override
    public void registerObserver(IObserver observer) {
	this.controller = (ICommandObserver) observer;
    }

    @Override
    public void notifyObserver(Command cmd, ISourceEntityImpl entity) {
	try {
	    this.controller.execCommand(cmd, entity);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void notifyObserver(Command cmd, String... params) {
	try {
	    this.controller.execCommand(cmd, params);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void setTitle(String proj) {
	this.frame.setTitle(proj);
	this.buttonSave.setEnabled(true);
	this.buttonRemove.setEnabled(true);
	this.mntmImportFile.setVisible(true);
    }

    @Override
    public void clearList() {
	DefaultListModel<ISourceEntityImpl> listModel = (DefaultListModel<ISourceEntityImpl>) listSrcFile.getModel();
	listModel.clear();
	editorPane.setText(null);
    }

    @Override
    public void clearTree() {
	DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
	DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
	root.removeAllChildren();
	model.reload();
    }

    @Override
    public void openEditor(ISourceEntityImpl entity) {
	editorPane.setEditable(true);
	editorPane.setText(((ISourceFile) entity).getContent());
    }

    @Override
    public void notifyObserver(Command cmd, ISourceEntityImpl entity, String content) {
	try {
	    this.controller.execCommand(cmd, entity, content);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void notifyObserver(Command cmd) {
	try {
	    this.controller.execCommand(cmd);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void notifyObserver(Command cmd, ISourceFile srcFile) {
	try {
	    this.controller.execCommand(cmd, srcFile);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void addOutput(Image img) {
	if (img != null) {
	    diagramLabel.setIcon(new ImageIcon(img));
	    diagramLabel.setText(null);
	} else {
	    diagramLabel.setIcon(null);
	    diagramLabel.setText("Empty content");
	}
    }

    @Override
    public void addOutput(String response) {
	JOptionPane.showMessageDialog(null, response);
    }

    @Override
    public void notifyObserver(Command cmd, String filename, FileType fileType, String content) {
	try {
	    this.controller.execCommand(cmd, filename, fileType, content);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void clearDiagram() {
	diagramLabel.setText(null);
	diagramLabel.setIcon(null);
    }

}
