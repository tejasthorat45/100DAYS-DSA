package LeetCode100Days;

import java.util.HashSet;
import java.util.Set;

public class DAY15_Q3 {

    public static int maxSubSeqString(String s){
        int n = s.length();
        int maxlen =0;
        int left =0;
        Set<Character> set = new HashSet<>();


        for(int right=0;right<n;right++){

            while (set.contains(s.charAt(right))){

                set.remove(s.charAt(left));
                left++;

            }

            set.add(s.charAt(right));
            maxlen = Math.max(maxlen,right-left+1);

        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "abcdacbnk";
        System.out.println(maxSubSeqString(s));
    }
}
