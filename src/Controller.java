/**
 * Main class for program, creates model and GUI
 * with model as argument
 * @author Connor LoMonaco
 * @version 3/25/2015
 *
 */
public class Controller {

	public static void main(String[] args) {
		Model myModel = new Model();
		GUI gui = new GUI(myModel);
	}
}
