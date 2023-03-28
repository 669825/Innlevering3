package oppgave5;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public interface KoeADT<T> {
	
	/**
	 * Legge til et element bak i k�en.
	 * 
	 * @param element er elementet som blir satt inn i k�en
	 */
	void innKoe(T element);

	/**
	 * Fjerner og returnerer elementet foran i k�en.
	 * 
	 * @return elementet foran i k�en
	 * @exception EmptyCollectionException unntak som kastes hvis k�en er tom
	 */

	T utKoe();

	/**
	 * Returnerer elementet foran i k�en uten � fjerne det fra k�en.
	 * 
	 * @return elementet foran i k�en
	 * @exception EmptyCollectionException unntak kastes hvis k�en allerede er tom
	 */
	T foerste();

	/**
	 * Returnerer sann hvis denne k�en ikke inneholder noen elementer.
	 * 
	 * @return sann dersom k�en er tom ellers usann
	 */
	boolean erTom();

}//