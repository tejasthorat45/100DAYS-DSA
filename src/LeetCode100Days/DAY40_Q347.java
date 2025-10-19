package LeetCode100Days;

import java.util.*;

public class DAY40_Q347 {

    //using heap

    public static int[] usingMinHeap(int nums[],int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //step 2 create min heaeap -> store decending order

        PriorityQueue<int[]> minheap = new PriorityQueue<>(
                (a,b)->a[1]-b[1]
        );

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minheap.add(new int[]{entry.getKey(), entry.getValue()});

            if (minheap.size()>k){
                minheap.poll();
            }
        }

        //build the res
        int res[] = new int[k];

        int i=0;

        while (!minheap.isEmpty()){

            res[i++] = minheap.poll()[0];
        }

        return res;
    }
    //top k freq elemnt
    public static int[] Optimal(int nums[],int k){

        //step cal frewq;
        Map<Integer,Integer> map = new HashMap<>();

        for (int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        // store in bucket

        List<Integer>[] bucket = new List[nums.length+1];

        for(int key : map.keySet()){

            int freq = map.get(key);

            if(bucket[freq]==null){

                bucket[freq]= new ArrayList<>();

            }

            bucket[freq].add(key);


        }

        //gets the res;

        int res[] = new int[k];
        int idx=0;

        for(int i= bucket.length-1;i>=0 && idx<k;i--){

            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    res[idx]=num;
                    if(idx==k){
                        return res;
                    }
                }
            }
        }

        return res;



    }

    public static void main(String[] args) {
        int num[]={1,1,1,3,2,2,};
        System.out.println(Optimal(num,2));
        System.out.println(usingMinHeap(num,2));

    }
}
