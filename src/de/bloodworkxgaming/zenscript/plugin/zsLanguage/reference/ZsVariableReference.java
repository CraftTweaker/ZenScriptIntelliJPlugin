package de.bloodworkxgaming.zenscript.plugin.zsLanguage.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsIcon;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsFile;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsUtil;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsVariable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZsVariableReference extends PsiReferenceBase<ZsVariable> implements PsiPolyVariantReference {
    private String varName;

    public ZsVariableReference(ZsVariable element) {
        super(element, new TextRange(0, element.getName() == null ? 0 : element.getName().length()));
        varName = element.getName();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        ZsFile file = (ZsFile) myElement.getContainingFile();

        final List<ZsVariable> properties = ZsUtil.findVariables(file, varName);

        List<ResolveResult> results = new ArrayList<>();
        for (ZsVariable property : properties) {
            if (property != myElement)
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
        ZsFile file = (ZsFile) myElement.getContainingFile();

        List<ZsVariable> properties = ZsUtil.findVariables(file);
        List<LookupElement> variants = new ArrayList<>();

        Set<String> alreadyAdded = new HashSet<>();


        for (final ZsVariable property : properties) {
            if (property.getName() != null && property.getName().length() > 0) {
                if (!alreadyAdded.contains(property.getName())){
                    alreadyAdded.add(property.getName());
                    variants.add(LookupElementBuilder.create(property).
                            withIcon(ZsIcon.FILE).
                            withTypeText(property.getParent().getText())
                    );
                }
            }
        }
        return variants.toArray();
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        return myElement.setName(newElementName);
    }
}
