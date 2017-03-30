package edt.textui.main;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Manager>{

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public OpenDocument(Manager app) {
        super(MenuEntry.OPEN, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        Form f = new Form();
        InputString filename = new InputString(f, Message.openFile());
        f.parse();
        Display display = new Display();
        Document doc = new Document();
        doc = doc.loadDocument(filename.value());
        if (doc != null) {
            entity().setDocument(doc.loadDocument(filename.value()));
        }
        else{
            display.add(Message.fileNotFound());
            display.display();
        }
    }
}
