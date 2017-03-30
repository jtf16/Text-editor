package edt.textui.main;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<Manager>{

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SaveDocument(Manager app) {
        super(MenuEntry.SAVE, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        String filename = entity().getDocument().getFilename();
        Document doc = new Document();
        doc = doc.loadDocument(filename);
        if(!entity().getDocument().equals(doc)){
            if(filename == null){
                Form f = new Form();
                InputString file = new InputString(f, Message.newSaveAs());
                f.parse();
                entity().getDocument().setFilename(file.value());
                filename = file.value();
            }
            entity().getDocument().saveDocument(filename);
        }
    }
}