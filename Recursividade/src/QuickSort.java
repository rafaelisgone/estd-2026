import java.util.Arrays;

public class QuickSort {

    public static void quick(int[] array, int left, int right){
        int i = left;
        int j = right;
        int aux;
        int pivotidx = (left + right) / 2;
        int pivot = array[pivotidx];

        // partição
        while (i <= j){
            while(array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i <= j){
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;
                i++;
                j--;
            }
        }

        // recursão
        if (left < j){
            quick(array, left, j);
        }
        if (i < right){
            quick(array, i, right);
        }
    }

    public static void main(String[] args){
        int[] vet = {77, 44, 22, 33, 99, 55, 66, 11, 88};
        quick(vet, 0, vet.length - 1);
        System.out.println(Arrays.toString(vet));
    }
}
