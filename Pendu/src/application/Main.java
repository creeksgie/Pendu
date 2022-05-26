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
	private Parent root;

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
			root = load.load();
			ControleurAccueil acc = load.getController();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(opt.getPolice("Accueil")).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Jeu du pendu");
			primaryStage.getIcons().add(new Image("/tête.png"));
			acc.ControleurAccueil(primaryStage,jeu,opt);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
