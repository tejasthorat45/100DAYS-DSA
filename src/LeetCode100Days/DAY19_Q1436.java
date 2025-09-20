package LeetCode100Days;

import java.util.*;

public class DAY19_Q1436 {

    public static String UseHashet(List<List<String>> paths){

        Set<String> cites = new HashSet<>();

        for(List<String> path : paths){
            //add to set
            cites.add(path.get(0));
        }

        //

        for(List<String> path : paths){
            String destination = path.get(1);

            if(!cites.contains(destination)){
                return destination;
            }
        }
        return "";


    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("a", "b"));
        paths.add(Arrays.asList("b", "C"));
        paths.add(Arrays.asList("C", "D"));

        System.out.println(UseHashet(paths));

    }
}
