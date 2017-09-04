package de.bloodworkxgaming.zenscript.plugin.zsLanguage.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import de.bloodworkxgaming.zenscript.plugin.zsLanguage.ZsFileType;

public class ZsElementFactory {
    public static ZsAssignStatement createAssignStatement(Project project, String name, String value) {
        final ZsFile file = createFile(project, name + " = " + value);
        return (ZsAssignStatement) file.getFirstChild();
    }

    public static ZsAssignStatement createAssignStatement(Project project, String name) {
        final ZsFile file = createFile(project, name);
        return (ZsAssignStatement) file.getFirstChild();
    }

    public static ZsVariable createVariableStatement(Project project, String name) {
        final ZsFile file = createFile(project, name);
        return (ZsVariable) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final ZsFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

    public static ZsFile createFile(Project project, String text) {
        String name = "dummy.zs";
        return (ZsFile) PsiFileFactory.getInstance(project).createFileFromText(name, ZsFileType.INSTANCE, text);
    }
}
