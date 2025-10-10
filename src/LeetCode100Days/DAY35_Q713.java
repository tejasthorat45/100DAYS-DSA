package LeetCode100Days;

public class DAY35_Q713 {

    // ✅ Method 1: Brute Force Approach (O(n^2))
    public static int numSubarrayProductLessThanK_BruteForce(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currProduct = 1;
            for (int j = i; j < n; j++) {
                currProduct *= nums[j];
                if (currProduct < k) {
                    ans++;
                } else {
                    break; // Once product >= k, no need to check further for this i
                }
            }
        }
        return ans;
    }

    // ✅ Method 2: Sliding Window Approach (O(n))
    public static int numSubarrayProductLessThanK_SlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (k <= 1) return 0;

        int i = 0, j = 0;
        int ans = 0;
        int prod = 1;

        while (j < n) {
            prod *= nums[j];

            while (prod >= k) {
                prod /= nums[i];
                i++;
            }

            ans += (j - i + 1);
            j++;
        }

        return ans;
    }

    // ✅ Main method to test both approaches
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        System.out.println("Input Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\nK = " + k);

        int bruteForceResult = numSubarrayProductLessThanK_BruteForce(nums, k);
        int slidingWindowResult = numSubarrayProductLessThanK_SlidingWindow(nums, k);

        System.out.println("\n👉 Brute Force Result: " + bruteForceResult);
        System.out.println("👉 Sliding Window Result: " + slidingWindowResult);
    }
}

