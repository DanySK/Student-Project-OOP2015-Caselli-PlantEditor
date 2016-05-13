package interfaces;

/**
 * Questa interfaccia rappresenta un controller. Può essere utilizzata come
 * livello Controller nell'utilizzo di un'architettura MVC. Estende
 * l'interfaccia <code>ICommandObserver</code>.
 * 
 * @author ashleycaselli
 *
 */
public interface IController extends ICommandObserver {
    /**
     * Metodo per impostare il model.
     * 
     * @param model
     *            model da impostare
     */
    public void setModel(IModel model);

    /**
     * Metodo per impostare la view.
     * 
     * @param view
     *            view da impostare
     */
    public void setView(IView view);

}
