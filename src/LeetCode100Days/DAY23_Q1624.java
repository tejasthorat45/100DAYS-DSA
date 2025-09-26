package LeetCode100Days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DAY23_Q1624 {
    //Largest Substring Between Two Equal Characters
    public static int optimal(String s){
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int res =0; //var

        for(int i=0;i<n;i++){

            char c = s.charAt(i);

            if(!map.containsKey(c)){
                map.put(c,i);
            }else{
                res = Math.max(res,i-map.get(c)-1);
            }


        }

        return res;
    }

    public static int usingArray(String s){
        int count[] = new int[26];
        Arrays.fill(count,-1);
        int res =0;

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(count[c-'a']==-1){
                //visted
                count[c-'a']=i;

            }else{
                res = Math.max(res,i-count[c-'a']-1);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abbba";
        System.out.println(optimal(s));
        System.out.println(usingArray(s));

    }


}
