package LeetCode100Days;

import java.util.ArrayList;
import java.util.List;

public class DAY67_Q46 {
    public static List<List<Integer>> permutation(int nums[])
    {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(res,curr,nums);
        return res;



    }

    private static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums) {


        //base ciondition

        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                backtrack(res,curr,nums);
                curr.remove(curr.size()-1);
            }

        }
    }


    public static void main(String[] args) {

        int nums[] = {1,2,3};

        System.out.println(permutation(nums));

    }
}
