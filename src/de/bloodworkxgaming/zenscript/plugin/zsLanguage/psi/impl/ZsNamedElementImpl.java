package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class ZsNamedElementImpl extends ASTWrapperPsiElement implements ZsNamedElement {
    public ZsNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference getReference() {
        PsiReference[] references = getReferences();
        return references.length == 0 ? null : references[0];
    }

    @NotNull
    @Override
    public PsiReference[] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }
}
