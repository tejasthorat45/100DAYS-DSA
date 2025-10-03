package LeetCode100Days;


/// count the number Of Nice Subaray

import java.util.HashMap;
import java.util.Map;

public class Day29_Q1248 {

    public static int usingHashMap(int nums[],int k){

        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int res =0, oddcount =0;


        for(int i=0;i<n;i++){

            oddcount += (nums[i]%2);

            if(map.containsKey(oddcount-k)){
                res += map.get(oddcount-k);
            }



            map.put(oddcount,map.getOrDefault(oddcount,0)+1);


        }

        return res;


    }

    public static int slindingWindow(int nums[],int k){

        int res =0 ; int oddCount =0;
        int i=0;
        int j=0;
        int prevCount =0;

        while (j<nums.length){

            if(nums[j]%2 != 0){
                oddCount++;
                prevCount=0;
            }

            while(oddCount==k){

                prevCount++;
                if (i<nums.length && nums[i]%2==1){
                    oddCount--;
                }
                i++;
            }
            res+=prevCount;

            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] ={7,1,2,3,5}; int k =3;
        System.out.println(usingHashMap(nums,k));
        System.out.println(slindingWindow(nums,k));
    }
}

