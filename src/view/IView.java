package view;

public abstract class IView {
	protected   static int SPAN =4; 
	protected static  int WALL=1; 
	protected  static float CELL =9; 
	/**
	 * Lancer la vue et affichage des éléments.
	 */
	public abstract void view();
	/**
	 * Mise a jour de la vue.
	 */
	public abstract void uptdate();
	
}
