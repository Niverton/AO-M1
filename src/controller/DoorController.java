package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import model.Board;
import model.Door;
import view.DoorView;

public class DoorController implements IController, Observer {

	private DoorView doorView; 
	private Board board;
	private Door door;
	public DoorController(Board board){
		
		this.board = board;
		this.door = Door.getInstance(board);
	}
	
	@Override
	public void start(Pane pane) {
		// TODO Auto-generated method stub
		
		doorView = new DoorView(board, pane, door);
		doorView.view();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		doorView.uptdate();
	}

}
