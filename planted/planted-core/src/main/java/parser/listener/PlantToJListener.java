package parser.listener;

import gram.PlantBaseListener;
import gram.PlantParser.ClassBodyContext;
import gram.PlantParser.ClassDeclarationContext;
import gram.PlantParser.FieldDeclarationContext;
import gram.PlantParser.FirstParamBodyDeclarationContext;
import gram.PlantParser.MethodDeclarationContext;
import gram.PlantParser.MethodNameDeclarationContext;
import gram.PlantParser.ModifierDeclarationContext;
import gram.PlantParser.NameDeclarationContext;
import gram.PlantParser.OtherParamBodyDeclarationContext;
import gram.PlantParser.ParamDeclarationContext;
import gram.PlantParser.ReturnTypeMethodDeclarationContext;
import gram.PlantParser.TypeDeclarationContext;
import gram.PlantParser.TypeParamDeclarationContext;
import interfaces.IObserver;
import interfaces.IParseObservable;
import interfaces.IParseObserver;

public class PlantToJListener extends PlantBaseListener implements IParseObservable {

    private IParseObserver observer = null;
    private String className = null;
    private String mod = "public ";
    private boolean returnTypeMethod = false;
    private String ret;
    private String tmpName = null;
    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String HASH = "#";

    @Override
    public void enterClassDeclaration(ClassDeclarationContext ctx) {
	super.enterClassDeclaration(ctx);
	ret = new StringBuilder().toString();
	className = ctx.getChild(1).toString();
	className = Character.toString(className.charAt(0)).toUpperCase() + className.substring(1, className.length());
	ret = ret.concat(new StringBuilder().append(mod + "class ").append(className).toString());
    }

    @Override
    public void enterClassBody(ClassBodyContext ctx) {
	super.enterClassBody(ctx);
	ret = ret.concat(new StringBuilder().append(" {\n").toString());
    }

    @Override
    public void enterFieldDeclaration(FieldDeclarationContext ctx) {
	super.enterFieldDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append("\n\t").toString());
    }

    @Override
    public void enterModifierDeclaration(ModifierDeclarationContext ctx) {
	super.enterModifierDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(getModifiers(ctx.getText())).append(" ").toString());
    }

    @Override
    public void enterNameDeclaration(NameDeclarationContext ctx) {
	super.enterNameDeclaration(ctx);
	this.tmpName = ctx.getText();
    }

    @Override
    public void enterTypeDeclaration(TypeDeclarationContext ctx) {
	super.enterTypeDeclaration(ctx);
	ret = ret
		.concat(new StringBuilder().append(ctx.getText()).append(" ").append(tmpName).append(";\n").toString());
	tmpName = null;
    }

    @Override
    public void enterTypeParamDeclaration(TypeParamDeclarationContext ctx) {
	super.enterTypeParamDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(ctx.getText()).toString());
    }

    @Override
    public void exitClassBody(ClassBodyContext ctx) {
	super.exitClassBody(ctx);
	ret = ret.concat(new StringBuilder().append("\n}\n\n").toString());
    }

    @Override
    public void enterParamDeclaration(ParamDeclarationContext ctx) {
	super.enterParamDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append("(").toString());
    }

    @Override
    public void exitParamDeclaration(ParamDeclarationContext ctx) {
	super.exitParamDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(") {").toString());
    }

    @Override
    public void exitFirstParamBodyDeclaration(FirstParamBodyDeclarationContext ctx) {
	super.exitFirstParamBodyDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(" " + ctx.getChild(1).toString()).toString());
    }

    @Override
    public void enterOtherParamBodyDeclaration(OtherParamBodyDeclarationContext ctx) {
	super.enterOtherParamBodyDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(", ").toString());
    }

    @Override
    public void exitOtherParamBodyDeclaration(OtherParamBodyDeclarationContext ctx) {
	super.exitOtherParamBodyDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append(" " + ctx.getChild(2).toString()).toString());
    }

    @Override
    public void enterMethodNameDeclaration(MethodNameDeclarationContext ctx) {
	super.enterMethodNameDeclaration(ctx);
	if (!returnTypeMethod) {
	    ret = ret.concat(new StringBuilder().append("void ").toString());
	}
	ret = ret.concat(new StringBuilder().append(ctx.getText()).toString());
    }

    @Override
    public void enterMethodDeclaration(MethodDeclarationContext ctx) {
	super.enterMethodDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append("\n\t").toString());
    }

    @Override
    public void exitMethodDeclaration(MethodDeclarationContext ctx) {
	super.exitMethodDeclaration(ctx);
	ret = ret.concat(new StringBuilder().append("\n\t}").toString());
	returnTypeMethod = false;
    }

    // public String getValue() {
    // return ret;
    // }

    @Override
    public void enterReturnTypeMethodDeclaration(ReturnTypeMethodDeclarationContext ctx) {
	super.enterReturnTypeMethodDeclaration(ctx);
	returnTypeMethod = true;
	ret = ret.concat(new StringBuilder().append(ctx.getText() + " ").toString());
    }

    private String getModifiers(String s) {
	switch (s) {
	case PLUS:
	    return "public";
	case MINUS:
	    return "private";
	case HASH:
	    return "protected";
	default:
	    break;
	}
	return null;
    }

    @Override
    public void registerObserver(IObserver observer) {
	this.observer = (IParseObserver) observer;
    }

    @Override
    public void exitClassDeclaration(ClassDeclarationContext ctx) {
	super.exitClassDeclaration(ctx);
	notifyObserver(className, ret);
    }

    @Override
    public void notifyObserver(String name, String value) {
	this.observer.exec(name, value);
    }

}
