package MainPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;

import ClassPackage.Month;

public class Main {

	public static void main(String[] args) {
		// DEFINICIO VARIABLES		
		ArrayList<Month> mesosAny = new ArrayList<Month>();
		HashSet<Month> mesosAnyHashSet;

		// ACCIONS
		// Omplim l'ArrayList
		Collections.addAll(mesosAny, new Month("Gener"), new Month("Febrer"), new Month("Març"), new Month("Abril"),
				new Month("Maig"), new Month("Juny"), new Month("Juliol"), new Month("Setembre"), new Month("Octubre"),
				new Month("Novembre"), new Month("Decembre"));

		System.out.println("***AFEGIR AGOST EN EL SEU LLOC***");
		recorrerAmbFor(mesosAny);
		System.out.println("S'afegeix...");
		mesosAny.add(7, new Month("Agost"));
		recorreAmbIterator(mesosAny);

		System.out.println("\r\n***CONVERSIÓ EN HASHSET***");
		mesosAnyHashSet = new HashSet<Month>(mesosAny);
		recorrerAmbFor(mesosAnyHashSet);
		System.out.println("\r\nSi es prova d'afegir un duplicat, no l'afegeix i no dona error.");
		mesosAnyHashSet.add(new Month("Febrer"));
		recorreAmbIterator(mesosAnyHashSet);
		System.out.println("\r\nPerò sí altres elements (Hola).");
		mesosAnyHashSet.add(new Month("Hola"));
		recorrerAmbFor(mesosAnyHashSet);
		System.out.println("\r\nSi la col·leció té un duplicat, no s'afegeix");
		mesosAny.add(1, new Month("Febrer"));
		recorrerAmbOperacionsAgragades(mesosAny);
		mesosAnyHashSet = new HashSet<Month>(mesosAny);
		recorrerAmbFor(mesosAnyHashSet);

	}

	private static void recorrerAmbFor(Collection<Month> c) {
		// DEFINICIO VARIABLES
		String text = "";

		// ACCIONS
		for (Month object : c) {
			text = text + object.getName() + " ";
		}

		// SORTIDA
		System.out.println(text);

	}

	private static void recorreAmbIterator(Collection<Month> c) {
		// DEFINICIÓ VARIABLES
		String text = "";

		// ACCIONS
		for (Iterator<Month> iterator = c.iterator(); iterator.hasNext();) {
			Month month = (Month) iterator.next();
			text = String.format("%s%s ", text, month.getName());
		}

		// SORTIDA
		System.out.println(text);
	}

	private static void recorrerAmbOperacionsAgragades(Collection<Month> c) {
		// DEFINICIO VARIABLES
		String text = "";

		// ACCIONS
		text = c.stream().map(p -> p.getName()).collect(Collectors.joining(" "));

		// SORTIDA
		System.out.println(text);

	}
}
