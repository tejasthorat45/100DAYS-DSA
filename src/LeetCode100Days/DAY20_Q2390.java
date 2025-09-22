package LeetCode100Days;

import java.util.Stack;

public class DAY20_Q2390 {

    //using Stack

    public static String removestar(String s){

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(c=='*'){

                st.pop();


            }else{
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder("");

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }

    //using Two pointer

    public static String removesStar(String s){

        char arr[] = new char[s.length()];

        int j=0;

        for (int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(c=='*'){
                j--;
            }else{
                arr[j] = c;
                j++;
            }
        }

        StringBuilder sb = new StringBuilder("");

        for (int k =0;k<j;k++){
            sb.append(arr[k]);

        }

        return sb.toString();


    }
    public static void main(String[] args) {

        String s ="te*ds*sd";
        System.out.println(removestar(s));
        System.out.println(removesStar(s));


    }







}
