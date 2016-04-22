package interfaces;

public interface ICommandObservable extends IObservable {

    public void notifyObserver(Command cmd);

    public void notifyObserver(Command cmd, ISourceEntityImpl entity);

    public void notifyObserver(Command cmd, String... params);

    public void notifyObserver(Command cmd, ISourceEntityImpl entity, String content);

    public void notifyObserver(Command cmd, ISourceFile srcFile);

    public void notifyObserver(Command cmd, ISourceFile srcFile, FileType fileType);

    public void notifyObserver(Command cmd, String filename, FileType fileType, String content);

}
