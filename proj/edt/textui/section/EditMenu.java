package edt.textui.section;

import pt.utl.ist.po.ui.*;

import edt.textui.section.*;

import edt.core.*;

/**
 * Represents the edit menu of this application. This menu
 * shows the option to edit the selected section.
 ***/

public class EditMenu extends Menu {
    /**
     * Builds an EditMenu object. It has all available options for editing
     * a section.
     *
     * @param doc
     * @param section
     **/
    public EditMenu(Section sec, Document doc) {
        super(MenuEntry.TITLE, new Command<?>[] { 
            new ChangeTitle(sec),
            new ListSections(sec),
            new ShowSection(sec),
            new SelectSection(sec, doc),
            new InsertSection(sec, doc),
            new IndexSection(sec, doc),
            new RemoveSection(sec, doc),
            new InsertParagraph(sec),
            new IndexParagraph(sec, doc),
            new ChangeParagraph(sec),
            new RemoveParagraph(sec, doc),
        });
    }
}
