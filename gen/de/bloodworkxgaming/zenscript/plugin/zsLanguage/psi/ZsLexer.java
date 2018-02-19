package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.lexer.FlexAdapter;

public class ZsLexer extends FlexAdapter {
    public ZsLexer() {
        super(new _ZsLexer());
    }
}
