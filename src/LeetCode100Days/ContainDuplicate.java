package LeetCode100Days;
//day2

import java.util.Arrays;

public class ContainDuplicate {

    public static boolean isContentDuplicate(int nums[]){

        // for that array need sorted
        Arrays.sort(nums);

        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] ={1,2,4,1,4};
       boolean ans=  isContentDuplicate(nums);
        System.out.println(ans);

    }
}
