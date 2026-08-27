public class Potencia {

    public static double potencia(double base, int expoente) {
        if (expoente == 0) {
            return 1;
        } else {
            return base * potencia(base, expoente - 1);
        }
    }

    public static void main(String[] args){
        double base = 2;
        int expoente = 3;
        double resposta = potencia(base, expoente);

        System.out.print("O resultado de " + base + " elevado a " + expoente + " é: " + resposta);
    }
}
