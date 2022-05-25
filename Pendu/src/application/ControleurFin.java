package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ControleurFin {
	
	@FXML
	public ImageView Fin;
	
	@FXML
	public Label E;
	@FXML
	public Label M;

	@FXML
	private Button closeButton;
	@FXML
	private Button AButton;
	
	private Parent root;

	private GestionJeu jeu;
	
	public void ControleurJeu(GestionJeu Jeu)
	{
		jeu = Jeu;
		if(jeu.MaxErreursDepasse())
		{
			Image image = new Image("file:Images/loose.png");
			Fin.setImage(image);
			E.setText("Vous perdu, Le mot étais :");
		}
		else
		{
			Image image = new Image("file:Images/win.png");
			Fin.setImage(image);
			E.setText("Vous gagnez, Le mot étais :");
		}
		
		M.setText(jeu.getMotMystere());
	}


	@FXML
	public void Aventure(ActionEvent event) throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("jeu.fxml"));
		root = load.load();
		ControleurJeu controlleurJeu = load.getController();
		controlleurJeu.ControleurJeu(jeu);
		Stage stage = (Stage) AButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
	@FXML
	public void Quitter(ActionEvent event) throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("Accueil.fxml"));
		root = load.load();
		ControleurAccueil acc = load.getController();
		acc.ControleurAccueil(jeu);
		Stage stage = (Stage) AButton.getScene().getWindow();
		Scene scene = new Scene(root); 
		stage.setScene(scene);
	}
	
	@FXML
	public void Parametre(ActionEvent event) throws IOException 
	{
		Font Titre = new Font("",30);
		Font Base = new Font("",24);
		Dialog<String> dialog = new Dialog<>();
		Image image1 = new Image("file:Images/Parametre.jpeg");
		ImageView imageView = new ImageView(image1);	
		Image image2 = new Image("file:Images/1.png");
		ImageView imageView1 = new ImageView(image2);
		Label T = new Label("Option");
		T.setLayoutY(30);T.setLayoutX(150);
		T.setFont(Titre);
		imageView.setFitHeight(400);
		imageView.setFitWidth(700);
		String f = "Facile";
		String m = "Moyen";
		String d = "Difficile";
		ObservableList<String> D = FXCollections.observableArrayList(f,m,d);
		ComboBox<String> C = new ComboBox<String>(D);
		C.getSelectionModel().select(0);
		C.setLayoutY(150);C.setLayoutX(200);
		Label L = new Label("Difficulter:");
		L.setLayoutY(150);L.setLayoutX(50);
		L.setFont(Base);
		Slider S = new Slider();
		S.setBlockIncrement(5);S.setLayoutY(250);S.setLayoutX(150);
		S.setMajorTickUnit(5);S.setMax(25);S.setMin(10);
		S.setMinorTickCount(0);S.setShowTickLabels(true);S.setSnapToTicks(true);
		AnchorPane grille = new AnchorPane(imageView,imageView1,T,C,S,L);
		grille.setMinHeight(400);
		grille.setMinWidth(700);
		dialog.getDialogPane().setContent(grille);
		ButtonType buttonTypeOk = new ButtonType("Valider", ButtonData.OK_DONE);
		ButtonType buttonTypeOkAnnuler = new ButtonType("Quitter", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk,buttonTypeOkAnnuler);
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("Parametre.css").toExternalForm());
		dialog.showAndWait();
		if (C.getValue() == "Facile")
    	{jeu.ChangerDico("Dictionnaires/DicoFacile.txt");}
    	if (C.getValue() == "Moyen")
    	{jeu.ChangerDico("Dictionnaires/DicoMoyen.txt");}
    	if (C.getValue() == "Difficile")
    	{jeu.ChangerDico("Dictionnaires/DicoDifficile.txt");}	
	}
		
	@FXML
	public void Aide(ActionEvent event) throws IOException 
	{
		Dialog<Image> dialog = new Dialog<>();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BoiteAide.fxml"));
		AnchorPane grille = loader.load();
		dialog.getDialogPane().setContent(grille);
		ButtonType buttonTypeOkAnnuler = new ButtonType("Quitter", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOkAnnuler);
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("Aide.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");
		dialog.showAndWait();
	}
		
}
