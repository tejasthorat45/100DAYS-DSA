package LeetCode100Days;
// two sum

import java.util.HashMap;
import java.util.Map;

public class DAY8_Q1 {

    // brute force O(n^2)
    public static int[] solution1(int nums[], int tar) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == tar) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // no solution
    }

    // optimal solution using HashMap O(n)
    public static int[] OptimalSolution(int nums[], int tar) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = tar - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int tar = 9;

        int ans1[] = solution1(nums, tar);       // brute force
        int ans2[] = OptimalSolution(nums, tar); // optimal

        System.out.print("Brute Force Output: ");
        for (int num : ans1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Optimal Output: ");
        for (int num : ans2) {
            System.out.print(num + " ");
        }
    }
}
