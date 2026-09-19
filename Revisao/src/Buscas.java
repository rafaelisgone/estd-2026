import java.util.Arrays;
import java.util.Scanner;

public class Buscas {

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

    // busca binária
    public static int buscaBinaria(int[] vetor, int inicio, int fim, int numeroProcurado) {
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == numeroProcurado) {
                return meio;
            } else if (vetor[meio] < numeroProcurado) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    // busca binaria (recursiva)
    public static int buscaBinariaRecursiva(int[] vetor, int inicio, int fim, int numeroProcurado) {
        if (inicio > fim) {
            return -1;
        }

        int meio = (inicio + fim) / 2;

        if (vetor[meio] == numeroProcurado) {
            return meio;
        } else if (vetor[meio] < numeroProcurado) {
            return buscaBinariaRecursiva(vetor, meio + 1, fim, numeroProcurado);
        } else {
            return buscaBinariaRecursiva(vetor, inicio, meio - 1, numeroProcurado);
        }
    }

    // medidor de tempo - busca sequencial
    public static void medirTempoSequencial(int[] vetor, int numeroProcurado) {
        long inicio = System.nanoTime();
        int resultado = buscaSequencial(vetor, numeroProcurado);
        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1_000_000;

        System.out.println("\n--- Busca Sequencial ---");
        if (resultado != -1) {
            System.out.println("Número encontrado na posição " + resultado + ".");
        } else {
            System.out.println("Número não encontrado.");
        }
        System.out.println("Tempo de execução: " + duracaoMs + " ms.");
    }

    // medidor de tempo - busca binaria (iterativa)
    public static void medirTempoBinaria(int[] vetor, int numeroProcurado) {
        long inicio = System.nanoTime();
        int resultado = buscaBinaria(vetor, 0, vetor.length - 1, numeroProcurado);
        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1_000_000;

        System.out.println("\n--- Busca Binária (não recursiva) ---");
        if (resultado != -1) {
            System.out.println("Número encontrado na posição " + resultado + ".");
        } else {
            System.out.println("Número não encontrado.");
        }
        System.out.println("Tempo de execução: " + duracaoMs + " ms.");
    }

    // medidor de tempo - busca binaria (recursiva)
    public static void medirTempoBinariaRecursiva(int[] vetor, int numeroProcurado) {
        long inicio = System.nanoTime();
        int resultado = buscaBinariaRecursiva(vetor, 0, vetor.length - 1, numeroProcurado);
        long fim = System.nanoTime();
        long duracaoMs = (fim - inicio) / 1_000_000;

        System.out.println("\n--- Busca Binária (recursiva) ---");
        if (resultado != -1) {
            System.out.println("Número encontrado na posição " + resultado + ".");
        } else {
            System.out.println("Número não encontrado.");
        }
        System.out.println("Tempo de execução: " + duracaoMs + " ms.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tam = 100000;
        int[] vetor = new int[tam];

        gerarVetor(vetor);

        System.out.println("============ VETORZINHO ============");
        System.out.println(Arrays.toString(vetor));

        System.out.println("\nQual número você deseja procurar?");
        int numeroProcurado = sc.nextInt();

        medirTempoSequencial(vetor, numeroProcurado);
        medirTempoBinaria(vetor, numeroProcurado);
        medirTempoBinariaRecursiva(vetor, numeroProcurado);
    }
}