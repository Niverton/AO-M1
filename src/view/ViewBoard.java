package view;




import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.Board;
import model.Point2D;
import model.RelationshipEdge; 
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
	public static void drawWall (  ){
		int x = 0 , y = 0 , xspan = 0 , yspan = 0 ;
		Multigraph<Point2D,RelationshipEdge<Point2D>> door = board.getDoor();
		BreadthFirstIterator<Point2D,RelationshipEdge<Point2D>> iter = new BreadthFirstIterator<Point2D,RelationshipEdge<Point2D>>(door); 

		while(iter.hasNext()){
			Point2D sommet = iter.next(); 
			Set<RelationshipEdge<Point2D>> children = door.edgesOf(sommet);
			for(RelationshipEdge<Point2D> d : children){

				Point2D source = door.getEdgeSource(d); 
				Point2D destination = door.getEdgeTarget(d);
				if ( source.getY()== destination.getY() ){
					x = ( (WALL+CELL) + (WALL+CELL) * ( ( int ) ( source.getX()+ destination.getX() ) / 2 ) ) * SPAN;
					y = (WALL + source.getY() * (WALL+CELL) ) * SPAN;
					xspan = WALL * SPAN;
					yspan = CELL * SPAN;
					Rectangle square = new Rectangle ( x , y , xspan , yspan ) ;
					if(!d.isOpen()){
						square.setFill (WALLCOLOR) ;
					}else{
						square.setFill (WALLCOLOROPEN) ;
					}


					pane.getChildren( ).add ( square ) ;
				}
				else if( source.getX()== destination.getX() ){
					x = (WALL + source.getX() * (WALL+CELL) ) * SPAN;
					y = ( (WALL+CELL) + (WALL+CELL) * ( ( int ) ( source.getY()+ destination.getY() ) / 2 ) ) * SPAN ; ;
					xspan = CELL * SPAN;
					yspan = WALL * SPAN;
					Rectangle square = new Rectangle ( x , y , xspan , yspan ) ;
					if(!d.isOpen()){
						square.setFill (WALLCOLOR) ;
					}else{
						square.setFill (WALLCOLOROPEN) ;
					}

					pane.getChildren( ).add ( square ) ;
				}
			}
		}
	}


	public void view() {

		this.drawFrame();
		this.drawWall();
	}
	@Override
	public void uptdate() {
		// TODO Auto-generated method stub

	}

}
