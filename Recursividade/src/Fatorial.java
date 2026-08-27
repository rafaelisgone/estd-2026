public class Fatorial {

    public static int fatorial(int num) {
        if (num == 0){
            return 1;
        } else {
            return num * fatorial(num - 1);
        }
    }

    public static void main(String[] args) {
        int x = 4;
        int resposta = fatorial(x);

        System.out.println("O fatorial de " + x + " é: " + resposta);
    }
}