// Generated from gram/Plant.g4 by ANTLR 4.5
package gram;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PlantParser}.
 */
public interface PlantListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PlantParser#plantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPlantDeclaration(PlantParser.PlantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#plantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPlantDeclaration(PlantParser.PlantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(PlantParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(PlantParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(PlantParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(PlantParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(PlantParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(PlantParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(PlantParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(PlantParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(PlantParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(PlantParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#returnTypeMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterReturnTypeMethodDeclaration(PlantParser.ReturnTypeMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#returnTypeMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitReturnTypeMethodDeclaration(PlantParser.ReturnTypeMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#paramDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParamDeclaration(PlantParser.ParamDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#paramDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParamDeclaration(PlantParser.ParamDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#firstParamBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFirstParamBodyDeclaration(PlantParser.FirstParamBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#firstParamBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFirstParamBodyDeclaration(PlantParser.FirstParamBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#paramBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParamBodyDeclaration(PlantParser.ParamBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#paramBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParamBodyDeclaration(PlantParser.ParamBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#otherParamBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterOtherParamBodyDeclaration(PlantParser.OtherParamBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#otherParamBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitOtherParamBodyDeclaration(PlantParser.OtherParamBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#typeParamDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeParamDeclaration(PlantParser.TypeParamDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#typeParamDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeParamDeclaration(PlantParser.TypeParamDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(PlantParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(PlantParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#modifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModifierDeclaration(PlantParser.ModifierDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#modifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModifierDeclaration(PlantParser.ModifierDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#nameDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNameDeclaration(PlantParser.NameDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#nameDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNameDeclaration(PlantParser.NameDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlantParser#methodNameDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodNameDeclaration(PlantParser.MethodNameDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlantParser#methodNameDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodNameDeclaration(PlantParser.MethodNameDeclarationContext ctx);
}