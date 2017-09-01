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
%eof{ return;
%eof}

EOL=\R
WHITE_SPACE=\s+


%%
<YYINITIAL> {
  {WHITE_SPACE}         { return WHITE_SPACE; }

  "COMMENT"             { return COMMENT; }
  "CRLF"                { return CRLF; }
  "KEY"                 { return KEY; }
  "SEPARATOR"           { return SEPARATOR; }
  "VALUE"               { return VALUE; }
  "L_ROUND_BRACKET"     { return L_ROUND_BRACKET; }
  "R_ROUND_BRACKET"     { return R_ROUND_BRACKET; }
  "L_ANGLE_BRACKET"     { return L_ANGLE_BRACKET; }
  "R_ANGLE_BRACKET"     { return R_ANGLE_BRACKET; }
  "L_SQUARE_BRACKET"    { return L_SQUARE_BRACKET; }
  "R_SQUARE_BRACKET"    { return R_SQUARE_BRACKET; }
  "L_SWIRL_BRACKET"     { return L_SWIRL_BRACKET; }
  "R_SWIRL_BRACKET"     { return R_SWIRL_BRACKET; }


}

[^] { return BAD_CHARACTER; }
