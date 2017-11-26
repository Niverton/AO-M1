package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import model.Labyrinth;
import model.Door;
import view.DoorView;

public class DoorController implements IController, Observer {
	
	private DoorView doorView; 
	private Labyrinth board;
	private Door door;
	/**
	 * 
	 * @param board le labyrinth. 
	 */
	public DoorController(Labyrinth board){
		
		this.board = board;
		this.door = Door.getInstance(board);
	}
	
	/**
	 * @param pane le Pane du jeux.
	 */
	public void start(Pane pane) {
		// TODO Auto-generated method stub
		
		doorView = new DoorView(board, pane, door);
		doorView.view();
	}

	/**
	 * @param o l'observable appelant.
	 * @param arg les arguments passser par l'observable. 
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		doorView.uptdate();
	}

}
