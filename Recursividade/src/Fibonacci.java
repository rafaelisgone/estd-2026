public class Fibonacci {

    public static int fibonacci(int numero) {
        if (numero == 1 || numero == 2) {
            return 1;
        } else {
            return fibonacci(numero - 1) + fibonacci(numero - 2);
        }
    }

    public static void main(String[] args) {
        int numero = 6;
        int resposta = fibonacci(numero);

        System.out.println("A Sequência de Fibonacci do número " + numero + " é: " + resposta);
    }
}
