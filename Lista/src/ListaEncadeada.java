public class ListaEncadeada<T> {

    private static class No<T> {
        public T dado;        // valor guardado neste nó
        public No<T> proximo; // próximo nó

        public No(T valor) {
            dado = valor;
            proximo = null;
        }
    }

    private No<T> inicio;

    // quantidade de elementos
    private int tamanho;

    // cria uma lista vazia
    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }

    // adiciona elementos
    public void adicionar(T valor) {
        // cria o nó que vai guardar o valor
        No<T> novoNo = new No<>(valor);
        No<T> atual;

        if (inicio == null) {
            // se a lista estiver vazia, o novo nó será o primeiro elemento
            inicio = novoNo;
        } else {
            // começa pelo primeiro nó caso já tenha elementos
            atual = inicio;

            // Ipercorre até o ÚLTIMO nó, ou seja,
            // aquele cujo "proximo" é null (por isso não é "atual != null")
            while (atual.proximo != null) {
                atual = atual.proximo; // avança um nó
            }

            // liga o último nó ao novo, que vira o novo último
            atual.proximo = novoNo;
        }

        tamanho++;
    }

    // exibe a lista
    public String imprimir() {
        String texto = ""; // cria a mensagem
        No<T> atual = inicio;

        // enquanto o atual não estiver vazio...
        while (atual != null) {
            texto += atual.dado + " -> "; // a mensagem irá receber o atual e a seta para continuar
            atual = atual.proximo; // passa para o próximo
        }

        return texto + "fim."; // quando a repetição chegar ao fim
    }

    // remove o primeiro elemento da lista
    public String removerPrimeiroElemento() {
        if (inicio == null) {
            return "Lista vazia, nada para remover.";
        }

        T removido = inicio.dado;  // guarda o dado antes de perder o nó
        inicio = inicio.proximo;   // o segundo nó passa a ser o primeiro
        tamanho--;                 // um elemento a menos

        return removido + " removido com sucesso.";
    }

    // adiciona um nó no começo da lista
    public void adicionarNoInicio(T valor) {
        No<T> novoNo = new No<>(valor);

        novoNo.proximo = inicio; // o novo nó aponta para o antigo primeiro
        inicio = novoNo;         // o novo nó passa a ser o primeiro

        tamanho++;               // um elemento a mais
    }

    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();

        lista.adicionar("3");
        lista.adicionar("5");
        lista.adicionar("10");

        System.out.println("Lista = " + lista.imprimir());

        System.out.println(lista.removerPrimeiroElemento());

        System.out.println("Lista = " + lista.imprimir());

        System.out.println(lista.removerPrimeiroElemento());

        System.out.println("Lista = " + lista.imprimir());
    }
}