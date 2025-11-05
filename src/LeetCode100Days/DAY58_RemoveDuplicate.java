package LeetCode100Days;

public class DAY58_RemoveDuplicate {

    public static void removedupli(String str , int idx , StringBuilder res ,boolean map[]){

        //base case;
        if(idx==str.length()){
            System.out.println(res);
            return;
        }


        //work
        char curchar = str.charAt(idx);

        if(map[curchar-'a']==true){
            removedupli(str,idx+1,res,map);
        }else{
            //add to map

            map[curchar-'a']=true;
            removedupli(str, idx, res.append(curchar), map);
        }
    }

    public static void main(String[] args) {
        String str = "abcadf";
        boolean map[] = new boolean[26];

   removedupli(str,0,new StringBuilder(""),map);

    }
}
