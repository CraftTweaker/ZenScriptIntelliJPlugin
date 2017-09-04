package de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing;

import com.intellij.lexer.FlexAdapter;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi._ZsLexer;

public class ZsLexerAdapter extends FlexAdapter {
    public ZsLexerAdapter() {
        super(new _ZsLexer());
    }
}
