// Generated from gram/SimpleJava.g4 by ANTLR 4.5
package gram;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleJavaParser}.
 */
public interface SimpleJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(SimpleJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(SimpleJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(SimpleJavaParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(SimpleJavaParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(SimpleJavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(SimpleJavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(SimpleJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(SimpleJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(SimpleJavaParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(SimpleJavaParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#methodBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodBodyDeclaration(SimpleJavaParser.MethodBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#methodBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodBodyDeclaration(SimpleJavaParser.MethodBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(SimpleJavaParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(SimpleJavaParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#paramDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParamDeclaration(SimpleJavaParser.ParamDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#paramDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParamDeclaration(SimpleJavaParser.ParamDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#paramBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParamBodyDeclaration(SimpleJavaParser.ParamBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#paramBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParamBodyDeclaration(SimpleJavaParser.ParamBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#firstParamBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFirstParamBodyDeclaration(SimpleJavaParser.FirstParamBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#firstParamBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFirstParamBodyDeclaration(SimpleJavaParser.FirstParamBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#otherParamBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterOtherParamBodyDeclaration(SimpleJavaParser.OtherParamBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#otherParamBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitOtherParamBodyDeclaration(SimpleJavaParser.OtherParamBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#paramName}.
	 * @param ctx the parse tree
	 */
	void enterParamName(SimpleJavaParser.ParamNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#paramName}.
	 * @param ctx the parse tree
	 */
	void exitParamName(SimpleJavaParser.ParamNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(SimpleJavaParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(SimpleJavaParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#fieldInitializion}.
	 * @param ctx the parse tree
	 */
	void enterFieldInitializion(SimpleJavaParser.FieldInitializionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#fieldInitializion}.
	 * @param ctx the parse tree
	 */
	void exitFieldInitializion(SimpleJavaParser.FieldInitializionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(SimpleJavaParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(SimpleJavaParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(SimpleJavaParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(SimpleJavaParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#methodReturnType}.
	 * @param ctx the parse tree
	 */
	void enterMethodReturnType(SimpleJavaParser.MethodReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#methodReturnType}.
	 * @param ctx the parse tree
	 */
	void exitMethodReturnType(SimpleJavaParser.MethodReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpleJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpleJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterFieldType(SimpleJavaParser.FieldTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitFieldType(SimpleJavaParser.FieldTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleJavaParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterParamType(SimpleJavaParser.ParamTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleJavaParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitParamType(SimpleJavaParser.ParamTypeContext ctx);
}