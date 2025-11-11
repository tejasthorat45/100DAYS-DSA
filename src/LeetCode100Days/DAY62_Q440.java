package LeetCode100Days;

public class DAY62_Q440 {

    public static int findLexi(int n,  int k){


        int curr =1;
        k-=1;

        while(k>0){

            int cnt = Count(curr,curr+1,n);

            if(cnt<=k){
                //next trie
                curr++;
                k-=cnt;


            }else{ //same rie hjust multi plies by 10
                curr*=10;
                k-=1;
            }
        }

        return curr;

    }
    public static int Count(int current,int next,int n){
        int countnu=0;


        while (current<=n){

            countnu+=(next-current);

            current*=10;
            next*=10;
            next=Math.min(n+1,next);

        }
        return countnu;
    }

    public static void main(String[] args) {
        System.out.println(findLexi(13,3));
    }
}
