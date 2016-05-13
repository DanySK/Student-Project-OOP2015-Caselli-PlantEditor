package interfaces;

import java.io.Serializable;

/**
 * Questa interfaccia rappresenta un'entità che descrive una sorgente. Estende
 * le interfacce <code>ISourceEntity</code> e <code>Serializable</code>. E'
 * conforme al pattern bridge.
 * 
 * @author ashleycaselli
 *
 */
public interface ISourceEntityImpl extends ISourceEntity, Serializable {
    /**
     * Metodo per estrarre il nome della sorgente.
     * 
     * @return nome della sorgente
     */
    public String getName();

    /**
     * Metodo per impostare il nome della sorgente.
     * 
     * @param name
     *            nome della sorgente
     */
    public void setName(String name);

}
