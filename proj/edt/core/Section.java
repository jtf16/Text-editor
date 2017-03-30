package edt.core;
/**
 * Grupo 46
 * @author Hugo Gaspar  81977
 * @author Joao Costa   82528
 * @author Joao Freitas 81950
 * @version 1.0
 */

import java.util.*;

/**
 *  Classe Secção representa uma secção de um determinado documento ou ou subsecção
 *  de uma secção já existente
 */
public class Section extends TextElement {

    /** 
     *  Variavel que representa o título de uma secção (Quando criada, esta não contém título)
     */
    private String _title = "";

    /** 
     *  Variavel que representa o nome de um autor do documento
     */
    private List<Paragraph> _paragraphs = new ArrayList<>();
    
    /** 
     *  Variavel que representa o nome de um autor do documento
     */
    private List<Section> _sections = new ArrayList<>();

    /**
     *  Construtor da classe Section inicializado a null
     */
    public Section() {}

    /**
     *  Construtor que recebe uma String para o título do secção
     *  @param title - Título da secção
     */
    public Section(String title) {
        _title = title;
    }

    /**
     *  Método que retorna na forma pretendida o título da secção
     *  @return String - Título da secção na forma pretendida
     */
    public String getHeadline() {
        if (this.getKey() != null) {
            return "[" + this.getKey() + "]" + "{" + this.getTitle() + "}\n";
        }
        else {
            return "[]" + "{" + this.getTitle() + "}\n";
        }
    }

    /**
     *  Método que atribui um titulo a uma secção
     *  @param title - Título da Secção
     */
    public void setTitle(String title) {
        _title = title;
    }

    /**
     *  Método que devolve o título da secção
     *  @return String - Títutlo da secção
     */
    public String getTitle() {
        return _title;
    }

    /**
     *  Método que devolve o tamanho da secção, somando o tamanho do título
     *  ao tamanho do parágrafos e das suas subsecções
     *  @return - Tamanho da Secção
     */
    public int getSize() {
        int size = this.getTitle().length();

        for (Paragraph paragraph : _paragraphs) {
            size += paragraph.getSize();
        }

        for (Section section : _sections) {
            size += section.getSize();
        }

        return size;
    }

    /**
     *  Método que devolve o conteúdo da secção, concatenando o conteúdo dos parágrafos
     *  com o conteúdo das subsecções
     *  @return String - Conteúdo das secções
     */

    public String getTitles() {
        String content = "";
        content = content.concat(this.getHeadline());

        for (Section section : _sections) {
            content = content.concat(section.getTitles());
        }

        return content;
    }

    /**
     *  Método que devolve a lista das subsecções
     *  @return List - Lista das subsecções de uma secção
     */
    public List<Section> getSubsections() {
        return _sections;
    }

    /**
     *  Método que devolve uma subsecção
     *  @param idx - Índice da lista de subsecções
     *  @return Section - Devolve a secção correspondente ao índice
     */
    public Section getSection(int idx) {
        return _sections.get(idx);
    }

    /**
     *  Método que devolve o identificador único
     *  @return String - Devolve identificador único da subsecção
     */
    public String getSubsectionIndex() {
        return "";
    }

    /**
     *  Método que adiciona uma subsecção a uma determinada secção
     *  @param idx - Índice da lista de subsecção
     *  @param sec - Secção a adicionar
     */
    public void addSection(int idx, Section sec) {
        if (getSubsections().size() > idx && idx >= 0) {
            _sections.add(idx, sec);
        }
        else {
            _sections.add(sec);
        }
    }

    /**
     *  Método que remove uma secção de um documento ou de uma secção
     *  @param idx - Índice da lista de subsecção
     *  @param doc - documento ao qual será removida a secção     
     *  @return boolean - Devolve True caso a secção/subsecção tenha sido removida e 
     *                    false caso contrário
     */
    public boolean removeSection(int idx, Document doc) {
        int i = 0;
        if (getSubsections().size() > idx  && idx >= 0) {
            for (Section section : _sections) {
                for (Paragraph paragraph : section.getParagraphs()) {
                    if(paragraph.isIndexed()){
                        doc.removeFromIndex(paragraph);
                    }
                }
                section.removeSection(i, doc);
                i++;
            }
            if (getSection(idx).isIndexed()) {
                doc.removeFromIndex(getSection(idx));
            }
            _sections.remove(idx);
            return true;
        }
        return false;
    }

    /**
     *  Método que adiciona um parágrafo a uma secção
     *  @param idx - Índice da lista de parágrafos
     *  @param par - Parágrafo a adicionar
     */
    public void addParagraph(int idx, Paragraph par) {
        if (getParagraphs().size() > idx && idx >= 0) {
            _paragraphs.add(idx, par);
        }
        else{
            _paragraphs.add(par);
        }
    }

    /**
     *  Método que remove um parágrafo de um documento ou de uma secção
     *  @param idx - Índice da lista de parágrafo
     *  @param doc - documento ao qual será removido o parágrafo  
     *  @return boolean - Devolve True caso o parágrafo tenha sido removido e 
     *                    false caso contrário
     */
    public boolean removeParagraph(int idx, Document doc) {
        if (getParagraphs().size() > idx && idx >= 0) {
            if (getParagraph(idx).isIndexed()) {
                doc.removeFromIndex(getParagraph(idx));
            }
            _paragraphs.remove(idx);
            return true;
        }
        return false;
    }

    /**
     *  Método que devolve um parágrafo
     *  @param idx - Índice da lista de parágrafos
     *  @return Paragraph - Paragrafo a ser devolvido
     */
    public Paragraph getParagraph(int idx) {
        return _paragraphs.get(idx);
    }

    /**
     *  Método que devolve a lista de todos os parágrafos de uma secção
     *  @return List - Lista com todos os parágrafos da secção
     */
    public List<Paragraph> getParagraphs() {
        return _paragraphs;
    }

    /**
     *  Método que devolve o conteúdo da secção
     *  @return String - Devolve o contéudo da secção 
     */
    public String accept(VisitorContent visitorContent){
        return visitorContent.visit(this);
    }
}