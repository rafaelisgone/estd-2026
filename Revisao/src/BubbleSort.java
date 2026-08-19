import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    // preecnhe o vetor com números aleatorios
    public static void lerVetor (int[] vetor){
        Random random = new Random();
        for (int i = 0; i < vetor.length; i ++){
            vetor[i] = random.nextInt(100);
        }
    }

    // faz o bubble sort
    public static void bubbleSort (int[] vetor){
        for (int i = 0; i < vetor.length - 1; i ++){
            for (int j = 0; j < vetor.length - 1 - i; j ++){
                if (vetor[j] > vetor[j + 1]){
                    int temp = vetor [j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    public static void main (String[] args){
        int[] vetor  = new int[8];

        lerVetor(vetor);
        System.out.println("----------------- Vetor -----------------");
        System.out.println(Arrays.toString(vetor));

        bubbleSort(vetor);
        System.out.println("-------------- Bubble Sort --------------");
        System.out.println(Arrays.toString(vetor));
    }
}