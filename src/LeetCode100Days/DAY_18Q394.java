package LeetCode100Days;

import java.util.Stack;

//decode String
public class DAY_18Q394 {

    public static String DecodeStr(String s){

        //3-4  steps

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int currentNum =0;
        String currString = "";

        for(char c : s.toCharArray()){

            // make a number
            if(Character.isDigit(c)){
                currentNum=currentNum*10+(c-'0');

            } else if (c == '[') {
                //Proccess operation
                numStack.push(currentNum);
                stringStack.push(currString);;
                currentNum=0;
                currString="";
            } else if (c ==']' ) {
                // Now we have to perform action
                int times = numStack.pop();
                String preString = stringStack.pop();

                StringBuilder sb = new StringBuilder("");

                for(int i=0;i<times;i++){
                    sb.append(currString);
                }
                currString = preString+sb.toString();



            }else {
                currString+=c;
            }
        }
        return currString;



    }

    public static void main(String[] args) {
        String s="2[abc]3[cd]ef";
        System.out.println(DecodeStr(s));
        String v = "3[a2[c]]";
        System.out.println(DecodeStr(v));
    }
}
