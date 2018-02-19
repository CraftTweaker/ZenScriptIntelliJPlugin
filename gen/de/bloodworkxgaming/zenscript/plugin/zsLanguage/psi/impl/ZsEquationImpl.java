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

public class ZsEquationImpl extends ASTWrapperPsiElement implements ZsEquation {

  public ZsEquationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZsVisitor visitor) {
    visitor.visitEquation(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZsVisitor) accept((ZsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZsArrayMapRead> getArrayMapReadList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsArrayMapRead.class);
  }

  @Override
  @NotNull
  public List<ZsBracketHandler> getBracketHandlerList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsBracketHandler.class);
  }

  @Override
  @NotNull
  public List<ZsFunctionCall> getFunctionCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsFunctionCall.class);
  }

  @Override
  @NotNull
  public List<ZsNumber> getNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsNumber.class);
  }

  @Override
  @NotNull
  public List<ZsVariable> getVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZsVariable.class);
  }

}
