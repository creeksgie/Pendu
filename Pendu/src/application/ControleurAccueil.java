package application;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class ControleurAccueil {
	
	private GestionOption opt;
	private Stage stageacc;
	private Scene sceneacc;
	
	public void ControleurAcc(Stage s,GestionJeu Jeu,GestionOption Opt) {
		opt = Opt;
		stageacc = s;
		sceneacc = stageacc.getScene();
		sceneacc.getStylesheets().clear();
    	sceneacc.getStylesheets().add(getClass().getResource(opt.getPolice("Accueil")).toExternalForm());
	}
}
