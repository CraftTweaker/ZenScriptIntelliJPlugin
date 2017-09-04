package de.bloodworkxgaming.zenscript.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.ui.Messages;

public class NewZSAction extends AnAction{


    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Object navigatable = anActionEvent.getData(CommonDataKeys.NAVIGATABLE);
        if (navigatable != null) {
            Messages.showDialog(navigatable.toString(), "Selected Element:", new String[]{"OK"}, -1, null);
        }
    }
}
