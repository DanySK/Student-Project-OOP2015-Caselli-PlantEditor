package interfaces;

import java.awt.Image;

public interface IView extends ICommandObservable {

    public void clear();

    public void clearAll();

    public void clearDiagram();

    public void addOutput(ISourceEntityImpl entity);

    public void addOutput(Image img);

    public void addOutput(String response);

    public void setTitle(String proj);

    public void openEditor(ISourceEntityImpl entity);

}
