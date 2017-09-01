package de.bloodworkxgaming.zenscript.plugin.zsLanguage.parsing;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.formatter.ZsTypes;
import org.jetbrains.annotations.NotNull;

public class ZsParserDefinition implements ParserDefinition {
    public ZsParserDefinition() {
        System.out.println("ZsParserDefinition has been created");
    }

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new ZsLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        throw new UnsupportedOperationException("Should not be called directly");
    }

    @Override
    public IFileElementType getFileNodeType() {
        return null;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return ZsTypes.WHITESPACE_SET;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return ZsTypes.JAVA_COMMENT_BIT_SET;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return null;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return null;
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return null;
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return null;
    }
}
