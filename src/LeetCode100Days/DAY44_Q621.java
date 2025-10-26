package LeetCode100Days;

import java.util.*;

public class DAY44_Q621 {

    public static int leastInterval(char[] tasks, int p) {
        // Step 1: Count frequency of each task
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Step 2: Max heap for most frequent tasks first
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        int time = 0;

        // Step 3: Process tasks until all are done
        while (!pq.isEmpty()) {
            int cycle = p + 1;                 // total slots in a cycle
            List<Integer> store = new ArrayList<>(); // store remaining frequencies
            int taskCount = 0;                 // how many tasks we run in this cycle

            // Step 4: Run up to (p + 1) tasks in this cycle
            while (cycle-- > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();   // pick most frequent task
                System.out.println("Running task with frequency " + currentFreq);

                if (currentFreq > 1) {
                    store.add(currentFreq - 1);  // still has more left
                }
                taskCount++;
            }

            // Step 5: Push unfinished tasks back into heap
            for (int remaining : store) {
                pq.offer(remaining);
            }

            // Step 6: Add time
            if (pq.isEmpty()) {
                time += taskCount; // last cycle, only actual tasks
            } else {
                time += (p + 1);   // full cycle including idle time
            }

            System.out.println("After cycle, total time = " + time);
            System.out.println("Heap now = " + pq + "\n");
        }

        return time;
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int p = 2;

        int result = leastInterval(tasks, p);
        System.out.println("Minimum total time to finish all tasks = " + result);
    }
}

