// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl.*;

public interface ZsTypes {

  IElementType PROPERTY = new ZsElementType("PROPERTY");

  IElementType ANY = new ZsTokenType("any");
  IElementType AS = new ZsTokenType("as");
  IElementType BLOCK_COMMENT = new ZsTokenType("BLOCK_COMMENT");
  IElementType BOOL = new ZsTokenType("bool");
  IElementType BYTE = new ZsTokenType("byte");
  IElementType COLON = new ZsTokenType(":");
  IElementType COMMA = new ZsTokenType(",");
  IElementType CRLF = new ZsTokenType("CRLF");
  IElementType DOUBLE = new ZsTokenType("double");
  IElementType DOUBLE_QUOTED_STRING = new ZsTokenType("DOUBLE_QUOTED_STRING");
  IElementType ELSE = new ZsTokenType("else");
  IElementType FALSE = new ZsTokenType("false");
  IElementType FLOAT = new ZsTokenType("float");
  IElementType FOR = new ZsTokenType("for");
  IElementType FUNCTION = new ZsTokenType("function");
  IElementType IF = new ZsTokenType("if");
  IElementType IMPORT = new ZsTokenType("import");
  IElementType IN = new ZsTokenType("in");
  IElementType INT = new ZsTokenType("int");
  IElementType KEY = new ZsTokenType("KEY");
  IElementType LINE_COMMENT = new ZsTokenType("LINE_COMMENT");
  IElementType LONG = new ZsTokenType("long");
  IElementType L_ANGLE_BRACKET = new ZsTokenType("<");
  IElementType L_CURLY_BRACKET = new ZsTokenType("{");
  IElementType L_ROUND_BRACKET = new ZsTokenType("(");
  IElementType L_SQUARE_BRACKET = new ZsTokenType("[");
  IElementType NULL = new ZsTokenType("null");
  IElementType NUMBER = new ZsTokenType("NUMBER");
  IElementType RETURN = new ZsTokenType("return");
  IElementType R_ANGLE_BRACKET = new ZsTokenType(">");
  IElementType R_CURLY_BRACKET = new ZsTokenType("}");
  IElementType R_ROUND_BRACKET = new ZsTokenType(")");
  IElementType R_SQUARE_BRACKET = new ZsTokenType("]");
  IElementType SEPARATOR = new ZsTokenType("SEPARATOR");
  IElementType SHORT = new ZsTokenType("short");
  IElementType SINGLE_QUOTED_STRING = new ZsTokenType("SINGLE_QUOTED_STRING");
  IElementType STRING = new ZsTokenType("string");
  IElementType TRUE = new ZsTokenType("true");
  IElementType VAL = new ZsTokenType("val");
  IElementType VALUE = new ZsTokenType("VALUE");
  IElementType VAR = new ZsTokenType("var");
  IElementType VERSION = new ZsTokenType("version");
  IElementType VOID = new ZsTokenType("void");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new ZsPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
