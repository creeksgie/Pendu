package application;

import java.io.IOException;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
	
	private Parent root,root2;
	private GestionJeu jeu;
	private GestionOption opt;
	private char[] mot = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
	
	private Image pendu;
	private boolean Gagner = true;
	public int savePendu ;
	public int validerParametre;
	
	
	public void ControleurJ(Stage s,GestionJeu Jeu,GestionOption Opt)
	{
		jeu = Jeu;
		opt = Opt;
		savePendu = opt.actualPendu;
		jeu.InitialiserPartie();
		CreerLabel(motMystere);
		int n = jeu.getNbMaxErreurs() +1;
		Erreur.setText(jeu.getNbErreurs()+ " sur "+ n);
		CreerPendu(jeu.getNbErreurs());
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
		    FXMLLoader load1 = new FXMLLoader(getClass().getResource("BarreD'option.fxml"));
			root = load.load();
			root2 = load1.load();
			AnchorPane grille = new AnchorPane(root,root2);
			ControleurOption controlleurOpt = load1.getController();
			ControleurFin fin = load.getController();
			Stage stage = (Stage) A.getScene().getWindow();
			Scene scene = new Scene(grille);
			scene.getStylesheets().add(getClass().getResource(opt.getPolice("Aide")).toExternalForm());
			fin.ControleurF(stage,jeu,opt);
			controlleurOpt.ControleurOpt(stage,jeu,opt,"Aide");
			stage.setScene(scene);
		}
		else if(finJeu)//sinon si le jeu est fini on gagne
		{
			FXMLLoader load = new FXMLLoader(getClass().getResource("Fin.fxml"));
		    FXMLLoader load1 = new FXMLLoader(getClass().getResource("BarreD'option.fxml"));
			root = load.load();
			root2 = load1.load();
			AnchorPane grille = new AnchorPane(root,root2);
			ControleurOption controlleurOpt = load1.getController();
			ControleurFin fin = load.getController();
			Stage stage = (Stage) A.getScene().getWindow();
			Scene scene = new Scene(grille);
			scene.getStylesheets().add(getClass().getResource(opt.getPolice("Aide")).toExternalForm());
			fin.ControleurF(stage,jeu,opt);
			controlleurOpt.ControleurOpt(stage,jeu,opt,"Aide");
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

	public boolean getGagner() {
		return Gagner;
	}

	public void setGagner(boolean gagner) {
		Gagner = gagner;
	}
	
}
