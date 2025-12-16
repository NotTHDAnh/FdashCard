package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CardSet {
	int id;
	String name;
	String description;
	List<Card> listOfCard;;
	public CardSet() {
		id = 0;
		name = "";
		description = "";
		listOfCard = new ArrayList<Card>();
	} 
	
	public CardSet(String name,String des) {
		id = ThreadLocalRandom.current().nextInt(1,101);
		this.name = name;
		this.description = des;
		
	}
	CardSet(int id, List<Card> set){
		this.id = id;
		this.listOfCard = set;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getListOfCard() {
		return listOfCard;
	}

	public void setListOfCard(List<Card> listOfCard) {
		this.listOfCard = listOfCard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
