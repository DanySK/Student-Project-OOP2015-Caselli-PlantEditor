package interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface IModel {

    public void save(OutputStream out) throws IOException;

    public void load(InputStream in) throws ClassNotFoundException, IOException;

    public void clearData();

    public boolean addData(IProject project);

    public boolean addData(ISourceEntityImpl srcFile, IProject project);

    public boolean removeData(IProject project);

    public boolean removeData(ISourceEntityImpl srcFile, IProject project);

}
