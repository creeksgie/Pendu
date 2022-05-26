package application;
	

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	private GestionJeu jeu;
	private GestionOption opt;
	private Parent root,root2;

	@Override
	public void init() throws IOException
	{
		opt = new GestionOption();
		jeu = new GestionJeu(opt.getDico(0));
		
		jeu.InitialiserPartie();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader load = new FXMLLoader(getClass().getResource("Accueil.fxml"));
			FXMLLoader load1 = new FXMLLoader(getClass().getResource("AccueilBouton.fxml"));
			root = load.load();
			root2 = load1.load();
			AnchorPane grille = new AnchorPane(root,root2);
			ControleurAccueil acc = load.getController();
			ControleurOption Opt = load1.getController();
			Scene scene = new Scene(grille);
			scene.getStylesheets().add(getClass().getResource(opt.getPolice("Accueil")).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Jeu du pendu");
			primaryStage.getIcons().add(new Image("/tête.png"));
			acc.ControleurAcc(primaryStage,jeu,opt);
			Opt.ControleurOpt(primaryStage,jeu,opt,"Accueil");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
