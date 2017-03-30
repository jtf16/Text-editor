package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Section> {
    private Document _document; 
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertSection(Section sec, Document doc) {
        super(MenuEntry.INSERT_SECTION, sec);
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
        InputString title = new InputString(f, Message.requestSectionTitle());
        f.parse();

        Section section = new Section(title.value());
        entity().addSection(idx.value(), section);
    }
}
