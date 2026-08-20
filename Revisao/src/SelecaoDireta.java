import java.util.Arrays;
import java.util.Random;

public class SelecaoDireta {
    // preenche o vetor
    public static void lerVetor(int[] vetor) {
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100);
        }
    }

    // encontra o menor
    public static int encontraMenor(int[] vetor) {
        int menor = vetor[0];
        for (int i = 0; i < vetor.length; i++) {
            if (menor > vetor[i]) {
                menor = vetor[i];
            }
        }
        return menor;
    }

    // seleção direta
    public static void selecaoDireta(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int posicaoMenor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[posicaoMenor]) {
                    posicaoMenor = j;
                }
            }

            if (posicaoMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[posicaoMenor];
                vetor[posicaoMenor] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] vetor = new int[7];
        lerVetor(vetor);
        System.out.println("Vetor original:");
        System.out.println(Arrays.toString(vetor));

        selecaoDireta(vetor);
        System.out.println("Vetor com seleção direta:");
        System.out.println(Arrays.toString(vetor));
    }
}