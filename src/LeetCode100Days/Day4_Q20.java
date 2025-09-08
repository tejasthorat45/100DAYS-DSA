package LeetCode100Days;

import java.util.Stack;

public class Day4_Q20 {
    //optimal approch O(n) o1 sc
    public static boolean IsValideparathesis(String str){

        Stack<Character>s = new Stack<>();


        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);

            if(ch=='(' || ch=='{' || ch == '['){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                } else if (s.peek() == '(' && ch == ')'||
                            s.peek()=='{' && ch=='}' ||
                           s.peek()=='[' && ch == ']') {
                    s.pop();


                }else {
                    return false;
                }
            }
        }

        if(s.isEmpty()){
            return true;
        }else {
            return false;
        }

    }
    public static void main(String[] args) {
        String str ="(()){}[[]]";
        boolean ans = IsValideparathesis(str);
        System.out.println(ans);

    }


}
