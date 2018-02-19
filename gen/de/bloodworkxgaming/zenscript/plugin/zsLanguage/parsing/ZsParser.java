// This is a generated file. Not intended for manual editing.
package de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes.*;
import static de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing.ZsParserUtil.*;
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
    else if (t == ARRAY_MAP_READ) {
      r = arrayMapRead(b, 0);
    }
    else if (t == ASSIGN_STATEMENT) {
      r = assignStatement(b, 0);
    }
    else if (t == BRACKET_HANDLER) {
      r = bracketHandler(b, 0);
    }
    else if (t == CAST_EXPRESSION) {
      r = castExpression(b, 0);
    }
    else if (t == CLASS_NAME) {
      r = class_name(b, 0);
    }
    else if (t == CONDITION) {
      r = condition(b, 0);
    }
    else if (t == EQUATION) {
      r = equation(b, 0);
    }
    else if (t == FIELD_REFERENCE) {
      r = field_reference(b, 0);
    }
    else if (t == FOR_LOOP) {
      r = for_loop(b, 0);
    }
    else if (t == FUNCTION_CALL) {
      r = functionCall(b, 0);
    }
    else if (t == FUNCTION_BODY) {
      r = function_body(b, 0);
    }
    else if (t == FUNCTION_DECLARATION) {
      r = function_declaration(b, 0);
    }
    else if (t == IF_STATEMENT) {
      r = if_statement(b, 0);
    }
    else if (t == IMPORT_LIST) {
      r = import_list(b, 0);
    }
    else if (t == IMPORT_STATEMENT) {
      r = import_statement(b, 0);
    }
    else if (t == LAMBDA_FUNCTION_DECLARATION) {
      r = lambda_function_declaration(b, 0);
    }
    else if (t == MAP_DECLARATION) {
      r = map_declaration(b, 0);
    }
    else if (t == MAP_ENTRY) {
      r = map_entry(b, 0);
    }
    else if (t == MODULO_TYPE) {
      r = moduloType(b, 0);
    }
    else if (t == NUMBER) {
      r = number(b, 0);
    }
    else if (t == PARAMETER_LIST) {
      r = parameter_list(b, 0);
    }
    else if (t == PARAMETER_VARIABLE) {
      r = parameter_variable(b, 0);
    }
    else if (t == PREPROCESSOR_LIST) {
      r = preprocessor_list(b, 0);
    }
    else if (t == RETURN_STATEMENT) {
      r = return_statement(b, 0);
    }
    else if (t == STATEMENT) {
      r = statement(b, 0);
    }
    else if (t == STATEMENT_BODY) {
      r = statement_body(b, 0);
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
  // L_SQUARE_BRACKET validVariable (COMMA validVariable)* COMMA? R_SQUARE_BRACKET
  public static boolean arrayDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDeclaration")) return false;
    if (!nextTokenIs(b, L_SQUARE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_SQUARE_BRACKET);
    r = r && validVariable(b, l + 1);
    r = r && arrayDeclaration_2(b, l + 1);
    r = r && arrayDeclaration_3(b, l + 1);
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

  // COMMA?
  private static boolean arrayDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDeclaration_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER (DOT IDENTIFIER)* (L_SQUARE_BRACKET (validVariable) R_SQUARE_BRACKET)+
  public static boolean arrayMapRead(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayMapRead")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && arrayMapRead_1(b, l + 1);
    r = r && arrayMapRead_2(b, l + 1);
    exit_section_(b, m, ARRAY_MAP_READ, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean arrayMapRead_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayMapRead_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!arrayMapRead_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayMapRead_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean arrayMapRead_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayMapRead_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (L_SQUARE_BRACKET (validVariable) R_SQUARE_BRACKET)+
  private static boolean arrayMapRead_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayMapRead_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arrayMapRead_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!arrayMapRead_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayMapRead_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // L_SQUARE_BRACKET (validVariable) R_SQUARE_BRACKET
  private static boolean arrayMapRead_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayMapRead_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_SQUARE_BRACKET);
    r = r && arrayMapRead_2_0_1(b, l + 1);
    r = r && consumeToken(b, R_SQUARE_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (validVariable)
  private static boolean arrayMapRead_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayMapRead_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = validVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (STATIC | GLOBAL)? (VAR | VAL)? field_reference (AS class_name)? EQUAL (validVariable)
  public static boolean assignStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_STATEMENT, "<assign statement>");
    r = assignStatement_0(b, l + 1);
    r = r && assignStatement_1(b, l + 1);
    r = r && field_reference(b, l + 1);
    r = r && assignStatement_3(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && assignStatement_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (STATIC | GLOBAL)?
  private static boolean assignStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_0")) return false;
    assignStatement_0_0(b, l + 1);
    return true;
  }

  // STATIC | GLOBAL
  private static boolean assignStatement_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STATIC);
    if (!r) r = consumeToken(b, GLOBAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // (VAR | VAL)?
  private static boolean assignStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_1")) return false;
    assignStatement_1_0(b, l + 1);
    return true;
  }

  // VAR | VAL
  private static boolean assignStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, VAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AS class_name)?
  private static boolean assignStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_3")) return false;
    assignStatement_3_0(b, l + 1);
    return true;
  }

  // AS class_name
  private static boolean assignStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && class_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (validVariable)
  private static boolean assignStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStatement_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = validVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS | ASTERISK | DIV
  static boolean binary_math_signs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_math_signs")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, DIV);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_ANGLE_BRACKET (IDENTIFIER | COLON | DIGITS | ASTERISK | SEMICOLON | COMMA | DOT | PLUS | MINUS | BOOL | BYTE | SHORT | INT | LONG | FLOAT | DOUBLE | STRING )* R_ANGLE_BRACKET
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

  // (IDENTIFIER | COLON | DIGITS | ASTERISK | SEMICOLON | COMMA | DOT | PLUS | MINUS | BOOL | BYTE | SHORT | INT | LONG | FLOAT | DOUBLE | STRING )*
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

  // IDENTIFIER | COLON | DIGITS | ASTERISK | SEMICOLON | COMMA | DOT | PLUS | MINUS | BOOL | BYTE | SHORT | INT | LONG | FLOAT | DOUBLE | STRING
  private static boolean bracketHandler_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracketHandler_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, DIGITS);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, SHORT);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (arrayDeclaration | functionCall | field_reference | number | validCallable) AS class_name
  public static boolean castExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "castExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAST_EXPRESSION, "<cast expression>");
    r = castExpression_0(b, l + 1);
    r = r && consumeToken(b, AS);
    r = r && class_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // arrayDeclaration | functionCall | field_reference | number | validCallable
  private static boolean castExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "castExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arrayDeclaration(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = field_reference(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = validCallable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (BOOL | BYTE | SHORT | INT | LONG | FLOAT | DOUBLE | STRING | IDENTIFIER) (L_SQUARE_BRACKET class_name? R_SQUARE_BRACKET)*
  public static boolean class_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, CLASS_NAME, "<class name>");
    r = class_name_0(b, l + 1);
    r = r && class_name_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BOOL | BYTE | SHORT | INT | LONG | FLOAT | DOUBLE | STRING | IDENTIFIER
  private static boolean class_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, SHORT);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (L_SQUARE_BRACKET class_name? R_SQUARE_BRACKET)*
  private static boolean class_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!class_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_name_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // L_SQUARE_BRACKET class_name? R_SQUARE_BRACKET
  private static boolean class_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_SQUARE_BRACKET);
    r = r && class_name_1_0_1(b, l + 1);
    r = r && consumeToken(b, R_SQUARE_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // class_name?
  private static boolean class_name_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name_1_0_1")) return false;
    class_name(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // unary_math_signs? validVariable ( (IN validVariable) | ((EQEQ | NOT_EQUAL | GREATER_EQUAL | LESS_EQUAL | L_ANGLE_BRACKET | R_ANGLE_BRACKET) validVariable)*)
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = condition_0(b, l + 1);
    r = r && validVariable(b, l + 1);
    r = r && condition_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unary_math_signs?
  private static boolean condition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_0")) return false;
    unary_math_signs(b, l + 1);
    return true;
  }

  // (IN validVariable) | ((EQEQ | NOT_EQUAL | GREATER_EQUAL | LESS_EQUAL | L_ANGLE_BRACKET | R_ANGLE_BRACKET) validVariable)*
  private static boolean condition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condition_2_0(b, l + 1);
    if (!r) r = condition_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IN validVariable
  private static boolean condition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    r = r && validVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((EQEQ | NOT_EQUAL | GREATER_EQUAL | LESS_EQUAL | L_ANGLE_BRACKET | R_ANGLE_BRACKET) validVariable)*
  private static boolean condition_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_2_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!condition_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "condition_2_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (EQEQ | NOT_EQUAL | GREATER_EQUAL | LESS_EQUAL | L_ANGLE_BRACKET | R_ANGLE_BRACKET) validVariable
  private static boolean condition_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condition_2_1_0_0(b, l + 1);
    r = r && validVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQEQ | NOT_EQUAL | GREATER_EQUAL | LESS_EQUAL | L_ANGLE_BRACKET | R_ANGLE_BRACKET
  private static boolean condition_2_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_2_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    if (!r) r = consumeToken(b, LESS_EQUAL);
    if (!r) r = consumeToken(b, L_ANGLE_BRACKET);
    if (!r) r = consumeToken(b, R_ANGLE_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unary_math_signs? valid_calculation_variable (binary_math_signs unary_math_signs? valid_calculation_variable)+
  public static boolean equation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUATION, "<equation>");
    r = equation_0(b, l + 1);
    r = r && valid_calculation_variable(b, l + 1);
    r = r && equation_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unary_math_signs?
  private static boolean equation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equation_0")) return false;
    unary_math_signs(b, l + 1);
    return true;
  }

  // (binary_math_signs unary_math_signs? valid_calculation_variable)+
  private static boolean equation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equation_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equation_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!equation_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "equation_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // binary_math_signs unary_math_signs? valid_calculation_variable
  private static boolean equation_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equation_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binary_math_signs(b, l + 1);
    r = r && equation_2_0_1(b, l + 1);
    r = r && valid_calculation_variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // unary_math_signs?
  private static boolean equation_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equation_2_0_1")) return false;
    unary_math_signs(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // validCallable (DOT IDENTIFIER)*
  public static boolean field_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_REFERENCE, "<field reference>");
    r = validCallable(b, l + 1);
    r = r && field_reference_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean field_reference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_reference_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!field_reference_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_reference_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean field_reference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_reference_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOR (((variable COMMA)? variable IN validVariable) | (variable IN DIGITS ((DOT DOT) | TO) DIGITS)) statement_body
  public static boolean for_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && for_loop_1(b, l + 1);
    r = r && statement_body(b, l + 1);
    exit_section_(b, m, FOR_LOOP, r);
    return r;
  }

  // ((variable COMMA)? variable IN validVariable) | (variable IN DIGITS ((DOT DOT) | TO) DIGITS)
  private static boolean for_loop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = for_loop_1_0(b, l + 1);
    if (!r) r = for_loop_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (variable COMMA)? variable IN validVariable
  private static boolean for_loop_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = for_loop_1_0_0(b, l + 1);
    r = r && variable(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && validVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (variable COMMA)?
  private static boolean for_loop_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_1_0_0")) return false;
    for_loop_1_0_0_0(b, l + 1);
    return true;
  }

  // variable COMMA
  private static boolean for_loop_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // variable IN DIGITS ((DOT DOT) | TO) DIGITS
  private static boolean for_loop_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && consumeTokens(b, 0, IN, DIGITS);
    r = r && for_loop_1_1_3(b, l + 1);
    r = r && consumeToken(b, DIGITS);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT DOT) | TO
  private static boolean for_loop_1_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_1_1_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = for_loop_1_1_3_0(b, l + 1);
    if (!r) r = consumeToken(b, TO);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT DOT
  private static boolean for_loop_1_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_1_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // validCallable ((DOT IDENTIFIER)* (L_ROUND_BRACKET R_ROUND_BRACKET | (L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET)))+
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = validCallable(b, l + 1);
    r = r && functionCall_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((DOT IDENTIFIER)* (L_ROUND_BRACKET R_ROUND_BRACKET | (L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET)))+
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

  // (DOT IDENTIFIER)* (L_ROUND_BRACKET R_ROUND_BRACKET | (L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET))
  private static boolean functionCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionCall_1_0_0(b, l + 1);
    r = r && functionCall_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean functionCall_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!functionCall_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionCall_1_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean functionCall_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET R_ROUND_BRACKET | (L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET)
  private static boolean functionCall_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, L_ROUND_BRACKET, R_ROUND_BRACKET);
    if (!r) r = functionCall_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET (validVariable (COMMA validVariable)*) R_ROUND_BRACKET
  private static boolean functionCall_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ROUND_BRACKET);
    r = r && functionCall_1_0_1_1_1(b, l + 1);
    r = r && consumeToken(b, R_ROUND_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // validVariable (COMMA validVariable)*
  private static boolean functionCall_1_0_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0_1_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = validVariable(b, l + 1);
    r = r && functionCall_1_0_1_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA validVariable)*
  private static boolean functionCall_1_0_1_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0_1_1_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!functionCall_1_0_1_1_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionCall_1_0_1_1_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA validVariable
  private static boolean functionCall_1_0_1_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0_1_1_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && validVariable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY_BRACKET statement* return_statement? R_CURLY_BRACKET
  public static boolean function_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_body")) return false;
    if (!nextTokenIs(b, L_CURLY_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY_BRACKET);
    r = r && function_body_1(b, l + 1);
    r = r && function_body_2(b, l + 1);
    r = r && consumeToken(b, R_CURLY_BRACKET);
    exit_section_(b, m, FUNCTION_BODY, r);
    return r;
  }

  // statement*
  private static boolean function_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_body_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_body_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // return_statement?
  private static boolean function_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_body_2")) return false;
    return_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FUNCTION IDENTIFIER ((L_ROUND_BRACKET parameter_list R_ROUND_BRACKET) | (L_ROUND_BRACKET R_ROUND_BRACKET)) (AS class_name)? function_body
  public static boolean function_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION, IDENTIFIER);
    r = r && function_declaration_2(b, l + 1);
    r = r && function_declaration_3(b, l + 1);
    r = r && function_body(b, l + 1);
    exit_section_(b, m, FUNCTION_DECLARATION, r);
    return r;
  }

  // (L_ROUND_BRACKET parameter_list R_ROUND_BRACKET) | (L_ROUND_BRACKET R_ROUND_BRACKET)
  private static boolean function_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_declaration_2_0(b, l + 1);
    if (!r) r = function_declaration_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET parameter_list R_ROUND_BRACKET
  private static boolean function_declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ROUND_BRACKET);
    r = r && parameter_list(b, l + 1);
    r = r && consumeToken(b, R_ROUND_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET R_ROUND_BRACKET
  private static boolean function_declaration_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, L_ROUND_BRACKET, R_ROUND_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AS class_name)?
  private static boolean function_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_3")) return false;
    function_declaration_3_0(b, l + 1);
    return true;
  }

  // AS class_name
  private static boolean function_declaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && class_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF unary_math_signs? L_ROUND_BRACKET condition ((OR | AND | XOR) condition)* R_ROUND_BRACKET (statement_body | statement) (ELSE (statement_body | statement))?
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && if_statement_1(b, l + 1);
    r = r && consumeToken(b, L_ROUND_BRACKET);
    r = r && condition(b, l + 1);
    r = r && if_statement_4(b, l + 1);
    r = r && consumeToken(b, R_ROUND_BRACKET);
    r = r && if_statement_6(b, l + 1);
    r = r && if_statement_7(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // unary_math_signs?
  private static boolean if_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1")) return false;
    unary_math_signs(b, l + 1);
    return true;
  }

  // ((OR | AND | XOR) condition)*
  private static boolean if_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!if_statement_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (OR | AND | XOR) condition
  private static boolean if_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_4_0_0(b, l + 1);
    r = r && condition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OR | AND | XOR
  private static boolean if_statement_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, XOR);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement_body | statement
  private static boolean if_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_body(b, l + 1);
    if (!r) r = statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE (statement_body | statement))?
  private static boolean if_statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_7")) return false;
    if_statement_7_0(b, l + 1);
    return true;
  }

  // ELSE (statement_body | statement)
  private static boolean if_statement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && if_statement_7_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement_body | statement
  private static boolean if_statement_7_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_7_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_body(b, l + 1);
    if (!r) r = statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // import_statement*
  public static boolean import_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_LIST, "<import list>");
    int c = current_position_(b);
    while (true) {
      if (!import_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_list", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // IMPORT IDENTIFIER (DOT IDENTIFIER)* (AS IDENTIFIER)? SEMICOLON
  public static boolean import_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT, IDENTIFIER);
    r = r && import_statement_2(b, l + 1);
    r = r && import_statement_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, IMPORT_STATEMENT, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean import_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!import_statement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_statement_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean import_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AS IDENTIFIER)?
  private static boolean import_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_3")) return false;
    import_statement_3_0(b, l + 1);
    return true;
  }

  // AS IDENTIFIER
  private static boolean import_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AS, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_ROUND_BRACKET | R_ROUND_BRACKET | L_SQUARE_BRACKET | R_SQUARE_BRACKET | L_CURLY_BRACKET | R_CURLY_BRACKET | EQUAL | EXCL | TILDE | QUEST | COLON | PLUS | MINUS | ASTERISK | DIV | OR | AND | XOR | PERC | AT | HASH | SEMICOLON | COMMA | DOT | EQEQ | NOT_EQUAL | LESS_EQUAL | GREATER_EQUAL | ANY   | BOOL  | BYTE  | SHORT | INT   | LONG  | FLOAT | DOUBLE| STRING| FUNCTION| IN | TO | VOID | AS | VERSION | IF | ELSE | FOR | RETURN | IMPORT | VAR | VAL | STATIC| GLOBAL | NULL | TRUE | FALSE
  static boolean keywords(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keywords")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ROUND_BRACKET);
    if (!r) r = consumeToken(b, R_ROUND_BRACKET);
    if (!r) r = consumeToken(b, L_SQUARE_BRACKET);
    if (!r) r = consumeToken(b, R_SQUARE_BRACKET);
    if (!r) r = consumeToken(b, L_CURLY_BRACKET);
    if (!r) r = consumeToken(b, R_CURLY_BRACKET);
    if (!r) r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, EXCL);
    if (!r) r = consumeToken(b, TILDE);
    if (!r) r = consumeToken(b, QUEST);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, XOR);
    if (!r) r = consumeToken(b, PERC);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, HASH);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    if (!r) r = consumeToken(b, LESS_EQUAL);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    if (!r) r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, SHORT);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, FUNCTION);
    if (!r) r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, TO);
    if (!r) r = consumeToken(b, VOID);
    if (!r) r = consumeToken(b, AS);
    if (!r) r = consumeToken(b, VERSION);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, IMPORT);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, VAL);
    if (!r) r = consumeToken(b, STATIC);
    if (!r) r = consumeToken(b, GLOBAL);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION ((L_ROUND_BRACKET parameter_list R_ROUND_BRACKET) | (L_ROUND_BRACKET R_ROUND_BRACKET)) (AS class_name)? function_body
  public static boolean lambda_function_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_function_declaration")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    r = r && lambda_function_declaration_1(b, l + 1);
    r = r && lambda_function_declaration_2(b, l + 1);
    r = r && function_body(b, l + 1);
    exit_section_(b, m, LAMBDA_FUNCTION_DECLARATION, r);
    return r;
  }

  // (L_ROUND_BRACKET parameter_list R_ROUND_BRACKET) | (L_ROUND_BRACKET R_ROUND_BRACKET)
  private static boolean lambda_function_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_function_declaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lambda_function_declaration_1_0(b, l + 1);
    if (!r) r = lambda_function_declaration_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET parameter_list R_ROUND_BRACKET
  private static boolean lambda_function_declaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_function_declaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ROUND_BRACKET);
    r = r && parameter_list(b, l + 1);
    r = r && consumeToken(b, R_ROUND_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET R_ROUND_BRACKET
  private static boolean lambda_function_declaration_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_function_declaration_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, L_ROUND_BRACKET, R_ROUND_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AS class_name)?
  private static boolean lambda_function_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_function_declaration_2")) return false;
    lambda_function_declaration_2_0(b, l + 1);
    return true;
  }

  // AS class_name
  private static boolean lambda_function_declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_function_declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && class_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY_BRACKET (map_entry COMMA)* map_entry?  R_CURLY_BRACKET (AS class_name)?
  public static boolean map_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_declaration")) return false;
    if (!nextTokenIs(b, L_CURLY_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY_BRACKET);
    r = r && map_declaration_1(b, l + 1);
    r = r && map_declaration_2(b, l + 1);
    r = r && consumeToken(b, R_CURLY_BRACKET);
    r = r && map_declaration_4(b, l + 1);
    exit_section_(b, m, MAP_DECLARATION, r);
    return r;
  }

  // (map_entry COMMA)*
  private static boolean map_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_declaration_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!map_declaration_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "map_declaration_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // map_entry COMMA
  private static boolean map_declaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_declaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = map_entry(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // map_entry?
  private static boolean map_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_declaration_2")) return false;
    map_entry(b, l + 1);
    return true;
  }

  // (AS class_name)?
  private static boolean map_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_declaration_4")) return false;
    map_declaration_4_0(b, l + 1);
    return true;
  }

  // AS class_name
  private static boolean map_declaration_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_declaration_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && class_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // validVariable COLON validVariable
  public static boolean map_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_ENTRY, "<map entry>");
    r = validVariable(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && validVariable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (bracketHandler | variable) PERC DIGITS
  public static boolean moduloType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduloType")) return false;
    if (!nextTokenIs(b, "<modulo type>", IDENTIFIER, L_ANGLE_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODULO_TYPE, "<modulo type>");
    r = moduloType_0(b, l + 1);
    r = r && consumeTokens(b, 0, PERC, DIGITS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // bracketHandler | variable
  private static boolean moduloType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduloType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracketHandler(b, l + 1);
    if (!r) r = variable(b, l + 1);
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
  // L_ANGLE_BRACKET | R_ANGLE_BRACKET | DOUBLE_QUOTED_STRING | SINGLE_QUOTED_STRING
  static boolean other_keywords(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "other_keywords")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ANGLE_BRACKET);
    if (!r) r = consumeToken(b, R_ANGLE_BRACKET);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (parameter_variable COMMA)* parameter_variable
  public static boolean parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_list_0(b, l + 1);
    r = r && parameter_variable(b, l + 1);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // (parameter_variable COMMA)*
  private static boolean parameter_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!parameter_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter_list_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // parameter_variable COMMA
  private static boolean parameter_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_variable(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // variable (AS class_name)?
  public static boolean parameter_variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_variable")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && parameter_variable_1(b, l + 1);
    exit_section_(b, m, PARAMETER_VARIABLE, r);
    return r;
  }

  // (AS class_name)?
  private static boolean parameter_variable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_variable_1")) return false;
    parameter_variable_1_0(b, l + 1);
    return true;
  }

  // AS class_name
  private static boolean parameter_variable_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_variable_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && class_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PREPROCESSOR*
  public static boolean preprocessor_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preprocessor_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, PREPROCESSOR_LIST, "<preprocessor list>");
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, PREPROCESSOR)) break;
      if (!empty_element_parsed_guard_(b, "preprocessor_list", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // RETURN validVariable SEMICOLON
  public static boolean return_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && validVariable(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // assignStatement SEMICOLON
  //               | EOL
  //               | functionCall SEMICOLON
  //               | for_loop
  //               | if_statement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = statement_2(b, l + 1);
    if (!r) r = for_loop(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
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
  // L_CURLY_BRACKET statement* R_CURLY_BRACKET | function_body
  public static boolean statement_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_body")) return false;
    if (!nextTokenIs(b, L_CURLY_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_body_0(b, l + 1);
    if (!r) r = function_body(b, l + 1);
    exit_section_(b, m, STATEMENT_BODY, r);
    return r;
  }

  // L_CURLY_BRACKET statement* R_CURLY_BRACKET
  private static boolean statement_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY_BRACKET);
    r = r && statement_body_0_1(b, l + 1);
    r = r && consumeToken(b, R_CURLY_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement*
  private static boolean statement_body_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_body_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_body_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // SEMICOLON
  static boolean statement_recover(PsiBuilder b, int l) {
    return consumeToken(b, SEMICOLON);
  }

  /* ********************************************************** */
  // EXCL
  static boolean unary_math_signs(PsiBuilder b, int l) {
    return consumeToken(b, EXCL);
  }

  /* ********************************************************** */
  // bracketHandler
  //                   | variable
  //                   | DOUBLE_QUOTED_STRING
  //                   | SINGLE_QUOTED_STRING
  //                   | arrayMapRead
  //                   | (L_ROUND_BRACKET validVariable R_ROUND_BRACKET)
  public static boolean validCallable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "validCallable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALID_CALLABLE, "<valid callable>");
    r = bracketHandler(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = arrayMapRead(b, l + 1);
    if (!r) r = validCallable_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // L_ROUND_BRACKET validVariable R_ROUND_BRACKET
  private static boolean validCallable_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "validCallable_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ROUND_BRACKET);
    r = r && validVariable(b, l + 1);
    r = r && consumeToken(b, R_ROUND_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lambda_function_declaration
  //                   | arrayMapRead
  //                   | castExpression
  //                   | equation
  //                   | functionCall
  //                   | field_reference
  //                   | bracketHandler
  //                   | moduloType
  //                   | variable
  //                   | number
  //                   | NULL
  //                   | DOUBLE_QUOTED_STRING
  //                   | SINGLE_QUOTED_STRING
  //                   | arrayDeclaration
  //                   | TRUE
  //                   | FALSE
  //                   | map_declaration
  public static boolean validVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "validVariable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALID_VARIABLE, "<valid variable>");
    r = lambda_function_declaration(b, l + 1);
    if (!r) r = arrayMapRead(b, l + 1);
    if (!r) r = castExpression(b, l + 1);
    if (!r) r = equation(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = field_reference(b, l + 1);
    if (!r) r = bracketHandler(b, l + 1);
    if (!r) r = moduloType(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = arrayDeclaration(b, l + 1);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = map_declaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bracketHandler
  //                                        | functionCall
  //                                        | field_reference
  //                                        | number
  //                                        | arrayMapRead
  //                                        | variable
  //                                        | SINGLE_QUOTED_STRING
  //                                        | DOUBLE_QUOTED_STRING
  static boolean valid_calculation_variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valid_calculation_variable")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracketHandler(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = field_reference(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = arrayMapRead(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    exit_section_(b, m, null, r);
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
  // preprocessor_list? import_list (statement | function_declaration )*
  static boolean zsFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zsFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = zsFile_0(b, l + 1);
    r = r && import_list(b, l + 1);
    r = r && zsFile_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // preprocessor_list?
  private static boolean zsFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zsFile_0")) return false;
    preprocessor_list(b, l + 1);
    return true;
  }

  // (statement | function_declaration )*
  private static boolean zsFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zsFile_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!zsFile_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "zsFile_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // statement | function_declaration
  private static boolean zsFile_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zsFile_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = function_declaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
