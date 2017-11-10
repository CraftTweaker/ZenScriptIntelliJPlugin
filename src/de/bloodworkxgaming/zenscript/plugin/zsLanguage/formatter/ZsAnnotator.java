package de.bloodworkxgaming.zenscript.plugin.zsLanguage.formatter;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsVariable;
import org.jetbrains.annotations.NotNull;

public class ZsAnnotator implements Annotator, DumbAware{
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof ZsVariable){
            holder.createInfoAnnotation(element.getTextRange(), "ZenScript Variable: " + ((ZsVariable) element).getName());
        }
    }
}
