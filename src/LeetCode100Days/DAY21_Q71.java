package LeetCode100Days;

import java.util.Stack;

public class DAY21_Q71 {

    public static String simplifyPath(String path){


        // we are token or demeleter in Split()
        String [] paths = path.split("/");

        Stack<String > st = new Stack<>();


        for(String dir : paths){

            //we 3 condition 'a,b,c -> stack 2) . --> nothing 3)".." -->pop means we are chamging root directoeiea

            if (dir.equals(".") || dir.equals("")){
                continue;
            }else if (dir.equals("..")){
                //check st is not empty
                if(!st.isEmpty()) st.pop();
            }else{
                //a ,b c

                st.push(dir);
            }
        }

        if(st.isEmpty()) return "/";

        StringBuilder res = new StringBuilder("");



        for(String dir : st){
            res.append("/").append(dir);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String path ="/a/b//c/.//../"; //---> /a__>/b --> //-----> /a/b
        System.out.println(simplifyPath(path));
    }
}
