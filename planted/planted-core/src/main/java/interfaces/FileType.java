package interfaces;

public enum FileType {

    PLANTUML(".pu"), JAVA(".java");

    private String extension;

    private FileType(String extension) {
	this.extension = extension;
    }

    public String getExtension() {
	return this.extension;
    }

}
