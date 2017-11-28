package model;



public class NonMoveableObject extends ObjectGame {
	private String name; 
	/**
	 * 
	 * @param name le nom de l'objet.
	 */
	public NonMoveableObject(String name){
		super();
		this.name = name;
	}
	/**
	 * 
	 * @param name le nom de l'objet non mobile 
	 * @param x l'abscisse de l'objet
	 * @param y l'ordonnée de l'objet
	 */
	public NonMoveableObject(String name, int x, int y){
		super(x,y); 
		this.name = name;
	}
	/**
	 * 
	 * @return le nom de l'objet nonmobile.
	 */
	public String  getName(){
		return name;
	}
}
