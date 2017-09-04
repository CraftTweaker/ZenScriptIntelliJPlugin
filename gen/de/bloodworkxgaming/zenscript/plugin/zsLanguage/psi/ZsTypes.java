// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl.*;

public interface ZsTypes {

  IElementType ARRAY_DECLARATION = new ZsElementType("ARRAY_DECLARATION");
  IElementType ARRAY_READ = new ZsElementType("ARRAY_READ");
  IElementType ASSIGN_STATEMENT = new ZsElementType("ASSIGN_STATEMENT");
  IElementType BRACKET_HANDLER = new ZsElementType("BRACKET_HANDLER");
  IElementType CAST_EXPRESSION = new ZsElementType("CAST_EXPRESSION");
  IElementType CLASS_NAME = new ZsElementType("CLASS_NAME");
  IElementType CONDITION = new ZsElementType("CONDITION");
  IElementType EQUATION = new ZsElementType("EQUATION");
  IElementType FOR_LOOP = new ZsElementType("FOR_LOOP");
  IElementType FUNCTION_BODY = new ZsElementType("FUNCTION_BODY");
  IElementType FUNCTION_CALL = new ZsElementType("FUNCTION_CALL");
  IElementType FUNCTION_DECLARATION = new ZsElementType("FUNCTION_DECLARATION");
  IElementType IF_STATEMENT = new ZsElementType("IF_STATEMENT");
  IElementType IMPORT_LIST = new ZsElementType("IMPORT_LIST");
  IElementType IMPORT_STATEMENT = new ZsElementType("IMPORT_STATEMENT");
  IElementType LAMBDA_FUNCTION_DECLARATION = new ZsElementType("LAMBDA_FUNCTION_DECLARATION");
  IElementType NUMBER = new ZsElementType("NUMBER");
  IElementType PARAMETER_LIST = new ZsElementType("PARAMETER_LIST");
  IElementType PARAMETER_VARIABLE = new ZsElementType("PARAMETER_VARIABLE");
  IElementType RETURN_STATEMENT = new ZsElementType("RETURN_STATEMENT");
  IElementType STATEMENT = new ZsElementType("STATEMENT");
  IElementType STATEMENT_BODY = new ZsElementType("STATEMENT_BODY");
  IElementType VALID_CALLABLE = new ZsElementType("VALID_CALLABLE");
  IElementType VALID_VARIABLE = new ZsElementType("VALID_VARIABLE");
  IElementType VARIABLE = new ZsElementType("VARIABLE");

  IElementType AND = new ZsTokenType("&");
  IElementType ANY = new ZsTokenType("any");
  IElementType AS = new ZsTokenType("as");
  IElementType ASTERISK = new ZsTokenType("*");
  IElementType AT = new ZsTokenType("@");
  IElementType BLOCK_COMMENT = new ZsTokenType("BLOCK_COMMENT");
  IElementType BOOL = new ZsTokenType("bool");
  IElementType BYTE = new ZsTokenType("byte");
  IElementType COLON = new ZsTokenType(":");
  IElementType COMMA = new ZsTokenType(",");
  IElementType DIGITS = new ZsTokenType("DIGITS");
  IElementType DIV = new ZsTokenType("/");
  IElementType DOT = new ZsTokenType(".");
  IElementType DOUBLE = new ZsTokenType("double");
  IElementType DOUBLE_QUOTED_STRING = new ZsTokenType("DOUBLE_QUOTED_STRING");
  IElementType ELSE = new ZsTokenType("else");
  IElementType EOL = new ZsTokenType("EOL");
  IElementType EQEQ = new ZsTokenType("==");
  IElementType EQUAL = new ZsTokenType("=");
  IElementType EXCL = new ZsTokenType("!");
  IElementType FALSE = new ZsTokenType("false");
  IElementType FLOAT = new ZsTokenType("float");
  IElementType FLOATING_POINT = new ZsTokenType("FLOATING_POINT");
  IElementType FOR = new ZsTokenType("for");
  IElementType FUNCTION = new ZsTokenType("function");
  IElementType GREATER_EQUAL = new ZsTokenType(">=");
  IElementType HASH = new ZsTokenType("#");
  IElementType IDENTIFIER = new ZsTokenType("IDENTIFIER");
  IElementType IF = new ZsTokenType("if");
  IElementType IMPORT = new ZsTokenType("import");
  IElementType IN = new ZsTokenType("in");
  IElementType INT = new ZsTokenType("int");
  IElementType LESS_EQUAL = new ZsTokenType("<=");
  IElementType LINE_COMMENT = new ZsTokenType("LINE_COMMENT");
  IElementType LONG = new ZsTokenType("long");
  IElementType L_ANGLE_BRACKET = new ZsTokenType("<");
  IElementType L_CURLY_BRACKET = new ZsTokenType("{");
  IElementType L_ROUND_BRACKET = new ZsTokenType("(");
  IElementType L_SQUARE_BRACKET = new ZsTokenType("[");
  IElementType MINUS = new ZsTokenType("-");
  IElementType NOT_EQUAL = new ZsTokenType("!=");
  IElementType NULL = new ZsTokenType("null");
  IElementType OR = new ZsTokenType("|");
  IElementType PERC = new ZsTokenType("%");
  IElementType PLUS = new ZsTokenType("+");
  IElementType QUEST = new ZsTokenType("?");
  IElementType RETURN = new ZsTokenType("return");
  IElementType R_ANGLE_BRACKET = new ZsTokenType(">");
  IElementType R_CURLY_BRACKET = new ZsTokenType("}");
  IElementType R_ROUND_BRACKET = new ZsTokenType(")");
  IElementType R_SQUARE_BRACKET = new ZsTokenType("]");
  IElementType SEMICOLON = new ZsTokenType(";");
  IElementType SHORT = new ZsTokenType("short");
  IElementType SINGLE_QUOTED_STRING = new ZsTokenType("SINGLE_QUOTED_STRING");
  IElementType STRING = new ZsTokenType("string");
  IElementType TILDE = new ZsTokenType("~");
  IElementType TO = new ZsTokenType("to");
  IElementType TRUE = new ZsTokenType("true");
  IElementType VAL = new ZsTokenType("val");
  IElementType VAR = new ZsTokenType("var");
  IElementType VERSION = new ZsTokenType("version");
  IElementType VOID = new ZsTokenType("void");
  IElementType XOR = new ZsTokenType("^");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARRAY_DECLARATION) {
        return new ZsArrayDeclarationImpl(node);
      }
      else if (type == ARRAY_READ) {
        return new ZsArrayReadImpl(node);
      }
      else if (type == ASSIGN_STATEMENT) {
        return new ZsAssignStatementImpl(node);
      }
      else if (type == BRACKET_HANDLER) {
        return new ZsBracketHandlerImpl(node);
      }
      else if (type == CAST_EXPRESSION) {
        return new ZsCastExpressionImpl(node);
      }
      else if (type == CLASS_NAME) {
        return new ZsClassNameImpl(node);
      }
      else if (type == CONDITION) {
        return new ZsConditionImpl(node);
      }
      else if (type == EQUATION) {
        return new ZsEquationImpl(node);
      }
      else if (type == FOR_LOOP) {
        return new ZsForLoopImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new ZsFunctionBodyImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new ZsFunctionCallImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new ZsFunctionDeclarationImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new ZsIfStatementImpl(node);
      }
      else if (type == IMPORT_LIST) {
        return new ZsImportListImpl(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new ZsImportStatementImpl(node);
      }
      else if (type == LAMBDA_FUNCTION_DECLARATION) {
        return new ZsLambdaFunctionDeclarationImpl(node);
      }
      else if (type == NUMBER) {
        return new ZsNumberImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new ZsParameterListImpl(node);
      }
      else if (type == PARAMETER_VARIABLE) {
        return new ZsParameterVariableImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new ZsReturnStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new ZsStatementImpl(node);
      }
      else if (type == STATEMENT_BODY) {
        return new ZsStatementBodyImpl(node);
      }
      else if (type == VALID_CALLABLE) {
        return new ZsValidCallableImpl(node);
      }
      else if (type == VALID_VARIABLE) {
        return new ZsValidVariableImpl(node);
      }
      else if (type == VARIABLE) {
        return new ZsVariableImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
