import java.util.Stack;

public class TrabalhoParte1 {

    /*
    OBSERVAÇÕES: A solução tem que verificar 3 casos:
    1. Verificar quando abre e fecha com delimitadores diferentes. Exemplo: {(2 + 4} + 9)
    2. Verificar quando um delimitador é aberto e não é fechado. Exemplo: (2 + 1
    3. Verificar quando um delimitador é fechado sem abertura. Exemplo: (2 x 8)]
    E se caso não houver delimitadores, a função deverá dizer que é uma expressão válida
     */

    public static boolean verificar(String expressao) {
        Stack<Character> pilha = new Stack<>(); // o uso do Character vai fazer com que a pilha guarde somente caracteres

        // Percorre a expressão caractere por caractere
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i); // o caracter "c" irá guardar e adicionar o delimitador encontrado dentro da pilha

            // Caso 1: abertura -> empilha
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }

            // Caso 2: fechamento -> confere com o topo
            else if (c == ')' || c == ']' || c == '}') {

                // Fechou sem ter aberto nada
                if (pilha.isEmpty()) {
                    return false;
                }

                char topo = pilha.pop(); // remove a última abertura

                // O topo precisa ser o par do caractere atual
                if (!combina(topo, c)) {
                    return false;
                }
            }
        }

        // No final, se sobrou abertura sem fechar, está errada
        return pilha.isEmpty();
    }

    // Diz se a abertura e o fechamento formam um par
    private static boolean combina(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')')
                || (abertura == '[' && fechamento == ']')
                || (abertura == '{' && fechamento == '}');
    }

    public static void main(String[] args) {
        String[] testes = {
                "{[(3 + 2) * 4] - 1}",   // válida
                "(3 + [2 * 4)]",         // tipos diferentes
                "((3 + 2)",              // falta fechar
                "3 + 2)",                // fecha sem abrir
                "7 * 5"                  // sem delimitadores (válida)
        };

        for (String expr : testes) {
            String resultado = verificar(expr) ? "VÁLIDA" : "INVÁLIDA";
            System.out.println(expr + " -> " + resultado);
        }
    }
}