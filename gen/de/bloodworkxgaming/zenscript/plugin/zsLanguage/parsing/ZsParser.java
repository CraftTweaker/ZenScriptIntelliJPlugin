// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ZsParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ASSIGN_STATEMENT) {
      r = assignStatement(b, 0);
    }
    else if (t == BRACKET_HANDLER) {
      r = bracketHandler(b, 0);
    }
    else if (t == FUNCTION_CALL) {
      r = functionCall(b, 0);
    }
    else if (t == NUMBER) {
      r = number(b, 0);
    }
    else if (t == VALID_VARIABLE) {
      r = validVariable(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return zsFile(b, l + 1);
  }

  /* ********************************************************** */
  // (VAR | VAL)? IDENTIFIER EQUAL validVariable SEMICOLON
  public static boolean assignStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_STATEMENT, "<assign statement>");
    r = assignStatement_0(b, l + 1);
    r = r && consumeTokens(b, 0, IDENTIFIER, EQUAL);
    r = r && validVariable(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VAR | VAL)?
  private static boolean assignStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_0")) return false;
    assignStatement_0_0(b, l + 1);
    return true;
  }

  // VAR | VAL
  private static boolean assignStatement_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, VAL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_ANGLE_BRACKET (IDENTIFIER | COLON)* R_ANGLE_BRACKET
  public static boolean bracketHandler(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracketHandler")) return false;
    if (!nextTokenIs(b, L_ANGLE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ANGLE_BRACKET);
    r = r && bracketHandler_1(b, l + 1);
    r = r && consumeToken(b, R_ANGLE_BRACKET);
    exit_section_(b, m, BRACKET_HANDLER, r);
    return r;
  }

  // (IDENTIFIER | COLON)*
  private static boolean bracketHandler_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracketHandler_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!bracketHandler_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracketHandler_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // IDENTIFIER | COLON
  private static boolean bracketHandler_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracketHandler_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [bracketHandler IDENTIFIER] (DOT IDENTIFIER)+ (L_ROUND_BRACKET R_ROUND_BRACKET | (L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET))
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    if (!nextTokenIs(b, "<function call>", DOT, L_ANGLE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = functionCall_0(b, l + 1);
    r = r && functionCall_1(b, l + 1);
    r = r && functionCall_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [bracketHandler IDENTIFIER]
  private static boolean functionCall_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_0")) return false;
    functionCall_0_0(b, l + 1);
    return true;
  }

  // bracketHandler IDENTIFIER
  private static boolean functionCall_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracketHandler(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT IDENTIFIER)+
  private static boolean functionCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionCall_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!functionCall_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionCall_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT IDENTIFIER
  private static boolean functionCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET R_ROUND_BRACKET | (L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET)
  private static boolean functionCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, L_ROUND_BRACKET, R_ROUND_BRACKET);
    if (!r) r = functionCall_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET
  private static boolean functionCall_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ROUND_BRACKET);
    r = r && functionCall_2_1_1(b, l + 1);
    r = r && consumeToken(b, R_ROUND_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // validVariable (COMMA validVariable)*
  private static boolean functionCall_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = validVariable(b, l + 1);
    r = r && functionCall_2_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA validVariable)*
  private static boolean functionCall_2_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2_1_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!functionCall_2_1_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionCall_2_1_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA validVariable
  private static boolean functionCall_2_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2_1_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && validVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bracketHandler | assignStatement | property | EOL | functionCall SEMICOLON
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracketHandler(b, l + 1);
    if (!r) r = assignStatement(b, l + 1);
    if (!r) r = consumeToken(b, PROPERTY);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = item__4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // functionCall SEMICOLON
  private static boolean item__4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionCall(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DIGITS | FLOATING_POINT | DIGIT
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, DIGITS);
    if (!r) r = consumeToken(b, FLOATING_POINT);
    if (!r) r = consumeToken(b, DIGIT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bracketHandler | functionCall | IDENTIFIER | number | NULL
  public static boolean validVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "validVariable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALID_VARIABLE, "<valid variable>");
    r = bracketHandler(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, NULL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean zsFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zsFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "zsFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

}
