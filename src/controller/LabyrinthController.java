package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import model.Labyrinth;
import view.ViewLabyrinth;

public class LabyrinthController implements IController, Observer{
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
