import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.Scanner;

public class BuscaSequencial {

    // gerar vetorzin
    public static void gerarVetor(int[] vetor) {
        int dois = 2;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = dois;
            dois += 2;
        }
    }

    // busca sequencial
    public static int buscaSequencial(int[] vetor, int numeroProcurado) {
        for (int i = 0; i < vetor.length; i++) {
            if (numeroProcurado == vetor[i]) {
                return i;
            }
        }
        return -1;
    }

    // medidor de tempo
    public static void medirTempo(int[] vetor, int numeroProcurado) {
        long inicio = System.nanoTime();
        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1_000_000;

        int resultado = buscaSequencial(vetor, numeroProcurado);

        if (resultado != -1) {
            System.out.println("\nNúmero encontrado na posição "+ resultado +".");
        } else {
            System.out.println("Número não encontrado.");
        }
        System.out.println("Tempo de execução "+ duracaoMs +" ms.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tam = 100000;
        int[] vetor = new int[tam];

        gerarVetor(vetor);

        System.out.println("\n================================================================= VETORZINHO ================================================================");
        System.out.println(Arrays.toString(vetor));

        System.out.println("\nQual número você deseja procurar?");
        int numeroProcurado = sc.nextInt();

        medirTempo(vetor, numeroProcurado);
    }
}