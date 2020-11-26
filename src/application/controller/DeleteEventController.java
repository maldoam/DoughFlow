package application.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

import application.Main;
import application.model.*;

public class DeleteEventController {
	
	public static User currentUser;
	
	@FXML
	private Label completionLabel;
	@FXML
	private Button DeleteButton;
	@FXML
	private Button ReturnHomeButton;
	@FXML
	private ChoiceBox<Event> EventChoiceBox;
	@FXML
	private TextArea EventTextArea;
	
	public void initializeUser(User user) {
		currentUser = user;
		
		EventChoiceBox = new ChoiceBox<Event>();
		EventChoiceBox.setItems(FXCollections.observableArrayList(currentUser.getEvents()));
		
		
	}
	
	public void returnHome(ActionEvent event) throws IOException {
		Stage deleteEventStage = (Stage)ReturnHomeButton.getScene().getWindow();
		deleteEventStage.close();
	    
		FXMLLoader mainLoader = new FXMLLoader();
		mainLoader.setLocation(Main.class.getResource("controller/MainView.fxml"));
		
		Parent mainRoot = mainLoader.load();
		Scene mainScene = new Scene(mainRoot);
		
		MainController mainController = mainLoader.getController();
		mainController.initializeUser(currentUser);
		
		Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		mainStage.setScene(mainScene);
		mainStage.show();
	}
	
}
