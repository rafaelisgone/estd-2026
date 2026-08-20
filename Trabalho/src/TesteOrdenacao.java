import java.util.Arrays;
import java.util.Random;

public class TesteOrdenacao {
    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

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

    public static void insercaoDireta(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > aux) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }
    }

    // ---------- GERAÇÃO DE VETORES ----------

    public static int[] gerarAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(10000);
        }
        return vetor;
    }

    public static int[] gerarOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i;
        }
        return vetor;
    }

    public static int[] gerarInvertido(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }
        return vetor;
    }

    // ---------- MEDIÇÃO DE TEMPO ----------

    // recebe o vetor de teste e o nome do algoritmo, mede e imprime o tempo
    public static void medirTempo(String nomeAlgoritmo, int[] vetorOriginal) {
        int[] copia = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

        long inicio = System.nanoTime();

        switch (nomeAlgoritmo) {
            case "Bubble Sort":
                bubbleSort(copia);
                break;
            case "Seleção Direta":
                selecaoDireta(copia);
                break;
            case "Inserção Direta":
                insercaoDireta(copia);
                break;
        }

        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1_000_000; // nanosegundos -> milissegundos

        System.out.println(nomeAlgoritmo + ": " + duracaoMs + " ms");
    }

    // ---------- MAIN ----------

    public static void main(String[] args) {
        int tamanho = 100;

        int[] aleatorio = gerarAleatorio(tamanho);
        int[] ordenado = gerarOrdenado(tamanho);
        int[] invertido = gerarInvertido(tamanho);

        String[] algoritmos = {"Bubble Sort", "Seleção Direta", "Inserção Direta"};

        System.out.println("===== Vetor Aleatório (" + tamanho + " elementos) =====");
        for (String alg : algoritmos) {
            medirTempo(alg, aleatorio);
        }

        System.out.println("\n===== Vetor Ordenado (" + tamanho + " elementos) =====");
        for (String alg : algoritmos) {
            medirTempo(alg, ordenado);
        }

        System.out.println("\n===== Vetor Invertido (" + tamanho + " elementos) =====");
        for (String alg : algoritmos) {
            medirTempo(alg, invertido);
        }
    }
}