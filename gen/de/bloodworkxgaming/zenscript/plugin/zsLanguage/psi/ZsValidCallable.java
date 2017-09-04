// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZsValidCallable extends PsiElement {

  @Nullable
  ZsArrayRead getArrayRead();

  @Nullable
  ZsBracketHandler getBracketHandler();

  @Nullable
  ZsVariable getVariable();

  @Nullable
  PsiElement getDoubleQuotedString();

  @Nullable
  PsiElement getSingleQuotedString();

}
