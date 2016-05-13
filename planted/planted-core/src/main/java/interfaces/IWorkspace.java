package interfaces;

/**
 * Questa interfaccia rappresenta un workspace. Estende l'interfaccia
 * <code>IModel</code>.
 * 
 * @author ashleycaselli
 *
 */
public interface IWorkspace extends IModel {
    /**
     * Metodo per estrarre il nome del workspace.
     * 
     * @return nome estratto
     */
    public String getName();

    /**
     * Metodo per impostare il nome del worksapce.
     * 
     * @param name
     *            nome da impostare al workspace
     */
    public void setName(String name);

}
