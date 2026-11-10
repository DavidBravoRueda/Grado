package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class funcionesTest {

	@Test
	public void testEsCapicua() {
        int capicua = 121;
        int noCapicua = 123;

        assertTrue(funciones.esCapicua(capicua));
        assertFalse(funciones.esCapicua(noCapicua));
    }

    @Test
    public void testEsPrimo() {
        int primo = 7;
        int noPrimo = 4;

        assertTrue(funciones.esPrimo(primo));
        assertFalse(funciones.esPrimo(noPrimo));
    }

    @Test
    public void testSiguientePrimo() {
        int numero = 7;
        int siguientePrimoEsperado = 11;

        assertEquals(siguientePrimoEsperado, funciones.siguientePrimo(numero));
    }

    @Test
    public void testDigitos() {
        int numero = 123;
        int cero = 0;

        assertEquals(3, funciones.digitos(numero));
        assertEquals(1, funciones.digitos(cero));
    }

    @Test
    public void testVoltea() {
        int numero = 123;
        int cero = 0;

        assertEquals(321, funciones.voltea(numero));
        assertEquals(cero, funciones.voltea(cero));
    }

    @Test
    public void testDigitoN() {
        int numero = 123;
        int posicion1 = 1;
        int posicion0 = 0;

        assertEquals(2, funciones.digitoN(numero, posicion1));
        assertEquals(1, funciones.digitoN(numero, posicion0));
    }

    @Test
    public void testQuitaPorDetras() {
        int numero = 123;
        int quitar1 = 1;
        int cero = 0;

        assertEquals(12, funciones.quitaPorDetras(numero, quitar1));
        assertEquals(cero, funciones.quitaPorDetras(cero, quitar1));
    }

    @Test
    public void testQuitaPorDelante() {
        int numero = 123;
        int quitar1 = 1;
        int cero = 0;

        assertEquals(23, funciones.quitaPorDelante(numero, quitar1));
        assertEquals(cero, funciones.quitaPorDelante(cero, quitar1));
    }

    @Test
    public void testPegaPorDetras() {
        int numero = 123;
        int pegar4 = 4;
        int cero = 0;

        assertEquals(1234, funciones.pegaPorDetras(numero, pegar4));
        assertEquals(5, funciones.pegaPorDetras(cero, 5));
    }

    @Test
    public void testPegaPorDelante() {
        int numero = 123;
        int pegar4 = 4;
        int cero = 0;

        assertEquals(4123, funciones.pegaPorDelante(numero, pegar4));
        assertEquals(5, funciones.pegaPorDelante(cero, 5));
    }
	

}
