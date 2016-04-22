package interfaces;

public interface ISourceFile extends ISourceEntityImpl {

    public FileType getFileType();

    public String getContent();

    public void setContent(String content);

}
