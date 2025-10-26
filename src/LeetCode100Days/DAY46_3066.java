package LeetCode100Days;

import java.util.PriorityQueue;

public class DAY46_3066 {

    public static int findmincnt(int nums[],int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.offer(num);

        }

        int sum =0;

        while(!pq.isEmpty() && pq.peek()<k){

            int x = pq.poll();
            int y = pq.poll();

            int ans = x*2 + y;
            pq.offer(ans);

            sum++;

        }

        return sum;



    }

    public static void main(String[] args) {

        int nums[]={2,10,11,1,3};

        System.out.println(findmincnt(nums,10));

    }
}
