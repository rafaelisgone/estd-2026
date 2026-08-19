import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercicio1 {
    // ler elementos
    public static void lerVetor(int[] vetor) {
        Random aleatorio = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = aleatorio.nextInt(100);
        }
    }

    // soma entre os elementos de dois indices
    public static int somaEntreIndices(int[] vetor, int inicio, int fim) {
        int soma = 0;
        for (int i = inicio; i <= fim; i++) {
            soma = soma + vetor[i];
        }
        return soma;
    }

    // remove o elemento pelo valor
    public static int removerPorValor(int[] vetor, int quantidade, int valor) {
        for (int i = 0; i < quantidade; i++) {
            if (vetor[i] == valor) {
                for (int j = i; j < quantidade - 1; j++) {
                    vetor[j] = vetor[j + 1];
                }
                quantidade--;
                break;
            }
        }
        return quantidade;
    }

    // remove o elemento pelo indice
    public static int removerPorPosicao(int[] vetor, int quantidade, int posicao) {
        for (int i = posicao; i < quantidade - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        quantidade--;
        return quantidade;
    }

    // somar os pares
    public static int somaPares(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                soma += vetor[i];
            }
        }
        return soma;
    }
    public static void main(String[] args) {
        int[] vetor = new int[10];
        int quantidade = vetor.length;
        Scanner entrada = new Scanner(System.in);

        lerVetor(vetor);

        // exibe o vetor
        System.out.println("=================== VETOR ===================");
        System.out.println(Arrays.toString(vetor));

        // mostra a soma dos pares
        int somaPares = somaPares(vetor);
        System.out.println("\nO total da soma de números pares é: "+ somaPares);

        // pergunta sobre a soma dos indices e coleta os dados
        System.out.print("Entre quais índices deseja somar? ");
        int inicio = entrada.nextInt();

        System.out.print("Até qual índice deseja somar? ");
        int fim = entrada.nextInt();

        // exibe a respota
        int resultado = somaEntreIndices(vetor, inicio, fim);
        System.out.println("Soma dos elementos: " + resultado);

        // remover elemento
        System.out.print("Qual valor deseja remover? ");
        int valor = entrada.nextInt();

        quantidade = removerPorValor(vetor, quantidade, valor);
        System.out.println(Arrays.toString(vetor));

        // remove pelo indice
        System.out.print("Qual posição deseja remover? ");
        int posicao = entrada.nextInt();

        quantidade = removerPorPosicao(vetor, quantidade, posicao);
        System.out.println(Arrays.toString(vetor));
    }
}