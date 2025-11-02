package LeetCode100Days;

import java.util.ArrayList;
import java.util.List;

public class DAY51_Q78 {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> usinRecursion(int nums[]){

        List<Integer> temp = new ArrayList<>();
        solve(0,nums,temp);
        return res;


    }

    private static void solve(int i, int[] nums, List<Integer> temp) {

        //base case
        if(i>=nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        solve(i+1,nums,temp);
        temp.remove(temp.size()-1);
        solve(i+1,nums,temp);
    }

    public static void main(String[] args) {

        int nums[]={1,2,3};

        System.out.println(usinRecursion(nums));;

    }
}
