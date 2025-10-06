package LeetCode100Days;

import java.util.HashSet;
import java.util.Set;

//contains Duplicate 2
public class DAY33_Q219 {

    public static boolean UsingSet(int nums[],int k){
        int n= nums.length;


        Set<Integer> set = new HashSet<>();
        int i=0,j=0;

        while(j<n){

            //check window sizw
            if(Math.abs(i-j)>k){
                set.remove(nums[i]);
                i++;
            }

            if(set.contains(nums[j])){
                return true;
            }

            set.add(nums[j]);
            j++;
        }
        return false;
    }

    public static void main(String args[]){
        int nums[]={1,2,3,1,2,3};
        System.out.println(UsingSet(nums,2));
    }
}
