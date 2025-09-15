package LeetCode100Days;


//valid anagram
public class DAY13_242 {

    public static boolean isValidAnagram(String s , String t ){

        int n = s.length();
        int  k = t.length();
        int count[] = new int[26];

        if(n != k){
            return false ;
        }

        for(int i=0;i<n ; i++){
           count [s.charAt(i)-'a']++;
        }

        for(int j=0;j<k;j++){
            count[t.charAt(j)-'a']--;
        }

        for(int m =0;m< count.length;m++){
            if(count[m]!=0){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String s = "anagram";
        String t  ="nagara";

        Boolean b = isValidAnagram(s,t);
        System.out.println(b);

    }
}
