package edt.core;
/**
 * Grupo 46
 * @author Hugo Gaspar  81977
 * @author Joao Costa   82528
 * @author Joao Freitas 81950
 * @version ---------------------------------------------------------------------------
 * @since -----------------------------------------------------------------------------
 */

/**
 *  Classe Paragraph representa um paragrafo de uma determinada secção
 */
public class Paragraph extends TextElement {

    /** 
     *  Variavel que representa o contéudo de um parágrafo
     */
    private String _text;

    /** 
     *  Construtor que cria um parágrafo 
     *  @param tamanho - determina qual a dimensao da matriz para o jogo
     */
    public Paragraph(String text) {
        _text = text;
    }

    /**
     *  Método que introduz conteúdo no parágrafo
     *  @param text - Contéudo a introduzir no parágrafo
     */ 
    public void setText(String text) {
        _text = text;
    }

    /**
     *  Método que devolve o conteúdo do parágrafo
     *  @return String - Devolve o contéudo do parágrafo 
     */
    public String getText() {
        return _text;
    }

    /**
     *  Método que devolve o tamanho do contéudo do parágrafo
     *  @return int - Devolve o tamanho do conteúdo do parágrafo 
     */
    public int getSize() {
        return this.getText().length();
    }

    public String accept(VisitorContent visitorContent){
        return visitorContent.visit(this);
    }
}