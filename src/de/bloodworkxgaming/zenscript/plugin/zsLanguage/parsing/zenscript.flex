package de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing;


import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.formatter.ZsTypes;
import com.intellij.pom.java.LanguageLevel;


// suppress various warnings/inspections for the generated class
@SuppressWarnings ({"FieldCanBeLocal", "UnusedDeclaration", "UnusedAssignment", "AccessStaticViaInstance", "MismatchedReadAndWriteOfArray", "WeakerAccess", "SameParameterValue", "CanBeFinal", "SameReturnValue", "RedundantThrows", "ConstantConditions"})

%%

%class _ZsLexer
%implements FlexLexer
%final
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}


%{
    public _ZsLexer() {
        this(null);
  }

  public void goTo(int offset) {
    zzCurrentPos = zzMarkedPos = zzStartRead = offset;
    zzAtEOF = false;
  }
%}


CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "



LineTerminator = \r|\n|\r\n

WHITE_SPACE_CHAR = [\ \n\r\t\f]

C_STYLE_COMMENT=("/*"[^"*"]{COMMENT_TAIL})|"/*"
DOC_COMMENT="/*""*"+("/"|([^"/""*"]{COMMENT_TAIL}))?
COMMENT_TAIL=([^"*"]*("*"+[^"*""/"])?)*("*"+"/")?
END_OF_LINE_COMMENT="/""/"[^\r\n]*



%state mu
%state emu
%state par
%state comment
%state comment_block
%state comment_end
%state data
%state raw

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]


/* */
Identifier = [:jletter:] [:jletterdigit:]*
DecIntegerLiteral = 0 | [1-9][0-9]*

%state STRING
%state WAITING_VALUE

%%

/* keywords */
<YYINITIAL> "boolean"            { return ZsTypes.BOOLEAN; }
<YYINITIAL> "break"              { return ZsTypes.BREAK; }

<YYINITIAL> {
  /* identifiers */ 
  {Identifier}                   { return ZsTypes.IDENTIFIER; }
 
  /* literals */
  {DecIntegerLiteral}            { return ZsTypes.INTEGER_LITERAL; }

  {WHITE_SPACE_CHAR}+ { return ZsTypes.WHITESPACE; }

  {C_STYLE_COMMENT} { return ZsTypes.C_STYLE_COMMENT; }
  {END_OF_LINE_COMMENT} { return ZsTypes.END_OF_LINE_COMMENT; }
  {DOC_COMMENT} { return ZsTypes.DOC_COMMENT; }

  /* operators */
  "="                            { return ZsTypes.EQ; }
  "=="                           { return ZsTypes.EQEQ; }
  "+"                            { return ZsTypes.PLUS; }
  
  "("                            { return ZsTypes.L_ROUND_BRACKET; }
  ")"                            { return ZsTypes.R_ROUND_BRACKET; }
  "<"                            { return ZsTypes.L_ANGLE_BRACKET; }
  ">"                            { return ZsTypes.R_ANGLE_BRACKET; }
  "["                            { return ZsTypes.L_SQUARE_BRACKET; }
  "]"                            { return ZsTypes.R_SQUARE_BRACKET; }
  "{"                            { return ZsTypes.L_SWIRL_BRACKET; }
  "}"                            { return ZsTypes.R_SWIRL_BRACKET; }


<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return SimpleTypes.COMMENT; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return SimpleTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return SimpleTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return SimpleTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }

}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+ yytext() + ">"); }