package LeetCode100Days;

import java.util.ArrayList;
import java.util.List;

public class DAY65_Q241 {

    public static List<Integer> AddParenthhesis(String expres){

        return Solve(expres);
    }

    private static List<Integer> Solve(String s) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c=='+' || c== '-' || c=='*'){

                List<Integer> leftres = Solve(s.substring(0,i));

                List<Integer> rightres = Solve(s.substring(i+1));

                for(int x : leftres){
                    for (int y : rightres){

                        if(c=='+'){
                            res.add(x+y);

                        } else if (c=='-') {
                            res.add(x-y);

                        }else{
                            res.add(x*y);
                        }

                    }
                }
            }
        }

        if(res.isEmpty()){
            res.add(Integer.parseInt(s));
        } return res;
    }

    public static void main(String[] args) {
        System.out.println(AddParenthhesis("2-1-1"));

    }
}
