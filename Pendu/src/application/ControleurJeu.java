package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControleurJeu {
	
	@FXML
	public Button closeButton;
	@FXML
	public Button AButton;
	
	public ControleurJeu(){
		
	}
	
	@FXML
	public void Aventure(ActionEvent event) throws IOException {
		AnchorPane root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
		Stage stage = (Stage) AButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	
	}
	
	@FXML
	public void Quitter(ActionEvent event) throws IOException {
		AnchorPane root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
		Stage stage = (Stage) closeButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	

	@FXML
	public void Parametre(ActionEvent event) throws IOException {
		Dialog<Image> dialog = new Dialog<>();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BoiteAide.fxml"));
		AnchorPane grille = loader.load();
		dialog.getDialogPane().setContent(grille);
		ButtonType buttonTypeOkAnnuler = new ButtonType("Quitter", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOkAnnuler);
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("Aide.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");
		Optional<Image> selection = dialog.showAndWait();
	
	}
	
	@FXML
	public void Aide(ActionEvent event) throws IOException {
		Dialog<Image> dialog = new Dialog<>();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BoiteAide.fxml"));
		AnchorPane grille = loader.load();
		dialog.getDialogPane().setContent(grille);
		ButtonType buttonTypeOkAnnuler = new ButtonType("Quitter", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOkAnnuler);
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("Aide.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");
		Optional<Image> selection = dialog.showAndWait();
	}
}
