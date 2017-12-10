package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import view.CandyView;

public class CandyController implements IController, Observer {
	
	private CandyView view;
	
	public CandyController() {
	}
	
	
	@Override
	public void start(Pane pane) {
		System.out.println("CandyController.start");
		view = new CandyView(pane);
	}
	
	@Override
	public void update(Observable gc, Object arg) {
		//System.out.println("CandyController update");
		view.update();
	}
}
