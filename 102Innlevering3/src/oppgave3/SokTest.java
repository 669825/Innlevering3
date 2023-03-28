package oppgave3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import Sok.Sok;

/*Testplan for søkealgoritmer:

Lineærsøking i usortert tabell
Test 1: Finn et eksisterende element i en liten usortert tabell (f.eks. [4, 6, 1, 8, 3]), forventet resultat: true
Test 2: Finn et ikke-eksisterende element i en liten usortert tabell, forventet resultat: false
Test 3: Finn et eksisterende element i en stor usortert tabell (f.eks. 10 000 elementer), forventet resultat: true
Test 4: Finn et ikke-eksisterende element i en stor usortert tabell, forventet resultat: false

Lineærsøking i sortert tabell
Test 1: Finn et eksisterende element i en liten sortert tabell (f.eks. [1, 3, 4, 6, 8]), forventet resultat: true
Test 2: Finn et ikke-eksisterende element i en liten sortert tabell, forventet resultat: false
Test 3: Finn et eksisterende element i en stor sortert tabell (f.eks. 10 000 elementer), forventet resultat: true
Test 4: Finn et ikke-eksisterende element i en stor sortert tabell, forventet resultat: false

Binærsøking i sortert tabell
Test 1: Finn et eksisterende element i en liten sortert tabell (f.eks. [1, 3, 4, 6, 8]), forventet resultat: true
Test 2: Finn et ikke-eksisterende element i en liten sortert tabell, forventet resultat: false
Test 3: Finn et eksisterende element i en stor sortert tabell (f.eks. 10 000 elementer), forventet resultat: true
Test 4: Finn et ikke-eksisterende element i en stor sortert tabell, forventet resultat: false
Testene kan implementeres som JUnit-tester i en egen testklasse, for eksempel "SokTest". 
*/
public class SokTest {

    private int[] usortert = { 5, 3, 8, 2, 9, 1, 7, 4, 6 };
    private int[] sortert = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    @Test
    public void testLinearSokUsortert() {
        assertTrue(Sok.linaerSokUsortert(usortert, 4));
        assertFalse(Sok.linaerSokUsortert(usortert, 10));
    }

    @Test
    public void testLinearSokSortert() {
        assertTrue(Sok.linaerSokSortert(sortert, 4));
        assertFalse(Sok.linaerSokSortert(sortert, 10));
    }
    
    @Test
    public void testBinaerSok() {
        assertTrue(Sok.binaerSok(sortert, 4));
        assertFalse(Sok.binaerSok(sortert, 10));
    }
}

