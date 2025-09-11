package LeetCode100Days;

import java.util.HashMap;
import java.util.Map;

// Sub array Sum Equal tO K
public class Day10_Q560 {

    public static int BruteForce(int nums[],int k){
        int ans=0;
        for(int i=0;i< nums.length;i++){

            int currentsum = 0;

            for(int j=i;j< nums.length;j++){
                currentsum+=nums[j];

                if(currentsum==k){
                    ans++;
                }
            }
        }

        return ans;
    }

    ///optimal Code using map o(n) and O(n)

     public static int OptimalSolu(int nums[],int k){

         Map<Integer,Integer> map = new HashMap<>();
         map.put(0,1);

         int prefixsum =0;
         int count =0;


         for(int num : nums){
             prefixsum+=num;

             count+= map.getOrDefault(prefixsum-k,0);
             map.put(prefixsum, map.getOrDefault(prefixsum,0)+1);


         }

         return count;
     }


     public static void main(String[] args) {
         int arr []={10,2,-2,-20,10};
         int ans = BruteForce(arr,-10);
         System.out.println(ans);
         System.out.println(OptimalSolu(arr,-10));

     }
}
