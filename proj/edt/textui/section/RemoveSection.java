package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {
    private Document _document; 

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveSection(Section sec, Document doc) {
        super(MenuEntry.REMOVE_SECTION, sec);
        _document = doc;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger idx = new InputInteger(f, Message.requestSectionId());
        f.parse();

        entity().removeSection(idx.value(), _document);
    }
}
