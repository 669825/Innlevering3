package oppgave5;

import java.util.*;

public class BinaerTreKlient <T extends Comparable<? super T>> implements BinaerTreInterface<T> {
	
	
	
	/*
	 * Teoretiske høyden på et fullstendig binært tre vil være 
	 * h = log2(n+1)-1. Den maksimale teoretiske høyden vil
	 * tilsvare antall noder minus roten, altså n - 1.
	 * 
	 */
	public static int MinTHoyde(int antnoder) {
		return (int) Math.floor(Math.log(antnoder) / Math.log(2));
		
	}
	
	public static int MaxTHoyde(int noder) {
		return Math.subtractExact(noder,1);
	}
	
	public static int MinHoyde(BinaerTre[] liste) {
		
	
		int min = 0;
		for(int i = 0;i < liste.length - 1;i++) {
			if(liste[i].Hoyde() < liste[i + 1].Hoyde()) {
				min = liste[i].Hoyde();
			}else {
				min = liste[i + 1].Hoyde();
			}
			i++;
		}
		return min;
	}
	

	public static int MaxHoyde(BinaerTre[] liste) {
		
		int max = 0;
		
		
		for(int i = 0;i < liste.length - 1;i++) {
			if(liste[i].Hoyde() > liste[i + 1].Hoyde()) {
				max = liste[i].Hoyde();
			}else {
				max = liste[i + 1].Hoyde();
			}
			i++;
		}
		return max;
	}

	
	
	public static void main(String[] args) {
		// b)
		
		//genrerer trær og tilfeldige verdier til nodene
		Random terning = new Random();
		int tall = terning.nextInt();
		
		int antTraer = 100;//(100)
		int antNoder = 1023;//(1023)
		
		
		BinaerTre<Integer>[] traer = new BinaerTre[antTraer];
		
		for (int i = 0; i < antTraer; i++) {
			BinaerTre<Integer> tre = new BinaerTre<Integer>();
			for (int j = 0; j < antNoder; j++) {
				tre.leggTil(tall);
			}
			traer[i] = tre;
		}
		
		
		
		
		/*
		 * Skriver ut info
		 */
		/*
		int snitt = Math.subtractExact(MaxHoyde(traer),MinHoyde(traer))/2;
		
		for (int i = 0; i < traer.length; i++) {
			System.out.println("Antall noder i treet: " + antNoder);
			System.out.println("Minimale teoretiske høyde: " + MinTHoyde(antNoder));
			System.out.println("Maksimale teoretiske høyde: "+ MaxTHoyde(antNoder));
			System.out.println("Minste høyde: "+ MinHoyde(traer));
			System.out.println("Største høyde: "+ MaxHoyde(traer));
			System.out.println("Gjennomsnittlig høyde: "+(snitt));
			*/
		}
		
		
		
		
		
		
		

	

	@Override
	public boolean inneholder(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T finn(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T leggTil(T nyElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fjern(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInordenIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
