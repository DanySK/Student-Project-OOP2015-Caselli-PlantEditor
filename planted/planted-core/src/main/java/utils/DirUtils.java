package utils;

import java.io.File;

/**
 * Questa classe contiene le utils per le cartelle del sistema.
 * 
 * @author ashleycaselli
 *
 */
public class DirUtils {
    /**
     * Metodo per creare la cartella del workspace.
     */
    public static void createWorkspace() {
	new File(SysKB.WORKSPACE_PATH).mkdirs();
	createExportDir();
    }

    /**
     * Metodo per creare le cartelle di esportazione dei file sorgenti e
     * diagrammi.
     */
    private static void createExportDir() {
	new File(SysKB.EXPORT_PATH).mkdirs();
	new File(SysKB.DIAGRAM_PATH).mkdirs();
    }

}
