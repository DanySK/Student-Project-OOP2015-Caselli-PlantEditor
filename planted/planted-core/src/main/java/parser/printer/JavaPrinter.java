package parser.printer;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import gram.PlantLexer;
import gram.PlantParser;
import gram.PlantParser.PlantDeclarationContext;
import gram.SimpleJavaLexer;
import gram.SimpleJavaParser;
import gram.SimpleJavaParser.ClassDeclarationContext;
import interfaces.FileType;
import interfaces.IParseObserver;
import interfaces.IParser;
import parser.listener.JToJListener;
import parser.listener.PlantToJListener;

public class JavaPrinter implements IParser, IParseObserver {

    private List<String> ret = new ArrayList<>();

    @Override
    public List<String> parse(String code, FileType srcType) {
	switch (srcType) {
	case PLANTUML:
	    return printJavaFromPlant(code);
	case JAVA:
	    return printJavaFromJava(code);
	default:
	    return null;
	}

    }

    private List<String> printJavaFromJava(String in) {
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
	JToJListener listener = new JToJListener();
	walker.walk(listener, cont);
	return ret;
    }

    private List<String> printJavaFromPlant(String in) {
	// Get our lexer
	PlantLexer lexer = new PlantLexer(new ANTLRInputStream(in));

	// Get a list of matched tokens
	CommonTokenStream tokens = new CommonTokenStream(lexer);

	// Pass the tokens to the parser
	PlantParser parser = new PlantParser(tokens);

	// Specify our entry point
	PlantDeclarationContext cont = parser.plantDeclaration();

	// Walk it and attach our listener
	ParseTreeWalker walker = new ParseTreeWalker();
	PlantToJListener listener = new PlantToJListener();
	listener.registerObserver(this);
	walker.walk(listener, cont);

	return ret;
    }

    @Override
    public void exec(String name, String value) {
	ret.add(name);
	ret.add(value);
    }

}
