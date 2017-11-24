package controller;

import javafx.scene.layout.Pane;
import model.Board;
import view.ViewBoard;

public class BoardController implements IController{
	private ViewBoard v;
	private Board board;
	public BoardController(Board board){
		this.board = board;
	}
	
	/**
	 * @param pane le Pane du jeux. 
	 */
	public void start(Pane pane) {
		// TODO Auto-generated method stub
		v = new ViewBoard(board, pane);
		v.view();
	}

}
