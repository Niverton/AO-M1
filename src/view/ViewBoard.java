package view;




import java.util.Set;
import java.util.Vector;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.Board;
import model.Vertex;

import model.Edge;
import model.Graph; 
/**
 * 
 * @author laurent
 *
 */
public class ViewBoard extends IView {
	private static Board board;
	private static Pane pane;
	protected static final Paint WALLCOLOR = Color.BURLYWOOD; 
	protected static final Paint WALLCOLOROPEN = Color.web("25154d"); 
	public ViewBoard(Board b, Pane pane) {
		this.board = b;
		this.pane = pane;
	}
	public static void drawFrame( ){
		Rectangle square;
		square = new Rectangle ( 0 , 0 ,
				SPAN * ( board.getSize()  *(CELL+WALL) + WALL) , WALL * SPAN ) ;
		square.setFill (WALLCOLOR) ;
		pane.getChildren ( ) . add ( square ) ;
		square = new Rectangle ( 0 , SPAN * (board.getSize() * (CELL+WALL) ) ,
				SPAN * ( board.getSize() * (CELL+WALL) + WALL) , WALL * SPAN ) ;
		square.setFill(WALLCOLOR) ;
		pane.getChildren ( ) . add ( square ) ;
		square = new Rectangle ( 0 , 0 ,
				WALL * SPAN, SPAN * (board.getSize() * (CELL+WALL) + WALL) ) ;
		square.setFill (WALLCOLOR) ;
		pane.getChildren ( ) . add ( square ) ;
		square = new Rectangle (SPAN * ( board.getSize() *(CELL+WALL) ) , 0 ,
				WALL * SPAN, SPAN * (board.getSize() * (CELL + WALL) + WALL) ) ;
		square.setFill (WALLCOLOR) ;
		pane.getChildren( ).add (square) ;
		for ( int x = 0 ; x < board.getSize()-1 ; ++x ){
			int offsetX = ( (WALL+CELL) + (WALL+CELL) * x ) * SPAN;
			for ( int y = 0 ; y <board.getSize()-1 ; ++y ){
				int offsetY = ( (WALL+CELL) + (WALL+CELL) * y ) * SPAN;
				square = new Rectangle ( offsetX , offsetY ,
						WALL * SPAN, WALL * SPAN ) ;
				square.setFill (WALLCOLOR) ;
				pane.getChildren( ).add ( square ) ;
			}
		}

	}
	public static void drawWalls (  ){
		int x = 0 , y = 0 , xspan = 0 , yspan = 0 ;
		Graph door = board.getBoard();
		BreadthFirstIterator<Vertex,Edge> iter = new BreadthFirstIterator<Vertex,Edge>(door); 
		Board.Directions direction[] = new Board.Directions[4]; 
		Vector<Board.Directions> list = new Vector<Board.Directions >( );
		for ( int i = 0 ; i < direction.length ; ++i )
			list.add( Board.Directions.values( ) [ i ] ) ;
		
		while(iter.hasNext()){
			Vertex v = iter.next();
			for(int i =0; i< direction.length; i++){
			
				Board.Directions dir = list.get(i);
				if(v.inBorders(0, board.getSize(), dir) && board.isWall(v, dir)){
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
					
					drawWall(xs,ys,xt,yt);

				}
			}
		}
	}

	public static void drawWall(int xs, int ys, int xt, int yt){
		int x =0, y=0, xspan =0, yspan=0; 

		if(ys == yt){
			x = ( (WALL+CELL) + (WALL+CELL) * ( ( int ) ( xs+ xt ) / 2 ) ) * SPAN;
			y = (WALL +ys * (WALL+CELL) ) * SPAN;
			xspan = WALL * SPAN;
			yspan = CELL * SPAN;
			Rectangle square = new Rectangle ( x , y , xspan , yspan ) ;

			square.setFill (WALLCOLOR) ;

			pane.getChildren( ).add ( square ) ;
		}
		else if( xt == xs ){
			x = (WALL + xs * (WALL+CELL) ) * SPAN;
			y = ( (WALL+CELL) + (WALL+CELL) * ( ( int ) ( ys+yt) / 2 ) ) * SPAN ; ;
			xspan = CELL * SPAN;
			yspan = WALL * SPAN;
			Rectangle square = new Rectangle ( x , y , xspan , yspan ) ;

			square.setFill (WALLCOLOR) ;
			pane.getChildren( ).add ( square ) ;
		}
	}


	public void view() {

		this.drawFrame();
		this.drawWalls();
	}
	@Override
	public void uptdate() {
		// TODO Auto-generated method stub

	}

}
