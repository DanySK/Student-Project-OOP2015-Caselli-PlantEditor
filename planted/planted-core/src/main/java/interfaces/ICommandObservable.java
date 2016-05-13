package interfaces;

/**
 * Questa interfaccia rappresenta un'entità osservabile per l'esecuzione di
 * comandi. Estende l'interfaccia <code>IObservable</code>.
 * 
 * @author ashleycaselli
 *
 */
public interface ICommandObservable extends IObservable {
    /**
     * Metodo per notificare il suo ascoltatore.
     * 
     * @param cmd
     *            comando da eseguire
     */
    public void notifyObserver(Command cmd);

    /**
     * Metodo per notificare il suo ascoltatore.
     * 
     * @param cmd
     *            comando da eseguire
     * @param entity
     */
    public void notifyObserver(Command cmd, ISourceEntityImpl entity);

    /**
     * Metodo per notificare il suo ascoltatore.
     * 
     * @param cmd
     *            comando da eseguire
     * @param params
     */
    public void notifyObserver(Command cmd, String... params);

    /**
     * Metodo per notificare il suo ascoltatore.
     * 
     * @param cmd
     *            comando da eseguire
     * @param entity
     * @param content
     */
    public void notifyObserver(Command cmd, ISourceEntityImpl entity, String content);

    /**
     * Metodo per notificare i suoi ascoltatori.
     * 
     * @param cmd
     *            comando da eseguire
     * @param srcFile
     */
    public void notifyObserver(Command cmd, ISourceFile srcFile);

    /**
     * Metodo per notificare il suo ascoltatore.
     * 
     * @param cmd
     *            comando da eseguire
     * @param srcFile
     * @param fileType
     */
    public void notifyObserver(Command cmd, ISourceFile srcFile, FileType fileType);

    /**
     * Metodo per notificare il suo ascoltatore.
     * 
     * @param cmd
     *            comando da eseguire
     * @param filename
     * @param fileType
     * @param content
     */
    public void notifyObserver(Command cmd, String filename, FileType fileType, String content);

}
