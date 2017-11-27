package view;




import java.awt.Dimension;

import java.util.Vector;

import org.jgrapht.traverse.BreadthFirstIterator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.Labyrinth;
import model.graph.Edge;
import model.graph.Graph;
import model.graph.Vertex; 
/**
 * 
 * @author laurent
 *
 */
public class ViewLabyrinth extends IView {
	private static Labyrinth labyrinth;
	private  static Pane pane;
	protected static final Paint WALLCOLOR = Color.BURLYWOOD; 
	protected static final Paint DOORCOLOR = Color.web("25154d"); 
	public ViewLabyrinth(Labyrinth b, Pane pane) {
		this.labyrinth = b;
		this.pane = pane;
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		pane.autosize();

		SPAN =4;
	}
	/**
	 * Dessiner la fenêtre ( le cadre). 
	 */
	public static void drawFrame( ){
		Rectangle square;
		square = new Rectangle ( 0 , 0 ,
				SPAN * ( labyrinth.getSize()  *(CELL+WALL) + WALL) , WALL * SPAN ) ;
		square.setFill (WALLCOLOR) ;
		pane.getChildren ( ) . add ( square ) ;
		square = new Rectangle ( 0 , SPAN * (labyrinth.getSize() * (CELL+WALL) ) ,
				SPAN * ( labyrinth.getSize() * (CELL+WALL) + WALL) , WALL * SPAN ) ;
		square.setFill(WALLCOLOR) ;
		pane.getChildren ( ) . add ( square ) ;
		square = new Rectangle ( 0 , 0 ,
				WALL * SPAN, SPAN * (labyrinth.getSize() * (CELL+WALL) + WALL) ) ;
		square.setFill (WALLCOLOR) ;
		pane.getChildren ( ) . add ( square ) ;
		square = new Rectangle (SPAN * ( labyrinth.getSize() *(CELL+WALL) ) , 0 ,
				WALL * SPAN, SPAN * (labyrinth.getSize() * (CELL + WALL) + WALL) ) ;
		square.setFill (WALLCOLOR) ;
		pane.getChildren( ).add (square) ;
		for ( int x = 0 ; x < labyrinth.getSize()-1 ; ++x ){
			float offsetX = ( (WALL+CELL) + (WALL+CELL) * x ) * SPAN;
			for ( int y = 0 ; y <labyrinth.getSize()-1 ; ++y ){
				float offsetY = ( (WALL+CELL) + (WALL+CELL) * y ) * SPAN;
				square = new Rectangle ( offsetX , offsetY ,
						WALL * SPAN, WALL * SPAN ) ;
				square.setFill (WALLCOLOR) ;
				pane.getChildren( ).add ( square ) ;
			}
		}

	}
	/**
	 * Dzqqinier les murs.
	 */
	public static void drawWallsAndDoor (  ){
		int x = 0 , y = 0 , xspan = 0 , yspan = 0 ;
		Graph door = labyrinth.getLabyrinth();
		BreadthFirstIterator<Vertex,Edge> iter = new BreadthFirstIterator<Vertex,Edge>(door); 
		Labyrinth.Directions direction[] = new Labyrinth.Directions[4]; 
		Vector<Labyrinth.Directions> list = new Vector<Labyrinth.Directions >( );
		for ( int i = 0 ; i < direction.length ; ++i )
			list.add( Labyrinth.Directions.values( ) [ i ] ) ;
		
		while(iter.hasNext()){
			Vertex v = iter.next();
			for(int i =0; i< direction.length; i++){
			
				Labyrinth.Directions dir = list.get(i);
				boolean isOpenDoor = labyrinth.isOpenDoor(v, dir);
				if(v.inBorders(0, labyrinth.getSize(), dir) && (labyrinth.isWall(v, dir) || isOpenDoor)){
					
						
					int xs = v.getX(); 
					int ys = v.getY();
					int xt = xs; 
					int yt = ys; 
					switch(dir){
					case NORTH: yt --; 
					break; 
					case SOUTH: yt++; 
					break; 
					case EAST: xt++; 
					break; 
					case WEST: xt--;
					break;
					}
					if(isOpenDoor)
					drawWall(xs,ys,xt,yt, true);
					else
					drawWall(xs,ys,xt,yt, false);

				}
				
			}
		}
	}
	/**
	 * 
	 * @param xs abscisse source 
	 * @param ys ordonnée source 
	 * @param xt abscisse destination
	 * @param yt ordnnées destination
	 */
	public static void drawWall(int xs, int ys, int xt, int yt, boolean isDoor){
		float x =0, y=0;
		float  xspan =0, yspan=0; 

		if(ys == yt){
			x = ( (WALL+CELL) + (WALL+CELL) * ( ( int ) ( xs+ xt ) / 2 ) ) * SPAN;
			y = (WALL +ys * (WALL+CELL) ) * SPAN;
			xspan = WALL * SPAN;
			yspan = CELL * SPAN;
			Rectangle square = new Rectangle ( x , y , xspan , yspan ) ;
			if(isDoor){
				square.setFill (DOORCOLOR) ;
			}
			else{
				square.setFill (WALLCOLOR) ;
			}

			pane.getChildren( ).add ( square ) ;
		}
		else if( xt == xs ){
			x = (WALL + xs * (WALL+CELL) ) * SPAN;
			y = ( (WALL+CELL) + (WALL+CELL) * ( ( int ) ( ys+yt) / 2 ) ) * SPAN ; ;
			xspan = CELL * SPAN;
			yspan = WALL * SPAN;
			Rectangle square = new Rectangle ( x , y , xspan , yspan ) ;

			if(isDoor){
				square.setFill (DOORCOLOR) ;
			}
			else{
				square.setFill (WALLCOLOR) ;
			}
			pane.getChildren( ).add ( square ) ;
		}
	}


	public void view() {

		this.drawFrame();
		this.drawWallsAndDoor();
	}
	@Override
	public void uptdate() {
		// TODO Auto-generated method stub

	}

}
