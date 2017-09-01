package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.psi.tree.IElementType;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsLanguage;
import org.jetbrains.annotations.NotNull;

public class ZsElementType extends IElementType {
    public ZsElementType(@NotNull String debugName) {
        super(debugName, ZsLanguage.INSTANCE);
    }
}
