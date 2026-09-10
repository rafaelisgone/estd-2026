import java.util.Arrays;

public class BuscaBinaria {

    // gerar vetorzin
    public static void gerarVetor(int[] vetor) {
        int dois = 2;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = dois;
            dois += 2;
        }
    }

    // busca binaria
    public static int buscaBinaria(int[] vetor, int inicio, int fim, int numeroProcurado) {
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == numeroProcurado) {
                return meio;
            } else if (vetor[meio] <= numeroProcurado) {
                inicio = meio - 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    // medidor de tempo
    public static void medirTempo(int[] vetor, int numeroProcurado) {
        long inicio = System.nanoTime();
        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1_000_000;

        int resultado = buscaBinaria(vetor, inicio, fim, numeroProcurado);

        if (resultado != -1) {
            System.out.println("\nNúmero encontrado na posição "+ resultado +".");
        } else {
            System.out.println("Número não encontrado.");
        }
        System.out.println("Tempo de execução "+ duracaoMs +" ms.");
    }

    public static void main(String[] args) {
        int tam = 100000;

        int[] vetor = new int[tam];

        gerarVetor(vetor);

        int inicio = 0;
        int fim = tam - 1;

        System.out.println("\n================================================================= VETORZINHO ================================================================");
        System.out.println(Arrays.toString(vetor));
    }
}