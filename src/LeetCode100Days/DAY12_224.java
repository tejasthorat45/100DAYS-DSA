package LeetCode100Days;
//BASIC CALCULATOR

import java.util.Stack;

public class DAY12_224 {

    public static int basicCalculator(String s){

        int sign =1;
        int num =0;
        int result =0;
        //store Character array
        Stack<Integer> st = new Stack<>();


        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num *10 + (c-'0');

            }else if(c=='+'){
                result+=num*sign;
                num=0;
                sign=1;
            }else if (c=='-'){
                result+= num *sign;
                num=0;
                sign=-1;
            }else if (c=='('){
                st.push(result);
                st.push(sign);
                result=0;
                sign=1;
            }else if(c==')'){

                result+= sign*num;
                num = 0;

                result *= st.pop(); // pop sign
                result += st.pop(); // pop result
            }

        }
        if (num != 0) result += sign * num;

        return result;



    }

    public static void main(String[] args) {

        String str = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(basicCalculator(str));

    }
}
