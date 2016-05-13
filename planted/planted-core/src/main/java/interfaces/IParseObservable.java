package interfaces;

/**
 * Questa interfaccia rappresenta un'entità osservabile per la funzionalità di
 * parsing. Estende l'interfaccia <code>IObservable</code>.
 * 
 * @author ashleycaselli
 *
 */
public interface IParseObservable extends IObservable {
    /**
     * Metodo per notificare il suo ascoltatore.
     * 
     * @param name
     * @param value
     */
    public void notifyObserver(String name, String value);
}
