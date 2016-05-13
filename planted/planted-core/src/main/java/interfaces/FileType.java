package interfaces;

/**
 * Questo enumerativo rappresenta il tipo di un file sorgente.
 * 
 * @author ashleycaselli
 *
 */
public enum FileType {

    PLANTUML(".pu"), JAVA(".java");

    private String extension;

    private FileType(String extension) {
	this.extension = extension;
    }

    /**
     * Metodo per estrarre l'estensione del file sorgente dal tipo.
     * 
     * @return estensione del file sorgente
     */
    public String getExtension() {
	return this.extension;
    }

}
