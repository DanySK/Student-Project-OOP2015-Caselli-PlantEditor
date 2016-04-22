package domainmodel;

import interfaces.FileType;
import interfaces.IPlantSourceFile;

public class PlantSourceFile implements IPlantSourceFile {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private final FileType fileType = FileType.PLANTUML;
    private String content;

    public PlantSourceFile() {
	this.content = "@startuml\n\n\n\n@enduml";
    }

    public PlantSourceFile(String name) {
	this.name = name.trim();
	this.content = "@startuml\n\n\n\n@enduml";
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
	// return "PlantSourceFile [name=" + name + "]";
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
