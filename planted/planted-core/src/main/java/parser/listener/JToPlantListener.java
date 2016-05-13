package parser.listener;

import gram.SimpleJavaBaseListener;
import gram.SimpleJavaParser.ClassBodyContext;
import gram.SimpleJavaParser.ClassDeclarationContext;
import gram.SimpleJavaParser.FieldDeclarationContext;
import gram.SimpleJavaParser.FieldNameContext;
import gram.SimpleJavaParser.FieldTypeContext;
import gram.SimpleJavaParser.MethodNameContext;
import gram.SimpleJavaParser.MethodReturnTypeContext;
import gram.SimpleJavaParser.ModifierContext;
import gram.SimpleJavaParser.OtherParamBodyDeclarationContext;
import gram.SimpleJavaParser.ParamDeclarationContext;
import gram.SimpleJavaParser.ParamNameContext;
import gram.SimpleJavaParser.ParamTypeContext;
import interfaces.IObserver;
import interfaces.IParseObservable;
import interfaces.IParseObserver;

/**
 * Questa classe rappresenta un listener per la grammatica SimpleJava, per
 * costruire codice utilizzato dalla libreria PlantUML a partire da codice Java.
 * Estende la classe <code>SimpleJavaBaseListener</code> e implementa
 * l'interfaccia <code>IParseObservable</code>.
 * 
 * @author ashleycaselli
 *
 */
public class JToPlantListener extends SimpleJavaBaseListener implements IParseObservable {

    private IParseObserver observer = null;
    private String ret = new StringBuilder().append("@startuml\n").toString();
    private String fieldType = null;
    private final String PUBLIC = "public";
    private final String PRIVATE = "private";
    private final String PROTECTED = "protected";
    private String className = null;
    private boolean classMod = true;

    @Override
    public void enterClassDeclaration(ClassDeclarationContext ctx) {
	super.enterClassDeclaration(ctx);
	className = ctx.getChild(2).getText();
	ret = ret.concat(new StringBuilder().append("class ").append(className).toString());
    }

    @Override
    public void exitClassDeclaration(ClassDeclarationContext ctx) {
	super.exitClassDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append("\n@enduml").toString());
	notifyObserver(className, ret);
	ret = new StringBuilder().append("@startuml").toString();
    }

    @Override
    public void enterParamDeclaration(ParamDeclarationContext ctx) {
	super.enterParamDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append("(").toString());
    }

    @Override
    public void exitParamDeclaration(ParamDeclarationContext ctx) {
	super.exitParamDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(")").append("\n").toString());
    }

    @Override
    public void enterParamName(ParamNameContext ctx) {
	super.enterParamName(ctx);
	ret = ret.concat(new StringBuilder().append(ctx.getText()).toString());
    }

    @Override
    public void enterOtherParamBodyDeclaration(OtherParamBodyDeclarationContext ctx) {
	super.enterOtherParamBodyDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(", ").toString());
    }

    @Override
    public void exitFieldDeclaration(FieldDeclarationContext ctx) {
	super.exitFieldDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(":").append(fieldType).append("\n").toString());
    }

    @Override
    public void enterFieldName(FieldNameContext ctx) {
	super.enterFieldName(ctx);
	ret = ret.concat(new StringBuilder().append(ctx.getText()).toString());
    }

    @Override
    public void enterFieldType(FieldTypeContext ctx) {
	super.enterFieldType(ctx);
	fieldType = ctx.getText();
    }

    @Override
    public void enterModifier(ModifierContext ctx) {
	super.enterModifier(ctx);
	if (!classMod) {
	    ret = ret.concat(new StringBuilder().append(getModifiers(ctx.getText())).toString());
	}
	classMod = false;
    }

    @Override
    public void enterMethodName(MethodNameContext ctx) {
	super.enterMethodName(ctx);
	ret = ret.concat(new StringBuilder().append(ctx.getText()).toString());
    }

    @Override
    public void enterMethodReturnType(MethodReturnTypeContext ctx) {
	super.enterMethodReturnType(ctx);
	ret = ret.concat(new StringBuilder().append(ctx.getText()).append(" ").toString());
    }

    @Override
    public void enterParamType(ParamTypeContext ctx) {
	super.enterParamType(ctx);
	ret = ret.concat(new StringBuilder().append(ctx.getText()).append(" ").toString());
    }

    @Override
    public void enterClassBody(ClassBodyContext ctx) {
	super.enterClassBody(ctx);
	ret = ret.concat(new StringBuilder().append(" {\n").toString());
    }

    @Override
    public void exitClassBody(ClassBodyContext ctx) {
	super.exitClassBody(ctx);
	ret = ret.concat(new StringBuilder().append("\n}").toString());
    }

    /**
     * Metodo per la conversione dei modificatori del linguaggio.
     * 
     * @param s
     *            testo contenente il modificatore
     * @return modificatore convertito (conforme al linguaggio usato dalla
     *         libreria PlantUML)
     */
    private String getModifiers(String s) {
	switch (s) {
	case PUBLIC:
	    return "+";
	case PRIVATE:
	    return "-";
	case PROTECTED:
	    return "#";
	default:
	    return null;
	}
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
