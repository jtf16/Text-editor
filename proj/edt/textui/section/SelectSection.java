package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.textui.main.*;

import edt.core.*;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Section> {
    private Document _document; 

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SelectSection(Section sec, Document doc) {
        super(MenuEntry.SELECT_SECTION, sec);
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
        InputInteger idx = new InputInteger(f, Message.requestSectionId());
        f.parse();

        if(idx.value() < entity().getSubsections().size() && idx.value() >= 0){
            display.add(Message.newActiveSection(idx.value()));
            display.display();
            EditMenu menu = new EditMenu(entity().getSection(idx.value()), _document);
            menu.open();
        }
        else{
            display.add(Message.noSuchSection(idx.value()));
            display.display();
        }

    }
}
