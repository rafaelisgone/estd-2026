import java.util.Arrays;
import java.util.Random;

public class Exercicio2 {
    // enche o vetor com valores randoms
    public static void lerVetor(int[] vetor) {
        Random aleatorio = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = aleatorio.nextInt(100);
        }
    }

    // intercala os vetores
    public static int[] intercalar(int[] vetor1, int[] vetor2) {
        int[] vetor3 = new int[50];
        int posicao = 0;

        for (int i = 0; i < 25; i++) {
            vetor3[posicao] = vetor1[i];
            posicao++;

            vetor3[posicao] = vetor2[i];
            posicao++;
        }
        return vetor3;
    }

    public static void main(String[] args) {
        int[] vetor1 = new int[25];
        int[] vetor2 = new int[25];

        lerVetor(vetor1);
        lerVetor(vetor2);

        // exibe o vet 1
        System.out.println("Vetor 1:");
        System.out.println(Arrays.toString(vetor1));

        // exibe  vet 2
        System.out.println("\nVetor 2:");
        System.out.println(Arrays.toString(vetor2));

        int[] vetor3 = intercalar(vetor1, vetor2);
        // exibe o vet intercalado
        System.out.println("\nVetor intercalado:");
        System.out.println(Arrays.toString(vetor3));
    }
}