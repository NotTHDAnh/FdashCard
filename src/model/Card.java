package model;


public class Card {
	private int id;
	private String hint, description;
	private int set_id;
	public Card() {
		hint = description = "";
	}

	
	public Card(int id, String hint, String description,int set_id) {
		this.id = id;
		this.hint = hint;
		this.description = description;
		this.set_id = set_id;
	}
	
	public int getSet_id() {
		return set_id;
	}
	
	public void setSet_id(int set_id) {
		this.set_id = set_id;
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
