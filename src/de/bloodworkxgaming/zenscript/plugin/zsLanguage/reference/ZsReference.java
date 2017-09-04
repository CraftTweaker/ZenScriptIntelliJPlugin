package de.bloodworkxgaming.zenscript.plugin.zsLanguage.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsIcon;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsUtil;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsVariable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ZsReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String varName;

    public ZsReference(PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        varName = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<ZsVariable> properties = ZsUtil.findVariables(project, varName);
        List<ResolveResult> results = new ArrayList<>();
        for (ZsVariable property : properties) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<ZsVariable> properties = ZsUtil.findVariables(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final ZsVariable property : properties) {
            if (property.getName() != null && property.getName().length() > 0) {
                variants.add(LookupElementBuilder.create(property).
                        withIcon(ZsIcon.FILE).
                        withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
