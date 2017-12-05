package model.interfaces;

import model.NonMoveableObject;

public interface ListO {
	public NonMoveableObject getObject(int t);
	public void add(NonMoveableObject nMO);
	public NonMoveableObject  getByNameObject(String s);
}
