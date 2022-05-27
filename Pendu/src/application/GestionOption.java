package application;


public class GestionOption {
	
	//Dictionnaire utilisable
	private String[] Dico = {"Dictionnaires/DicoFacile.txt","Dictionnaires/DicoMoyen.txt","Dictionnaires/DicoDifficile.txt"};
	
	//Tableau de String qui contiendra les chemins pour acceder au différente étapes de construction du pendu
	private String[] Pendu = {"","","","","","","","","",""};
	
	//Chaine de caractère qui contient l'accés au fichier css pour la page d'accueil
	private String PoliceAccueil;
	//Chaine de caractère qui contient l'accés au fichier css pour la page du jeu
	private String PoliceJeu;
	//Chaine de caractère qui contient l'accés au fichier css pour la page d'aide
	private String PoliceAide;
	//Chaine de caractère qui contient l'accés au fichier css pour la page des parametres
	private String PoliceParametre;
	
	//entier qui récupère la valeur de la police 
	private int value;
	//chaine de caractère qui récupère le dictionnaire utiliser 
	public String actualDico;
	//entier qui récupère la valeur du pendu utiliser actuellement (0 pour le pirate Brun et 1 pour le pirate roux)
	public int actualPendu;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//Constructeur
	///////////////////////////////////////////////////////////////////////////////////////////////
	public GestionOption() {
		setPendu(1);
		setPolice(1);
		
    }
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//Les accesseurs/modifieurs de données membres
	///////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @param i : l'indice qui permet de retrouver le dico dans le tableau 
	 * @return le chemin d'accès au dictionnaire en question
	 */
	public String getDico(int i) {
		if(i == 0)
			actualDico = "Facile";
		if(i == 1)
			actualDico = "Moyen";
		if(i == 2)
			actualDico = "Difficile";
		return Dico[i];
	}

	/**
	 * @param i : l'indice qui permet de recuperer un état du pendu
	 * @return le chemin d'accès vers l'états du pendu à l'indice i 
	 */
	public String getPendu(int i) {
		return Pendu[i];
	}
	
	/**
	 * @param i : le choix du pendu utiliser avec pour 0 le pirate Brun et pour 1 le pirate Roux
	 */
	public void setPendu(int i) {
		String[] pirateRoux = {"","file:Images/chapeau.png","file:Images/têteroux.png","file:Images/busteroux.png","file:Images/brasdroitroux.png"
				,"file:Images/2brasRoux.png","file:Images/1jamberoux.png","file:Images/2jamberoux.png","file:Images/1piedroux.png","file:Images/pirate_roux.png"};
		String[] pirateBrun = {"","file:Images/chapeaubrun.png","file:Images/têtebrun.png","file:Images/busteBrun.png","file:Images/1brasBrun.png"
			,"file:Images/2brasBrun.png","file:Images/1jambeBrun.png","file:Images/2jambeBrun.png","file:Images/1piedBrun.png","file:Images/pirateBrun.png"};
		if(i == 1)
		{
			this.Pendu = pirateRoux;
		}
		else if(i == 0)
			this.Pendu = pirateBrun;
		actualPendu = i;
	}

	/**
	 * @param s : le choix de la scène entre 4 possibilités, Accueil Jeu Aide et Parametre 
	 * @return le chemin d'accès vers le fichier css qui permet de modifier la police de la scène en question
	 */
	public String getPolice(String s) {
		if (s == "Accueil")
		{
			return PoliceAccueil;
		}
		if(s == "Jeu")
		{
			return PoliceJeu;
		}
		if(s == "Aide")
		{
			return PoliceAide;
		}
		else if (s == "Parametre")
		{
			return PoliceParametre;
		}
		return s;
	}
	
	/**
	 * @param i : l'indice qui permet de choisir la taille de Police dans un tableau 
	 */
	public void setPolice(int i) {
		String[] ppara = {"/Parametre.css","/Parametre2.css","/Parametre3.css","/Parametre4.css"};
		String[] pacc = {"/Accueil.css","/Accueil2.css","/Accueil3.css","/Accueil4.css"};
		String[] pjeu = {"/jeu.css","/jeu2.css","/jeu3.css","/jeu4.css"};
		String[] paide = {"/Aide.css","/Aide2.css","/Aide3.css","/Aide4.css"};
		this.PoliceAccueil = pacc[i];
		this.PoliceParametre = ppara[i];
		this.PoliceAide = paide[i];
		this.PoliceJeu = pjeu[i];
		
		if(i == 0)
			setValue(10);
		if(i == 1)
			setValue(15);
		if(i == 2)
			setValue(20);
		if(i == 3)
			setValue(25);
	}

	/**
	 * @return la taille de la police utiliser 
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value : la taille de la police
	 */
	public void setValue(int value) {
		this.value = value;
	}

}
