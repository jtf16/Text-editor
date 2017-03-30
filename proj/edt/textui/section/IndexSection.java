package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.core.*;

/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends Command<Section> {
    private Document _document; 
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexSection(Section sec, Document doc) {
        super(MenuEntry.NAME_SECTION, sec);
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
        InputString uid = new InputString(f, Message.requestUniqueId());
        f.parse();

        TextElement ele = _document.getTextElement(uid.value());


        if(idx.value() < entity().getSubsections().size() && idx.value() >= 0){
            if (ele != null) {
                _document.removeFromIndex(ele);
            }
            
            if (_document.indexElement(uid.value(), entity().getSection(idx.value()))) {
                display.add(Message.sectionNameChanged());
                display.display();
            }
        }
        else{
            display.add(Message.noSuchSection(idx.value()));
            display.display();
        }

    }
}
