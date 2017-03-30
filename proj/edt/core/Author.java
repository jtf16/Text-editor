package edt.core;
/**
 * Grupo 46
 * @author Hugo Gaspar  81977
 * @author Joao Costa   82528
 * @author Joao Freitas 81950
 * @version ----------------------------------------------------------------
 * @since ------------------------------------------------------------------
 */

import java.io.Serializable;

/**
 *	Classe Author representa um autor de um determinado documento
 */
public class Author implements Serializable {

	/** 
     *	Variavel que representa o nome de um autor do documento
     */
    private String _name;

	/** 
     *	Variavel que representa o email de um autor do documento
     */
    private String _email;
 
    /** 
     *  Construtor que atribui um nome e um email a um autor
     *	@param nome - mome do autor
     * 	@param email - email do autor
     */
    public Author(String nome, String email) {
        _name = nome;
        _email = email;
    }

    /**
     *	Método que devolve o email de um autor
     *  @return String - devolve o email do autor
     */
    public String getEmail() {
        return _email;
    }

    /**
     *	Método que devolve o nome de um autor
     *  @return String - devolve o nome do autor
     */
    public String getName() {
        return _name;
    }

    /**
     *	Método que verifica se dois autores são iguais, isto é, se dois autores têm o mesmo nome e email.
     *	@param obj - Objecto o qual se vai verificar se é o mesmo autor (tem o mesmo nome e email) 
     *  @return boolean - Devolve true caso dois objectos sejam do tipo autor e iguais, false em caso contrário
     */
    public boolean equals(Object obj) {

        if (obj instanceof Author) { 																			
            Author author = (Author) obj;																			
            return author.getName().equals(this.getName()) && author.getEmail().equals(this.getEmail());
        }
        else {
            return false;
        }
    }

    public int compareTo(Author author) {
        if (this.getName().equals(author.getName())) {
            return 0;
        }
        return -1;
    }
}