package LeetCode100Days;

import java.util.*;

class DAY39 {

    // Approach 1: Min Heap (Optimal Solution)
    // Time: O(n log k), Space: O(k)
    public int[] sortKSortedArray(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n];

        // Create a min heap of size k+1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first k+1 elements to the heap
        for (int i = 0; i <= k && i < n; i++) {
            minHeap.offer(arr[i]);
        }

        int index = 0;

        // Process remaining elements
        for (int i = k + 1; i < n; i++) {
            result[index++] = minHeap.poll();
            minHeap.offer(arr[i]);
        }

        // Extract remaining elements from heap
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;
    }
}
