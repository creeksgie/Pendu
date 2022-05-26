package application;



import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ControleurAccueil {
	@FXML
	private Label Titre;
	@FXML
	private Button closeButton;
	@FXML
	private Button AButton;
	
	private GestionOption opt;
	private Stage stageacc;
	private Scene sceneacc;
	public int savePendu ;
	public int validerParametre;
	
	public void ControleurAcc(Stage s,GestionJeu Jeu,GestionOption Opt) {
		opt = Opt;
		stageacc = s;
		savePendu = opt.actualPendu;
		sceneacc = stageacc.getScene();
		sceneacc.getStylesheets().clear();
    	sceneacc.getStylesheets().add(getClass().getResource(opt.getPolice("Accueil")).toExternalForm());
	}
}
