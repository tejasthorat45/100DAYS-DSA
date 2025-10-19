package LeetCode100Days;

import java.util.*;

class DAY43_Q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // int m = nums1.length;
        // int n = nums2.length;

        // //define max Heap

        // PriorityQueue<int[]> pq = new PriorityQueue<>(
        //     (a,b)-> b[0]-a[0]
        // );


        //done
        // for(int i=0;i<m;i++){

        //     for(int j=0;j<n;j++){

        //         int sum = nums1[i]+nums2[j];

        //         if(pq.size()<k){
        //             pq.offer(new int[]{sum,i,j});
        //         }else if(pq.peek()[0]>sum){
        //             pq.poll();
        //             pq.add(new int[]{sum,i,j});
        //         }else{
        //             break;
        //         }
        //     }
        // }

        // List<List<Integer>> res = new ArrayList<>();

        // while(!pq.isEmpty()){
        //     int [] temp = pq.poll();

        //     int i=temp[1];
        //     int j = temp[2];

        //     res.add(Arrays.asList(nums1[i],nums2[j]));
        // }

        // return res;

        //better approach

        int m = nums1.length;
        int n = nums2.length;

        // Define MIN Heap (not max heap for this approach!)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> a[0] - b[0]  // Changed: a[0]-b[0] for MIN heap
        );

        Set<String> visited = new HashSet<>();

        // Add to priority queue
        int sum = nums1[0] + nums2[0];
        pq.offer(new int[]{sum, 0, 0});
        visited.add("0,0");

        // Storing result
        List<List<Integer>> res = new ArrayList<>();

        while(k-- > 0 && !pq.isEmpty()){  // Added: > 0 for clarity

            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));  // Fixed: Arrays.asList

            // Push (i, j+1)
            if(j + 1 < n && !visited.contains(i + "," + (j + 1))){
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));  // Fixed: visited.add()
            }

            // Same for (i+1, j)
            if(i + 1 < m && !visited.contains((i + 1) + "," + j)){
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add((i + 1) + "," + j);  // Fixed: visited.add()
            }
        }

        return res;
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
        System.out.println("Expected: [[1,2], [1,4], [1,6]]");
        System.out.println();

        // Test Case 2
        int[] nums1_2 = {1, 1, 2};
        int[] nums2_2 = {1, 2, 3};
        int k2 = 2;
        System.out.println("Test Case 2:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_2) +
                ", nums2 = " + Arrays.toString(nums2_2) + ", k = " + k2);
        System.out.println("Output: " + solution.kSmallestPairs(nums1_2, nums2_2, k2));
        System.out.println("Expected: [[1,1], [1,1]]");
        System.out.println();

        // Test Case 3
        int[] nums1_3 = {1, 2};
        int[] nums2_3 = {3};
        int k3 = 3;
        System.out.println("Test Case 3:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_3) +
                ", nums2 = " + Arrays.toString(nums2_3) + ", k = " + k3);
        System.out.println("Output: " + solution.kSmallestPairs(nums1_3, nums2_3, k3));
        System.out.println("Expected: [[1,3], [2,3]]");
        System.out.println();

        // Test Case 4 - Larger example
        int[] nums1_4 = {1, 2, 4, 5, 6};
        int[] nums2_4 = {3, 5, 7, 9};
        int k4 = 5;
        System.out.println("Test Case 4:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_4) +
                ", nums2 = " + Arrays.toString(nums2_4) + ", k = " + k4);
        System.out.println("Output: " + solution.kSmallestPairs(nums1_4, nums2_4, k4));
        System.out.println("Expected: [[1,3], [2,3], [1,5], [4,3], [2,5]]");
        System.out.println();

        // Test Case 5 - Edge case
        int[] nums1_5 = {1};
        int[] nums2_5 = {1};
        int k5 = 1;
        System.out.println("Test Case 5:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_5) +
                ", nums2 = " + Arrays.toString(nums2_5) + ", k = " + k5);
        System.out.println("Output: " + solution.kSmallestPairs(nums1_5, nums2_5, k5));
        System.out.println("Expected: [[1,1]]");
    }
}

// Time Complexity: O(k log k)
// Space Complexity: O(k)