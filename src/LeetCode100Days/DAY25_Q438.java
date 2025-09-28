package LeetCode100Days;
 //slinding window

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAY25_Q438 {

    public static List<Integer> findAllAnagram(String s,String p){

        List<Integer> res = new ArrayList<>();

        if(p.length()>s.length()){
            return res;
        }

        int[] pcount = new int[26];
        int [] scount = new int[26];

        for(char c :p.toCharArray()){
            pcount[c-'a']++;
        }

        // for scount for(int
        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            scount[c-'a']++;

            if(i>=p.length()){
                scount[s.charAt(i-p.length())-'a']--;


            }

            //compare

            if(Arrays.equals(scount,pcount)){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p ="abc";
        List<Integer> arr = findAllAnagram(s,p);
        for (Integer a : arr){
            System.out.print(a);

        }

    }
}
