package Controller;

import model.Card;
import model.CardSet;

public class flashCardController {
	CardSet  listOfCard;
	public flashCardController() {
		// this line to add cardSet from db, which will be done later
		listOfCard = new CardSet();
		listOfCard.setName("null");
	}
	
	public flashCardController(String name,String desc) {
		listOfCard = new CardSet();
	}
	
	public flashCardController(String name) {
		listOfCard = new CardSet();
		listOfCard.setName(name);
	}
	
	public CardSet getListOfCard() {
		return listOfCard;
	}
	
	public Card getCard(int id) {
		for (Card card : listOfCard.getListOfCard()) {
			if(card.getId() == id) {
				return card;
			}
		}
		return null;
	}
	
	public boolean addCard(Card newCard) {
		for (Card card : listOfCard.getListOfCard()) {
			if(newCard.getId() == card.getId()) {
				return false;
			}
		}
		listOfCard.getListOfCard().add(newCard);
		return true;
	}
	
	public boolean updateCard(Card newCard,int id) {
		for (Card card : listOfCard.getListOfCard()) {
			if(card.getId() == id) {
				listOfCard.getListOfCard().set(listOfCard.getListOfCard().indexOf(card), newCard );
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteCard(int id) {
		return listOfCard.getListOfCard().remove(getCard(id));
	}
}