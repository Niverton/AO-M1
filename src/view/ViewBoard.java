package view;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

import javax.swing.event.ChangeListener;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import javafx.scene.shape.*;



import javafx.animation.FillTransition; 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage; 
import javafx.animation.Timeline; 
import javafx.animation.ParallelTransition; 
import javafx.animation.RotateTransition; 
import javafx.animation.ScaleTransition; 
import javafx.animation.TranslateTransition; 
import javafx.util.Duration;
import model.Board;
import model.Point2D; 
/**
 * 
 * @author laurent
 *
 */
public class ViewBoard extends IView {
	private static Board board;
	private static Pane pane;
	protected static final Paint WALLCOLOR = Color.BURLYWOOD; 
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
		 Multigraph<Point2D,DefaultWeightedEdge> door = board.getDoor();
		 BreadthFirstIterator<Point2D,DefaultWeightedEdge> iter = new BreadthFirstIterator<Point2D,DefaultWeightedEdge>(door); 
		 
		 while(iter.hasNext()){
			Point2D sommet = iter.next(); 
			Set<DefaultWeightedEdge> children = door.edgesOf(sommet);
			for(DefaultWeightedEdge d : children){
				
				Point2D source = door.getEdgeSource(d); 
				Point2D destination = door.getEdgeTarget(d);
				if ( source.getY()== destination.getY() ){
					x = ( (WALL+CELL) + (WALL+CELL) * ( ( int ) ( source.getX()+ destination.getX() ) / 2 ) ) * SPAN;
					y = (WALL + source.getY() * (WALL+CELL) ) * SPAN;
					xspan = WALL * SPAN;
					yspan = CELL * SPAN;
					Rectangle square = new Rectangle ( x , y , xspan , yspan ) ;
					square.setFill (WALLCOLOR) ;
					pane.getChildren( ).add ( square ) ;
					}
					else if( source.getX()== destination.getX() ){
					x = (WALL + source.getX() * (WALL+CELL) ) * SPAN;
					y = ( (WALL+CELL) + (WALL+CELL) * ( ( int ) ( source.getY()+ destination.getY() ) / 2 ) ) * SPAN ; ;
					xspan = CELL * SPAN;
					yspan = WALL * SPAN;
					Rectangle square = new Rectangle ( x , y , xspan , yspan ) ;
					square.setFill (WALLCOLOR) ;
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
