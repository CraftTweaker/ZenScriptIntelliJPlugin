// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes.*;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.*;

public class ZsVariableImpl extends ZsNamedElementImpl implements ZsVariable {

  public ZsVariableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZsVisitor visitor) {
    visitor.visitVariable(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZsVisitor) accept((ZsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

  public String getName() {
    return ZsPsiImplUtil.getName(this);
  }

  public PsiElement getNameIdentifier() {
    return ZsPsiImplUtil.getNameIdentifier(this);
  }

  public PsiElement setName(String name) {
    return ZsPsiImplUtil.setName(this, name);
  }

}
