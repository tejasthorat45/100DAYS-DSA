package LeetCode100Days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAY66_Q17 {

    static List<String> res = new ArrayList<>();

    public static void solve(int idx , String digits, StringBuilder temp, Map<Character,String> map){

        if(idx == digits.length()){   // FIXED
            res.add(temp.toString());
            return;
        }

        char ch = digits.charAt(idx);
        String str = map.get(ch);

        for (int i = 0; i < str.length(); i++) {

            temp.append(str.charAt(i));

            solve(idx + 1, digits, temp, map);

            temp.deleteCharAt(temp.length() - 1);  // FIXED
        }
    }

    public static List<String> letterCombination(String digits){

        if(digits.length() == 0){
            return new ArrayList<>();
        }

        Map<Character, String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder temp = new StringBuilder();

        res.clear();  // IMPORTANT if main calls multiple times
        solve(0, digits, temp, map);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombination("23"));
    }
}
