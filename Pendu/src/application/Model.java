package application;

import java.io.IOException;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Model {
	private boolean Gagner;
	private GestionJeu Jeu;
	private char[] mot = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	private int ChoixDico;
	private String[] Dico = {"Dictionnaires/DicoFacile.txt","Dictionnaires/DicoMoyen.txt","Dictionnaires/DicoDifficile.txt"};
	
	public void initialize(){
		
	}
	
	public Model()
	{
		this.Gagner = true;
		this.ChoixDico = 0;
		
	}
	
	public Model(int newDico,boolean g)
	{
		setGagner(g);
		setChoixDico(newDico);
	}
	
	public void init(Label Erreur,Label Mot,int i) {
		try {
			System.out.println(i);
			Jeu = new GestionJeu(Dico[i]);
			setChoixDico(i);
			Jeu.InitialiserPartie();
			int n = Jeu.getNbMaxErreurs() +1;
			Erreur.setText(Jeu.getNbErreurs()+ " sur "+n);
			resetMot();
			CreerLabel(Mot);
			System.out.println(Mot);
		}catch(Exception e) {
        		
        }
	}
	
	public void reload(Label Erreur,Label Mot) {
		try {
			System.out.println(getChoixDico());
			Jeu = new GestionJeu(Dico[getChoixDico()]);
			Jeu.InitialiserPartie();
			int n = Jeu.getNbMaxErreurs() +1;
			Erreur.setText(Jeu.getNbErreurs()+ " sur "+n);
			resetMot();
			CreerLabel(Mot);
			System.out.println(Mot);
		}catch(Exception e) {
        		
        }
	}
	
	public boolean Verif(char reponse,Vector<Integer> pos,Label Erreur,Label Mot)
	{
		if (Jeu.ChercherLettreDansMot(reponse, pos) == 0)
	    {	
			  int n = Jeu.getNbMaxErreurs() +1;
	         Jeu.MAJNbErreurs();
	         Erreur.setText(Jeu.getNbErreurs()+ " sur "+ n);
	         if (Jeu.MaxErreursDepasse())
	         {
	         	setGagner(false);
	         	return true;
	         }
	         return false;
	    }
	    else
	    {
	   	
	   	int a = pos.size();
	   	int i = 0;
	   	while(a != 0)
	   	{
	   		this.mot[pos.get(i)]= reponse;
	   		i++;
	   		a--;
	   	}
		   	CreerLabel(Mot);
	 	   	if (Jeu.ToutTrouve()) 
	 	   		
	         {
	             setGagner(true);
	             return true;
	         }		
	 	   	return false;
	    }
	}
	
	private void CreerLabel(Label Mot)
	{
		int i = 0;
		char[] s = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		String P = new String (" ");
		int n = Jeu.getMotMystere().length();
			while(n != 0)
			{
				s[i] = '_';
				i++;
				n--;
			}
		n = Jeu.getMotMystere().length();
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
	
	public void runGame(Button aButton, Parent root, int newDico) throws IOException {
		
		/*AnchorPane root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
		Stage stage = (Stage) button.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);*/
	}
		
		
	public void runAide() throws IOException {
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
	
	public void runParametre() throws IOException {
    	/*String[] choix = {"Facile", "Moyen", "Difficile"};
    	ChoiceDialog<String> boiteChoix = new ChoiceDialog<>(choix[2], choix);
    	boiteChoix.setHeaderText("");
    	boiteChoix.setContentText("Difficulté:");
    	DialogPane dialogPane = boiteChoix.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("Aide.css").toExternalForm());
    	Optional<String> selection = boiteChoix.showAndWait();
    	if (selection.get() == "Facile")
    	{setChoixDico(0);}
    	if (selection.get() == "Moyen")
    	{setChoixDico(1);}
    	if (selection.get() == "Difficile")
    	{setChoixDico(2);}*/
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
    	{setChoixDico(0);}
    	if (C.getValue() == "Moyen")
    	{setChoixDico(1);}
    	if (C.getValue() == "Difficile")
    	{setChoixDico(2);}
	}
	
	public void backAccueil(Button button) throws IOException {
		AnchorPane root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
		Stage stage = (Stage) button.getScene().getWindow();
		Scene scene = new Scene(root); 
		stage.setScene(scene);
	}
	
	public void setGagner(boolean a){this.Gagner = a;}
	public boolean getGagner(){return this.Gagner;}
	public void setChoixDico(int i){this.ChoixDico = i;}
	public int getChoixDico(){return this.ChoixDico;}
	public String getmotMystere() {return Jeu.getMotMystere();}

	

}
