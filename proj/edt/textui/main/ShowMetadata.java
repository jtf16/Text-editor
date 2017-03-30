package edt.textui.main;

import java.util.*;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowMetadata(Manager app) {
        super(MenuEntry.SHOW_METADATA, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();
        Document doc = entity().getDocument();
        display.add(Message.documentTitle(doc.getTitle()) + "\n");
        for (Map.Entry<String, Author> entry : doc.getAuthors().entrySet()) {
            display.add(Message.author(entry.getValue().getName(), entry.getValue().getEmail()) + "\n");
        }
        display.add(Message.documentSections(doc.getSubsections().size()) + "\n");
        display.add(Message.documentBytes(doc.getSize()) + "\n");
        display.add(Message.documentIdentifiers(doc.getTextElements().size()));
        display.display();
    }
}
