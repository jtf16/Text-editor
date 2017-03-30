package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertParagraph(Section sec) {
        super(MenuEntry.INSERT_PARAGRAPH, sec);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger idx = new InputInteger(f, Message.requestParagraphId());
        InputString content = new InputString(f, Message.requestParagraphContent());
        f.parse();

        Paragraph par = new Paragraph(content.value());
        entity().addParagraph(idx.value(), par);
    }
}
