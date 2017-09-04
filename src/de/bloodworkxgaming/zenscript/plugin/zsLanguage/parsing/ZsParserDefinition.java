package de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsLanguage;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsFile;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi.ZsTypes;
import org.jetbrains.annotations.NotNull;

public class ZsParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(ZsTypes.LINE_COMMENT, ZsTypes.BLOCK_COMMENT);

    public static final IFileElementType FILE = new IFileElementType(ZsLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new ZsLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new ZsParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return ZsTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ZsFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
}
