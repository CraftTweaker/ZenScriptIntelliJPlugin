// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZsFunctionDeclaration extends PsiElement {

  @Nullable
  ZsParameterList getParameterList();

  @NotNull
  ZsStatementBody getStatementBody();

  @NotNull
  PsiElement getIdentifier();

}
