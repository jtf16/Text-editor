package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Section> {
    private Document _document;

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveParagraph(Section sec, Document doc) {
        super(MenuEntry.REMOVE_PARAGRAPH, sec);
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
        f.parse();

        if(idx.value() < entity().getParagraphs().size() && idx.value() >= 0){
            entity().removeParagraph(idx.value() , _document);
        }
        else{
            display.add(Message.noSuchParagraph(idx.value()));
            display.display();
        }
    }
}
