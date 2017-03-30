package edt.core;
/**
 * Grupo 46
 * @author Hugo Gaspar  81977
 * @author Joao Costa   82528
 * @author Joao Freitas 81950
 * @version ----------------------------------------------------------------
 * @since ------------------------------------------------------------------
 */

import java.util.*;

import java.io.*;

/**
 *  Classe Document representa um documento
 */
public class Document extends Section {

    /** 
     *  Variavel que representa o nome do documento
     */
    private String _filename;

    /** 
     *  Lista que representa os elementos de texto com id único
     */
    private Map<String, TextElement> _textElements = new HashMap<String, TextElement>();    
    
    /** 
     *  TreeMap que representa lista de autores de um documento
     *  (é usado TreeMap para uma ordenação mais eficiente dos autores por ordem alfabética)
     */
    private Map<String, Author> _autores = new TreeMap<String, Author>();

    /**
     *  Método que adiciona um autor à TreeMap de autores já presentes no documento
     *  @param author - Objecto do tipo Author
     */
    public void addAuthor(Author author) {
        _autores.put(author.getName(), author);
    }

    /**
     *  Método que devolve um TreeMap dos autores
     *  @return TreeMap<String, Author> - Devolve um TreeMap de dos autores ordenados
     */
    public Map<String, Author> getAuthors() {
        return _autores;
    }

    /**
     *  Método que devolve o elemento de texto correspondente ao id
     *  @param id - Identificador Único
     *  @return TextElement - Elemento de Texto (Secção ou Parágrafo)
     */
    public TextElement getTextElement(String id) {
        return _textElements.get(id);
    }
    
    /**
     *  Método que devolve a lista dos elementos de texto
     *  @return List<TextElement> - Lista dos elementos de texto
     */
    public Map<String, TextElement> getTextElements() {
        return _textElements;
    }

    /**
     *  Método que atribui um identificador único a um elemento de texto
     *  @param id - Identificador Único
     *  @param ele - Elemento de texto
     */
    public boolean indexElement(String id, TextElement ele) {
        boolean var = false;
        if (ele.isIndexed()) {
            removeFromIndex(ele);
            var = true;
        }
        ele.setKey(id);
        _textElements.put(id, ele);
        return var;
    }

    /**
     *  Método que retorna na forma pretendida o título do documento
     *  @return String - Título do documento na forma pretendida
     */
    public String getHeadline() {
        return "{" + this.getTitle() + "}\n";
    }
    
    /**
     *  Método que remove um elemento da lista TextElement e remove o seu
     *  identificador único
     *  @param ele - Elemento de texto
     */
    public void removeFromIndex(TextElement ele) {
        _textElements.remove(ele.getKey());
        ele.setKey(null);
    }

    /**
     *  Método que faz load de um Documento
     *  @param filename - Nome associado ao ficheiro que se pretende carregar
     *  @return Document - Devolve o documento que se pretendia carregar
     */
    public Document loadDocument(String filename) {

        ObjectInputStream in = null;
        Document doc = null;
        try {
            in = new ObjectInputStream(new FileInputStream(filename));
            doc = (Document) in.readObject();
            in.close();
        } catch(Exception e){

        }
        return doc;
    }

    /**
     *  Método que guarda um documento recebendo o nome do ficheiro
     * 	@param filename - Nome do ficheiro a guardar
     */
    public void saveDocument(String filename) {        
        
        ObjectOutputStream out = null;
        FileOutputStream filestream = null;
       
        try {
            filestream = new FileOutputStream(filename);
            out = new ObjectOutputStream(filestream);
            out.writeObject(this);
            out.close();
        } catch(IOException e) {}
    }

    /**
     *  Método que devolve o nome de um ficheiro
     * @return String - nome do ficheiro
     */
    public String getFilename() {
        return _filename;
    }

    /**
     *  Método que atribui um nome a um ficheiro
     *  @param filename - Nome do ficheiro 
     */
    public void setFilename(String filename) {
        _filename = filename;
    }

    /**
     *  Método que verifica se dois Documentos são iguais, isto é, se ambos os documentos
     *  têm o mesmo nome, os mesmo autores, o mesmo título e o memso conteúdo
     *  @param obj - Objecto o qual se vai verificar se é o mesmo documento (têm o mesmo nome,
     *               autores, título e conteúdo)
     *  @return boolean - Devolve True caso os documentos sejam iguais, false em caso contrário
     */
    public boolean equals(Object obj) {
        
        if (obj instanceof Document){
            Document doc = (Document)obj;
            return doc.getFilename().equals(this.getFilename()) && 
            doc.getAuthors().equals(this.getAuthors()) &&
            doc.getTitle().equals(this.getTitle()) &&
            doc.accept(new VisitorContent()).equals(this.accept(new VisitorContent()));
        }
        else{
            return false;
        }
    }
}