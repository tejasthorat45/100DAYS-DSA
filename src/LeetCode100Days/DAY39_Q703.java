package LeetCode100Days;

import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int K;

    public KthLargest(int k, int[] nums) {
        K = k;

        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > K) {
            pq.poll();
        }

        return pq.peek();
    }
}

public class DAY39_Q703 {
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("Initial kth largest: " + kthLargest.pq.peek());

        System.out.println("add(3): " + kthLargest.add(3));   // returns 4
        System.out.println("add(5): " + kthLargest.add(5));   // returns 5
        System.out.println("add(10): " + kthLargest.add(10)); // returns 5
        System.out.println("add(9): " + kthLargest.add(9));   // returns 8
        System.out.println("add(4): " + kthLargest.add(4));   // returns 8

        System.out.println("\nTest Case 2:");
        KthLargest kthLargest2 = new KthLargest(1, new int[]{});
        System.out.println("add(-3): " + kthLargest2.add(-3)); // returns -3
        System.out.println("add(-2): " + kthLargest2.add(-2)); // returns -2
        System.out.println("add(-4): " + kthLargest2.add(-4)); // returns -2
        System.out.println("add(0): " + kthLargest2.add(0));   // returns 0
        System.out.println("add(4): " + kthLargest2.add(4));   // returns 4

        System.out.println("\nTest Case 3:");
        KthLargest kthLargest3 = new KthLargest(2, new int[]{0});
        System.out.println("add(-1): " + kthLargest3.add(-1)); // returns -1
        System.out.println("add(1): " + kthLargest3.add(1));   // returns 0
        System.out.println("add(-2): " + kthLargest3.add(-2)); // returns 0
        System.out.println("add(-4): " + kthLargest3.add(-4)); // returns 0
        System.out.println("add(3): " + kthLargest3.add(3));   // returns 1
    }
}
