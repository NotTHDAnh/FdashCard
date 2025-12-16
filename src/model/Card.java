package model;


public class Card {
	private int id;
	private String hint, description;
	public Card() {
		hint = description = "";
	}
	
	public Card(int id, String hint, String description) {
		this.id = id;
		this.hint = hint;
		this.description = description;
	}
	
	public Card(String hint, String description) {
		
		this.hint = hint;
		this.description = description;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	
	public String getDescription() {
		return description;
	}
	public String getHint() {
		return hint;
	}
	
	@Override
	public String toString() {
		return id + " " + hint + " " + description;
	}
}
