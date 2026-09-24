import java.util.ArrayDeque;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {
        Queue<Integer> fila = new ArrayDeque<>();

        // Insere elementos
        fila.add(10);
        fila.add(20);
        fila.add(30);

        System.out.println("Fila: " + fila);

        // Remove elemento
        System.out.println("Removido: " + fila.poll());

        // Consulta o primeiro
        System.out.println("Primeiro elemento: " + fila.peek());

        System.out.println("Fila final: " + fila);
    }
}