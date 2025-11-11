package LeetCode100Days;

public class DAY63_Q3307 {

    public static char findkthChar(long k , int[] operation){

        //base case
        if(k==1) return 'a';

        long len =1;
        int operationtype =0;
        long newK = -1;

        for(int i=0;i<operation.length;i++){

            len*=2;

            if(len>=k){
                //doo workk

                operationtype=operation[i];
                newK = k-len/2;
                break;
            }
        }

        char c = findkthChar(newK, operation);

        if(operationtype==0){
            return c;
        }else{
            if(c=='z'){
                return 'a';
            }else{
                return (char)(c+1);

            }
        }
    }

    public static void main(String[] args) {
        int arr[]={0,1,0};
        System.out.println(findkthChar(6,arr));

    }
}
