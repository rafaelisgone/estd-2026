import java.util.Arrays;

public class InsercaoDireta {
    public static void insercaoDireta(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i];
            int j;

            for (j = i - 1; j >= 0 && vetor[j] > aux; j--) {
                vetor[j + 1] = vetor[j];
            }

            vetor[j + 1] = aux;
        }
    }

    public static void main(String[] args) {
        int[] vetor = {10, 20, 12, 5, 8, 25};

        System.out.println("Vetor original:");
        System.out.println(Arrays.toString(vetor));

        insercaoDireta(vetor);

        System.out.println("Vetor ordenado:");
        System.out.println(Arrays.toString(vetor));
    }
}