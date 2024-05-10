package negozio;

import java.util.Scanner;

public class Negozio {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Inserire il numero di prodotti da vendere: ");
		int numeroArticoli = sc.nextInt();

		String[] nomiProdotti = new String[numeroArticoli];
		double[] prezzoProdotti = new double[numeroArticoli];
		int[] quantitaProdotti = new int[numeroArticoli];
		int i = 0;
		String rispAcquisto;
//registrazione prodotti
		for (i = 0; i < numeroArticoli; i++) {
			System.out.println("Inserisci il nome del prodotto");
			nomiProdotti[i] = sc.nextLine().toLowerCase();
			System.out.println("Inserisci il prezzo del prodotto");
			prezzoProdotti[i] = sc.nextDouble();
			sc.nextLine();
			System.out.println("Inserisci la quantità disponibile del prodotto");
			quantitaProdotti[i] = sc.nextInt();
			sc.nextLine();
//lato cliente
		}
		System.out.println("Salve, Inserisci il nome del prodotto che vuoi acquistare");
		int quantitaScelta = 0;
		int indiceProdotto = -1;
		do {
			String daCercare = sc.nextLine();
			for (i = 0; i < nomiProdotti.length; i++) {
				if (nomiProdotti[i].contains(daCercare)) {
					indiceProdotto = i;
				}

			}
			if (indiceProdotto != -1) {
				System.out.println("Inserisci la quantità da acquistare del prodotto scelto:");
				quantitaScelta = sc.nextInt();
				sc.nextLine();
//verifica della quantità
				if (quantitaScelta <= quantitaProdotti[indiceProdotto]) {

					quantitaProdotti[indiceProdotto] -= quantitaScelta;

					double importoTotale = prezzoProdotti[indiceProdotto] * quantitaScelta;
					System.out.println("Acquisto effettuato con successo, importo da pagare: " + importoTotale);
//caso in cui la quantità non basti
				} else {
					System.out.println("Quantità non sufficiente per l'acquisto");
				}
//caso in cui il prodotto non esista
			} else {
				System.out.println("Prodotto non trovato nel negozio");
			}

			System.out.println("Vuoi acquistare altri prodotti?");
			rispAcquisto = sc.nextLine();

			if (rispAcquisto.equalsIgnoreCase("si") || rispAcquisto.equalsIgnoreCase("sì")) {
				System.out.println("Inserire il nome del nuovo prodotto che si vuole acquistare:");
			}

		} while (rispAcquisto.equalsIgnoreCase("si") || rispAcquisto.equalsIgnoreCase("sì"));

		System.out.println("Grazie e arrivederci");

	}

}
