public class Calculadora {
    public float dividir(int valor1, int valor2)
    {

        return valor1 / valor2;
    }
    public float multiplicar(int valor1, int valor2)
    {

        return valor1 * valor2;
    }

    public float somar(int valor1, int valor2)
    {

        return valor1 + valor2;
    }
    public float subtrair(int valor1, int valor2)
    {

        return valor1 - valor2;
    }

    public double jurosSimples(double capital, double taxaJuros, double periodo)
    {
        return capital * taxaJuros * periodo;
    }

    public double jurosCompostos(double capital, double periodo, double taxa)
    {
        return capital * Math.pow(1 + taxa, periodo);
    }

    public boolean numeroPrimo(int numero)
    {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;
        }
        return true;
    }
}
