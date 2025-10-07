package LeetCode100Days;

import java.util.*;

public class DAY34_Q1493 {

    // -------------------------------
    // METHOD 1: Brute Force (O(n²))
    // -------------------------------
    private static int findMax(int[] nums, int skipIdx) {
        int currentLen = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == skipIdx) continue; // skip one element

            if (nums[i] == 1) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;
            }
        }
        return maxLen;
    }

    public static int longestSubarrayBruteForce(int[] nums) {
        int res = 0;
        int zeros = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                res = Math.max(res, findMax(nums, i));
            }
        }

        // If no zeros, must delete one element
        if (zeros == 0) return nums.length - 1;

        return res;
    }

    // -------------------------------------
    // METHOD 2: Sliding Window (O(n))
    // -------------------------------------
    public static int longestSubarraySlidingWindow(int[] nums) {
        int i = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) zeroCount++;

            // shrink window when more than one zero
            while (zeroCount > 1) {
                if (nums[i] == 0) zeroCount--;
                i++;
            }

            // length after deleting one element
            maxLen = Math.max(maxLen, j - i);
        }

        return maxLen;
    }

    // ----------------------------------------------------
    // METHOD 3: Optimized (Track last zero index) (O(n))
    // ----------------------------------------------------
    public static int longestSubarrayOptimized(int[] nums) {
        int i = 0, j = 0;
        int maxLen = 0;
        int lastZeroIdx = -1;

        while (j < nums.length) {
            if (nums[j] == 0) {
                i = lastZeroIdx + 1;
                lastZeroIdx = j;
            }
            maxLen = Math.max(maxLen, j - i);
            j++;
        }
        return maxLen;
    }

    // -------------------------------
    // MAIN METHOD TO RUN ALL VERSIONS
    // -------------------------------
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println();

        int brute = longestSubarrayBruteForce(nums);
        System.out.println("1️⃣ Brute Force Result: " + brute);

        int sliding = longestSubarraySlidingWindow(nums);
        System.out.println("2️⃣ Sliding Window Result: " + sliding);

        int optimized = longestSubarrayOptimized(nums);
        System.out.println("3️⃣ Optimized Result: " + optimized);
    }
}

