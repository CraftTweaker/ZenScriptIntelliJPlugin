package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsLanguage;
import org.jetbrains.annotations.NotNull;

public class ZsPsiFile extends PsiFileBase {
    protected ZsPsiFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ZsLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return null;
    }
}
