package parser.listener;

import org.antlr.v4.runtime.ParserRuleContext;

import gram.SimpleJavaBaseListener;
import interfaces.IObserver;
import interfaces.IParseObservable;
import interfaces.IParseObserver;

/**
 * Questa classe rappresenta un listener per la grammatica SimpleJava, per
 * costruire codice Java a partire da codice Java. Estende la classe
 * <code>SimpleJavaBaseListener</code>.
 * 
 * @author ashleycaselli
 *
 */
@Deprecated
public class JToJListener extends SimpleJavaBaseListener implements IParseObservable {

    private String ret = new StringBuilder().toString();
    private IParseObserver observer = null;

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
	super.enterEveryRule(ctx);
	ret = ret.concat(new StringBuilder().append(ctx.getText()).append(" ").toString());
	System.out.println(ret + "\n");
    }

    @Override
    public void registerObserver(IObserver observer) {
	this.observer = (IParseObserver) observer;
    }

    @Override
    public void notifyObserver(String name, String value) {
	this.observer.exec(name, value);
    }

}
