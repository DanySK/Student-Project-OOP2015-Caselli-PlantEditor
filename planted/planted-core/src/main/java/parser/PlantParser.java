package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import interfaces.FileType;
import interfaces.IParser;
import utils.StringUtils;

public class PlantParser implements IParser {

    private final String PUBLIC = "public";
    private final String PRIVATE = "private";
    private final String PROTECTED = "protected";

    private String parsePlantFromJava(String code) {
	String ret = new StringBuilder().append("@startuml").append("\n").toString();
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
	if ((!newSt.get(0).equals("class") && !newSt.get(1).equals("class"))
		|| !newSt.get(newSt.indexOf("class") + 2).equals("{") || !newSt.get(newSt.size() - 1).equals("}")) {
	    return null;
	}
	ret = ret.concat(new StringBuilder().append(newSt.get(newSt.indexOf("class"))).append(" ")
		.append(newSt.get(newSt.indexOf("class") + 1).toLowerCase()).append(" {\n").toString());
	for (int i = newSt.indexOf("class") + 3; i < newSt.size() - 1; i++) {
	    if (newSt.get(i).contains("(") && newSt.get(i).contains(")")) {
		System.out.println("method");
	    } else {
		String spl = newSt.get(i);
		if (newSt.get(i).contains("=")) {
		    spl = newSt.get(i).split("=")[0].trim();
		} else {
		    spl = spl.substring(0, spl.length() - 1);
		}
		List<String> tmp = Arrays.asList(spl.split(" "));
		ret = ret.concat(new StringBuilder().append(getModifiers(tmp.get(0))).append(tmp.get(2)).append(" : ")
			.append(tmp.get(1)).append("\n").toString());
	    }
	}
	ret = ret.concat(new StringBuilder().append("}\n").append("@enduml").toString());
	return ret;
    }

    @Override
    public List<String> parse(String code, FileType srcType) {
	switch (srcType) {
	case JAVA:
	    return Lists.newArrayList(parsePlantFromJava(code));
	}
	return null;
    }

    private String getModifiers(String s) {
	switch (s) {
	case PUBLIC:
	    return "+";
	case PRIVATE:
	    return "-";
	case PROTECTED:
	    return "#";
	default:
	    break;
	}
	return null;
    }

}
