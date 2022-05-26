package application;


public class GestionOption {
	
	private String[] Dico = {"Dictionnaires/DicoFacile.txt","Dictionnaires/DicoMoyen.txt","Dictionnaires/DicoDifficile.txt"};
	
	private String[] Pendu = {"","file:Images/chapeau.png","file:Images/têteroux.png","file:Images/busteroux.png","file:Images/brasdroitroux.png"
			,"file:Images/2brasRoux.png","file:Images/1jamberoux.png","file:Images/2jamberoux.png","file:Images/1piedroux.png","file:Images/pirate_roux.png"};
	
	private String PoliceAccueil;
	private String PoliceJeu;
	private String PoliceAide;
	private String PoliceParametre;
	private int value;
	public String actualDico;
	public int actualPendu = 1;
	
	public GestionOption() {
		setPendu(1);
		setPolice(1);
		
    }

	public String getDico(int i) {
		if(i == 0)
			actualDico = "Facile";
		if(i == 1)
			actualDico = "Moyen";
		if(i == 2)
			actualDico = "Difficile";
		return Dico[i];
	}

	public String getPendu(int i) {
		return Pendu[i];
	}

	public void setPendu(int i) {
		String[] pirateRoux = {"","file:Images/chapeau.png","file:Images/têteroux.png","file:Images/busteroux.png","file:Images/brasdroitroux.png"
				,"file:Images/2brasRoux.png","file:Images/1jamberoux.png","file:Images/2jamberoux.png","file:Images/1piedroux.png","file:Images/pirate_roux.png"};
		String[] pirateBrun = {"","file:Images/chapeaubrun.png","file:Images/têtebrun.png","file:Images/busteBrun.png","file:Images/1brasBrun.png"
			,"file:Images/2brasBrun.png","file:Images/1jambeBrun.png","file:Images/2jambeBrun.png","file:Images/1piedBrun.png","file:Images/pirateBrun.png"};
		if(i == 1)
		{
			this.Pendu = pirateRoux;
		}
		else
			this.Pendu = pirateBrun;
		actualPendu = i;
	}

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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
