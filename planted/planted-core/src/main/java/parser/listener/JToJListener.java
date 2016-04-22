package parser.listener;

import org.antlr.v4.runtime.ParserRuleContext;

import gram.SimpleJavaBaseListener;

public class JToJListener extends SimpleJavaBaseListener {

    private String ret = new StringBuilder().toString();

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
	super.enterEveryRule(ctx);
	ret = ret.concat(new StringBuilder().append(ctx.getText()).append(" ").toString());
	System.out.println(ret + "\n");
    }

}
