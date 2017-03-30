package edt.core;
/**
 * Grupo 46
 * @author Hugo Gaspar  81977
 * @author Joao Costa   82528
 * @author Joao Freitas 81950
 * @version ---------------------------------------------------------------------------
 * @since -----------------------------------------------------------------------------
 */

import java.io.Serializable;

/**
 *  Classe TextElement representa uma classe abstracta que tanto pode ser
 *  um parágrafo como uma secção
 */
public abstract class TextElement implements Serializable {

    /** 
     *  Variavel que representa o identificador único de um elemento de texto
     */
    private String _key;

    /**
     *  Método que devolve o identificador único
     *  @return String - Devolve o identificador único de um elemento de texto
     */
    public String getKey() {
        return _key;
    }

    /**
     *  Método que atribui um identificador único a um elemento de texto
     *  @param key - Identificador único
     */
    public void setKey(String key) {
        _key = key;
    }

    /**
     *  Método que verifica se existe identificador único
     *  @return boolean - Devolve true caso não exista identificador único, false
     *                    em caso contrário
     */
    protected boolean isIndexed() {
        if (this.getKey() != null) {
            return true;
        }
        return false;
    }

    /**
     *  Método abstracto para o tamanho da secção/parágrafo
     *  @return int - Tamanho da Secção
     */
    public abstract int getSize(); 


    public abstract String accept(VisitorContent visitorContent);
}