package skunk.domain;
import myskunk.pl.SkunkUI;

public class Controller {
	SkunkUI ui = new SkunkUI();
	
	public Controller() {
		
	}

	public String getPlayerNameFromUI() {
		return ui.getEnteredName();
	}

}
