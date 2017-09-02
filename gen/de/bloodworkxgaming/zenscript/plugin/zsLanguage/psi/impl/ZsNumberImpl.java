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

public class ZsNumberImpl extends ASTWrapperPsiElement implements ZsNumber {

  public ZsNumberImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZsVisitor visitor) {
    visitor.visitNumber(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZsVisitor) accept((ZsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getDigit() {
    return findChildByType(DIGIT);
  }

  @Override
  @Nullable
  public PsiElement getDigits() {
    return findChildByType(DIGITS);
  }

  @Override
  @Nullable
  public PsiElement getFloatingPoint() {
    return findChildByType(FLOATING_POINT);
  }

}
