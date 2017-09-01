package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes.*;

%%

%{
  public _ZsLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _ZsLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

LINE_COMMENT="//".*
BLOCK_COMMENT="/"\*([^*]|\*+[^*/])*(\*+"/")?
DOUBLE_QUOTED_STRING=\"([^\\\"\r\n]|\\[^\r\n])*\"?
SINGLE_QUOTED_STRING='([^\\'\r\n]|\\[^\r\n])*'?
NUMBER=-?(0|[1-9][0-9]*)(\.[0-9]+)?([eE][+-]?[0-9]*)?

KEYWORD_ANY = [\s;]any[\s;]

%%
<YYINITIAL> {
  {WHITE_SPACE}                         { return WHITE_SPACE; }

  "("                                   { return L_ROUND_BRACKET; }
  ")"                                   { return R_ROUND_BRACKET; }
  "<"                                   { return L_ANGLE_BRACKET; }
  ">"                                   { return R_ANGLE_BRACKET; }
  "["                                   { return L_SQUARE_BRACKET; }
  "]"                                   { return R_SQUARE_BRACKET; }
  "{"                                   { return L_CURLY_BRACKET; }
  "}"                                   { return R_CURLY_BRACKET; }
  ","                                   { return COMMA; }
  ":"                                   { return COLON; }
  {KEYWORD_ANY}                             { return ANY; }
  "(?<![^\s])bool(?![^\s;])"                { return BOOL; }
  "(?<![^\s])byte(?![^\s;])"                { return BYTE; }
  "(?<![^\s])short(?![^\s;])"               { return SHORT; }
  "(?<![^\s])int(?![^\s;])"                 { return INT; }
  "(?<![^\s])long(?![^\s;])"                { return LONG; }
  "(?<![^\s])float(?![^\s;])"               { return FLOAT; }
  "(?<![^\s])double(?![^\s;])"              { return DOUBLE; }
  "(?<![^\s])string(?![^\s;])"              { return STRING; }
  "(?<![^\s])function(?![^\s;])"            { return FUNCTION; }
  "(?<![^\s])in(?![^\s;])"                  { return IN; }
  "(?<![^\s])void(?![^\s;])"                { return VOID; }
  "(?<![^\s])as(?![^\s;])"                  { return AS; }
  "(?<![^\s])version(?![^\s;])"             { return VERSION; }
  "(?<![^\s])if(?![^\s;])"                  { return IF; }
  "(?<![^\s])else(?![^\s;])"                { return ELSE; }
  "(?<![^\s])for(?![^\s;])"                 { return FOR; }
  "(?<![^\s])return(?![^\s;])"              { return RETURN; }
  "(?<![^\s])var(?![^\s;])"                 { return VAR; }
  "(?<![^\s])val(?![^\s;])"                 { return VAL; }
  "(?<![^\s])null(?![^\s;])"                { return NULL; }
  "(?<![^\s])true(?![^\s;])"                { return TRUE; }
  "(?<![^\s])false(?![^\s;])"               { return FALSE; }
  "(?<![^\s])import(?![^\s;])"              { return IMPORT; }
  "CRLF"                                { return CRLF; }
  "KEY"                                 { return KEY; }
  "SEPARATOR"                           { return SEPARATOR; }
  "VALUE"                               { return VALUE; }

  {LINE_COMMENT}                        { return LINE_COMMENT; }
  {BLOCK_COMMENT}                       { return BLOCK_COMMENT; }
  {DOUBLE_QUOTED_STRING}                { return DOUBLE_QUOTED_STRING; }
  {SINGLE_QUOTED_STRING}                { return SINGLE_QUOTED_STRING; }
  {NUMBER}                              { return NUMBER; }

}

[^] { return BAD_CHARACTER; }
