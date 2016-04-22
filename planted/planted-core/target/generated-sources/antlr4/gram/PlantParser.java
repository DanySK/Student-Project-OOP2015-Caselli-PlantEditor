// Generated from gram/Plant.g4 by ANTLR 4.5
package gram;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PlantParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TEXT=13, MODIFIER=14, WHITESPACE=15;
	public static final int
		RULE_plantDeclaration = 0, RULE_classDeclaration = 1, RULE_classBody = 2, 
		RULE_classBodyDeclaration = 3, RULE_fieldDeclaration = 4, RULE_methodDeclaration = 5, 
		RULE_returnTypeMethodDeclaration = 6, RULE_paramDeclaration = 7, RULE_firstParamBodyDeclaration = 8, 
		RULE_paramBodyDeclaration = 9, RULE_otherParamBodyDeclaration = 10, RULE_typeParamDeclaration = 11, 
		RULE_typeDeclaration = 12, RULE_modifierDeclaration = 13, RULE_nameDeclaration = 14, 
		RULE_methodNameDeclaration = 15;
	public static final String[] ruleNames = {
		"plantDeclaration", "classDeclaration", "classBody", "classBodyDeclaration", 
		"fieldDeclaration", "methodDeclaration", "returnTypeMethodDeclaration", 
		"paramDeclaration", "firstParamBodyDeclaration", "paramBodyDeclaration", 
		"otherParamBodyDeclaration", "typeParamDeclaration", "typeDeclaration", 
		"modifierDeclaration", "nameDeclaration", "methodNameDeclaration"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@startuml'", "'@enduml'", "'class'", "'{'", "'}'", "':'", "'int'", 
		"'String'", "'void'", "'('", "')'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "TEXT", "MODIFIER", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Plant.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PlantParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PlantDeclarationContext extends ParserRuleContext {
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public PlantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plantDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterPlantDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitPlantDeclaration(this);
		}
	}

	public final PlantDeclarationContext plantDeclaration() throws RecognitionException {
		PlantDeclarationContext _localctx = new PlantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_plantDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(33);
				classDeclaration();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PlantParser.TEXT, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__2);
			setState(42);
			match(TEXT);
			setState(43);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__3);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << TEXT) | (1L << MODIFIER))) != 0)) {
				{
				{
				setState(46);
				classBodyDeclaration();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitClassBodyDeclaration(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classBodyDeclaration);
		try {
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				fieldDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				methodDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public NameDeclarationContext nameDeclaration() {
			return getRuleContext(NameDeclarationContext.class,0);
		}
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public ModifierDeclarationContext modifierDeclaration() {
			return getRuleContext(ModifierDeclarationContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if (_la==MODIFIER) {
				{
				setState(58);
				modifierDeclaration();
				}
			}

			setState(61);
			nameDeclaration();
			setState(62);
			match(T__5);
			setState(63);
			typeDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodNameDeclarationContext methodNameDeclaration() {
			return getRuleContext(MethodNameDeclarationContext.class,0);
		}
		public ParamDeclarationContext paramDeclaration() {
			return getRuleContext(ParamDeclarationContext.class,0);
		}
		public ModifierDeclarationContext modifierDeclaration() {
			return getRuleContext(ModifierDeclarationContext.class,0);
		}
		public ReturnTypeMethodDeclarationContext returnTypeMethodDeclaration() {
			return getRuleContext(ReturnTypeMethodDeclarationContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if (_la==MODIFIER) {
				{
				setState(65);
				modifierDeclaration();
				}
			}

			setState(69);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) {
				{
				setState(68);
				returnTypeMethodDeclaration();
				}
			}

			setState(71);
			methodNameDeclaration();
			setState(72);
			paramDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnTypeMethodDeclarationContext extends ParserRuleContext {
		public ReturnTypeMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnTypeMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterReturnTypeMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitReturnTypeMethodDeclaration(this);
		}
	}

	public final ReturnTypeMethodDeclarationContext returnTypeMethodDeclaration() throws RecognitionException {
		ReturnTypeMethodDeclarationContext _localctx = new ReturnTypeMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnTypeMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamDeclarationContext extends ParserRuleContext {
		public List<ParamBodyDeclarationContext> paramBodyDeclaration() {
			return getRuleContexts(ParamBodyDeclarationContext.class);
		}
		public ParamBodyDeclarationContext paramBodyDeclaration(int i) {
			return getRuleContext(ParamBodyDeclarationContext.class,i);
		}
		public ParamDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterParamDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitParamDeclaration(this);
		}
	}

	public final ParamDeclarationContext paramDeclaration() throws RecognitionException {
		ParamDeclarationContext _localctx = new ParamDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__9);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__7) {
				{
				{
				setState(77);
				paramBodyDeclaration();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FirstParamBodyDeclarationContext extends ParserRuleContext {
		public TypeParamDeclarationContext typeParamDeclaration() {
			return getRuleContext(TypeParamDeclarationContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(PlantParser.TEXT, 0); }
		public FirstParamBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_firstParamBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterFirstParamBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitFirstParamBodyDeclaration(this);
		}
	}

	public final FirstParamBodyDeclarationContext firstParamBodyDeclaration() throws RecognitionException {
		FirstParamBodyDeclarationContext _localctx = new FirstParamBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_firstParamBodyDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			typeParamDeclaration();
			setState(86);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamBodyDeclarationContext extends ParserRuleContext {
		public FirstParamBodyDeclarationContext firstParamBodyDeclaration() {
			return getRuleContext(FirstParamBodyDeclarationContext.class,0);
		}
		public List<OtherParamBodyDeclarationContext> otherParamBodyDeclaration() {
			return getRuleContexts(OtherParamBodyDeclarationContext.class);
		}
		public OtherParamBodyDeclarationContext otherParamBodyDeclaration(int i) {
			return getRuleContext(OtherParamBodyDeclarationContext.class,i);
		}
		public ParamBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterParamBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitParamBodyDeclaration(this);
		}
	}

	public final ParamBodyDeclarationContext paramBodyDeclaration() throws RecognitionException {
		ParamBodyDeclarationContext _localctx = new ParamBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_paramBodyDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			firstParamBodyDeclaration();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(89);
				otherParamBodyDeclaration();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherParamBodyDeclarationContext extends ParserRuleContext {
		public TypeParamDeclarationContext typeParamDeclaration() {
			return getRuleContext(TypeParamDeclarationContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(PlantParser.TEXT, 0); }
		public OtherParamBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherParamBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterOtherParamBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitOtherParamBodyDeclaration(this);
		}
	}

	public final OtherParamBodyDeclarationContext otherParamBodyDeclaration() throws RecognitionException {
		OtherParamBodyDeclarationContext _localctx = new OtherParamBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_otherParamBodyDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__11);
			setState(96);
			typeParamDeclaration();
			setState(97);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParamDeclarationContext extends ParserRuleContext {
		public TypeParamDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParamDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterTypeParamDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitTypeParamDeclaration(this);
		}
	}

	public final TypeParamDeclarationContext typeParamDeclaration() throws RecognitionException {
		TypeParamDeclarationContext _localctx = new TypeParamDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeParamDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitTypeDeclaration(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierDeclarationContext extends ParserRuleContext {
		public TerminalNode MODIFIER() { return getToken(PlantParser.MODIFIER, 0); }
		public ModifierDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterModifierDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitModifierDeclaration(this);
		}
	}

	public final ModifierDeclarationContext modifierDeclaration() throws RecognitionException {
		ModifierDeclarationContext _localctx = new ModifierDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_modifierDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(MODIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameDeclarationContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PlantParser.TEXT, 0); }
		public NameDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterNameDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitNameDeclaration(this);
		}
	}

	public final NameDeclarationContext nameDeclaration() throws RecognitionException {
		NameDeclarationContext _localctx = new NameDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_nameDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodNameDeclarationContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PlantParser.TEXT, 0); }
		public MethodNameDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodNameDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).enterMethodNameDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlantListener ) ((PlantListener)listener).exitMethodNameDeclaration(this);
		}
	}

	public final MethodNameDeclarationContext methodNameDeclaration() throws RecognitionException {
		MethodNameDeclarationContext _localctx = new MethodNameDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_methodNameDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21p\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\7\2%\n"+
		"\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4\62\n\4\f\4\16\4"+
		"\65\13\4\3\4\3\4\3\5\3\5\5\5;\n\5\3\6\5\6>\n\6\3\6\3\6\3\6\3\6\3\7\5\7"+
		"E\n\7\3\7\5\7H\n\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\7\tQ\n\t\f\t\16\tT\13\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\7\13]\n\13\f\13\16\13`\13\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\2\2\22\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\4\3\2\t\13\3\2\t\ng\2\"\3\2\2\2"+
		"\4+\3\2\2\2\6/\3\2\2\2\b:\3\2\2\2\n=\3\2\2\2\fD\3\2\2\2\16L\3\2\2\2\20"+
		"N\3\2\2\2\22W\3\2\2\2\24Z\3\2\2\2\26a\3\2\2\2\30e\3\2\2\2\32g\3\2\2\2"+
		"\34i\3\2\2\2\36k\3\2\2\2 m\3\2\2\2\"&\7\3\2\2#%\5\4\3\2$#\3\2\2\2%(\3"+
		"\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7\4\2\2*\3\3\2\2\2"+
		"+,\7\5\2\2,-\7\17\2\2-.\5\6\4\2.\5\3\2\2\2/\63\7\6\2\2\60\62\5\b\5\2\61"+
		"\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65"+
		"\63\3\2\2\2\66\67\7\7\2\2\67\7\3\2\2\28;\5\n\6\29;\5\f\7\2:8\3\2\2\2:"+
		"9\3\2\2\2;\t\3\2\2\2<>\5\34\17\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\5\36"+
		"\20\2@A\7\b\2\2AB\5\32\16\2B\13\3\2\2\2CE\5\34\17\2DC\3\2\2\2DE\3\2\2"+
		"\2EG\3\2\2\2FH\5\16\b\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\5 \21\2JK\5\20"+
		"\t\2K\r\3\2\2\2LM\t\2\2\2M\17\3\2\2\2NR\7\f\2\2OQ\5\24\13\2PO\3\2\2\2"+
		"QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7\r\2\2V\21\3\2\2"+
		"\2WX\5\30\r\2XY\7\17\2\2Y\23\3\2\2\2Z^\5\22\n\2[]\5\26\f\2\\[\3\2\2\2"+
		"]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\25\3\2\2\2`^\3\2\2\2ab\7\16\2\2bc\5\30"+
		"\r\2cd\7\17\2\2d\27\3\2\2\2ef\t\3\2\2f\31\3\2\2\2gh\t\3\2\2h\33\3\2\2"+
		"\2ij\7\20\2\2j\35\3\2\2\2kl\7\17\2\2l\37\3\2\2\2mn\7\17\2\2n!\3\2\2\2"+
		"\n&\63:=DGR^";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}