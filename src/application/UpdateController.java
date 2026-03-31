package application;


import java.io.IOException;

import Controller.MainController;
import Controller.flashCardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Card;
import model.CardSet;

public class UpdateController extends SceneController{
	@FXML TextField termField;
	@FXML TextArea defField;
	MainController mainCtrl;
	flashCardController fcCtrl;
	private Card card;
	int index;
	@FXML private Label errorMsg;

	
	private void setError(Control c, boolean isError) {
		if(isError) c.getStyleClass().add("error");
		else c.getStyleClass().remove("error");
	}
	
	public void cancelUpdate(ActionEvent e) throws IOException{
		switchToScene(e, "/application/Cards.fxml",(CardController c)->c.setCardSets(fcCtrl.getListOfCard(),mainCtrl,fcCtrl,index));
	}
	
	@FXML void onSave(ActionEvent e) throws IOException {
		boolean ok =  true;
		
		boolean badTerm = utils.Validation.isValid(termField.getText());
		boolean badDef = utils.Validation.isValid(defField.getText());
		setError(termField,!badTerm);
		setError(defField,!badDef);
		if(!badTerm|| !badDef) ok = false;
		else ok =  true;

		if(!ok) {
			errorMsg.setVisible(true);
			if(errorMsg != null) errorMsg.setText("* Please fill all the fields,each fields should be 1500 characters");
		}
		else {
			card.setHint(termField.getText());
			card.setDescription(defField.getText());
			fcCtrl.updateCard(card, card.getId());
			mainCtrl.updateSet(fcCtrl.getListOfCard().getId(), fcCtrl.getListOfCard());
			switchToScene(e, "Cards.fxml", (CardController c)->c.setCardSets(fcCtrl.getListOfCard(), mainCtrl,fcCtrl, index));
		}
	}

	
	public void setCardSets(MainController controller,flashCardController fcCtrl,int index,CardSet chosenSet) {
		this.mainCtrl = controller;
		this.index = index;
		this.fcCtrl = fcCtrl;
		this.fcCtrl.setListOfCard(chosenSet);
		card = fcCtrl.getListOfCard().getListOfCard().get(index);
		this.termField.setText(card.getHint());
		this.defField.setText(card.getDescription());
	}
}
