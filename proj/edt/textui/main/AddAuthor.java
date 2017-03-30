package edt.textui.main;

import pt.utl.ist.po.ui.*;

import edt.core.*;

import java.util.*;

/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public AddAuthor(Manager app) {
        super(MenuEntry.ADD_AUTHOR, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputString nome = new InputString(f, Message.requestAuthorName());
        InputString email = new InputString(f, Message.requestEmail());
        f.parse();

        Document doc = entity().getDocument();
        if(doc.getAuthors()!= null){
            if(doc.getAuthors().containsKey(nome.value())){
                Display display = new Display();
                display.add(Message.duplicateAuthor(nome.value()));
                display.display();
            }            
            else{
                Author a1 = new Author(nome.value(), email.value());
                entity().getDocument().addAuthor(a1);
            }
        }
        else{
            Author a1 = new Author(nome.value(), email.value());
            entity().getDocument().addAuthor(a1);
        }
    }
}
