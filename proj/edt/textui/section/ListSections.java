package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListSections(Section sec) {
        super(MenuEntry.LIST_SECTIONS, sec);
    }

    private void recursive(Section section){
        if(section.getSubsections() != null){
            for (Section seccao : section.getSubsections()) {
                recursive(seccao);
            }
        }
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        for (Section section : entity().getSubsections()) {
            display.add(section.getTitles());
        }
        
        if (entity().getSubsections() != null) {
            display.display();
        }
    }
}
