package LeetCode100Days;

import java.util.*;

public class DAY36_Q2958 {

    // ✅ Sliding Window + HashMap Solution
    public static int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int n = nums.length;
        int ans = 0;

        while (j < n) {
            // Add current element to map
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // If current element frequency exceeds k → shrink window
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]); // ✅ Clean map
                }
                i++;
            }

            // Update max window length
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }

    // ✅ Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;

        int result = maxSubarrayLength(nums, k);
        System.out.println("Length of Longest Subarray = " + result);
    }
}

