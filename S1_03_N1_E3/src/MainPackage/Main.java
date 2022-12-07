package MainPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import ExcepcionsPackage.ErrorFitxerPaissos;
import IOPackage.ReadFile;
import IOPackage.WriteFile;

public class Main {

	public static void main(String[] args) {
		// DEFINICIO VARIABLES
		byte puntuacio = 0;
		int numRandom = 0;
		String text = "", nomUsuari = "", resposta = "";
		ArrayList<String> paisos = new ArrayList<>();
		Random myRandom = new Random();
		ReadFile myReadFile;
		HashMap<String, String> paisCapital;

		// ACCIONS
		try {
			// 1) S'inicialitzen totes les variables
			myReadFile = new ReadFile();
			paisCapital = myReadFile.getPaisCapital();
			paisos.addAll(paisCapital.keySet());

			// 2) Es demana el nom d'usuari
			nomUsuari = ToolsGlbl.scannerStrg("Introdueix el nom d'usuari:", true);

			// 3) Es realitzen les 10 preguntes.
			for (int i = 0; i < 10; i++) {
				numRandom = myRandom.nextInt(paisos.size());
				text = String.format("\r\nPREGUNTA %s/10:\r\nCapital de '%s'?", i + 1, paisos.get(numRandom));
				resposta = ToolsGlbl.scannerStrg(text, true);

				if (paisCapital.get(paisos.get(i)).equals(resposta)) {
					puntuacio++;
					text = "Resposta correcte!!";
				} else {
					text = "Resposta incorrecte!!";
				}
				System.out.println(text + "\r\nLa teva puntuació és de " + puntuacio + " punts");

				// S'elimina xk no es pugui repetir.
				paisos.remove(i);
			}

			// 4) Es mostra el resultat
			System.out.println(
					String.format("\r\n\r\n%s, la teva puntuació final és de %s punts!", nomUsuari, puntuacio));

			// 5) Es guarda en el fitxer
			new WriteFile(nomUsuari, puntuacio);
		} catch (ErrorFitxerPaissos e) {
			System.out.println(e.getMessage());
		}

		// 6) Joc finalitzat
		System.out.println("\r\nJoc finalitzat!");

	}

}
