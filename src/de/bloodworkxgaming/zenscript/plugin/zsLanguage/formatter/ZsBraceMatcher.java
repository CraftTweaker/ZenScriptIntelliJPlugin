package de.bloodworkxgaming.zenscript.plugin.zsLanguage.formatter;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ZsBraceMatcher implements PairedBraceMatcher {
    @NotNull
    @Override
    public BracePair[] getPairs() {
        return new BracePair[]{
                new BracePair(ZsTypes.L_ROUND_BRACKET, ZsTypes.R_ROUND_BRACKET, true),
                new BracePair(ZsTypes.L_ANGLE_BRACKET, ZsTypes.R_ANGLE_BRACKET, true),
                new BracePair(ZsTypes.L_SQUARE_BRACKET, ZsTypes.R_SQUARE_BRACKET, true),
                new BracePair(ZsTypes.L_CURLY_BRACKET, ZsTypes.R_CURLY_BRACKET, true),
        };
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType iElementType, @Nullable IElementType iElementType1) {
        return false;
    }

    @Override
    public int getCodeConstructStart(PsiFile psiFile, int i) {
        return 0;
    }
}
