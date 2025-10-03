package LeetCode100Days;

import java.util.HashMap;
import java.util.Map;

public class DAY28_Q930 {

    public static int bruteforce(int nums[],int goal){

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int res =0;
        int currentsum =0;

        for(int i=0; i<n;i++){

            currentsum+=nums[i];

            if(map.containsKey(currentsum-goal)){
                res+= map.get(currentsum-goal);
            }

            map.put(currentsum, map.getOrDefault(currentsum,0)+1);


        }

        return res;
    }

    //using slinding window

    public static int slidindwindow(int nums[],int goal){


        int i=0,j=0;
        int windowsum=0;
        int result =0;
        int zeroscnt =0;

        int n= nums.length;

        while(j<n){

            windowsum+=nums[j];

            while(i<j && (nums[i]==0 || windowsum>goal)){

                if(nums[i]==0){
                    zeroscnt++;
                }else{
                    zeroscnt=0;
                }
                windowsum-=nums[i];
                i++;
            }

            if(windowsum==goal){
                result+= 1+zeroscnt;
            }

            j++;
        }

        return result;
    }


    public static void main(String[] args) {
        int nums[] = {1,0,0,1,1};
        System.out.println(bruteforce(nums,2));
        System.out.println(slidindwindow(nums,2));
    }
}
