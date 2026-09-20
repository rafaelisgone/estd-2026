import java.util.Arrays;
import java.util.Random;

public class Trabalho1B {

    // <<<<< MÉTODOS DE ORDENAÇÃO >>>>>
    public static void bubbleSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
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
                int aux = vetor[i];
                vetor[i] = vetor[posicaoMenor];
                vetor[posicaoMenor] = aux;
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

    public static void quickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int aux;
        int pivotidx = (left + right) / 2;
        int pivot = array[pivotidx];

        // partição
        while (i <= j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i <= j) {
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;
                i++;
                j--;
            }
        }

        // recursão
        if (left < j) {
            quickSort(array, left, j);
        }
        if (i < right) {
            quickSort(array, i, right);
        }
    }

    // <<<<< GERAÇÃO DE VETORES >>>>>
    public static int[] gerarAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(100);
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

    // <<<<< MEDIDOR DE TEMPO >>>>>
    public static void medirTempo(String nomeAlgoritmo, int[] vetorOriginal) {
        // cria uma cópia do vetor original para aplicar nos outros vetores
        int[] copia = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
        // guarda o tempo antes de começar a ordenação
        long inicio = System.nanoTime();

        // aqui é onde a ordenação de fato acontece. O switch compara a String nomeAlgoritmo
        // recebida como parâmetro e decide qual método de ordenação chamar sobre a copia
        switch (nomeAlgoritmo) {
            case "Bubble Sort":
                bubbleSort(copia); break;

            case "Seleção Direta":
                selecaoDireta(copia); break;

            case "Inserção Direta":
                insercaoDireta(copia); break;

            case "Quicksort":
                quickSort(copia, 0, copia.length - 1); break;
        }

        // guarda o tempo depois que a ordenação terminou
        long fim = System.nanoTime();
        // calcula o tempo em nanossegundos
        long duracaoMs = (fim - inicio) / 1_000_000;

        System.out.println(nomeAlgoritmo + ": " + duracaoMs + " ms.");
    }

    // <<<<< MAIN >>>>>
    public static void main(String[] args) {
        // aqui é criado um vetor de tamanhos que será percorrido pelo for de baixo
        int[] tamanhos = {100, 1000, 10000, 100000};

        for (int tamanho : tamanhos) { // aqui
            System.out.println("========================================");
            System.out.println("TAMANHO DO VETOR: " + tamanho);
            System.out.println("========================================");

            // aqui cada vetor recebe o tamanho do vetor de cima, dependendo do indice
            int[] aleatorio = gerarAleatorio(tamanho);
            int[] ordenado = gerarOrdenado(tamanho);
            int[] invertido = gerarInvertido(tamanho);

            System.out.println("--- Ordem Crescente ---");
            medirTempo("Bubble Sort", ordenado);
            medirTempo("Seleção Direta", ordenado);
            medirTempo("Inserção Direta", ordenado);
            medirTempo("Quicksort", ordenado);

            System.out.println("--- Ordem Decrescente ---");
            medirTempo("Bubble Sort", invertido);
            medirTempo("Seleção Direta", invertido);
            medirTempo("Inserção Direta", invertido);
            medirTempo("Quicksort", invertido);

            System.out.println("--- Ordem Aleatória ---");
            medirTempo("Bubble Sort", aleatorio);
            medirTempo("Seleção Direta", aleatorio);
            medirTempo("Inserção Direta", aleatorio);
            medirTempo("Quicksort", aleatorio);

            System.out.println(); // cada vez que o vetor termina, ele é percorrido novamente,
            // porém com um tamanho diferente para fazer os testes
        }
    }
}