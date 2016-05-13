package filefilter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import interfaces.FileType;
import interfaces.IFileFilter;

/**
 * Questa classe rappresenta un filtro per i file PlantUML. Estende la classe
 * <code>FileFilter</code>, ed implementa l'interfaccia
 * <code>IFileFilter</code>.
 * 
 * @author ashleycaselli
 *
 */
public class PlantFileFilter extends FileFilter implements IFileFilter {

    @Override
    public boolean accept(File f) {
	if (f.isDirectory())
	    return true;
	String fname = f.getName().toLowerCase();
	return fname.endsWith(FileType.PLANTUML.getExtension());
    }

    @Override
    public String getDescription() {
	return "Plant Source File";
    }

    @Override
    public FileType getFilterType() {
	return FileType.PLANTUML;
    }

}
