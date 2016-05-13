package interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Questa interfaccia rappresenta un modello. Può essere utilizzata come livello
 * Model nell'utilizzo di un'architetture MVC.
 * 
 * @author ashleycaselli
 *
 */
public interface IModel {
    /**
     * Metodo per il salvataggio dei dati.
     * 
     * @param out
     *            stream di output su cui scrivere i dati
     * @throws IOException
     */
    public void save(OutputStream out) throws IOException;

    /**
     * Metodo per il caricamento dei dati.
     * 
     * @param in
     *            stream di input da cui leggere i dati
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void load(InputStream in) throws ClassNotFoundException, IOException;

    /**
     * Metodo per eliminare tutti i dati.
     */
    public void clearData();

    /**
     * Metodo per aggiungere dati.
     * 
     * @param project
     *            progetto da aggiungere
     * @return <code>true</code> se il progetto viene aggiunto,
     *         <code>false</code> se il progetto esiste già
     */
    public boolean addData(IProject project);

    /**
     * Metodo per aggiungere dati.
     * 
     * @param srcFile
     *            file sorgente da aggiungere
     * @param project
     *            progetto nel quale inserire il file sorgente
     * @return <code>true</code> se il file sorgente viene aggiunto,
     *         <code>false</code> se il progetto non esiste o se il file
     *         sorgente esiste già all'interno del progetto
     */
    public boolean addData(ISourceEntityImpl srcFile, IProject project);

    /**
     * Metodo per rimuovere un progetto.
     * 
     * @param project
     *            progetto da rimuovere
     * @return <code>true</code> se il progetto viene rimosso correttamente
     *         (solo se il progetto esiste), <code>false</code> se il progetto
     *         non esiste
     */
    public boolean removeData(IProject project);

    /**
     * Metodo per eliminare un file sorgente all'interno di un progetto.
     * 
     * @param srcFile
     *            file sorgente che si vuole eliminare
     * @param project
     *            progetto dentro il quale cercare il file sorgente da eliminare
     * @return <code>true</code> se il file sorgente viene rimosso
     *         correttamente, <code>false</code> se il progetto o il file
     *         sorgente non esistono
     */
    public boolean removeData(ISourceEntityImpl srcFile, IProject project);

}
