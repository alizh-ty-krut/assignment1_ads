import java.util.Scanner;

public class Task3 {
    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start) return;

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        int j = start;
        int temp = 0;

        for (; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayLength = sc.nextInt();
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) arr[i] = sc.nextInt();

        quickSort(arr, 0, arrayLength - 1);

        if (arrayLength % 2 == 1) System.out.println(arr[arrayLength / 2]);
        else System.out.println((arr[arrayLength / 2 - 1] + arr[arrayLength / 2]) / 2);
    }
}
