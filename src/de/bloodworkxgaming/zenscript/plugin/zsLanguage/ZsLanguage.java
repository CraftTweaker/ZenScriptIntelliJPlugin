package de.bloodworkxgaming.zenscript.plugin.zsLanguage;

import com.intellij.lang.Language;

public class ZsLanguage extends Language {
    public static final ZsLanguage INSTANCE = new ZsLanguage();

    ZsLanguage() {
        super("ZENSCRIPT");
    }
}
