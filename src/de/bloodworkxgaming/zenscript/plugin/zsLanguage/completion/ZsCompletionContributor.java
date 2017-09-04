package de.bloodworkxgaming.zenscript.plugin.zsLanguage.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsLanguage;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes;
import org.jetbrains.annotations.NotNull;

public class ZsCompletionContributor extends CompletionContributor {
    public ZsCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(ZsTypes.IDENTIFIER).withLanguage(ZsLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                        result.addElement(LookupElementBuilder.create("Hello"));
                    }
                });
    }
}
