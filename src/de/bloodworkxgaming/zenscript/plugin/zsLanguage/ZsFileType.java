package de.bloodworkxgaming.zenscript.plugin.zsLanguage;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ZsFileType extends LanguageFileType {

    public static final ZsFileType INSTANCE = new ZsFileType();

    ZsFileType() {
        super(ZsLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "ZenScript file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "CraftTweaker language support for ZS";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "zs";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ZsIcon.FILE;
    }
}
