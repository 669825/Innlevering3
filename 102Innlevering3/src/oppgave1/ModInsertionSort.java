package oppgave1;

import java.util.Random;

public class ModInsertionSort {

	// hjelpemtode for å finne minste element i tabell, sørger for at start posisjon
	// har dt minste elementet, og returerer minste Indeks
	private static <T extends Comparable<? super T>> void min(T[] tab, int start, int slutt) {

		T min = tab[start];
		int minIndeks = start;

		for (int i = start + 1; i <= slutt; i++) {
			if (tab[i].compareTo(min) < 0) {
				min = tab[i];
				minIndeks = i;
			}
		} // bytter om dersom start element ikke er minst
		if (minIndeks != start) {
			T temp = tab[start];
			tab[start] = min;
			tab[minIndeks] = temp;
		}
	}

	//hjelpemetode for å bytte om naboelementer
	private static <T extends Comparable<? super T>> void swap(T[] tab, int indeks, int j) {
		if (indeks != j) {
			T temp = (T) tab[indeks];
			tab[indeks] = tab[j];
			tab[j] = temp;
		}
	}

	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static <T extends Comparable<? super T>> void standardInsertionSort(T[] tab, int start, int slutt) {
		for (int i = start + 1; i <= slutt; i++) {
			T tmp = tab[i];
			int j = i - 1; // siste i sortert del
			boolean ferdig = false;

			while (!ferdig && j >= 0) {
				if (tmp.compareTo(tab[j]) < 0) {
					tab[j + 1] = tab[j];
					j--;
				} else {
					ferdig = true;
				}
			}

			tab[j + 1] = tmp;
		}
	}

	public static <T extends Comparable<? super T>> void modInsertionSort(T[] tab, int start, int slutt) {

		// finner indeks for minste element og flytter det til start
		min(tab, start, slutt);

		/*
		 * sorterer deretter tabellen fra høyre til venstre, med unntak fra første
		 * elementet som vi nå vet er minst
		 */

		// sorterer listen fra høyre til venstre
		for (int k = slutt; k > 0; k--) {
			T x = tab[k];
			T y = tab[k - 1];

			if (x.compareTo(y) < 0) {
				T temp = x;
				tab[k] = y;
				tab[k + 1] = temp;
			}
		}
	}

	public static <T extends Comparable<? super T>> void doubleInsertionSort(T[] tab, int start, int slutt) {
		// finner indeks for minste element og flytter det til start
		min(tab, start, slutt);

		// itererer gjennom tabellen og sammenligner 2 elementer om gangen, bruker
		// steglengde på 2
		for (int i = start + 2; i <= slutt; i += 2) {
			// lagrer første og andre element i et par, midlertidig
			T tmp1 = tab[i];
			T tmp2 = tab[i - 1];
			if (tmp1.compareTo(tmp2) < 0) { // sammenligner elementene i "paret"
				tab[i] = tmp2; // bytter om dersom de er i feil rkkefølge
				tab[i - 1] = tmp1;
			}
			int j = i - 2;
			while (j >= start && tab[j].compareTo(tab[j + 2]) > 0) {
				swap(tab, j, j + 2);
				swap(tab, j + 1, j + 3);//
				j -= 2;
			}
		}
	}

	public static void main(String[] args) {

		Random rand = new Random();
		int lengde = 100000;

		// genererer tabell med oppgitt lengde, elementer som har tilfeldige data
		Integer[] tab = new Integer[lengde];
		for (int i = 0; i < lengde; i++) {
			tab[i] = rand.nextInt();
		}

		// Tidsbruk for modifisert Insertion sort
		long startTime = System.nanoTime();
		standardInsertionSort(tab, 0, tab.length - 1);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000; // mikrosek
		System.out.println("Tidsbruk for standard Insertion sort: " + duration + " ms");

		// Tidsbruk for standard Insertion sort
		long startTime2 = System.nanoTime();
		modInsertionSort(tab, 0, tab.length - 1);
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2) / 1000; // mikrosek
		System.out.println("Tidsbruk for modifisert Insertion sort: " + duration2 + " ms");

		/*
		 * genererer tabell med halvparten sorterte elementer og resten av elementer som
		 * har tilfeldige data
		 */
		
		int lengde2 = 10;
		Integer[] tab2 = new Integer[lengde2];
		int mid = lengde2 / 2;

		for (int i = 0; i < mid; i++) {
			tab2[i] = i;
		}
		for (int j = mid; j < lengde2; j++) {
			tab2[j] = rand.nextInt(lengde2);
		}

		// b) tid
		// Tidsbruk for sammenligning av to elementer Insertion sort
		long startTime3 = System.nanoTime();
		doubleInsertionSort(tab, 0, tab.length - 1);
		long endTime3 = System.nanoTime();
		long duration3 = (endTime3 - startTime3) / 1000000; // millisekunder
		System.out.println("Tidsbruk for dobbel sammenligning ved Insertion sort: " + duration3 + " ms");

		// test av metodene
		standardInsertionSort(tab2, 0, tab2.length - 1);
		System.out.print("standardInsertionSort: " + "[");
		for (int s : tab2) {
			System.out.print(s + ", ");
		}
		System.out.println("]");

		modInsertionSort(tab2, 0, tab2.length - 1);
		System.out.print("modInsertionSort: " + "[");
		for (int s : tab2) {
			System.out.print(s + ", ");
		}
		System.out.println("]");

		doubleInsertionSort(tab2, 0, tab2.length - 1);
		System.out.print("doubleInsertionSort: " + "[");
		for (int s : tab2) {
			System.out.print(s + ", ");
		}
		System.out.println("]");

	}

}
