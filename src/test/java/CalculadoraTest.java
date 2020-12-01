import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class CalculadoraTest {
    @Test
    public void dividirPorZeroTest() {
        int atual = 0;
        String esperado = "/ by zero";
        Calculadora calculadora = new Calculadora();
        Exception e = Assert.assertThrows(Exception.class, () -> calculadora.dividir(2, 0));
        Assert.assertEquals(esperado, e.getMessage());
    }

    @Test
    public void dividirTest() {
        int valor1 = 360;
        int valor2 = 12;
        int esperado = 30;
        Calculadora calculadora = new Calculadora();
        float resultado = calculadora.dividir(valor1, valor2);
        Assert.assertEquals(esperado, resultado, resultado);
    }

    @Test
    public void multiplicarTest() {
        int valor1 = 2;
        int valor2 = 7;
        int  esperado = 14;
        Calculadora calculadora = new Calculadora();
        float resultado = calculadora.multiplicar(valor1, valor2);
        Assert.assertEquals(esperado, resultado, resultado);
    }

    @Test
    public void somarTest() {
        int valor1 = 97;
        int valor2 = 103;
        int  esperado = 200;
        Calculadora calculadora = new Calculadora();
        float resultado = calculadora.somar(valor1, valor2);
        Assert.assertEquals(esperado, resultado, resultado);
    }

    @Test
    public void subtrairTest() {
        int valor1 = 67;
        int valor2 = 54;
        int  esperado = 13;
        Calculadora calculadora = new Calculadora();
        float resultado = calculadora.subtrair(valor1, valor2);
        Assert.assertEquals(esperado, resultado, resultado);
    }

    @Test
    public void jurosSimplesTest() {
        double capital = 2000;
        double taxaJuros = 0.10;
        double periodo = 2;
        double esperado = 400;
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.jurosSimples(capital, taxaJuros, periodo);
        Assert.assertEquals((double)esperado, resultado, resultado);
    }

    @Test
    public void jurosCompostosTest() {
        double capital = 300;
        double periodo = 3;
        double taxaJuros = 2;
        double esperado = 318.36;
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.jurosCompostos(capital, periodo, taxaJuros);
        Assert.assertEquals(esperado, resultado, resultado);
    }

    @Test
    public void numeroPrimoTest() {
        int numero = 3;
        boolean esperado = true;
        Calculadora calculadora = new Calculadora();
        boolean resultado = calculadora.numeroPrimo(numero);
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void numeroNaoPrimoTest() {
        int numero = 9;
        boolean esperado = false;
        Calculadora calculadora = new Calculadora();
        boolean resultado = calculadora.numeroPrimo(numero);
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void mockNumeroPrimoTest() throws Exception {
        int numero = 3;
        boolean esperado = false;
        String METHOD = "numeroPrimo";
        Calculadora calculadoraMock = new Calculadora();
        Calculadora spy = (Calculadora) PowerMockito.spy(calculadoraMock);
        PowerMockito.when(spy, METHOD, numero).thenReturn(false);
        boolean resultado = spy.numeroPrimo(numero);
        Assert.assertEquals(esperado, resultado);
    }
}