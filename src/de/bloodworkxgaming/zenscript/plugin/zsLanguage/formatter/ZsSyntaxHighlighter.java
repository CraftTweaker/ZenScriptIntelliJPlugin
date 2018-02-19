package de.bloodworkxgaming.zenscript.plugin.zsLanguage.formatter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.colors.TextAttributesScheme;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing.ZsLexerAdapter;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTokenType;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsVariable;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ZsSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("ZS_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("ZS_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VARIABLE = createTextAttributesKey("ZS_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE); //TODO: set back to right name
    public static final TextAttributesKey COMMENT = createTextAttributesKey("ZS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("ZS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey STRING = createTextAttributesKey("ZS_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("ZS_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BRACKET_HANDLER = createTextAttributesKey("ZS_BRACKET_HANDLER", DefaultLanguageHighlighterColors.MARKUP_ATTRIBUTE);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] VARIABLE_KEYS = new TextAttributesKey[]{VARIABLE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] BRACKET_HANDLER_KEYS = new TextAttributesKey[]{BRACKET_HANDLER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ZsLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ZsTypes.VARIABLE)) {
            return VARIABLE_KEYS;
        }
        if (isKeyword(tokenType)) {
            return KEYWORD_KEYS;
        }
        if (tokenType.equals(ZsTypes.DOUBLE_QUOTED_STRING) | tokenType.equals(ZsTypes.SINGLE_QUOTED_STRING)) {
            return STRING_KEYS;
        }
        if (tokenType.equals(ZsTypes.LINE_COMMENT) || tokenType.equals(ZsTypes.BLOCK_COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        if (isNumber(tokenType)){
            return NUMBER_KEYS;
        }
        if (tokenType.equals(ZsTypes.BRACKET_HANDLER)){
            return BRACKET_HANDLER_KEYS;
        }
        /* if (tokenType.equals(ZsTypes.IDENTIFIER)){
            return VARIABLE_KEYS;
        }*/

        return EMPTY_KEYS;
    }

    private  boolean isNumber (IElementType tokenType){
        return tokenType.equals(ZsTypes.NUMBER) |
                tokenType.equals(ZsTypes.DIGITS) |
                tokenType.equals(ZsTypes.EXP_NUMBER) |
                tokenType.equals(ZsTypes.FLOATING_POINT);
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
}
