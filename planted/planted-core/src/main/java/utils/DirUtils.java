package utils;

import java.io.File;

public class DirUtils {

    public static void createWorkspace() {
	new File(SysKB.WORKSPACE_PATH).mkdirs();
	createExportDir();
    }

    private static void createExportDir() {
	new File(SysKB.EXPORT_PATH).mkdirs();
	new File(SysKB.DIAGRAM_PATH).mkdirs();
	// new File(SysKB.CODE_PATH).mkdirs();
    }

}
