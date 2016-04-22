package interfaces;

import java.io.Serializable;

public interface ISourceEntityImpl extends ISourceEntity, Serializable {

    public String getName();

    public void setName(String name);

}
