package edt.textui.main;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowTextElement(Manager app) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        Form f = new Form();
        InputString uid = new InputString(f, Message.requestElementId());
        f.parse();
        
        TextElement ele = entity().getDocument().getTextElement(uid.value());

        if(ele == null){
            display.add(Message.noSuchTextElement(uid.value()));
        }

        else{
            display.add(ele.accept(new VisitorContent()));
        }
        display.display();
    }
}
