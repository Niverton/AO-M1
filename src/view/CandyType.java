package view;

import javafx.scene.image.Image;

public enum CandyType {
	Candy1("Candy1", "ressource/candy1.png", 100),
	Candy2("Candy2", "ressource/candy2.png", 200),
	Candy3("Candy3", "ressource/candy3.png", 300),
	Candy4("Candy4", "ressource/candy4.png", 400);
	
	private CandyType(String name, String sprite, int value) {
		this.name = name;
		this.sprite = new Image(getClass().getResource(sprite).toExternalForm());
		this.value = value;
	}
	
	public String toString() {
		return name;
	}
	
	public Image sprite() {
		return sprite;
	}
	
	public int value() {
		return value;
	}
	
	private String name;
	private Image sprite;
	private int value;
}
