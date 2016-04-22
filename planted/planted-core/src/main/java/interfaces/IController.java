package interfaces;

public interface IController extends ICommandObserver {

    public void setModel(IModel model);

    public void setView(IView view);

}
