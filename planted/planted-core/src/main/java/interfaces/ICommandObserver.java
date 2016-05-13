package interfaces;

import exception.NotPermittedCommandException;

/**
 * Questa interfaccia rappresenta un ascoltatore per l'esecuzione di comandi.
 * Estende l'interfaccia <code>IObserver</code>.
 * 
 * @author ashleycaselli
 *
 */
public interface ICommandObserver extends IObserver {
    /**
     * Metodo per eseguire un comando.
     * 
     * @param cmd
     *            comando da eseguire
     * @param entity
     * @throws NotPermittedCommandException
     */
    public void execCommand(Command cmd, ISourceEntityImpl entity) throws NotPermittedCommandException;

    /**
     * Metodo per eseguire un comando.
     * 
     * @param cmd
     *            comando da eseguire
     * @param params
     * @throws NotPermittedCommandException
     */
    public void execCommand(Command cmd, String... params) throws NotPermittedCommandException;

    /**
     * Metodo per eseguire un comando.
     * 
     * @param cmd
     *            comando da eseguire
     * @throws NotPermittedCommandException
     */
    public void execCommand(Command cmd) throws NotPermittedCommandException;

    /**
     * Metodo per eseguire un comando.
     * 
     * @param cmd
     *            comando da eseguire
     * @param entity
     * @param content
     * @throws NotPermittedCommandException
     */
    public void execCommand(Command cmd, ISourceEntityImpl entity, String content) throws NotPermittedCommandException;

    /**
     * Metodo per eseguire un comando.
     * 
     * @param cmd
     *            comando da eseguire
     * @param srcFile
     * @throws NotPermittedCommandException
     */
    public void execCommand(Command cmd, ISourceFile srcFile) throws NotPermittedCommandException;

    /**
     * Metodo per eseguire un comando.
     * 
     * @param cmd
     *            comando da eseguire
     * @param srcFile
     * @param fileType
     * @throws NotPermittedCommandException
     */
    public void execCommand(Command cmd, ISourceFile srcFile, FileType fileType) throws NotPermittedCommandException;

    /**
     * Metodo per eseguire un comando.
     * 
     * @param cmd
     *            comando da eseguire
     * @param filename
     * @param fileType
     * @param content
     * @throws NotPermittedCommandException
     */
    public void execCommand(Command cmd, String filename, FileType fileType, String content)
	    throws NotPermittedCommandException;

}
