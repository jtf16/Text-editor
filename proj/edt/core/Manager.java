package edt.core;
/**
 * Grupo 46
 * @author Hugo Gaspar  81977
 * @author Joao Costa   82528
 * @author Joao Freitas 81950
 * @version -------------------------------------------------------------------------
 * @since ---------------------------------------------------------------------------
 */

/**
 *	Classe Manager é a classe encarregue de gerir o documento actual
 */
public class Manager {

	/** 
     *	Variavel que representa um novo documento
     */
    private Document _doc = new Document();

    /**
     *	Método que devolve o documento
     * 	@return Document - Documento actual
     */
    public Document getDocument() {
        return _doc;
    }

    /**
     *	Método que altera o documento actual
     * 	@param doc - Novo documento a estar aberto
     */
    public void setDocument(Document doc) {
        _doc = doc;
    }
}
