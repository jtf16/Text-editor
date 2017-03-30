package edt.textui.main;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Manager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListTopSections(Manager app) {
        super(MenuEntry.SHOW_INDEX, app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        Document doc = entity().getDocument();
        display.add(doc.getHeadline());
        for (Section section : doc.getSubsections()) {
            display.add(section.getHeadline());
        }
        display.display();
    }
}
