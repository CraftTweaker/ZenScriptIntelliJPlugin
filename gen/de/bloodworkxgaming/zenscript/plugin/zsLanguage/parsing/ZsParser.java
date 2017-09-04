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
    if (t == ARRAY_DECLARATION) {
      r = arrayDeclaration(b, 0);
    }
    else if (t == ARRAY_READ) {
      r = arrayRead(b, 0);
    }
    else if (t == ASSIGN_STATEMENT) {
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
    else if (t == STATEMENT) {
      r = statement(b, 0);
    }
    else if (t == VALID_CALLABLE) {
      r = validCallable(b, 0);
    }
    else if (t == VALID_VARIABLE) {
      r = validVariable(b, 0);
    }
    else if (t == VARIABLE) {
      r = variable(b, 0);
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
  // L_SQUARE_BRACKET validVariable (COMMA validVariable)* R_SQUARE_BRACKET
  public static boolean arrayDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDeclaration")) return false;
    if (!nextTokenIs(b, L_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_SQUARE_BRACKET);
    r = r && validVariable(b, l + 1);
    r = r && arrayDeclaration_2(b, l + 1);
    r = r && consumeToken(b, R_SQUARE_BRACKET);
    exit_section_(b, m, ARRAY_DECLARATION, r);
    return r;
  }

  // (COMMA validVariable)*
  private static boolean arrayDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDeclaration_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!arrayDeclaration_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayDeclaration_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA validVariable
  private static boolean arrayDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && validVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (DOT IDENTIFIER)* (L_SQUARE_BRACKET DIGITS R_SQUARE_BRACKET)+
  public static boolean arrayRead(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayRead")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && arrayRead_1(b, l + 1);
    r = r && arrayRead_2(b, l + 1);
    exit_section_(b, m, ARRAY_READ, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean arrayRead_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayRead_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!arrayRead_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayRead_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean arrayRead_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayRead_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (L_SQUARE_BRACKET DIGITS R_SQUARE_BRACKET)+
  private static boolean arrayRead_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayRead_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arrayRead_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!arrayRead_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayRead_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // L_SQUARE_BRACKET DIGITS R_SQUARE_BRACKET
  private static boolean arrayRead_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayRead_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, L_SQUARE_BRACKET, DIGITS, R_SQUARE_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (VAR | VAL)? variable EQUAL validVariable
  public static boolean assignStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_STATEMENT, "<assign statement>");
    r = assignStatement_0(b, l + 1);
    r = r && variable(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && validVariable(b, l + 1);
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
  // validCallable (DOT IDENTIFIER)+ (L_ROUND_BRACKET R_ROUND_BRACKET | (L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET))
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = validCallable(b, l + 1);
    r = r && functionCall_1(b, l + 1);
    r = r && functionCall_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // DIGITS | FLOATING_POINT
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    if (!nextTokenIs(b, "<number>", DIGITS, FLOATING_POINT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, DIGITS);
    if (!r) r = consumeToken(b, FLOATING_POINT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // assignStatement SEMICOLON
  //               | EOL
  //               | functionCall SEMICOLON
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = statement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // assignStatement SEMICOLON
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignStatement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // functionCall SEMICOLON
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionCall(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bracketHandler | variable | DOUBLE_QUOTED_STRING | SINGLE_QUOTED_STRING | arrayRead
  public static boolean validCallable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "validCallable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALID_CALLABLE, "<valid callable>");
    r = bracketHandler(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = arrayRead(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bracketHandler | functionCall | variable | number | NULL | DOUBLE_QUOTED_STRING | SINGLE_QUOTED_STRING | arrayDeclaration | arrayRead
  public static boolean validVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "validVariable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALID_VARIABLE, "<valid variable>");
    r = bracketHandler(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = arrayDeclaration(b, l + 1);
    if (!r) r = arrayRead(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // statement*
  static boolean zsFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zsFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "zsFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

}
