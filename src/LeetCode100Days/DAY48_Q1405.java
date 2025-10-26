package LeetCode100Days;

import java.util.PriorityQueue;

import java.util.*;

public class DAY48_Q1405 {

    public String longestDiverseString(int a, int b, int c) {

        // Create a max heap storing {count, char}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (x, y) -> y[0] - x[0] // descending order by frequency
        );

        if (a > 0) pq.offer(new int[]{a, 'a'});
        if (b > 0) pq.offer(new int[]{b, 'b'});
        if (c > 0) pq.offer(new int[]{c, 'c'});

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            int[] first = pq.poll(); // most frequent char
            int len = sb.length();

            // Check if last two characters are the same
            if (len >= 2 && sb.charAt(len - 1) == first[1] && sb.charAt(len - 2) == first[1]) {

                // If heap is empty, break
                if (pq.isEmpty()) break;

                // Use the next best character
                int[] second = pq.poll();
                sb.append((char) second[1]);
                second[0]--;

                // Reinsert if still available
                if (second[0] > 0) pq.offer(second);

                // Put first back for later
                pq.offer(first);

            } else {
                sb.append((char) first[1]);
                first[0]--;
                if (first[0] > 0) pq.offer(first);
            }
        }

        return sb.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        DAY48_Q1405 obj = new DAY48_Q1405();

        System.out.println(obj.longestDiverseString(1, 1, 7)); // Example 1
        System.out.println(obj.longestDiverseString(2, 2, 1)); // Example 2
        System.out.println(obj.longestDiverseString(7, 1, 0)); // Example 3
    }
}
