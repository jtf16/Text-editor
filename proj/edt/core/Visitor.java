package edt.core;
/**
 * Grupo 46
 * @author Hugo Gaspar  81977
 * @author Joao Costa   82528
 * @author Joao Freitas 81950
 * @version 1.0
 */

public interface Visitor {

	public String visit(Section sec);

	public String visit(Paragraph par);
}
