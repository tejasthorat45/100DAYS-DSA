package LeetCode100Days;

import java.util.*;

public class DAY35_Q239 {

    // ---------- Method 1: Brute Force (O(n*k)) ----------
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int currMax = nums[i];
            for (int j = i; j < i + k; j++) {
                currMax = Math.max(currMax, nums[j]);
            }
            res[i] = currMax;
        }
        return res;
    }

    // ---------- Method 2: Optimized Deque (O(n)) ----------
    public static int[] maxSlidingWindowOptimized(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Step 1: Remove out-of-window elements
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // Step 2: Remove smaller elements from back
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            // Step 3: Add current index
            dq.offerLast(i);

            // Step 4: Record max for current window
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }

    // ---------- Main Method ----------
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Window size k = " + k);

        // Brute Force result
        int[] bruteResult = maxSlidingWindowBruteForce(nums, k);
        System.out.println("Brute Force Result:   " + Arrays.toString(bruteResult));

        // Optimized Deque result
        int[] optimizedResult = maxSlidingWindowOptimized(nums, k);
        System.out.println("Optimized Deque Result: " + Arrays.toString(optimizedResult));
    }
}

