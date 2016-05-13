package model;

import interfaces.FileType;
import interfaces.IJavaSourceFile;

/**
 * Questa classe rappresenta un file sorgente Java. Implementa l'interfaccia
 * <code>IJavaSourceFile</code>.
 * 
 * @author ashleycaselli
 *
 */
public class JavaSourceFile implements IJavaSourceFile {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private final FileType fileType = FileType.JAVA;
    private String content;

    public JavaSourceFile(String name) {
	this.name = Character.toString(name.charAt(0)).toUpperCase() + name.substring(1).trim();
	this.content = "public class " + Character.toString(name.charAt(0)).toUpperCase() + name.substring(1)
		+ " {\n\n}";
    }

    @Override
    public String getName() {
	return this.name;
    }

    @Override
    public void setName(String name) {
	this.name = name.trim();
    }

    @Override
    public String toString() {
	// return "JavaSourceFile [name=" + name + "]";
	return this.getName() + this.getFileType().getExtension();
    }

    @Override
    public FileType getFileType() {
	return this.fileType;
    }

    @Override
    public String getContent() {
	return this.content;
    }

    @Override
    public void setContent(String content) {
	this.content = content;
    }

}
