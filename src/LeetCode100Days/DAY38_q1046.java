package LeetCode100Days;
import java.util.*;
public class DAY38_q1046 {

   // import java.util.*;



        // -----------------------------------------------
        // 1️⃣ SORT-BASED APPROACH (Your version)
        // -----------------------------------------------
        public static int lastStoneWeightSort(int[] stones) {
            Arrays.sort(stones);
            int i = stones.length - 1;

            while (i > 0) {
                if (stones[i] == stones[i - 1]) {
                    if (i == 1) {
                        return 0; // both destroyed, no stones left
                    }
                    i = i - 2; // skip both
                } else if (stones[i] > stones[i - 1]) {
                    int temp = stones[i - 1];
                    stones[i - 1] = stones[i] - temp; // replace with difference
                    Arrays.sort(stones); // sort again after smashing
                    i--; // move pointer left
                }
            }
            return stones[0];
        }

        // -----------------------------------------------
        // 2️⃣ PRIORITY QUEUE (MAX HEAP) APPROACH (Efficient)
        // -----------------------------------------------
        public static int lastStoneWeightHeap(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            // Add all stones into max heap
            for (int s : stones) pq.add(s);

            // Keep smashing until ≤1 stone left
            while (pq.size() > 1) {
                int y = pq.poll(); // heaviest
                int x = pq.poll(); // second heaviest

                if (y != x) pq.add(y - x); // push difference
            }

            // Return last stone or 0
            return pq.isEmpty() ? 0 : pq.poll();
        }

        // -----------------------------------------------
        // 🧪 MAIN METHOD (Test both)
        // -----------------------------------------------
        public static void main(String[] args) {
            int[] stones = {2, 7, 4, 1, 8, 1};

            // Clone array since sorting modifies it
            int[] stonesCopy = stones.clone();

            System.out.println("Using Sort-based approach: " + lastStoneWeightSort(stones));
            System.out.println("Using Max Heap approach: " + lastStoneWeightHeap(stonesCopy));
        }


}
