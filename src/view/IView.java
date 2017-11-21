package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public abstract class IView {
	protected static final int SPAN =4; 
	protected static final int WALL=2; 
	protected static final int CELL =9; 
	public abstract void view();
	public abstract void uptdate();
}
