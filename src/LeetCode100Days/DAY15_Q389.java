package LeetCode100Days;

import java.util.HashMap;
import java.util.Map;

//389. Find the Difference
public class DAY15_Q389 {

    public static char usingmap(String s , String t){

        Map<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1); // increment
        }

        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)-1);//dr\ecrement

            if(map.get(c)<0){
                return c;

            }
        }
        return 'n';

    }

    public static char usingXor(String s,String t){
        char res =0;

        for(char c : s.toCharArray()){

            res^=c;

        }
        for (char c : t.toCharArray()){
            res^=c;
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "abcdeg";

        System.out.println(usingmap(s,t));
        System.out.println(usingXor(s,t));
    }
}
