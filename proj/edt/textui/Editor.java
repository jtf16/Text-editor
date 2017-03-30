package edt.textui;

import edt.core.*;

import edt.textui.main.MainMenu;

import edt.parser.*;

import static pt.utl.ist.po.ui.UserInteraction.IO;


public class Editor {

    public static void main(String[] args) {
    	Document doc = null;
    	try{
        String fileName = System.getProperty("import");
        
        Parser parser = new Parser();

        doc = parser.parse(fileName);
    	}catch(Exception e){

    	}
		Manager app =  new Manager();
		if(doc != null){
			app.setDocument(doc);
		}
		if(app != null){
        	MainMenu menu = new MainMenu(app);
        	menu.open();
        	IO.close();
		}
    }
}
