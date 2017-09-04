package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsIcon;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsAssignStatement;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsElementFactory;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsVariable;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ZsPsiImplUtil {
    public static String getVariableName(ZsAssignStatement element){
        ASTNode identifierNode = element.getNode().findChildByType(ZsTypes.VARIABLE);
        if (identifierNode != null){
            System.out.println("identifierNode.getText() = " + identifierNode.getText());
            return identifierNode.getText().replace("\\\\ ", " ");
        }else {
            return null;
        }
    }

    public static PsiElement setVariableName(ZsAssignStatement element, String newName){
        ASTNode keyNode = element.getNode().findChildByType(ZsTypes.VARIABLE);
        if (keyNode != null) {

            ZsAssignStatement property = ZsElementFactory.createAssignStatement(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(ZsAssignStatement element) {
        ASTNode keyNode = element.getNode().findChildByType(ZsTypes.VARIABLE);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
    /**********************
    *   {@link ZsVariable} *
    ***********************/
    public static String getName(ZsVariable variable){
        return variable.getText();
    }

    public static PsiElement setName(ZsVariable variable, String name){
        ASTNode keyNode = variable.getNode().findChildByType(ZsTypes.VARIABLE);

        if (keyNode != null) {
            ZsVariable property = ZsElementFactory.createVariableStatement(variable.getProject(), name);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            variable.getNode().replaceChild(keyNode, newKeyNode);
        }

        return variable;
    }

    public static PsiElement getNameIdentifier(ZsVariable element) {
        ASTNode keyNode = element.getNode().findChildByType(ZsTypes.VARIABLE);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final ZsAssignStatement element){
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getText();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return ZsIcon.FILE;
            }
        };
    }
}
