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

public class ZsValidVariableImpl extends ASTWrapperPsiElement implements ZsValidVariable {

  public ZsValidVariableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZsVisitor visitor) {
    visitor.visitValidVariable(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZsVisitor) accept((ZsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZsArrayDeclaration getArrayDeclaration() {
    return findChildByClass(ZsArrayDeclaration.class);
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
  public ZsCastExpression getCastExpression() {
    return findChildByClass(ZsCastExpression.class);
  }

  @Override
  @Nullable
  public ZsEquation getEquation() {
    return findChildByClass(ZsEquation.class);
  }

  @Override
  @Nullable
  public ZsFieldReference getFieldReference() {
    return findChildByClass(ZsFieldReference.class);
  }

  @Override
  @Nullable
  public ZsFunctionCall getFunctionCall() {
    return findChildByClass(ZsFunctionCall.class);
  }

  @Override
  @Nullable
  public ZsLambdaFunctionDeclaration getLambdaFunctionDeclaration() {
    return findChildByClass(ZsLambdaFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public ZsMapDeclaration getMapDeclaration() {
    return findChildByClass(ZsMapDeclaration.class);
  }

  @Override
  @Nullable
  public ZsModuloType getModuloType() {
    return findChildByClass(ZsModuloType.class);
  }

  @Override
  @Nullable
  public ZsNumber getNumber() {
    return findChildByClass(ZsNumber.class);
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
