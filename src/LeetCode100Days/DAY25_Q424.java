package LeetCode100Days;

public class DAY25_Q424 {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k =1;

        System.out.println(bruteForce(s,k));
        System.out.println(optimal(s,k));
    }

    private static int bruteForce(String s, int k) {

        int maxlen=0;
        for(int i=0;i<s.length();i++){
            int freq[] = new int[26];



            for(int j=i;j<s.length();j++){

                char c =  s.charAt(j);

                freq[c-'A']++;
                int maxfreq =0;

                for (int f : freq){
                    maxfreq = Math.max(f,maxfreq);
                }
                int len = j-i+1;
                int replace = len-maxfreq;

                if (replace <= k) {

                    maxlen = Math.max(maxlen ,len);
                }



            }
        }

        return maxlen;
    }

    public static int optimal(String s, int k){

        int freq[] = new int[26];

        int left=0;
        int maxlen =0;

        int  maxfreq=0;

        for(int right =0;right<s.length();right++ ){


            char c = s.charAt(right);

            freq[c-'A']++;

            maxfreq = Math.max(maxfreq,freq[c-'A']);

            if(right-left+1-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            maxlen = Math.max(maxlen,right-left+1);


        }

        return maxlen;
    }
}
