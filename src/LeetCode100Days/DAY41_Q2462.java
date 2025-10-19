package LeetCode100Days;

import java.util.PriorityQueue;

public class DAY41_Q2462 {

    public static int hireWorker(int costs[],int k , int candidate){

        int i=0,j= costs.length-1;

        int hired =0;
        int ans =0;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();


        while(hired<k){

            while (pq1.size()<candidate && i<=j){
                pq1.add(costs[i]);
                i++;
            }

            while (pq2.size()<candidate &j>=i){
                pq2.add(costs[j]);
                j--;
            }

            int min_pq1 = pq1.isEmpty()?Integer.MAX_VALUE:pq1.peek();
            int min_pq2 = pq2.isEmpty()?Integer.MAX_VALUE:pq2.peek();

            if(min_pq1<=min_pq2){
                ans+=pq1.poll();

            }else {
                ans+=pq2.poll();
            }

            hired++;

        }
        return ans;

    }

    public static void main(String[] args) {

        int num[] = {3,2,7,7,1,2};
        System.out.println(hireWorker(num,2,2));
    }
}
