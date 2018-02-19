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

public class ZsValidCallableImpl extends ASTWrapperPsiElement implements ZsValidCallable {

  public ZsValidCallableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZsVisitor visitor) {
    visitor.visitValidCallable(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZsVisitor) accept((ZsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZsArrayMapRead getArrayMapRead() {
    return findChildByClass(ZsArrayMapRead.class);
  }

  @Override
  @Nullable
  public ZsBracketHandler getBracketHandler() {
    return findChildByClass(ZsBracketHandler.class);
  }

  @Override
  @Nullable
  public ZsValidVariable getValidVariable() {
    return findChildByClass(ZsValidVariable.class);
  }

  @Override
  @Nullable
  public ZsVariable getVariable() {
    return findChildByClass(ZsVariable.class);
  }

  @Override
  @Nullable
  public PsiElement getDoubleQuotedString() {
    return findChildByType(DOUBLE_QUOTED_STRING);
  }

  @Override
  @Nullable
  public PsiElement getSingleQuotedString() {
    return findChildByType(SINGLE_QUOTED_STRING);
  }

}
