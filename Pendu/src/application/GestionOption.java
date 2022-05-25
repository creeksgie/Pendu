package application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;


public class GestionOption {
	
	private int ChoixDico;
	
	public GestionOption(int i) {
    	setChoixDico(i);
    }

	public int getChoixDico() {
		return ChoixDico;
	}

	public void setChoixDico(int choixDico) {
		ChoixDico = choixDico;
	}
	
	
}
