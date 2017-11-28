package model;

import java.util.ArrayList;

public class ListObject {
	ArrayList<NonMoveableObject> listObject; 
	
	public ListObject(){
		listObject = new ArrayList<NonMoveableObject>();
	}
	/**
	 * 
	 * @param t indice de l'objet � r�cuperer
	 * @return l'objet non mobile associ�
	 */
	public NonMoveableObject getObject(int t){
		return listObject.get(t);
	}
	/**
	 * 
	 * @param nMO l'objet non mobile a ajouter.
	 */
	public void add(NonMoveableObject nMO){
		this.listObject.add(nMO);
	}
	/**
	 * 
	 * @param sle nom de lobjet que l'on souhaite r�cup�rer
	 * @return l'objet associer a l'objet.
	 */
	public NonMoveableObject  getByNameObject(String s){
		// � ajouter exception s'il n'existe pas.
		for(NonMoveableObject n : this.listObject){
			if(n.getName().equals(s))
				return n;
		}
		return null;
	}
}
