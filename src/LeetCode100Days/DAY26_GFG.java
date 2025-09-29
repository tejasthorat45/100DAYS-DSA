package LeetCode100Days;

import java.util.*;

public class DAY26_GFG {

    // Brute Force Method (O(n*k))
    static List<Integer> firstNegIntBruteForce(int arr[], int k) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            int firstneg = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    firstneg = arr[j];
                    break; // stop at first negative
                }
            }
            res.add(firstneg);
        }
        return res;
    }

    // Optimal Method using Deque (O(n))
    static List<Integer> firstNegIntOptimal(int arr[], int k) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        int i = 0, j = 0;
        while (j < n) {
            if (arr[j] < 0) {
                dq.addLast(arr[j]);
            }

            if (j - i + 1 == k) {
                int neg = dq.isEmpty() ? 0 : dq.peekFirst();
                res.add(neg);

                // Slide the window
                if (arr[i] < 0 && !dq.isEmpty()) {
                    dq.removeFirst();
                }
                i++;
            }
            j++;
        }
        return res;
    }

    // Main Method for Testing
    public static void main(String[] args) {
        int arr1[] = {-8, 2, 3, -6, 10};
        int k1 = 2;

        int arr2[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k2 = 3;

        int arr3[] = {12, 1, 3, 5};
        int k3 = 3;

        System.out.println("Brute Force:");
        System.out.println(firstNegIntBruteForce(arr1, k1)); // [-8, 0, -6, -6]
        System.out.println(firstNegIntBruteForce(arr2, k2)); // [-1, -1, -7, -15, -15, 0]
        System.out.println(firstNegIntBruteForce(arr3, k3)); // [0, 0]

        System.out.println("\nOptimal (Deque):");
        System.out.println(firstNegIntOptimal(arr1, k1)); // [-8, 0, -6, -6]
        System.out.println(firstNegIntOptimal(arr2, k2)); // [-1, -1, -7, -15, -15, 0]
        System.out.println(firstNegIntOptimal(arr3, k3)); // [0, 0]
    }
}

