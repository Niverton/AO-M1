package model.directions;

public abstract class Directions {
	private String name; 
	public Directions(){
		name = "null"; 
	}
	/**
	 * 
	 * @param s nom de notre direction.
	 */
	protected void setName(String s){
		this.name = s;
	}
	/**
	 * 
	 * @return le nom de notre direction.
	 */
	public String getName(){
		return this.name;
	}
	/**
	 *  La cahine de caractère decrivant notre direction.
	 */
	public String toString(){
		return "direction = "+ this.getName();
	}
}
