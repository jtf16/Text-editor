package edt.textui.main;

import pt.utl.ist.po.ui.*;

import edt.textui.section.*;

import edt.core.*;

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public EditSection(Manager app) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Document doc = entity().getDocument();
        EditMenu menu = new EditMenu(doc, doc);
        
        menu.open();
    }
}

