package application;
import java.io.IOException;
import java.util.List;

import Controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.CardSet;

public class ListOfSetController extends SceneController{
	private List<CardSet> set;
	private MainController controller;
	@FXML private VBox listContainer;
	@FXML private Label emptyLabel;
	@FXML private Text emptyText;
	@FXML private ScrollPane SetPane;
	@FXML private Button switchToCreate;
	@FXML private ImageView emptyIcon;
	@FXML private Button homeButton;
	private CardSet chosenSet;
 
	
	public void switchToCreate(ActionEvent e) throws IOException{
		switchToScene(e, "CreateMenu.fxml",(CreateController c)-> c.setMainController(controller));
	}
	
	public void switchToLoaded(ActionEvent e) throws IOException{
		switchToScene(e, "Cards.fxml",(CardController c)->c.setCardSets(chosenSet,controller));
	}

	public void switchToHomeScreen(ActionEvent e) throws IOException{
		switchToScene(e, "/application/HomeScreen.fxml",(HomeScreenController c)-> c.setController(controller));
	}
	
	@FXML public void initialize() {
		Image img = new Image(getClass().getResourceAsStream("/images/home.png"));
		ImageView icon = new ImageView(img);
		icon.setFitWidth(24);
		icon.setFitHeight(24);
		icon.setPreserveRatio(true);
		homeButton.setGraphic(icon);
		img = new Image(getClass().getResourceAsStream("/images/empty.png"));
		emptyIcon.setImage(img);
		emptyIcon.setFitWidth(175);
		emptyIcon.setFitHeight(175);
		emptyIcon.setPreserveRatio(true);
		emptyLabel.setVisible(true);
		emptyText.setVisible(true);
		SetPane.setVisible(false);
	}
	
	public void setCardSetController(MainController controller) {
		this.controller = controller;
		this.set = controller.getListOfSet();
		if(!set.isEmpty()) {
			SetPane.setVisible(true);
			emptyIcon.setVisible(false);
			emptyLabel.setVisible(false);
			emptyText.setVisible(false);
			switchToCreate.setVisible(false);

			for (CardSet cardSet : set) {
				HBox row = new HBox(12);
				Button btn = new Button(cardSet.getName());
				btn.getStyleClass().add("menu-item");
				btn.setPrefWidth(280);
				btn.setMinWidth(280);

				btn.setMaxWidth(Double.MAX_VALUE);
				btn.setOnAction(e ->{
					chosenSet = cardSet;
					try {
						switchToLoaded(e);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				});
				Button deleteBtn = new Button();
				deleteBtn.getStyleClass().add("btn-delete");
				deleteBtn.setMinSize(30, 30);
				deleteBtn.setMaxSize(30, 30);
				Image img = new Image(getClass().getResourceAsStream("/images/trash.png"));
				ImageView icon = new ImageView(img);
				icon.setFitWidth(24);
				icon.setFitHeight(24);
				icon.setPreserveRatio(true);
				deleteBtn.setGraphic(icon);
				deleteBtn.setGraphic(icon);
				deleteBtn.setOnAction(ev -> {
					listContainer.getChildren().remove(row);
					if(listContainer.getChildren().isEmpty()) {
						listContainer.setVisible(false);
						SetPane.setVisible(false);
						emptyIcon.setVisible(!false);
						emptyLabel.setVisible(!false);
						emptyText.setVisible(!false);
						switchToCreate.setVisible(!false);
					}
				});
				row.getChildren().addAll(btn,deleteBtn);
				listContainer.getChildren().add(row);
				listContainer.setSpacing(10);
			}
		}
	}
	public CardSet getChosenSet() {
		return chosenSet;
	}
}
