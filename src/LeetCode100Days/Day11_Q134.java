package LeetCode100Days;

public class Day11_Q134 {

    public static int gasstation(int gas[],int cost[]){

        // we have return the starting iddx if there is suffiecent gas for rotating circle

        int totalgas=0;
        int totalcost =0;
        int res_idx=0;
        int tank =0;

        for(int i=0;i<gas.length;i++){

            totalgas+=gas[i];
            totalcost+=cost[i];

            tank +=gas[i]-cost[i];

            if(tank<0){
                res_idx=i+1;
                tank=0;
            }

        }

        return totalcost>totalgas ? -1:res_idx;
    }

    public static void main(String[] args) {
        int gas [] ={1,2,3,4,5};
        int cost[]={3,4,5,1,2};
        System.out.println(gasstation(gas,cost));

    }
}
