package interfaces;

/**
 * Questa interfaccia rappresenta un filtro per i file sorgenti.
 * 
 * @author ashleycaselli
 *
 */
public interface IFileFilter {
    /**
     * Metodo per estrarre il tipo di file da filtrare.
     * 
     * @return tipo del file da filtrare
     */
    public FileType getFilterType();
}
