// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZsStatementBody extends PsiElement {

  @Nullable
  ZsFunctionBody getFunctionBody();

  @NotNull
  List<ZsStatement> getStatementList();

}
