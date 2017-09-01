// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl.*;

public interface ZsTypes {

  IElementType PROPERTY = new ZsElementType("PROPERTY");

  IElementType COMMENT = new ZsTokenType("COMMENT");
  IElementType CRLF = new ZsTokenType("CRLF");
  IElementType KEY = new ZsTokenType("KEY");
  IElementType SEPARATOR = new ZsTokenType("SEPARATOR");
  IElementType VALUE = new ZsTokenType("VALUE");

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
