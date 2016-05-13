package interfaces;

import java.awt.Image;

/**
 * Questa interfaccia rappresenta una view. Può essere utilzizata come livello
 * View nell'utilizzo di un'architettura MVC. Estende l'interfaccia
 * <code>ICommandObservable</code>.
 * 
 * @author ashleycaselli
 *
 */
public interface IView extends ICommandObservable {
    /**
     * Metodo per pulire ogni lista.
     */
    public void clearList();

    /**
     * Metodo per pulire ogni albero.
     */
    public void clearTree();

    /**
     * Metodo per pulire ogni diagramma.
     */
    public void clearDiagram();

    /**
     * Metodo per aggiungere un output alla view.
     * 
     * @param entity
     *            entità da aggiungere
     */
    public void addOutput(ISourceEntityImpl entity);

    /**
     * Metodo per aggiungere un output alla view.
     * 
     * @param img
     *            immagine da aggiungere
     */
    public void addOutput(Image img);

    /**
     * Metodo per aggiungere un output alla view.
     * 
     * @param response
     *            testo da aggiungere
     */
    public void addOutput(String response);

    /**
     * Metodo per impostare il titolo della view.
     * 
     * @param proj
     *            testo del titolo
     */
    public void setTitle(String proj);

    /**
     * Metodo per aprire l'editor di testo.
     * 
     * @param entity
     *            entità da visualizzare all'interno dell'editor
     */
    public void openEditor(ISourceEntityImpl entity);

}
