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

public class ZsIfStatementImpl extends ASTWrapperPsiElement implements ZsIfStatement {

  public ZsIfStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZsVisitor visitor) {
    visitor.visitIfStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZsVisitor) accept((ZsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZsCondition> getConditionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsCondition.class);
  }

  @Override
  @NotNull
  public List<ZsStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsStatement.class);
  }

  @Override
  @NotNull
  public List<ZsStatementBody> getStatementBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsStatementBody.class);
  }

}
