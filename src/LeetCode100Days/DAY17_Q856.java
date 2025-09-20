package LeetCode100Days;

import java.util.Stack;

public class DAY17_Q856 {

    public static int ScoreOfParentisis(String s){

        int score =0;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(ch=='('){
                st.push(score);
                score=0;


            }else{
                score = st.pop()+Math.max(2*score,1);

            }
        }
        return score;
    }

    public static void main(String[] args) {
        String s = "((()))";
        System.out.println(ScoreOfParentisis(s));

    }

}
