package Controller;

import model.CardSet;
import java.util.List;
import java.util.ArrayList;

public class MainController {
	List<CardSet> listOfSet;
	public MainController() {
		listOfSet = new ArrayList<CardSet>();
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
	
	// ------
}
