package interfaces;

import exception.NotPermittedCommandException;

public interface ICommandObserver extends IObserver {

    public void execCommand(Command cmd, ISourceEntityImpl entity) throws NotPermittedCommandException;

    public void execCommand(Command cmd, String... params) throws NotPermittedCommandException;

    public void execCommand(Command cmd) throws NotPermittedCommandException;

    public void execCommand(Command cmd, ISourceEntityImpl entity, String content) throws NotPermittedCommandException;

    public void execCommand(Command cmd, ISourceFile srcFile) throws NotPermittedCommandException;

    public void execCommand(Command cmd, ISourceFile srcFile, FileType fileType) throws NotPermittedCommandException;

    public void execCommand(Command cmd, String filename, FileType fileType, String content)
	    throws NotPermittedCommandException;

}
