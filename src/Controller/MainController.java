package Controller;

import model.Card;
import model.CardDao;
import model.CardSet;
import model.CardSetDao;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {
	List<CardSet> listOfSet;
	public MainController() {
		try {
			CardSetDao csdao = new CardSetDao();
			if(!csdao.loadCardSet()) {
				listOfSet = new ArrayList<CardSet>();
			}
			else {
				listOfSet = csdao.getListOfCardSet();
				for (CardSet cardSet : listOfSet) {
					CardDao cdao = new CardDao();
					cdao.loadCard(cardSet.getId());
					cardSet.setListOfCard(cdao.getListOfCard());
				}
			}
		}catch (SQLException ex) {
			System.out.println("mainController _SQL " + ex.getMessage());
		}catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.println("mainController _Class Not Found " + ex.getMessage());
		}
	}
	public int getSize() {
		return listOfSet.size();
	}
	public List<CardSet> getListOfSet(){
		return listOfSet;
	}
	public CardSet  getSetOfCard(int id) {
		for (CardSet cardSet : listOfSet) {
			if(cardSet.getId() == id) {
				return cardSet;
			}
		}
		return null;
	}
	public boolean addSet(CardSet set) {
		if(getSetOfCard(set.getId()) == null){
			listOfSet.add(set);
			return true;
		}
		return false;
	}
	public void addNewSet(CardSet set) {
		try {
			CardSetDao dao = new CardSetDao();
			dao.addNewSet(set);
		}catch (SQLException ex) {
			System.out.println("mainController _SQL " + ex.getMessage());
		}catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.println("mainController _Class Not Found " + ex.getMessage());
		}
		finally {
			System.out.println("Set create successfullly!");
		}
	}
	public boolean updateSet(int id,CardSet set) {
		if(getSetOfCard(id) != null) {
			listOfSet.set(listOfSet.indexOf(getSetOfCard(id)), set);
			return true;
		}
		return false;
	}
	public boolean deleteSet(int id) {
		if (getSetOfCard(id) != null) {
			listOfSet.remove(getSetOfCard(id));
			return true;
		}
		return false;
	}
	
	public void deleteSetByID(int id) {
		try {
			CardSetDao dao = new CardSetDao();
			dao.deleteSet(id);
		}catch (SQLException ex) {
			System.out.println("mainController _SQL " + ex.getMessage());
		}catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.println("mainController _Class Not Found " + ex.getMessage());
		}
		finally {
			System.out.println("delete successfullly!");
		}
	}
	
	
	// ------
}
