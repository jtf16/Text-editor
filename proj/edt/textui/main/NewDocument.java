package edt.textui.main;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public NewDocument(Manager app) {
        super(MenuEntry.NEW, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Document doc = new Document();
        entity().setDocument(doc);
    }
}
