package de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing;

import com.intellij.lexer.FlexAdapter;

public class ZsLexerAdapter extends FlexAdapter {
    public ZsLexerAdapter() {
        super(new _ZsLexer());
        System.out.println("Lexer has been created");
    }
}
