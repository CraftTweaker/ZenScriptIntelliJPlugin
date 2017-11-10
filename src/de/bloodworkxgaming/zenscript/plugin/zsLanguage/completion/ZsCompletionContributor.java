package de.bloodworkxgaming.zenscript.plugin.zsLanguage.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ProcessingContext;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsIcon;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsLanguage;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsFile;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsUtil;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsVariable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZsCompletionContributor extends CompletionContributor {
    private String[] keywords = {
            "any",
            "bool",
            "byte",
            "short",
            "int",
            "long",
            "float",
            "double",
            "string",
            "function",
            "in",
            "void",
            "as",
            "version",
            "if",
            "else",
            "for",
            "return",
            "var",
            "val",
            "null",
            "true",
            "false",
            "import",
    };

    public ZsCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ZsTypes.IDENTIFIER).withLanguage(ZsLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                        for (String keyword : keywords) {
                            result.addElement(LookupElementBuilder.create(keyword));
                        }

                        if (parameters.getOriginalFile() instanceof ZsFile){

                            List<ZsVariable> properties = ZsUtil.findVariables((ZsFile) parameters.getOriginalFile());
                            Set<String> alreadyAdded = new HashSet<>();

                            for (final ZsVariable property : properties) {
                                if (property.getName() != null && property.getName().length() > 0) {
                                    if (!alreadyAdded.contains(property.getName())){
                                        alreadyAdded.add(property.getName());

                                        result.addElement(LookupElementBuilder.create(property));
                                    }
                                }
                            }
                        }
                    }
                });
    }
}
