package LeetCode100Days;
//insertion of 2 array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DAY33_Q349 {

    public static int[] Approch1(int nums1[],int nums2[])
    {
        ArrayList<Integer> list = new ArrayList<>();

        Set<Integer> set = Arrays
                           .stream(nums1)
                .boxed()
                .collect(Collectors.toSet());



        for(int num : nums2){

            if(set.contains(num)){
                list.add(num);
                set.remove(num);

            }
        }

        int res[]=list.stream().mapToInt(Integer::intValue).toArray();

        return res;




    }

    public static void main(String[] args) {
        int nums1[]={1,2,2,1};
        int nums2[]={2,2};

        int arr[] = Approch1(nums1,nums2);
        for (int num : arr){
            System.out.print(num);
        }
    }


}
