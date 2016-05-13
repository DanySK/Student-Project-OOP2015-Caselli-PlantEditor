package interfaces;

/**
 * Questa interfaccia rappresenta un'entità osservabile. Le classi che
 * implementano questa interfaccia devono essere utilizzate come osservatori
 * utilizzando il pattern observer.
 * 
 * @author ashleycaselli
 *
 */
public interface IObservable {
    /**
     * Metodo per registrare un ascoltatore.
     * 
     * @param observer
     *            ascoltatore da registrare
     */
    public void registerObserver(IObserver observer);

}
