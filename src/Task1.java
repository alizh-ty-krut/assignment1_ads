/*
       .-----------.
      /_ _ _ _ _ _ _\
     (    _   _      )
      )  ( ) ( )    (
     (   _ _ _ _     )
      '-------------'
      |             |  ___
      |             | /   \
      |   П И В О   |/  _  \
      |             |  / \  |
      |             |  \_/  |
      |             |\     /
      |             | \___/
      |             |
      '-------------'
*/

import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    public static void quickSort(char[] word, int start, int end) {
        if (end <= start) return;

        int pivot = partition(word, start, end);
        quickSort(word, start, pivot - 1);
        quickSort(word, pivot + 1, end);
    }

    public static int partition(char[] word, int start, int end) {
        char pivot = word[end];
        int i = start - 1;
        int j = start;
        char temp = 'a';

        for (; j <= end - 1; j++) {
            if (word[j] < pivot) {
                i++;
                temp = word[i];
                word[i] = word[j];
                word[j] = temp;
            }
        }
        i++;
        temp = word[i];
        word[i] = word[end];
        word[end] = temp;

        return i;
    }

    public static boolean areEqual(char[] arr1, char[] arr2) {
        if (arr1 == null && arr2 != null || arr2 == null && arr1 != null) return false;

        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string1 = sc.nextLine();
        String string2 = sc.nextLine();

        char[] char1 = string1.toCharArray();
        char[] char2 = string2.toCharArray();

        quickSort(char1, 0, char1.length - 1);
        quickSort(char2, 0, char2.length - 1);

        if (areEqual(char1, char2)) System.out.println("YES");
        else System.out.println("NO");
    }
}