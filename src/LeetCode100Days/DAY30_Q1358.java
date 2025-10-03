package LeetCode100Days;
//slinding window
public class DAY30_Q1358 {

    public static int ContainningAllThree(String s){

        int n = s.length();
        int i=0,j=0;
        int res =0;
        int[] freq = new int[3];

        while(j<n){
            char c = s.charAt(j);

            freq[c-'a']++;

            while(freq[0]>0&&freq[1]>0&&freq[2]>0){
                res+=(n-j);
                freq[s.charAt(i)-'a']--;
                i++;
            }

            j++;


        }

        return  res;
    }

    public static void main(String[] args) {
        String s = "aabcabcab";
        System.out.println(ContainningAllThree(s));
        System.out.println(ContainningAllThree("abcabc"));
    }
}
