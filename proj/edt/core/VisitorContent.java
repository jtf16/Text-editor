package edt.core;
/**
 * Grupo 46
 * @author Hugo Gaspar  81977
 * @author Joao Costa   82528
 * @author Joao Freitas 81950
 * @version 1.0
 */

public class VisitorContent implements Visitor{

	public String visit(Section sec){
		String content = "";
        content = content.concat(sec.getHeadline());
        
        for (Paragraph paragraph : sec.getParagraphs()) {
            content = content.concat(visit(paragraph) + "\n");
        }
        for (Section section : sec.getSubsections()) {
            content = content.concat(visit(section));
        }

        return content;
	}

	public String visit(Paragraph par){
		return par.getText();
	}
}
