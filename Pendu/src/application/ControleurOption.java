package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;
import javafx.util.Callback;


public class ControleurOption {
	@FXML
	private Label Titre;
	@FXML
	private Button closeButton;
	@FXML
	private Button AButton;
	
	private Parent root,root2;
	private GestionJeu jeu;
	private GestionOption opt;
	private Stage stageopt;
	private Scene sceneopt;
	public int savePendu ;
	public int validerParametre;
	public String sc;
	
	public void ControleurOpt(Stage s,GestionJeu Jeu,GestionOption Opt,String sc) throws IOException {
		jeu = Jeu;
		opt = Opt;
		stageopt = s;
		this.sc = sc;
		savePendu = opt.actualPendu;
		sceneopt = stageopt.getScene();
		sceneopt.getStylesheets().clear();
    	sceneopt.getStylesheets().add(getClass().getResource(opt.getPolice(sc)).toExternalForm());
	}
	
	@FXML
	public void Aventure(ActionEvent event) throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("jeu.fxml"));
		FXMLLoader load1 = new FXMLLoader(getClass().getResource("BarreD'option.fxml"));
		root = load.load();
		root2 = load1.load();
		AnchorPane grille = new AnchorPane(root,root2);
		ControleurJeu controlleurJeu = load.getController();
		ControleurOption controlleurOpt = load1.getController();
		Stage stage = (Stage) AButton.getScene().getWindow();
		controlleurJeu.ControleurJ(stage,jeu,opt);
		if(sc == "Aide" || sc == "Accueil")
		{
			sc ="Jeu";
		}
		controlleurOpt.ControleurOpt(stage,jeu,opt,sc);
		Scene scene = new Scene(grille);
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource(opt.getPolice("Jeu")).toExternalForm());
		stage.setScene(scene);
	}
	
	@FXML
	public void Quitter(ActionEvent event) throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("Accueil.fxml"));
		FXMLLoader load1 = new FXMLLoader(getClass().getResource("AccueilBouton.fxml"));
		root = load.load();
		root2 = load1.load();
		AnchorPane grille = new AnchorPane(root,root2);
		ControleurAccueil acc = load.getController();
		ControleurOption Opt = load1.getController();
		Stage stage = (Stage) AButton.getScene().getWindow();
		Scene scene = new Scene(grille); 
		acc.ControleurAcc(stage,jeu,opt);
		Opt.ControleurOpt(stage,jeu,opt,"Accueil");
		scene.getStylesheets().clear();
    	scene.getStylesheets().add(getClass().getResource(opt.getPolice("Accueil")).toExternalForm());
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
		Label A = new Label("A");
		Label a = new Label("A");
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
		
		
		T.setLayoutY(30);T.setLayoutX(160);
		T.setStyle("-fx-font-size : 30px;");
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
		Label L = new Label("Difficulté:");
		L.setAlignment(Pos.CENTER_RIGHT);
		L.setLayoutY(155);L.setLayoutX(50);
		L.setStyle("-fx-min-width : 140;");
		Slider S = new Slider();
		a.setStyle("-fx-font-size : 10px;");a.setLayoutY(252);a.setLayoutX(140);
		A.setStyle("-fx-font-size : 24px;");A.setLayoutY(240);A.setLayoutX(290);
		S.setBlockIncrement(5);S.setLayoutY(250);S.setLayoutX(150);
		S.setMajorTickUnit(5);S.setMax(25);S.setMin(10);
		S.setMinorTickCount(0);S.setShowTickLabels(false);S.setSnapToTicks(true);
		S.setValue(opt.getValue());
		AnchorPane grille = new AnchorPane(imageView,imageView1,T,C,S,L,Brun,Roux,a,A);
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
		dialog.setTitle("Jeu du pendu : Option");
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("/tête.png"));
		dialog.showAndWait();
		if(validerParametre  == 0)
			opt.setPendu(savePendu);
		else if (validerParametre == 1)
		{
			savePendu = opt.actualPendu;
		}
    	ControleurOpt(stageopt,jeu,opt,sc);
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
		dialog.setTitle("Jeu du pendu : Aide");
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("/tête.png"));
		dialog.showAndWait();
	}
	
	@FXML
	public void Fermer(ActionEvent event) {
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	}


}
