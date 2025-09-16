package LeetCode100Days;

//first Unique element in string

public class DAY14_Q387 {
    public static void main(String args[]){

        String s = "lletcode";
        String st = "loveleetcode";

        System.out.println(BruteForce(s));
        System.out.println(BruteForce(st));

        System.out.println(optimal(s));
        System.out.println(optimal(st));


    }
    public static int BruteForce(String s){

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            boolean unique = true;

            for(int j=0;j<s.length();j++){
                if(i != j && c == s.charAt(j)){
                    unique = false;
                    break;
                }
            }
            if(unique){
                return i;
            }
        }
        return -1;
    }

    public static int optimal(String s ){


        int arr [] = new int[26];

        //for lop for storing freq

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            arr[c-'a']++;

        }

        // cal the fre ==1 return

        for(int j=0;j<s.length();j++){

            char c = s.charAt(j);

            if(arr[c-'a']==1){ // freq
                return j;

            }


        }

        return -1;
    }


}
