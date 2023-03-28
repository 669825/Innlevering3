package oppgave3;

public class Sok {

	public static boolean linaerSokUsortert(int[] tab, int element) {
		boolean funnet = false;
		int i = 0;

		while (!funnet && (i < tab.length)) {
			if (tab[i] == element)
				funnet = true;
			i++;
		}

		return funnet;
	}

	public static boolean linaerSokSortert(int[] tab, int element) {
		int i = 0;

		while (i < tab.length && tab[i] < element) {
			i++;
		}

		return i < tab.length && tab[i] == element;
	}

	public static boolean binaerSok(int[] tab, int element) {
		return binaerSok(tab, 0, tab.length - 1, element);
	}

	private static boolean binaerSok(int[] tab, int element, int min, int maks) {

		boolean funnet = false;

		if (min > maks) {
			funnet = false;

		} else {
			int midten = (min + maks) / 2;

			if (element == tab[midten]) {
				funnet = true;

			} else {
				if (element < tab[midten]) {
					funnet = binaerSok(tab, element, min, midten - 1);
				} else {
					if (element > tab[midten]) {
						funnet = binaerSok(tab, element, midten + 1, maks);
					}
				}
			}
		}

		return funnet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
