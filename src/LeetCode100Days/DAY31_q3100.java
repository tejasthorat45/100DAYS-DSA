package LeetCode100Days;

public class DAY31_q3100 {

    public static int DrankWaterBotteles(int numExchange , int numBottles){

        int empty = numBottles;
        int drank = numBottles;
        while(empty>=numExchange){

            empty-=numExchange;
            empty++;
            drank++;
            numExchange++;
        }

        return drank;
    }

    public static void main(String args[]){

        System.out.println(DrankWaterBotteles(6,13));
    }
}
