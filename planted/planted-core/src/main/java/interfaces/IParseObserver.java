package interfaces;

/**
 * Questa interfaccia rappresenta un ascoltatore per la funzionalità di parsing.
 * Estende l'interfaccia <code>IObserver</code>.
 * 
 * @author ashleycaselli
 *
 */
public interface IParseObserver extends IObserver {
    /**
     * Metodo che viene eseguito quando viene notificato dall'entità che sta
     * ascoltando.
     * 
     * @param name
     * @param value
     */
    public void exec(String name, String value);

}
