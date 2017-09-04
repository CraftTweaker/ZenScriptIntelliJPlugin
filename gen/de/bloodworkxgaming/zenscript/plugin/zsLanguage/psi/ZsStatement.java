// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZsStatement extends PsiElement {

  @Nullable
  ZsAssignStatement getAssignStatement();

  @Nullable
  ZsFunctionCall getFunctionCall();

  @Nullable
  PsiElement getEol();

}
