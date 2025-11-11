package LeetCode100Days;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNum_Q386 {

    private static void dfs(int current , int n , List<Integer> result){

        //base case
        if(current>n){
            return;
        }

        result.add(current);

        for(int append=0;append<=9;append++){

            int newno = (current*10)+append;
            if(newno>n){
                return;
            }
           dfs(newno,n,result);
        }

    }

    public static List<Integer> lexicographical(int n){

        //for
        List<Integer> res = new ArrayList<>();


        for(int startnu =1;startnu<=9;startnu++){
            dfs(startnu,n,res);
        }
    return res;
    }

    //lexicogrpjhical

    public static void main(String[] args) {
        System.out.println(lexicographical(13));
    }
}
