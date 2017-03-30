package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ChangeParagraph(Section sec) {
        super(MenuEntry.EDIT_PARAGRAPH, sec);
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
        InputString cont = new InputString(f, Message.requestParagraphContent());
        f.parse();

        if(idx.value() < entity().getParagraphs().size() && idx.value() >= 0){
            entity().getParagraph(idx.value()).setText(cont.value());
        }

        else{
            display.add(Message.noSuchParagraph(idx.value()));
            display.display();
        }
   }
}
