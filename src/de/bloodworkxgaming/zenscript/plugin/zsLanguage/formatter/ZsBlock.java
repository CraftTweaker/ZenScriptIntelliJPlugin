package de.bloodworkxgaming.zenscript.plugin.zsLanguage.formatter;

import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZsBlock extends AbstractBlock {
    private CodeStyleSettings myStyleSettings; // todo consult these settings for the user's preferred formatting


    public ZsBlock(@NotNull ASTNode node, CodeStyleSettings styleSettings) {
        super(node, null, null);
        this.myStyleSettings = styleSettings;
    }

    @Override
    protected List<Block> buildChildren() {
        if (isLeaf()) {
            return Collections.emptyList();
        }

        ArrayList<Block> childBlocks = new ArrayList<>();
        for (ASTNode childNode : myNode.getChildren(null)) {
            if (childNode.getText().trim().length() == 0) {
                continue;
            }

            childBlocks.add(new ZsBlock(childNode, myStyleSettings));
        }

        return childBlocks;
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block block, @NotNull Block block1) {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    @Override
    public Indent getIndent() {
        if (myNode.getText().trim().length() == 0) {
            return null;
        }

        Indent indent;

/*
        // we indent if this element corresponds to a non-root "statements" expression
        if (myNode.getElementType() == ZsTypes_old.
                && myNode.getTreeParent().getElementType() != HbTokenTypes.FILE) {
            indent = Indent.getNormalIndent(); // todo should we pass true for relativeToDirectParent?
        } else {
            indent = Indent.getNoneIndent();
        }
  */

        indent = Indent.getNoneIndent();
        return indent;
    }
}

// < Source/Reference: https://gist.github.com/dmarcotte/4039840 >