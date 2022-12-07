package MainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Eines comunes a tots els programes
 * 
 * @author josep
 */
public class ToolsGlbl {
	static Scanner myScanner;


	/**
	 * Mètode per demanar a l'usuari que introdueixi un int
	 * 
	 * @return Torna el int introduït per l'usuari, si no està torna -1
	 */
	public static int scannerInt(String missatge) {
		return scannerInt(missatge, 0, 0, "");
	}
	
	/**
	 * Mètode per demanar a l'usuari que introdueixi un int
	 * 
	 * @param missatge Missatge capçalera x introduïr el valor.
	 * @param min Valor mínim del int que s'ha d'introduïr, si min i max = 0, no compte
	 * @param max Valor màxim del int que s'ha d'introduïr, si min i max = 0, no compte
	 * @return Torna el int introduït per l'usuari, si no està torna -1
	 */
	public static int scannerInt(String missatge, int min, int max) {
		return scannerInt(missatge, min, max, "");
	}

	/**
	 * Mètode per demanar a l'usuari que introdueixi un int, amb un límits min i
	 * max, i missatge d'error
	 * @param missatge      missatge que es mostrarà a l'usuari
	 * @param min           Valor mínim del int que s'ha d'introduir, si min i max = 0, no compte 
	 * @param max           Valor màxim del int que s'ha d'introduir, si min i max = 0, no compte
	 * @param missatgeError En cas d'error de format o fora de límits, si és "" no es mostra res
	 * @return Torna el int introduït per l'usuari, si no està torna -1
	 */
	public static int scannerInt(String missatge, int min, int max, String missatgeError) {
		// DEFINICIÓ VARIABLES
		boolean correcte = false;
		int myInt = -1;

		// ACCIONS
		System.out.println(missatge);
		while (!correcte) {
			try {
				myScanner = new Scanner(System.in);
				myInt = myScanner.nextInt();

				// Si arriba aquí, el format és correcte
				if (min == 0 & max == 0) {
					correcte = true;
				} else if (myInt > min & myInt < max) {
					correcte = true;
				}else {
					System.out.println(missatgeError);
				}
			} catch (InputMismatchException ex) {
				if (missatgeError.length() != 0) {
					System.out.println(missatgeError);
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		// SORTIDA
		return myInt;

	}

	/**
	 * Mètode per demanar a l'usuari que introdueixi un string
	 * 
	 * @param missatge Què s'ha de mostrar.
	 * @param linia    false=sols 1 paraula; true=fins intro
	 * @return El string que ha afegit l'usuari.
	 */
	public static String scannerStrg(String missatge, boolean linia) {
		// DEFINICIÓ VARIABLES
		boolean correcte = false;
		String myString = "";

		System.out.println(missatge);
		while (!correcte) {
			try {
				myScanner = new Scanner(System.in);
				if (linia) {
					myString = myScanner.nextLine();
				} else {
					myString = myScanner.next();
				}

				correcte = true;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		return myString;

	}

	public static void polsarTeclaPerContinuar() {
		// DEFINICIONS
		String text = "";

		// ACCIONS
		do {
			text = scannerStrg("Per continuar, polsar qualsevol tecla.", false);
		} while (text.length() == 0);

	}

}
