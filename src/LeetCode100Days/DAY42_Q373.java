package LeetCode100Days;

import java.util.*;

class DAY42_Q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Max heap to store pairs: [sum, i, j]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int m = nums1.length;
        int n = nums2.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.offer(new int[]{sum, i, j});
                } else if (pq.peek()[0] > sum) {
                    pq.poll();
                    pq.offer(new int[]{sum, i, j});
                } else {
                    // Breaking from here (slight improvement)
                    break;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
        }

        return result;
    }

    public static void main(String[] args) {
        DAY42_Q373 solution = new DAY42_Q373();

        // Test Case 1
        int[] nums1_1 = {1, 7, 11};
        int[] nums2_1 = {2, 4, 6};
        int k1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_1) +
                ", nums2 = " + Arrays.toString(nums2_1) + ", k = " + k1);
        System.out.println("Output: " + solution.kSmallestPairs(nums1_1, nums2_1, k1));
        System.out.println("Expected: [[1,2],[1,4],[1,6]]");
        System.out.println();

        // Test Case 2
        int[] nums1_2 = {1, 1, 2};
        int[] nums2_2 = {1, 2, 3};
        int k2 = 2;
        System.out.println("Test Case 2:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_2) +
                ", nums2 = " + Arrays.toString(nums2_2) + ", k = " + k2);
        System.out.println("Output: " + solution.kSmallestPairs(nums1_2, nums2_2, k2));
        System.out.println("Expected: [[1,1],[1,1]]");
        System.out.println();

        // Test Case 3
        int[] nums1_3 = {1, 2};
        int[] nums2_3 = {3};
        int k3 = 3;
        System.out.println("Test Case 3:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_3) +
                ", nums2 = " + Arrays.toString(nums2_3) + ", k = " + k3);
        System.out.println("Output: " + solution.kSmallestPairs(nums1_3, nums2_3, k3));
        System.out.println("Expected: [[1,3],[2,3]]");
    }
}

// Time Complexity: O(m*n*log(k)) in worst case, but with early break optimization
// Space Complexity: O(k)
// Note: This uses max heap to maintain k smallest pairs
