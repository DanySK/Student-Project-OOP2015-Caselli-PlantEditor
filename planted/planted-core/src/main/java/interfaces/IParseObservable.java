package interfaces;

public interface IParseObservable extends IObservable {

    public void notifyObserver(String name, String value);
}
