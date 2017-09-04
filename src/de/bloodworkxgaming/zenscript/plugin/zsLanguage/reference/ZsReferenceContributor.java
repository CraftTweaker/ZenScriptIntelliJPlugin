package de.bloodworkxgaming.zenscript.plugin.zsLanguage.reference;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsVariable;
import org.jetbrains.annotations.NotNull;

public class ZsReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        // registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class), new PsiReferenceProvider() {
        //     @NotNull
        //     @Override
        //     public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
        //         PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
        //         String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
//
        //         if (value != null && value.startsWith("zs" + ":")) {
        //             ZsVariableReference ref = new ZsVariableReference(element, new TextRange(4, value.length() + 1));
        //             return new PsiReference[]{ref};
        //         }
//
        //         return PsiReference.EMPTY_ARRAY;
        //     }
        // });

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(ZsTypes.VARIABLE), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                ZsVariable variable = (ZsVariable) element;
                String value = variable.getName();

                if (value != null) {
                    ZsVariableReference ref = new ZsVariableReference(variable);
                    return new PsiReference[]{ref};
                }

                return PsiReference.EMPTY_ARRAY;
            }
        });
    }
}
