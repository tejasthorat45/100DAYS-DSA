package LeetCode100Days;

import java.util.Stack;

public class DAY59_Reverse_Stack {

    public void reverse(Stack<Integer> st){




        //base case
        if(st.isEmpty()){
            return;


        }
        int top = st.pop();
        reverse(st);
        pushAtbottom(st,top);

    }

    //push AT bottom

    public static void pushAtbottom(Stack<Integer> st, int element){


        //base case

        if(st.isEmpty()){
            st.push(element);
            return;
        }

       int top = st.pop();
        pushAtbottom(st,element);
        st.push(top);

    }


    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st);


    }
}
