package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;


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
	private GestionOption opt;
	
	private Stage stagefin;
	private Scene scenefin;
	public int savePendu ;
	public int validerParametre;
	
	
	public void ControleurFin(Stage s,GestionJeu Jeu,GestionOption Opt)
	{
		jeu = Jeu;
		opt = Opt;
		stagefin = s;
		savePendu = opt.actualPendu;
		scenefin = stagefin.getScene();
		scenefin.getStylesheets().clear();
		scenefin.getStylesheets().add(getClass().getResource(opt.getPolice(opt.getPolice("Aide"))).toExternalForm());
		if(jeu.MaxErreursDepasse())
		{
			Image image = new Image("file:Images/loose.png");
			Fin.setImage(image);
			E.setText("Dommage vous avez perdu, Le mot était :");
		}
		else
		{
			Image image = new Image("file:Images/win.png");
			Fin.setImage(image);
			E.setText("Félicitations vous avez gagné !! Le mot était :");
		}
		
		M.setText(jeu.getMotMystere());
	}


	@FXML
	public void Aventure(ActionEvent event) throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("jeu.fxml"));
		root = load.load();
		ControleurJeu controlleurJeu = load.getController();
		Stage stage = (Stage) AButton.getScene().getWindow();
		controlleurJeu.ControleurJeu(stage,jeu,opt);
		Scene scene = new Scene(root);
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource(opt.getPolice("Jeu")).toExternalForm());
		stage.setScene(scene);
	}
	
	@FXML
	public void Quitter(ActionEvent event) throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("Accueil.fxml"));
		root = load.load();
		ControleurAccueil acc = load.getController();
		
		Stage stage = (Stage) AButton.getScene().getWindow();
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource(opt.getPolice("Accueil")).toExternalForm());
		acc.ControleurAccueil(stage,jeu,opt);
		stage.setScene(scene);
	}
	
	@FXML
	public void Parametre(ActionEvent event) throws IOException 
	{			
		Dialog<String> dialog = new Dialog<>();
		validerParametre = 0;
		Image image1 = new Image("file:Images/Parametre.jpeg");
		ImageView imageView = new ImageView(image1);	
		Image image2 = new Image("file:Images/1.png");
		ImageView imageView1 = new ImageView(image2);
		Label T = new Label("Option");
		Image penduB = new Image("file:Images/pirateBrun.png");
		ImageView B = new ImageView(penduB);
		B.setFitHeight(150);
		B.setFitWidth(75);
		Button Brun = new Button();
		Brun.setGraphic(B);
		Brun.addEventHandler(MouseEvent.MOUSE_PRESSED,new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if(event.isPrimaryButtonDown()) {
					opt.setPendu(0);
				}
			}
		});
		Brun.setLayoutY(150);Brun.setLayoutX(400);
		Image penduR = new Image("file:Images/pirate_roux.png");
		ImageView R = new ImageView(penduR);
		R.setFitHeight(150);
		R.setFitWidth(75);
		Button Roux = new Button();
		Roux.setGraphic(R);
		Roux.addEventHandler(MouseEvent.MOUSE_PRESSED,new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if(event.isPrimaryButtonDown()) {
					opt.setPendu(1);
				}
			}
		});
		Roux.setLayoutY(150);Roux.setLayoutX(550);
		
		
		T.setLayoutY(30);T.setLayoutX(150);
		imageView.setFitHeight(400);
		imageView.setFitWidth(700);
		String f = "Facile";
		String m = "Moyen";
		String d = "Difficile";
		ObservableList<String> D = FXCollections.observableArrayList(f,m,d);
		ComboBox<String> C = new ComboBox<String>(D);
		C.getSelectionModel().select(0);
		C.setValue(opt.actualDico);
		C.setLayoutY(150);C.setLayoutX(200);
		Label L = new Label("Difficulter:");
		L.setLayoutY(150);L.setLayoutX(50);
		Slider S = new Slider();
		S.setBlockIncrement(5);S.setLayoutY(250);S.setLayoutX(150);
		S.setMajorTickUnit(5);S.setMax(25);S.setMin(10);
		S.setMinorTickCount(0);S.setShowTickLabels(true);S.setSnapToTicks(true);
		S.setValue(opt.getValue());
		AnchorPane grille = new AnchorPane(imageView,imageView1,T,C,S,L,Brun,Roux);
		grille.setMinHeight(400);
		grille.setMinWidth(700);
		dialog.getDialogPane().setContent(grille);
		dialog.setHeight(400);
		ButtonType buttonTypeOk = new ButtonType("Valider", ButtonData.OK_DONE);
		ButtonType buttonTypeOkAnnuler = new ButtonType("Quitter", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk,buttonTypeOkAnnuler);
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().clear();
		dialogPane.getStylesheets().add(getClass().getResource(opt.getPolice("Parametre")).toExternalForm());
		dialog.setResultConverter(new Callback<ButtonType, String>() {
		    @Override
		    public String call(ButtonType b) {
		 
		        if (b == buttonTypeOk) {
		 
		        	if (C.getValue() == "Facile")
		        	{
		        		try {
		        			jeu.ChangerDico(opt.getDico(0));
		        		} catch (IOException e) {
		        			e.printStackTrace();
		        		}
		        	}
		        	if (C.getValue() == "Moyen")
		        	{
		        		try {
		        			jeu.ChangerDico(opt.getDico(1));
		        		} catch (IOException e) {
		        			e.printStackTrace();
		        		}
		        	}
		        	if (C.getValue() == "Difficile")
		        	{
		        		try {
		        			jeu.ChangerDico(opt.getDico(2));
		        		} catch (IOException e) {
		        			e.printStackTrace();
		        		}
		        	}
		        	
		        	if (S.getValue() == 10.0)
		        	{opt.setPolice(0);}
		        	if (S.getValue() == 15.0)
		        	{opt.setPolice(1);}
		        	if (S.getValue() == 20.0)
		        	{opt.setPolice(2);}
		        	if (S.getValue() == 25.0)
		        	{opt.setPolice(3);}
		        	
		        	validerParametre = 1;
		        }
		        	
				return null;
		    }
		});
		dialog.showAndWait();
		if(validerParametre  == 0)
			opt.setPendu(savePendu);
		else if (validerParametre == 1)
		{
			savePendu = opt.actualPendu;
		}
		
    	ControleurFin(stagefin,jeu,opt);
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
		dialogPane.getStylesheets().add(getClass().getResource(opt.getPolice("Aide")).toExternalForm());
		dialogPane.getStyleClass().add("myDialog");
		dialog.showAndWait();
	}
		
}
