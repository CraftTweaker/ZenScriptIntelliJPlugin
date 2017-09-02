// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl.*;

public interface ZsTypes {

  IElementType ASSIGN_STATEMENT = new ZsElementType("ASSIGN_STATEMENT");
  IElementType BRACKET_HANDLER = new ZsElementType("BRACKET_HANDLER");
  IElementType FUNCTION_CALL = new ZsElementType("FUNCTION_CALL");
  IElementType NUMBER = new ZsElementType("NUMBER");
  IElementType VALID_VARIABLE = new ZsElementType("VALID_VARIABLE");

  IElementType ANY = new ZsTokenType("any");
  IElementType AS = new ZsTokenType("as");
  IElementType ASTERISK = new ZsTokenType("*");
  IElementType AT = new ZsTokenType("@");
  IElementType BLOCK_COMMENT = new ZsTokenType("BLOCK_COMMENT");
  IElementType BOOL = new ZsTokenType("bool");
  IElementType BYTE = new ZsTokenType("byte");
  IElementType COLON = new ZsTokenType(":");
  IElementType COMMA = new ZsTokenType(",");
  IElementType DIGIT = new ZsTokenType("DIGIT");
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
  IElementType PROPERTY = new ZsTokenType("property");
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
  IElementType TRUE = new ZsTokenType("true");
  IElementType VAL = new ZsTokenType("val");
  IElementType VAR = new ZsTokenType("var");
  IElementType VERSION = new ZsTokenType("version");
  IElementType VOID = new ZsTokenType("void");
  IElementType XOR = new ZsTokenType("^");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ASSIGN_STATEMENT) {
        return new ZsAssignStatementImpl(node);
      }
      else if (type == BRACKET_HANDLER) {
        return new ZsBracketHandlerImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new ZsFunctionCallImpl(node);
      }
      else if (type == NUMBER) {
        return new ZsNumberImpl(node);
      }
      else if (type == VALID_VARIABLE) {
        return new ZsValidVariableImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
