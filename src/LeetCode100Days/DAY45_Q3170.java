package LeetCode100Days;

import javax.swing.table.TableRowSorter;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class DAY45_Q3170 {

    public static String findmin(String s){

        //define the pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {

            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        char chars[] = s.toCharArray();

        for(int i=0;i<s.length();i++){
            char c = chars[i];

            if(c!='*'){
                pq.offer(new int[]{c,i});
            }else{
                int[] remove = pq.poll();
                chars[remove[1]]='*';
            }
        }

        //build res

        StringBuilder sb = new StringBuilder();

        for(char c : chars){

            if(c!='*') sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaba*";
        System.out.println(findmin(s));
        System.out.println(findmin("ead*"));
    }
}
