package interfaces;

import java.util.List;

public interface IParser {

    public List<String> parse(String code, FileType srcType);

}
