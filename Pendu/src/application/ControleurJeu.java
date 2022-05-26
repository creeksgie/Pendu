package application;

import java.io.IOException;
import java.util.Vector;

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


public class ControleurJeu {
	
	@FXML
	private Button closeButton;
	@FXML
	private Button AButton;
	@FXML
	private Button A;
	@FXML
	private Button B;
	@FXML
	private Button C;
	@FXML
	private Button D;
	@FXML
	private Button E;
	@FXML
	private Button F;
	@FXML
	private Button G;
	@FXML
	private Button H;
	@FXML
	private Button I;
	@FXML
	private Button J;
	@FXML
	private Button K;
	@FXML
	private Button L;
	@FXML
	private Button M;
	@FXML
	private Button N;
	@FXML
	private Button O;
	@FXML
	private Button P;
	@FXML
	private Button Q;
	@FXML
	private Button R;
	@FXML
	private Button S;
	@FXML
	private Button T;
	@FXML
	private Button U;
	@FXML
	private Button V;
	@FXML
	private Button W;
	@FXML
	private Button X;
	@FXML
	private Button Y;
	@FXML
	private Button Z;
	
	@FXML
	private Label motMystere;
	@FXML
	public Label Erreur;
	@FXML
	private ImageView Pendu;
	
	private Parent root;
	private GestionJeu jeu;
	private GestionOption opt;
	private char[] mot = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	
	private Image pendu;
	private boolean Gagner = true;
	private Stage stagejeu;
	private Scene scenejeu;
	public int savePendu ;
	public int validerParametre;
	
	
	public void ControleurJeu(Stage s,GestionJeu Jeu,GestionOption Opt)
	{
		jeu = Jeu;
		opt = Opt;
		savePendu = opt.actualPendu;
		stagejeu = s;
		scenejeu = stagejeu.getScene();
		jeu.InitialiserPartie();
		CreerLabel(motMystere);
		int n = jeu.getNbMaxErreurs() +1;
		Erreur.setText(jeu.getNbErreurs()+ " sur "+ n);
		CreerPendu(jeu.getNbErreurs());
	}
	
	public void SavePartie(Stage s,GestionJeu Jeu,GestionOption Opt)
	{
		jeu = Jeu;
		opt = Opt;
		stagejeu = s;
		scenejeu = stagejeu.getScene();
		scenejeu.getStylesheets().clear();
    	scenejeu.getStylesheets().add(getClass().getResource(opt.getPolice("Jeu")).toExternalForm());
	}
	
	public void CreerPendu(int i)
	{
		if(i>0 && i<10)
		{
			pendu = new Image(opt.getPendu(i));
			Pendu.setOpacity(1);
			Pendu.setImage(pendu);
		}
		else
			Pendu.setOpacity(0);
	}
	

	@FXML
	public void Aventure(ActionEvent event) throws IOException {
		setGagner(true);
		jeu.InitialiserPartie();
		int n = jeu.getNbMaxErreurs() +1;
		Erreur.setText(jeu.getNbErreurs()+ " sur "+ n);
		CreerPendu(jeu.getNbErreurs());
		resetMot();
		CreerLabel(motMystere);
		A.setDisable(false);
		B.setDisable(false);
		C.setDisable(false);
		D.setDisable(false);
		E.setDisable(false);
		F.setDisable(false);
		G.setDisable(false);
		H.setDisable(false);
		I.setDisable(false);
		J.setDisable(false);
		K.setDisable(false);
		L.setDisable(false);
		M.setDisable(false);
		N.setDisable(false);
		O.setDisable(false);
		P.setDisable(false);
		Q.setDisable(false);
		R.setDisable(false);
		S.setDisable(false);
		T.setDisable(false);
		U.setDisable(false);
		V.setDisable(false);
		W.setDisable(false);
		X.setDisable(false);
		Y.setDisable(false);
		Z.setDisable(false);
	}
	
		
	
	@FXML
	public void Quitter(ActionEvent event) throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("Accueil.fxml"));
		root = load.load();
		ControleurAccueil acc = load.getController();
		Stage stage = (Stage) AButton.getScene().getWindow();
		Scene scene = new Scene(root); 
		acc.ControleurAccueil(stage,jeu,opt);
		scene.getStylesheets().clear();
    	scene.getStylesheets().add(getClass().getResource(opt.getPolice("Accueil")).toExternalForm());
		stage.setScene(scene);
	}
	
	@FXML
	public void Parametre(ActionEvent event) throws IOException {
		
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
		CreerPendu(jeu.getNbErreurs());
    	SavePartie(stagejeu,jeu,opt);
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
		dialog.showAndWait();
	}
	
	
	@FXML
	public void Lettre(ActionEvent event) throws IOException{
		Vector<Integer> pos;
		pos = new Vector<Integer>();
		boolean finJeu = false;
		char reponse;
		Button lettre = (Button) event.getSource();
		lettre.setDisable(true);
		reponse = lettre.getId().charAt(0);
		finJeu = jeu.Verif(reponse,pos);
		int n = jeu.getNbMaxErreurs() +1;
		Erreur.setText(jeu.getNbErreurs()+ " sur "+ n);
		CreerPendu(jeu.getNbErreurs());
		int a = pos.size();
	   	int i = 0;
	   	while(a != 0)
	   	{
	   		this.mot[pos.get(i)]= reponse;
	   		i++;
	   		a--;
	   	}
		CreerLabel(motMystere);
		if(finJeu) {
			i= jeu.getMotMystere().length();
			while(i > 0)
			{
				i--;
				if(this.mot[i] == ' ')
				{
					setGagner(false);
				}
				
			}
		}
		
		if(!getGagner())//si le boolean Gagner est à faux on perd
		{
	        FXMLLoader load = new FXMLLoader(getClass().getResource("Fin.fxml"));
			root = load.load();
			ControleurFin fin = load.getController();
			Stage stage = (Stage) AButton.getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(opt.getPolice(opt.getPolice("Aide"))).toExternalForm());
			fin.ControleurFin(stage,jeu,opt);
			stage.setScene(scene);
		}
		else if(finJeu)//sinon si le jeu est fini on gagne
		{
		    FXMLLoader load = new FXMLLoader(getClass().getResource("Fin.fxml"));
		    root = load.load();
			ControleurFin fin = load.getController();
			Stage stage = (Stage) AButton.getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(opt.getPolice(opt.getPolice("Aide"))).toExternalForm());
			fin.ControleurFin(stage,jeu,opt);
			stage.setScene(scene);
		}
	}
	
	private void CreerLabel(Label Mot)
	{
		int i = 0;
		char[] s = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		String P = new String (" ");
		int n = jeu.getMotMystere().length();
			while(n != 0)
			{
				s[i] = '_';
				i++;
				n--;
			}
		n = jeu.getMotMystere().length();
		i= 0;
		while(n != 0)
		{
			if(this.mot[i]!= ' ')
			{
				s[i]= this.mot[i];
			}
			P = P + new String (s[i]+" ");
			i++;
			n--;
		}
		Mot.setText(P);
	}
	
	public void resetMot() {
		for(int i = 0;i<12;i++)
		{
			this.mot[i] = ' ';
		}
	}
	

	public boolean getGagner() {
		return Gagner;
	}

	public void setGagner(boolean gagner) {
		Gagner = gagner;
	}
	
}
