package interfaces;

import java.io.Serializable;
import java.util.List;

public interface IProject extends ISourceEntityImpl, Serializable {

    public boolean addFile(ISourceEntityImpl srcFile);

    public boolean removeFile(ISourceEntityImpl srcFile);

    public List<ISourceEntityImpl> getSrcFiles();

}
