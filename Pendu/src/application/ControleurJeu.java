package application;

import java.io.IOException;
import java.util.Vector;

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
	private char[] mot = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	private String[] pirateRoux = {"","file:Images/chapeau.png","file:Images/têteroux.png","file:Images/busteroux.png","file:Images/brasdroitroux.png"
				,"file:Images/2brasRoux.png","file:Images/1jamberoux.png","file:Images/2jamberoux.png","file:Images/1piedroux.png","file:Images/pirate_roux.png"};
	private Image pendu;
	private boolean Gagner = true;
	
	
	public void ControleurJeu(GestionJeu Jeu)
	{
		jeu = Jeu;
		System.out.println(jeu.getDico());
		
		jeu.InitialiserPartie();
		System.out.println(jeu.getMotMystere());
		CreerLabel(motMystere);
		int n = jeu.getNbMaxErreurs() +1;
		Erreur.setText(jeu.getNbErreurs()+ " sur "+ n);
		CreerPendu(jeu.getNbErreurs());
	}
	
	public void CreerPendu(int i)
	{
		if(i>0 && i<10)
		{
			pendu = new Image(pirateRoux[i]);
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
		System.out.println(jeu.getMotMystere());//pour reset la partie
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
		acc.ControleurAccueil(jeu);
		Stage stage = (Stage) AButton.getScene().getWindow();
		Scene scene = new Scene(root); 
		stage.setScene(scene);
	}
	
	@FXML
	public void Parametre(ActionEvent event) throws IOException {
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
	        System.out.println("Vous perdez. Il fallait trouver "+jeu.getMotMystere()+" !!!");
	        FXMLLoader load = new FXMLLoader(getClass().getResource("Fin.fxml"));
			root = load.load();
			ControleurFin fin = load.getController();
			fin.ControleurJeu(jeu);
			Stage stage = (Stage) AButton.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
		}
		else if(finJeu)//sinon si le jeu est fini on gagne
		{
			System.out.println("Vous gagnez .vous avez trouver "+jeu.getMotMystere()+" !!!");
		    FXMLLoader load = new FXMLLoader(getClass().getResource("Fin.fxml"));
		    root = load.load();
			ControleurFin fin = load.getController();
			fin.ControleurJeu(jeu);
			Stage stage = (Stage) AButton.getScene().getWindow();
			Scene scene = new Scene(root);
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
		System.out.println(this.mot);
	}
	

	public boolean getGagner() {
		return Gagner;
	}

	public void setGagner(boolean gagner) {
		Gagner = gagner;
	}
	
}
