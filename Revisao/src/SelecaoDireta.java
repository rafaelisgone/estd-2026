import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelecaoDireta {
    // preenche o vetor
    public static void lerVetor (int[] vetor){
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++){
            vetor[i] = random.nextInt(100);
        }
    }

    // encontra o menor
    public static int encontraMenor (int[] vetor){
        int menor = vetor[0];
        for (int i = 0; i < vetor.length; i++){
            if (menor > vetor[i]){
                menor = vetor[i];
            }
        }
        return menor;
    }

    // seleçao direta
    public static void selecaoDireta (int[] vetor, int menor){
        for (int i = 0; i < vetor.length; i ++){
            menor = i;
            for (int j = 0; j < vetor.length; j ++){
                if (vetor[i] < menor){
                    menor = vetor[j];
                    int posicao = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]  vetor = new int[7];
            lerVetor(vetor);
            System.out.println("Vetor:");
            System.out.println(Arrays.toString(vetor));

            encontraMenor(vetor);
            selecaoDireta(vetor, menor);

            System.out.println("Vetor:");
            System.out.println(Arrays.toString(vetor));
    }
}
