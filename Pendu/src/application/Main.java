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
		jeu = new GestionJeu("Dictionnaires/DicoFacile.txt");
		jeu.InitialiserPartie();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader load = new FXMLLoader(getClass().getResource("Accueil.fxml"));
			root = load.load();
			ControleurAccueil acc = load.getController();
			acc.ControleurAccueil(jeu);
			System.out.println(jeu.getDico());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Jeu du pendu");
			primaryStage.getIcons().add(new Image("/tête.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
