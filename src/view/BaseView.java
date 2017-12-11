package view;

public abstract class BaseView {
	protected   static int SPAN =4; 
	protected static  int WALL=1; 
	protected  static float CELL =9; 
	/**
	 * Lancer la vue et affichage des �l�ments.
	 */
	public abstract void view();
	/**
	 * Mise a jour de la vue.
	 */
	public abstract void update();
	
}
