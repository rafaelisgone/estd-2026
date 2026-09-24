import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();

        // Insere elementos
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Pilha: " + pilha);

        // Consulta topo
        System.out.println("Topo: " + pilha.peek());

        // Remove elemento
        System.out.println("Removido: " + pilha.pop());
        
        System.out.println("Pilha final: " + pilha);
    }
}