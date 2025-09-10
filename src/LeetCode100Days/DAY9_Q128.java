package LeetCode100Days;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DAY9_Q128 {

    public static int maxSequence(int nums[]){

        Arrays.sort(nums); // o(logn) * O(n) = o(nlogn)
        int longest =1;
        int streak =1;

        for (int i=1;i< nums.length;i++){

            if(nums.length==0) return 0;

            if(nums[i]==nums[i-1]) continue;

            if(nums[i] == nums[i-1]+1){
                streak++;

            }else{
                longest = Math.max(streak,longest);
                streak=1;
            }

        }

        return Math.max(longest,streak);
    }

    public  static int optimalSolution(int nums[]){

        Set<Integer> set = new HashSet<>();

        if(nums.length ==0) return 0;

        int longest =1;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){

            if(!set.contains(num-1)){


                int current =1;
                int streak =1;

                while(set.contains(current+1)){
                    current++;
                    streak++;
                }

                longest = Math.max(longest,streak);
            }
        }

        return longest ;

    }

    public static void main(String[] args) {

        int[] arr ={1,2,100,101,102,4,3};
        System.out.println(maxSequence(arr));
        System.out.println(optimalSolution(arr));




    }
}
