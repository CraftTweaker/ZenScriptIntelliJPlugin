// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl.*;

public interface ZsTypes {

  IElementType BRACKETS = new ZsElementType("BRACKETS");
  IElementType PROPERTY = new ZsElementType("PROPERTY");

  IElementType COMMENT = new ZsTokenType("COMMENT");
  IElementType CRLF = new ZsTokenType("CRLF");
  IElementType KEY = new ZsTokenType("KEY");
  IElementType L_ANGLE_BRACKET = new ZsTokenType("L_ANGLE_BRACKET");
  IElementType L_ROUND_BRACKET = new ZsTokenType("L_ROUND_BRACKET");
  IElementType L_SQUARE_BRACKET = new ZsTokenType("L_SQUARE_BRACKET");
  IElementType L_SWIRL_BRACKET = new ZsTokenType("L_SWIRL_BRACKET");
  IElementType R_ANGLE_BRACKET = new ZsTokenType("R_ANGLE_BRACKET");
  IElementType R_ROUND_BRACKET = new ZsTokenType("R_ROUND_BRACKET");
  IElementType R_SQUARE_BRACKET = new ZsTokenType("R_SQUARE_BRACKET");
  IElementType R_SWIRL_BRACKET = new ZsTokenType("R_SWIRL_BRACKET");
  IElementType SEPARATOR = new ZsTokenType("SEPARATOR");
  IElementType VALUE = new ZsTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == BRACKETS) {
        return new ZsBracketsImpl(node);
      }
      else if (type == PROPERTY) {
        return new ZsPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
