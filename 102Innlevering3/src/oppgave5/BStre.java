package oppgave5;

import java.util.Iterator;

public class BStre<T extends Comparable<? super T>> implements BinaerTreInterface<T> {

	private BinaerTreNode<T> rot;
	private int antall;

	public BStre() {
		rot = null;
	}

	public BStre(T element) {
		rot = new BinaerTreNode<T>(element);
	}

	/*public void nivåorden(BinaerTreNode rot) {

		KjedetKoe<BinaerTreNode> kø = new KjedetKoe(); // Oppretter kø
		TabellSirkulaerKoe<BinaerTreNode> liste = new TabellSirkulaerKoe(); // oppretter tom liste
		liste.innKoe(rot);

		while (kø != null) {

		}

		while (!kø.tom()) // så lenge som køen ikke er tom
		{
			Node<T> p = kø.taUt(); // tar ut fra køen
			System.out.print(p.verdi + " "); // skriver ut

			if (p.venstre != null)
				kø.leggInn(p.venstre);
			if (p.høyre != null)
				kø.leggInn(p.høyre);
		}
	}*/

	/**
	 * S�ker etter et gitt element i treet.
	 * 
	 * @param element elementet vi s�ker etter.
	 * @return true om elementet finst, false elles.
	 */
	@Override
	public boolean inneholder(T element) {

		boolean funnet = false;

		if (rot == null) {
		} else if (finn(element) != null) {
			funnet = true;
		}
		return funnet;

	}

	@Override
	public T finn(T element) {
		return finn(element, rot);
	}

	private T finn(T element, BinaerTreNode<T> p) {

		T svar = null;

		// basis: p == null -> tomt undertre, elementet finst ikkje

		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) { // basistilfelle
				svar = p.getElement();
			}
			if (sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}

		return svar;
	}

	/**
	 * Legg eit element til treet dersom det ikkje finst fr� f�r. Elles blir det
	 * gamle elementet erstatta med det nye.
	 * 
	 * @param nyElement elementet som skal leggast til
	 * @return Elementet som vart erstatta, null om det ikkje finst fr� f�r
	 */
	@Override
	public T leggTil(T nyElement) {
		T resultat = null;
		if (rot == null) {
			rot = new BinaerTreNode<T>(nyElement);
		} else {
			resultat = leggTil(nyElement, rot);
		}
		return resultat;
	}

	private T leggTil(T nyttElement, BinaerTreNode<T> p) {

		// p er ulik null

		T resultat = null;
		int sml = nyttElement.compareTo(p.getElement());

		if (sml == 0) { // elementet finst fr� f�r
			resultat = p.getElement(); // tek vare p� gamal verdi
			p.setElement(nyttElement);
		} else if (sml < 0) {
			if (p.getVenstre() != null) { // p har venstrebarn
				resultat = leggTil(nyttElement, p.getVenstre());
			} else {
				p.setVenstre(new BinaerTreNode<T>(nyttElement));
			}
		} else {
			if (p.getHogre() != null) { // p har h�grebarn
				resultat = leggTil(nyttElement, p.getHogre());
			} else {
				p.setHogre(new BinaerTreNode<T>(nyttElement));
			}
		}

		return resultat;
	}

	/**
	 * Fjernar eit element fr� treet.
	 * 
	 * @param element elementet som skal fjernast.
	 * @return elementet som vart fjerna eller null om det ikkje finst.
	 */
	@Override
	public T fjern(T element) {
		// Er ikkje pensum � kunne skrive denne
		// Men de m� kunne forklare korleis vi slettar
		// Sj� lyskark
		return null;
	}
	

	/**
	 * Lagar ein iterator som g�r gjennom alle element i treet i inorden.
	 * 
	 * @return ein iterator som elementa i sortert rekkef�lge.
	 */
	@Override
	public Iterator<T> getInordenIterator() {
		// TODO Auto-generated method stub
		return null;
	}


}
