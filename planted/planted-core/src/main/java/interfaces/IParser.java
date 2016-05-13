package interfaces;

import java.util.List;

/**
 * Interfaccia che rappresenta un parser. L'implementazione di questa classe
 * permette alla classe che la implementa di avere il comportamente di un
 * Parser.
 * 
 * @author ashleycaselli
 *
 */
public interface IParser {
    /**
     * Questo metodo effettua il parsing della stringa passatagli come
     * parametro.
     * 
     * @param code
     *            testo su cui effettuare il parsing
     * @param srcType
     *            definisce il tipo del testo passatogli in ingresso
     * @return il metodo ritorna una lista che contiene il testo passato in
     *         input "parserizzato"
     */
    public List<String> parse(String code, FileType srcType);

}
