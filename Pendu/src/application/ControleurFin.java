package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ControleurFin {
	
	//Image qui affiche la victoire ou la defaite
	@FXML
	public ImageView Fin;
	
	//zone de texte qui affiche un text en fonction de la situtation du joueur
	@FXML
	public Label E;
	//zone de texte qui affiche le mot mystere
	@FXML
	public Label M;
	
	private GestionJeu jeu;
	private GestionOption opt;
	
	private Stage stagefin;
	private Scene scenefin;
	
	
	public void ControleurF(Stage s,GestionJeu Jeu,GestionOption Opt)
	{
		jeu = Jeu;
		opt = Opt;
		stagefin = s;
		scenefin = stagefin.getScene();
		scenefin.getStylesheets().clear();
		scenefin.getStylesheets().add(getClass().getResource(opt.getPolice("Aide")).toExternalForm());
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
}
