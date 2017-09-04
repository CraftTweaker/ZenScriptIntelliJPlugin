package de.bloodworkxgaming.zenscript.plugin.zsLanguage.formatter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing.ZsLexerAdapter;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ZsSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    public static final TextAttributesKey NUMBER = createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ZsLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        /*if (tokenType.equals(ZsTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        } else*/ if (isKeyword(tokenType)) {
            return KEYWORD_KEYS;
        } else /*if (tokenType.equals(ZsTypes.VALUE)) {
            return VALUE_KEYS;
        } else */if (tokenType.equals(ZsTypes.LINE_COMMENT) || tokenType.equals(ZsTypes.BLOCK_COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (isNumber(tokenType)){
            return NUMBER_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

    private boolean isKeyword(IElementType tokenType){
        return tokenType.equals(ZsTypes.ANY) |
        tokenType.equals(ZsTypes.BOOL) |
        tokenType.equals(ZsTypes.BYTE) |
        tokenType.equals(ZsTypes.SHORT) |
        tokenType.equals(ZsTypes.INT) |
        tokenType.equals(ZsTypes.LONG) |
        tokenType.equals(ZsTypes.FLOAT) |
        tokenType.equals(ZsTypes.DOUBLE) |
        tokenType.equals(ZsTypes.STRING) |
        tokenType.equals(ZsTypes.FUNCTION) |
        tokenType.equals(ZsTypes.IN) |
        tokenType.equals(ZsTypes.VOID) |
        tokenType.equals(ZsTypes.AS) |
        tokenType.equals(ZsTypes.VERSION) |
        tokenType.equals(ZsTypes.IF) |
        tokenType.equals(ZsTypes.ELSE) |
        tokenType.equals(ZsTypes.FOR) |
        tokenType.equals(ZsTypes.RETURN) |
        tokenType.equals(ZsTypes.VAR) |
        tokenType.equals(ZsTypes.VAL) |
        tokenType.equals(ZsTypes.NULL) |
        tokenType.equals(ZsTypes.TRUE) |
        tokenType.equals(ZsTypes.FALSE) |
        tokenType.equals(ZsTypes.IMPORT);
    }

    private  boolean isNumber (IElementType tokenType){
        return tokenType.equals(ZsTypes.NUMBER) |
                tokenType.equals(ZsTypes.DIGITS) |
                tokenType.equals(ZsTypes.FLOATING_POINT);
    }
}
