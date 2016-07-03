/**
 * Created by Lucas on 03.07.2016.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class TestJUnit {

    @Test
    public void Test1() {
        int a = Macierz.summac(1, 2);
        assertEquals(a, 3);
        System.out.println("Test 1 zakonczony powidzeniem");
    }

    @Test
    public void Test2() {
        boolean a = Macierz.sprawdzmacierz();
        assertEquals(a, true);
        System.out.println("Test 2 zakonczony powidzeniem");
    }


    @Test
    public void Test3() {
        boolean a = Macierz.koniecmac(5);
        assertTrue(a);
        System.out.println("Test 3 zakonczony powidzeniem");
    }

    @Test
    public void Test4() {
        double a = Macierz.wartkloc(5);
        assertNotNull(a);
        System.out.println("Test 4 zakonczony powidzeniem");
    }

    @Test
    public void Test5() {
        int[] a = Macierz.plansza(1, 2, 10);
        int[] tab = {1, 2, 10};
        assertArrayEquals(tab, a);
        System.out.println("Test 5 zakonczony powidzeniem");
    }

}
