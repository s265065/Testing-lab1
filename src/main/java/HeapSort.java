import java.util.Arrays;

public class HeapSort {

    private static void buildheap(int []arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            shiftDown(arr, i, arr.length - 1);
        }
    }

    private static void shiftDown(int[] arr, int i, int size) {

        while (true){

            System.out.println(Arrays.toString(arr));

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int max;

            if (left <= size && arr[left] > arr[i]) {
                max = left;
            } else {
                max = i;
            }

            if (right <= size && arr[right] > arr[max]) {
                max=right;
            }
            if (max != i) {
                swap(arr, i, max);
                i = max;
                continue;
            }
            break;
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int[] heapSort(int[] arr) {

        buildheap(arr);
        int sizeOfHeap = arr.length - 1;
        for (int i = sizeOfHeap; i > 0; i--) {
            swap(arr, 0, i);
            sizeOfHeap = sizeOfHeap - 1;
            shiftDown(arr, 0, sizeOfHeap);
        }
        return arr;
    }

}
