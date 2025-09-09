package LeetCode100Days;

import java.util.*;

public class Day8_Q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        if (nums == null || n < 3) return new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Day8_Q15 sol = new Day8_Q15();

        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = sol.threeSum(nums);

        System.out.println("Triplets that sum to 0:");
        for (List<Integer> triplet : ans) {
            System.out.println(triplet);
        }
    }
}
