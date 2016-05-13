package interfaces;

/**
 * Questo enumerativo contiene tutti i comandi che possono essere eseguiti.
 * 
 * @author ashleycaselli
 *
 */
public enum Command {

    /* workspace */
    LOAD, SAVE,
    /* project */
    ADD_PROJECT, REMOVE_PROJECT, SELECT_PROJECT,
    /* source file */
    ADD_SOURCE_FILE, REMOVE_SOURCE_FILE, OPEN_EDITOR, SAVE_EDITOR,
    /* source file diagram */
    GENERATE_DIAGRAM, EXPORT_DIAGRAM, CLEAR_DIAGRAM,
    /* source file code */
    EXPORT_CODE;

}
