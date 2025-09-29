package LeetCode100Days;

import java.util.Arrays;

public class Day26_Q455 {

    public static int assigncookei(int g[],int s[]){
        int m = g.length;
        int n = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i=0,j=0;

        while(i<m && j<n){

            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }

        return i;
    }

    public static void main(String[] args) {
        int g[]={1,2,3};
        int s[]={1,1};
        System.out.println(assigncookei(g,s));
    }
}
