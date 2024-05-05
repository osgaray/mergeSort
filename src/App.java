public class App {
    // Método de ordenamiento MergeSort
    public static void mergeSort(int[] arr, int left, int right) {
        // Si el subarray tiene más de un elemento
        if (left < right) {
            // Encuentra el punto medio del subarray
            int mid = (right + left) / 2;

            // Ordena recursivamente la mitad izquierda del subarray
            mergeSort(arr, left, mid);
            // Ordena recursivamente la mitad derecha del subarray
            mergeSort(arr, mid + 1, right);

            // Combina las dos mitades ordenadas del subarray
            merge(arr, left, mid, right);
        }
    }

    // Método para fusionar dos subarreglos ordenados
    public static void merge(int[] arr, int left, int mid, int right) {
        // Calcula los tamaños de los subarreglos a fusionar
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Crea arreglos temporales para almacenar los subarreglos
        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];

        // Copia los elementos a los arreglos temporales
        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            tempRight[j] = arr[mid + 1 + j];
        }

        // Fusiona los subarreglos temporales en el arreglo original
        int i = 0, j = 0;
        int k = left; // Índice inicial para el arreglo fusionado

        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de tempLeft, si los hay
        while (i < sizeLeft) {
            arr[k] = tempLeft[i];
            k++;
            i++;
        }

        // Copia los elementos restantes de tempRight, si los hay
        while (j < sizeRight) {
            arr[k] = tempRight[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) throws Exception {
        // Crea un arreglo desordenado
        int[] arr = { 35, 28, 92, 52, 76, 45, 13, 85, 12 };
        int n = arr.length;

        // Imprime el arreglo desordenado
        System.out.println("Arreglo desordenado");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Llama al método de ordenamiento MergeSort
        System.out.println();
        mergeSort(arr, 0, n - 1);

        // Imprime el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
