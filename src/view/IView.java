package view;

public abstract class IView {
	protected static final int SPAN =4; 
	protected static final int WALL=2; 
	protected static final int CELL =9; 
	public abstract void view();
	public abstract void uptdate();
}
