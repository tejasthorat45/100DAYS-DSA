package LeetCode100Days;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
public class DAY38_Q1962 {

    public static int removeStone(int piles[],int k){


        //max element every time in maxheap

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        int n = piles.length;
        int sum =0;

        for(int i=0;i<n;i++){
            sum+=piles[i];
            maxheap.add(piles[i]);

        }

        //step 2 -->doing operation maxelem /2 and - from sum

        for (int i=1;i<=k;i++){

            int max_ele = maxheap.peek();
            maxheap.poll();

            int remove = max_ele/2;

            sum-=remove;
            max_ele-=remove;
            maxheap.add(max_ele);

        }

        return sum;


    }


    public static void main(String[] args) {

        int piles[] ={4,3,6,7};

        System.out.println(removeStone(piles,3));

    }
}
