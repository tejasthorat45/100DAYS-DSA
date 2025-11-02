package LeetCode100Days;



import java.util.LinkedList;
import java.util.Queue;

public class DAY53_Q1823 {

    public static int usingQueue(int n ,  int k){

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){

            q.offer(i);
        }

        while(q.size()>1){
            for(int i=1;i<k;i++){

                q.offer(q.poll());

            }
            q.poll();


        }

        return q.peek();
    }

    //recursive

    private static int findwWinner(int n, int k){

        //base case

        if(n == 1) return 0;

        int idx = findwWinner(n-1,k);

        idx=(idx+k)%n;

        return idx;
    }

    public static int usingRecursive(int n,int k){

        int res = findwWinner(n,k);
        return res+1;


    }




    public static void main(String[] args) {

        System.out.println(usingQueue(5,2));
        System.out.println(usingRecursive(5,2));

    }
}

