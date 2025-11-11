package LeetCode100Days;

import java.util.ArrayList;
import java.util.List;

public class DAY61_Q440 {

    public static void solve(int currentno,int n,List<Integer> res ){

        if(currentno>n){
            return;
        }

        res.add(currentno);
        for(int append=0;append<=9;append++){

            int newNo = (currentno*10)+append;

//            if(newNo>n){
//                return;
//            }
            solve(newNo,n,res);
        }

    }

    public static int findlexigraphicanumber(int n, int k){

        List<Integer> res = new ArrayList<>();


        for(int i=1;i<=9;i++){
            solve(i,n,res);
        }
        return res.get(k-1);

    }

    public static void main(String[] args) {
        System.out.println(findlexigraphicanumber(13,2));
    }
}
