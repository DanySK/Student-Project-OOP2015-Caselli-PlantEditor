package parser.printer;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import gram.SimpleJavaLexer;
import gram.SimpleJavaParser;
import gram.SimpleJavaParser.ClassDeclarationContext;
import interfaces.FileType;
import interfaces.IParseObserver;
import interfaces.IParser;
import parser.listener.JToPlantListener;

public class PlantPrinter implements IParser, IParseObserver {
    private List<String> ret = null;

    private List<String> printPlantFromJava(String in) {
	ret = new ArrayList<>();
	// Get our lexer
	SimpleJavaLexer lexer = new SimpleJavaLexer(new ANTLRInputStream(in));

	// Get a list of matched tokens
	CommonTokenStream tokens = new CommonTokenStream(lexer);

	// Pass the tokens to the parser
	SimpleJavaParser parser = new SimpleJavaParser(tokens);

	// Specify our entry point
	ClassDeclarationContext cont = parser.classDeclaration();

	// Walk it and attach our listener
	ParseTreeWalker walker = new ParseTreeWalker();
	JToPlantListener listener = new JToPlantListener();
	listener.registerObserver(this);
	walker.walk(listener, cont);
	return ret;
    }

    @Override
    public List<String> parse(String code, FileType srcType) {
	switch (srcType) {
	case JAVA:
	    return printPlantFromJava(code);
	default:
	    return null;
	}
    }

    @Override
    public void exec(String name, String value) {
	ret.add(name);
	ret.add(value);
    }
}
