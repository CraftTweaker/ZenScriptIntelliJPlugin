package de.bloodworkxgaming.zenscript.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class NewZSAction extends AnAction{


    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        System.out.println("anActionEvent = " + anActionEvent);
    }
}
