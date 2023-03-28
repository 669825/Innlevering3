package oppgave2;

import java.util.ArrayDeque;
import java.util.Random;

public class Sortering {

	/*
	 * Algoritmer for sorteringsmetoder: O(f(n)), T(n)=c*f(n)
	 * 
	 * Utvalgssortering/Selection sort: f(n) = n^2, sekvensiell sortering: n*n
	 * 
	 * sammenligninger SorteringVedInsetting/insertion sort: f(n) = n^2, sammenligne
	 * element for insetting md ca. halvparten av tab ->n(n - 1)/2 -> n*n - > n^2
	 * 
	 * Flettesortering/Merge sort: f(n) = nlog2 n, n = 2^k, antall rekursjonsnivåer = (log2 n) + 1,
	 *                             hver sammnligning: O(n). Til sammen gir: nlog2 n
	 * 
	 * Kvikksortering/Quick sort: f(n)= nlog2 n, n sammenligninger, hver partisjon deler tab i 2.
	 *                                           -> log2 n, -> n* log2 * n -> nlog2 n.
	 * 
	 * 
	 */

	public static void main(String[] args) {

		//oppretter tabeller med ulike lengder
		Random rand = new Random();

		int lengde = 32000;
		// genererer tabell med oppgitt lengde, elementer som har tilfeldige data
		Integer[] tab = new Integer[lengde];
		for (int i = 0; i < lengde; i++) {
			tab[i] = rand.nextInt(lengde);
		}

		// Effektivitet målt i tid, ut fra de ulike sorteringsmetodene:

		// Utvalgsortering/Selection sort
		long startTime4 = System.nanoTime();
		utvalgssortering(tab, tab.length);
		long endTime4 = System.nanoTime();
		long duration4 = (endTime4 - startTime4) / 1000; // mikrosek
		System.out.println("Resultat Utvalgsortering: [n:  "Tid utført med utvalgssortering: " + duration4 + " ms");

		// Innsettsortering/Insertion sort
		long startTime = System.nanoTime();
		sorteringVedInsetting(tab, 0, tab.length - 1);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000; // mikrosek
		System.out.println("Tid utført med innsettingssortering: " + duration + " ms");

		// Flettesortering/merge sort
		long startTime2 = System.nanoTime();
		flettesortering(tab);
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2) / 1000; // mikrosek
		System.out.println("Tid utført med flettesortering: " + duration2 + " ms");

		// Kvikksortering/quick sort
		long startTime3 = System.nanoTime();
		kvikksorter(tab);
		long endTime3 = System.nanoTime();
		long duration3 = (endTime3 - startTime3) / 1000; // mikrosek
		System.out.println("Tid utført med kvikksortering: " + duration3 + " ms");

	}
		//| Skrive ut tabell med oversikt over algoritmen til de ulike
		// sorteringsmetodene:
	/*
		String[][] ovrsikt = {
				{
		}

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
		
		//b) Prøv å sortere en tabell der alle elementene er like med Quicksort og mål tiden. Forklar hva som skjer og
		hvorfor det skjer?
		
		
		int lengde2 = 10;
		Integer[] like = new Integer[lengde];
		for (int k = 0; k < lengde; k++) {
			tab[k] =  rand.nextInt(lengde2);
		}
		
		long startTime5 = System.nanoTime();
		kvikksorter(like);
		long endTime5 = System.nanoTime();
		long duration5 = (endTime5 - startTime5) / 1000000; // millisekunder
		System.out.println("Tid utført med kvikksortering: " + duration5 + " ms");

	}
		
	
	 * Utvalgsortering 
	 * //Test utvalgssortering(tab,tab.length);
	 * System.out.print("utvalgssortering: " + "["); for(int i : tab) {
	 * System.out.print(i + ", "); } System.out.println("]");
	 * 
	 * //SorteringVedInsetting 
	 * //Test sorteringVedInsetting(tab,0 , tab.length - 1);
	 * System.out.print("Sortering ved Insetting: " + "["); for(int j : tab) {
	 * System.out.print(j + ", "); } System.out.println("]");
	 * 
	 * //Flettesortering/merge sort 
	 * //test flettesortering(tab);
	 * System.out.print("Flettesortering: " + "["); for(int k : tab) {
	 * System.out.print(k + ", "); } System.out.println("]");
	 * 
	 * 
	 * //Kvikksorter/quick sort 
	 * //Test kvikksorter(tab);
	 * System.out.print("Kvikksortering: " + "["); for(int l : tab) {
	 * System.out.print(l + ", "); } System.out.println("]"); }
	 * 
	 */

	// Utvalgssortering / Plukksortering (DAT100) (Selction sort)
	// Sorterer dei f�rste n elmementa i tabellen. Kanskje litt uvanlig
	// Kunne ogs� utelatt n og sortert heile tabellen.

	public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int minstePos = finnMinstePos(a, i, n - 1);
			swap(a, i, minstePos);
		}
	}

	private static <T extends Comparable<? super T>> int finnMinstePos(T[] a, int fra, int til) {
		int p = fra;
		for (int i = fra + 1; i <= til; i++) {
			if (a[i].compareTo(a[p]) < 0) {
				p = i;
			}
		}

		return p;
	}

	/*
	 * // Sortering ved innsetting (Insertion sort) private static <T extends
	 * Comparable<? super T>> void sorteringVedInnsetting(T[] tab, int min, int
	 * maks) { sorteringVedInsetting(a, 0, n - 1); }
	 */
	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static <T extends Comparable<? super T>> void sorteringVedInsetting(T[] tab, int start, int slutt) {
		for (int i = start + 1; i <= slutt; i++) {
			T temp = tab[i];
			int j = i - 1;
			boolean ferdig = false;
			while (!ferdig && j >= 0) {
				if (temp.compareTo(tab[j]) < 0) {
					tab[j + 1] = tab[j];
					j--;
				} else {
					ferdig = true;
				}
			}
			tab[j + 1] = temp;
		}
	}

	// Flettesortering/merge sort
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<? super T>> void flettesortering(T[] tab) {

		int tabLengde = tab.length;

		if (tabLengde < 2) {
			return;
		}

		int mid = tabLengde / 2;
		T[] Vtab = (T[]) new Comparable[mid];
		T[] Htab = (T[]) new Comparable[tabLengde - mid];

		for (int i = 0; i < mid; i++) {
			Vtab[i] = (T) tab[i];
		}
		for (int i = mid; i < tabLengde; i++) {
			Htab[i - mid] = (T) tab[i];
		}

		flettesortering(Vtab);
		flettesortering(Htab);
		T[] temptab = (T[]) new Comparable[tab.length * 2];
		flette(temptab, Vtab, Htab);

	}

	private static <T extends Comparable<? super T>> void flette(T[] tab, T[] Vtab, T[] Htab) {

		// Flettar saman to deler som ligg ved sida av kvaranre

		int vTabLengde = Vtab.length;
		int hTabLengde = Htab.length;

		int i = 0, j = 0, k = 0;

		while (i < vTabLengde && j < hTabLengde) {
			if (Vtab[i].compareTo(Htab[j]) <= 0) {// element venstre del mindre/lik høyre del -> fletter inn i hovedtab
				tab[k] = Vtab[i];
				i++;
			} else {// element fra venstre del er større/lik høyre del -> fletter inn hovedtabell
				tab[k] = Htab[j];
				j++;
			}
			k++;
		}
		// fletter inn potensielle resterende elementer venstre del
		while (i < vTabLengde) {
			tab[k] = Vtab[i];
			i++;
			k++;
		}

		// fletter inn potensielle resterende elementer høyre del
		while (j < hTabLengde) {
			tab[k] = Htab[j];
			j++;
			k++;
		}
	}

	// Kvikksorter/Quick sort
	// -kan forbedres med sortering ved insetting ved få elementer igjen å sortere

	

	private static <T extends Comparable<? super T>> void kvikksorter(T[] tab) {
		if (tab == null || tab.length <= 1) {
			return; // basistilfellet, ingen sortering er nødvendig
		}

		int antall = 20;// få elementer igjen -> sorteringVedInsetting for mer effektiv sortering

		// bruker en deque for å unngå StackOverFlowError når tab har stort antall n
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		int min = 0;
		int maks = tab.length - 1;
		deq.add(maks);
		deq.add(min);

		while (!deq.isEmpty()) {
			min = deq.removeLast();
			maks = deq.removeLast();

			if (maks - min + 1 <= antall) {// sorteringVedInsetting ved få elementer igjen
				sorteringVedInsetting(tab, min, maks);
			} else {

				//Oppdaterer pivotIndeks ved partisjonring av tabellen
				int pivotIndeks = partisjon(tab, min, maks);

				//flere elementr til evnstre for pivot
				//-> legg i deq for senere sortering
				if (pivotIndeks - 1 > min) {
					deq.addLast(pivotIndeks - 1);
					deq.addLast(min);
				}

				//flere elementer til høyre for pivot
				//-> legg i deq for senere sortering
				if (pivotIndeks + 1 < maks) {
					deq.addLast(maks);
					deq.addLast(pivotIndeks + 1);
				}
			}

		}

	}

	/*
	 * private static <T extends Comparable<? super T>> void kvikksorterRek(T[] tab,
	 * int min, int maks) {
	 * 
	 * if(min < maks) { //velger pivot som siste element int pivotIndeks =
	 * partisjon(tab, min, maks); kvikksorterRek(tab, min, pivotIndeks - 1);
	 * kvikksorterRek(tab, pivotIndeks + 1, maks); } }
	 */

	
	private static <T extends Comparable<? super T>> int partisjon(T[] tab, int min, int maks) {

		int midt = (min + maks) / 2; 
		T p = tab[midt]; // p = pivot satt til midten av tabellen

		swap(tab, midt, maks);
		
		int indeks = min - 1;
		
		for (int j = min; j < maks; j++) {// j = indeks2
			if (tab[j].compareTo(p) < 0) {// elementer som er mindre enn pivot
				indeks++;
				if (indeks != j)
					swap(tab, indeks, j);
			}
		}

		swap(tab, indeks + 1, maks);
		return indeks + 1;
	}

	private static <T extends Comparable<? super T>> void swap(T[] tab, int indeks, int j) {
		if (indeks != j) {
			T temp = (T) tab[indeks];
			tab[indeks] = tab[j];
			tab[j] = temp;
		}
	}

}// end class