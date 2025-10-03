package LeetCode100Days;

import java.util.Arrays;

public class DAY29_Q268 {

    public static int FindMissingNumber(int nums[],int n){

        int totalsum = 0;
        int sum = n*(n+1)/2;

        for(int i : nums){
            totalsum+=i;
        }

        return sum-totalsum;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,3};

        System.out.println(FindMissingNumber(nums,3));
    }
}
