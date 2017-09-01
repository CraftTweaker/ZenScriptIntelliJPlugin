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
    if (t == BRACKETS) {
      r = brackets(b, 0);
    }
    else if (t == PROPERTY) {
      r = property(b, 0);
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
  // (L_ROUND_BRACKET ? R_ROUND_BRACKET) | (L_ANGLE_BRACKET ? R_ANGLE_BRACKET)
  public static boolean brackets(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brackets")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BRACKETS, "<brackets>");
    r = brackets_0(b, l + 1);
    if (!r) r = brackets_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // L_ROUND_BRACKET ? R_ROUND_BRACKET
  private static boolean brackets_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brackets_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brackets_0_0(b, l + 1);
    r = r && consumeToken(b, R_ROUND_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ROUND_BRACKET ?
  private static boolean brackets_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brackets_0_0")) return false;
    consumeToken(b, L_ROUND_BRACKET);
    return true;
  }

  // L_ANGLE_BRACKET ? R_ANGLE_BRACKET
  private static boolean brackets_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brackets_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brackets_1_0(b, l + 1);
    r = r && consumeToken(b, R_ANGLE_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // L_ANGLE_BRACKET ?
  private static boolean brackets_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brackets_1_0")) return false;
    consumeToken(b, L_ANGLE_BRACKET);
    return true;
  }

  /* ********************************************************** */
  // property|COMMENT|CRLF|brackets
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = brackets(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KEY? SEPARATOR VALUE?) | KEY
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, "<property>", KEY, SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY? SEPARATOR VALUE?
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && property_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY?
  private static boolean property_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_0")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean property_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
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
