import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class FilaIntercalada {

    public static Queue<Integer> intercalar(Queue<Integer> fila1, Queue<Integer> fila2) {
        // cria a pilha onde vai ser guardado os elementos intercalados
        Queue<Integer> resultado = new ArrayDeque<>();

        // aqui diz que, enquanto NÃO estiver vazio, ele vai repetir (! troca o sinal)
        while (!fila1.isEmpty() || !fila2.isEmpty()) {
            // aqui, ele fica verificando se ainda tem algum elemento, se tiver, ele remove
            // do fila1 e coloca no resultado, a mesma coisa acontece no if de baixo
            if (!fila1.isEmpty()) {
                resultado.add(fila1.poll());
            }

            if (!fila2.isEmpty()) {
                resultado.add(fila2.poll());
            }

        }

        return resultado;
    }

    public static void main(String[] args) {
        Queue<Integer> fila1 = new ArrayDeque<>();
        Queue<Integer> fila2 = new ArrayDeque<>();

        // Insere elementos da fila1
        fila1.add(10);
        fila1.add(20);
        fila1.add(30);

        // Insere elementos da fila2
        fila2.add(40);
        fila2.add(50);
        fila2.add(60);

        Queue<Integer> resultado = intercalar(fila1, fila2);
        System.out.println("Fila intercalada: " + resultado);
    }
}