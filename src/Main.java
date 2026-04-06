import java.util.Scanner;

public class Main {
    public static int sumSquares(int n) { // O(n)
        if (n == 1) return 1;

        return n * n + sumSquares(n - 1);
    }

    public static int sumArray(int[] arr, int n) {
        if (n == 0) return 0;

        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static long sumOfPowers(int b, int n) {
        if (n == 0) return 1;
        return (long) Math.pow(b, n) + sumOfPowers(b, n - 1);
    }

    public static void printReverse(Scanner sc, int n) {
        if (n == 0) return;
        int num = sc.nextInt();
        printReverse(sc, n - 1);
        System.out.print(num + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("task 1:");
        int n1 = sc.nextInt();
        System.out.println(sumSquares(n1));

        System.out.println("task 2:");
        int n2 = sc.nextInt();
        int[] arr = new int[n2];
        for (int i = 0; i < n2; i++) arr[i] = sc.nextInt();
        System.out.println(sumArray(arr, n2));

        System.out.println("task 3:");
        int b = sc.nextInt();
        int n3 = sc.nextInt();
        System.out.println(sumOfPowers(b, n3));

        System.out.println("task 4:");
        int n4 = sc.nextInt();
        printReverse(sc, n4);
        System.out.println();

        sc.close();
    }
}