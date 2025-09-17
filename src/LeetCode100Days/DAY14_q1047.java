package LeetCode100Days;

import java.util.Stack;

public class DAY14_q1047 {

    public static String RemoveDuplicate(String s){

        Stack<Character> st = new Stack<>();

        for(char c :s.toCharArray()){
            if(st.isEmpty() || st.peek() != c){
                st.push(c);
            }else if(st.peek()==c){
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder("");

        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String s = "axxyzy";
        System.out.println(RemoveDuplicate(s));
    }
}
