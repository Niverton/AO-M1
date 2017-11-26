package controller;

import javafx.scene.layout.Pane;
import model.Labyrinth;
import view.ViewLabyrinth;

public class LabyrinthController implements IController{
	private ViewLabyrinth v;
	private Labyrinth labyrinth;
	/**
	 * 
	 * @param labyrinth le labyrinth du jeux.
	 */
	public LabyrinthController(Labyrinth labyrinth){
		this.labyrinth = labyrinth;
	}
	
	/**
	 * @param pane le Pane du jeux. 
	 */
	public void start(Pane pane) {
		// TODO Auto-generated method stub
		v = new ViewLabyrinth(labyrinth, pane);
		v.view();
	}

}
