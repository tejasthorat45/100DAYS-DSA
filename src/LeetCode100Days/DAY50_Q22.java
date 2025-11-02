package LeetCode100Days;



import java.util.ArrayList;
import java.util.List;

//leetcode 22
public class DAY50_Q22 {
    List<String> generateparenthesis(int n){
        //using recursion

        //for storing res
        List<String> res = new ArrayList<>();


        generate(res,new StringBuilder(),0,0,n);
        return res;

    }

    private void generate(List<String> res, StringBuilder curr, int open,int close, int n) {
        //base case;

        if(curr.length()==2*n){
            res.add(curr.toString());
            return;
        }

        //addinf '( '

        if(open<n){
            curr.append('(');
            generate(res,curr,open+1,close,n);
            curr.deleteCharAt(curr.length()-1);

        }

        //adding ');

        if(close<open){
            curr.append(')');
            generate(res,curr,open,close+1,n);
            curr.deleteCharAt(curr.length()-1);
        }


    }

    public static void main(String[] args) {
        DAY50_Q22 obj = new DAY50_Q22();

        System.out.println(obj.generateparenthesis(2));

    }
}

