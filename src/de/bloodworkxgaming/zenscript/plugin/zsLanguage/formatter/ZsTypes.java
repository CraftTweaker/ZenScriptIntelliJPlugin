package de.bloodworkxgaming.zenscript.plugin.zsLanguage.formatter;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsLanguage;

public class ZsTypes {
    /**
     * Normal ElementTypes
     */
    public static final IElementType IDENTIFIER = new IElementType("IDENTIFIER", ZsLanguage.INSTANCE);
    public static final IElementType INTEGER_LITERAL = new IElementType("INTEGER_LITERAL", ZsLanguage.INSTANCE);

    public static final IElementType WHITESPACE = new IElementType("WHITESPACE", ZsLanguage.INSTANCE);

    /**
     * Braces
     */
    public static final IElementType L_ROUND_BRACKET = new IElementType("L_ROUND_BRACKET", ZsLanguage.INSTANCE);
    public static final IElementType R_ROUND_BRACKET = new IElementType("R_ROUND_BRACKET", ZsLanguage.INSTANCE);

    public static final IElementType L_ANGLE_BRACKET = new IElementType("L_ANGLE_BRACKET", ZsLanguage.INSTANCE);
    public static final IElementType R_ANGLE_BRACKET = new IElementType("R_ANGLE_BRACKET", ZsLanguage.INSTANCE);

    public static final IElementType L_SQUARE_BRACKET = new IElementType("L_SQUARE_BRACKET", ZsLanguage.INSTANCE);
    public static final IElementType R_SQUARE_BRACKET = new IElementType("R_SQUARE_BRACKET", ZsLanguage.INSTANCE);

    public static final IElementType L_SWIRL_BRACKET = new IElementType("L_SWIRL_BRACKET", ZsLanguage.INSTANCE);
    public static final IElementType R_SWIRL_BRACKET = new IElementType("R_SWIRL_BRACKET", ZsLanguage.INSTANCE);

    /**
     * Operators
     */
    public static final IElementType EQ = new IElementType("EQ", ZsLanguage.INSTANCE);
    public static final IElementType EQEQ = new IElementType("EQEQ", ZsLanguage.INSTANCE);
    public static final IElementType PLUS = new IElementType("PLUS", ZsLanguage.INSTANCE);

    /**
     * Keywords
     */
    public static final IElementType BOOLEAN = new IElementType("BOOLEAN", ZsLanguage.INSTANCE);
    public static final IElementType BREAK = new IElementType("BREAK", ZsLanguage.INSTANCE);


    /**
     * Comment types
     */
    public static final IElementType C_STYLE_COMMENT = new IElementType("C_STYLE_COMMENT", ZsLanguage.INSTANCE);
    public static final IElementType END_OF_LINE_COMMENT = new IElementType("END_OF_LINE_COMMENT", ZsLanguage.INSTANCE);
    public static final IElementType DOC_COMMENT = new IElementType("DOC_COMMENT", ZsLanguage.INSTANCE);


    /**
     * TokenSets
     */
    public static final TokenSet WHITESPACE_SET = TokenSet.create(WHITESPACE);
    public static final TokenSet JAVA_PLAIN_COMMENT_BIT_SET = TokenSet.create(END_OF_LINE_COMMENT, C_STYLE_COMMENT);
    public static final TokenSet JAVA_COMMENT_BIT_SET = TokenSet.orSet(JAVA_PLAIN_COMMENT_BIT_SET, TokenSet.create(DOC_COMMENT));


}
