package interfaces;

/**
 * Questa interfaccia rappresente un file sorgente. Estende l'interfaccia
 * <code>ISourceEntityImpl</code>
 * 
 * @author ashleycaselli
 *
 */
public interface ISourceFile extends ISourceEntityImpl {
    /**
     * Metodo per estrarre il tipo del file sorgente.
     * 
     * @return tipo del file sorgente
     */
    public FileType getFileType();

    /**
     * Metodo per estrarre il contenuto del file sorgente.
     * 
     * @return conenuto del file sorgente
     */
    public String getContent();

    /**
     * Metodo per impostare il contenuto del file sorgente.
     * 
     * @param content
     *            contenuto da impostare al file sorgente
     */
    public void setContent(String content);

}
