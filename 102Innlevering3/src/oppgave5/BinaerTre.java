package oppgave5;

import oppgave5.BinaerTreNode.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BinaerTre<T extends Comparable<? super T>> implements BinaerTreInterface<T> {

	private BinaerTreNode<T> rot;
	private int antall;

	public BinaerTre() {
		rot = null;
	}

	public BinaerTre(T element) {
		rot = new BinaerTreNode<T>(element);
	}

	public int Hoyde() {
		return HoydeRek(rot);
	}

	private int HoydeRek(BinaerTreNode<T> t) {

		if (t == null) {
			return -1;
		} else {
			int venstreHoyde = HoydeRek(t.getVenstre());
			int hoyreHoyde = HoydeRek(t.getHogre());
			return 1 + Math.max(venstreHoyde, hoyreHoyde);
		}
	}

	// rekursiv metode for å besøke alle noder i tre og legge dem inn inorden
	// rekkefølge i en ordnet liste
	public BinaerTreNode<T> balanser(List<T> liste) {
	    // Sorter listen i stigende rekkefølge
	    Collections.sort(liste);
	    
	    // Kall hjelpemetoden for å balansere treet
	    return balanser(liste, 0,liste.size()-1);
	}

	private BinaerTreNode<T> balanser(List<T> liste, int lav, int hoy) {
		
		if (lav > hoy) {
			return null;
		}
		
		int mid = (lav + hoy) / 2;
		BinaerTreNode<T> node = new BinaerTreNode<T>(liste.get(mid));
		
		node.setVenstre(balanser(liste, lav, mid-1));
		node.setHogre(balanser(liste, mid+1, hoy));

		return node;
	}

	/**
	 * S�ker etter et gitt element i treet.
	 * 
	 * @param element elementet vi s�ker etter.
	 * @return true om elementet finst, false elles.
	 */
	public boolean inneholder(T element) {
		return false;

		// Kan kalle finn-metoden nedanfor. Pr�v sj�lv.
	}

	/**
	 * Henter et element i treet.
	 * 
	 * @param element elementet vi leiter etter.
	 * @return Elementet dersom det finst, elles null.
	 */
	public T finn(T element) {
		return finn(element, rot);

	}

	private T finnRek(T element, BinaerTreNode<T> p) {
		T svar = null;
		// p == null -> basis gjer ingenting
		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) { // I rot
				svar = p.getElement(); // basis
			} else if (sml < 0) {
				svar = finnRek(element, p.getVenstre());
			} else {
				svar = finnRek(element, p.getHogre());
			}
		}
		return svar;
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
	public T fjern(T element) {
		// Er ikkje pensum � kunne skrive denne
		// Men de m� kunne forklare korleis vi slettar
		// Sj� lyskark

		return null;
	}

	public static void main(String[] args) {

		// a)
		// Oppretter 4 binære trær med ulike antall noder

		Random rand = new Random();// for generering av tilfeldige data for noder
		int[] antallNoder = { 12, 3, 0 }; // tabell for oppbevaring av antall noder for de ulike trærne
		BinaerTre<Integer>[] traer = new BinaerTre[antallNoder.length];

		for (int i = 0; i < antallNoder.length; i++) {
			BinaerTre<Integer> tre = new BinaerTre<Integer>();
			for (int j = 0; j < antallNoder[i]; j++) {
				int verdiNode = rand.nextInt();
				tre.leggTil(verdiNode);
			}
			traer[i] = tre;
		}

		/*
		 * skriver ut høyde av hvert tre og antall noder som ble lagt inn i hvert tre
		 */
		for (int i = 0; i < traer.length; i++) {
			System.out.println("Antall noder i treet er: " + antallNoder[i]);
			System.out.println("Høyde på treet er: " + traer[i].Hoyde());
		}

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
