import java.util.Scanner;

public class Task4 {
    public static boolean isOptimal(int[] weights, int days, int capacity) {
        int currentDays = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                currentDays++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return currentDays <= days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int weightsLength = sc.nextInt();
        int[] weights = new int[weightsLength];

        int maxWeight = 0;
        int sumOfAllElements = 0;

        for (int i = 0; i < weightsLength; i++) {
            weights[i] = sc.nextInt();
            if (weights[i] > maxWeight) maxWeight = weights[i];
            sumOfAllElements += weights[i];
        }

        int days = sc.nextInt();

        int lowerLimit = maxWeight;
        int upperLimit = sumOfAllElements;
        int result = upperLimit;

        while (lowerLimit <= upperLimit) {
            int midCapacity = lowerLimit + (upperLimit - lowerLimit) / 2;

            if (isOptimal(weights, days, midCapacity)) {
                result = midCapacity;
                upperLimit = midCapacity - 1;
            } else {
                lowerLimit = midCapacity + 1;
            }
        }

        System.out.println(result);
    }
}