package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.psi.tree.IElementType;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsLanguage;
import org.jetbrains.annotations.NotNull;

public class ZsTokenType extends IElementType {
    public ZsTokenType(@NotNull String debugName) {
        super(debugName, ZsLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "ZsTokenType" + super.toString();
    }
}
