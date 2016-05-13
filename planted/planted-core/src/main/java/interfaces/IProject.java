package interfaces;

import java.util.List;

/**
 * Questa interfaccia rappresenta un progetto. Estende l'interfaccia
 * <code>ISourceEntityIml</code>.
 * 
 * @author ashleycaselli
 *
 */
public interface IProject extends ISourceEntityImpl {
    /**
     * Metodo per aggiungere un file sorgente all'interno del progetto.
     * 
     * @param srcFile
     *            file sorgente da aggiungere
     * @return <code>true</code> se il file sorgente viene aggiunto,
     *         <code>false</code> se il file sorgente esiste già
     */
    public boolean addFile(ISourceEntityImpl srcFile);

    /**
     * Metodo per rimuovere un file sorgente.
     * 
     * @param srcFile
     *            file sorgente da rimuovere
     * @return <code>true</code> se il file sorgente viene correttamente rimosso
     *         (esiste), <code>false</code> se il file sorgente non esiste
     */
    public boolean removeFile(ISourceEntityImpl srcFile);

    /**
     * Metodo per estrarre la lista dei file sorgenti del progetto.
     * 
     * @return lista contenente i file sorgenti del progetto
     */
    public List<ISourceEntityImpl> getSrcFiles();

}
