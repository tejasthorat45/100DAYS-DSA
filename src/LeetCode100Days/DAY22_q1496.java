package LeetCode100Days;

import java.util.HashSet;
import java.util.Set;

public class DAY22_q1496 {

    public static boolean isPathCross(String path){

        Set<String> set = new HashSet<>();

        int x =0,y=0;
        set.add(x+","+y);

        for(char c : path.toCharArray()){

            if (c=='N'){
                y++;

            }else if (c=='S'){
                y--;
            } else if (c=='E') {
                x++;

            }else{
                x--;
            }

            String pos = x+","+y;

            if(set.contains(pos)){
                return true;
            }
            set.add(pos);
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPathCross("NESWW"));

    }
}
