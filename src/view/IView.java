package view;

public abstract class IView {
	protected static final int SPAN =4; 
	protected static final int WALL=2; 
	protected static final int CELL =9; 
	/**
	 * Lancer la vue et affichage des éléments.
	 */
	public abstract void view();
	/**
	 * Mise a jour de la vue.
	 */
	public abstract void uptdate();
}
