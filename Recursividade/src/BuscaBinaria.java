import java.util.Arrays;
import java.util.Scanner;

public class BuscaBinaria {
    public static int buscaBinaria(int[] vetor, int inicio, int fim, int numeroProcurado) {
        int meio = (inicio + fim) / 2;
        if (inicio > fim) {
            return -1;
        } else {
            if (vetor[meio] == numeroProcurado){
                return meio;
            } else if (numeroProcurado < vetor[meio]) {
                return buscaBinaria(vetor, inicio, meio - 1, numeroProcurado);
            } else {
                return buscaBinaria(vetor, meio + 1, fim, numeroProcurado);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = {3, 6, 8, 10, 22, 29, 38};
        int incio = vetor[0];
        int fim = vetor[6];

        System.out.println("<<<<<<<<< VETOR >>>>>>>>>");
        System.out.print(Arrays.toString(vetor));

        System.out.println("\n\nQual número você deseja procurar?");
        int numero = sc.nextInt();

        int resultado = buscaBinaria(vetor, 0, vetor.length, numero);
        System.out.print("Encontrado na "+ resultado +"º posição.");
    }
}