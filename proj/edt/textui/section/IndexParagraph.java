package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {
    private Document _document;

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(Section sec, Document doc) {
        super(MenuEntry.NAME_PARAGRAPH, sec);
        _document = doc;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        Form f = new Form();
        InputInteger idx = new InputInteger(f, Message.requestParagraphId());
        InputString uid = new InputString(f, Message.requestUniqueId());
        f.parse();

        TextElement ele = _document.getTextElement(uid.value());


        if(idx.value() < entity().getParagraphs().size() && idx.value() >= 0){
            if (ele != null) {
                _document.removeFromIndex(ele);
            }
            
            if (_document.indexElement(uid.value(), entity().getParagraph(idx.value()))) {
                display.add(Message.paragraphNameChanged());
                display.display();
            }
        }
        else{
            display.add(Message.noSuchParagraph(idx.value()));
            display.display();
        }
    }
}
