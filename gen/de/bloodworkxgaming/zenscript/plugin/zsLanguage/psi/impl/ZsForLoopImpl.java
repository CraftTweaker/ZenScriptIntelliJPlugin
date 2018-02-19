// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.*;

public class ZsForLoopImpl extends ASTWrapperPsiElement implements ZsForLoop {

  public ZsForLoopImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZsVisitor visitor) {
    visitor.visitForLoop(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZsVisitor) accept((ZsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ZsStatementBody getStatementBody() {
    return findNotNullChildByClass(ZsStatementBody.class);
  }

  @Override
  @Nullable
  public ZsValidVariable getValidVariable() {
    return findChildByClass(ZsValidVariable.class);
  }

  @Override
  @NotNull
  public List<ZsVariable> getVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsVariable.class);
  }

  @Override
  @NotNull
  public PsiElement getIn() {
    return findNotNullChildByType(IN);
  }

}
