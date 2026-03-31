package Controller;

import java.sql.SQLException;

import model.Card;
import model.CardDao;
import model.CardSet;

public class flashCardController {
	CardSet  listOfCard;
	public flashCardController() {
		listOfCard = new CardSet();
		listOfCard.setName("null");
	}
	
	public flashCardController(String name,String desc) {
		listOfCard = new CardSet();
	}// ???
	
	public flashCardController(String name) {
		listOfCard = new CardSet();
		listOfCard.setName(name);
	}
	public void setListOfCard(CardSet listOfCard) {
		this.listOfCard = listOfCard;
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
	public void addNewCard(Card newCard,int set_id) {
		try {
			CardDao dao = new CardDao();
			dao.addCard(newCard,set_id);
		}catch (SQLException ex) {
			System.out.println("flashCardController _SQL " + ex.getMessage());
		}catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.println("flashCardController _Class Not Found " + ex.getMessage());
		}
		finally {
			System.out.println("Card add successfully!");
		}
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