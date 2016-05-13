package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import interfaces.FileType;
import interfaces.IParser;
import utils.StringUtils;

/**
 * Questa classe rappresenta un parser per il linguaggio Java costruito come
 * riconoscitore di grammatica.
 * 
 * @author ashleycaselli
 *
 */
public class JavaParser implements IParser {

    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String HASH = "#";

    /**
     * Metodo per parserizzare codice per la libreria PlantUML e tradurlo in
     * codice per il linguaggio Java.
     * 
     * @param code
     *            codice conforme al linguaggio utilizzato dalla libreria
     *            PlantUML
     * @return codice conforme al linguaggio Java
     */
    private String parseJavaFromPlant(String code) {
	String ret = null;
	String src = code.trim();
	List<String> st = Arrays.asList(src.split("\n"));
	List<String> newSt = new ArrayList<String>();
	st.forEach(sf -> {
	    if (sf.contains("class")) {
		Arrays.asList(sf.split(" ")).forEach(c -> {
		    newSt.add(c);
		});
	    } else if (!sf.equals(StringUtils.EMPTY) || !sf.isEmpty()) {
		newSt.add(sf.trim());
	    }
	});
	newSt.forEach(nst -> System.out.println(nst));
	if (!newSt.get(0).equals("@startuml") || !newSt.get(newSt.size() - 1).equals("@enduml")
		|| !newSt.get(1).equals("class") || !newSt.get(3).equals("{")
		|| !newSt.get(newSt.size() - 2).equals("}")) {
	    return null;
	}
	ret = new StringBuilder().append("public class ").append(Character.toUpperCase(newSt.get(2).charAt(0)))
		.append(newSt.get(2).substring(1)).append(" {\n").toString();
	for (int i = 4; i < newSt.size() - 2; i++) {
	    List<String> ls = Arrays.asList(newSt.get(i).split(":"));
	    ret = ret.concat(new StringBuilder().append("\n").append("\t")
		    .append(getModifiers(Character.toString(newSt.get(i).charAt(0)))).append(" ").append(ls.get(1))
		    .toString());
	    if (!newSt.get(i).contains(")")) {
		ret = ret.concat(
			new StringBuilder().append(" ").append(ls.get(0).substring(1).trim()).append(";\n").toString());
	    } else {
		if (newSt.get(i).contains("()")) {
		    ret = ret.concat(new StringBuilder().append(" ").append(ls.get(0).substring(1).trim()).toString());
		} else {
		    int minIndex = ls.get(0).substring(1).indexOf('(');
		    int maxIndex = ls.get(0).substring(1).indexOf(')') + 1;
		    ret = ret.concat(new StringBuilder().append(ls.get(0).substring(1).substring(minIndex, maxIndex))
			    .toString());
		}
		ret = ret.concat(new StringBuilder().append(" {\n\n\t};\n").toString());
	    }
	}
	ret = ret.concat("\n}");
	return ret;
    }

    /**
     * Metodo per la conversione dei modificatori del linguaggio.
     * 
     * @param s
     *            testo contenente il modificatore
     * @return modificatore convertito (conforme al linguaggio Java)
     */
    private String getModifiers(String s) {
	switch (s) {
	case PLUS:
	    return "public";
	case MINUS:
	    return "private";
	case HASH:
	    return "protected";
	default:
	    return null;
	}
    }

    @Override
    public List<String> parse(String code, FileType srcType) {
	switch (srcType) {
	case PLANTUML:
	    return Lists.newArrayList(parseJavaFromPlant(code));
	default:
	    return null;
	}
    }

}
