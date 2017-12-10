package controller;

import javafx.scene.layout.Pane;
import view.DoorView;
public class DoorController  {
		
		private DoorView d;
		
		public DoorController( ){
		
		}
		
		/**
		 * @param pane Le pane du jeux.
		 */
		public void start(Pane pane){
		    d = new DoorView(pane);
			d.view();
		}

		public void update() {
			d.update();
		}

}