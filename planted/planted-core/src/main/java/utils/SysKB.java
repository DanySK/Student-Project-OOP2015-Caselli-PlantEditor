package utils;

/**
 * Questa classe contiene le consocenze di base del sistema. in particolare i
 * path di default delle cartelle (ed i nomi) e file del sistema.
 * 
 * @author ashleycaselli
 *
 */
public class SysKB {
    /**
     * Campo che contiene il nome del workspace.
     */
    public static final String WORKSPACE_NAME = "workspace";
    /**
     * Campo che contiene il seperatore per le cartelle e file nel path.
     */
    public static final String DIR_SEPARATOR = "/";
    /**
     * Campo che contiene il path del workspace.
     */
    public static final String WORKSPACE_PATH = WORKSPACE_NAME + DIR_SEPARATOR;
    /**
     * Campo che contiene il nome del file in cui vengono salvati i dati del
     * sistema.
     */
    public static final String FILE_NAME = "archive";
    /**
     * Campo che contiene il path del file in cui vengono salvati i dati del
     * sistema.
     */
    public static final String FILE_PATH = WORKSPACE_PATH + FILE_NAME + DIR_SEPARATOR;
    /**
     * Campo che contiene il nome della cartella dove saranno collocati i dati
     * esportati.
     */
    public static final String EXPORT_DIR_NAME = "export";
    /**
     * Campo che contiene il path della cartella dove saranno collocati i dati
     * esportati.
     */
    public static final String EXPORT_PATH = WORKSPACE_PATH + DIR_SEPARATOR + EXPORT_DIR_NAME + DIR_SEPARATOR;
    /**
     * Campo che contiene il nome della cartella dove saranno collocati i
     * diagrammi esportati.
     */
    public static final String DIAGRAM_DIR = "diagram";
    /**
     * Campo che contiene il path della cartella dove saranno collocati i
     * diagrammi esportati.
     */
    public static final String DIAGRAM_PATH = DIAGRAM_DIR + DIR_SEPARATOR;

}
