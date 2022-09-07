import java.util.*;

public class SubstringWindow {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        if(s.equals(t)) return t;
        HashMap<Character,Integer> map= new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);//keys=A,B,C: Values:1,1,1
        }
        
       
        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {//0,1,2,3,4,5
            char right = s.charAt(endWindow);//A,D,O,B,E,C,
            if (map.containsKey(right)) {//ture,false,false,false,true,false,ture
                map.put(right, map.get(right) - 1);//A,0:B,0:C,0
                if (map.get(right) == 0) matched++;//1,2,3
            }

            while (matched == map.size()) {//1==3,2==3,3==3
                if (minLen > endWindow - start + 1) {//12>5-0+1:true,6>5-0+1:false
                    minLen = endWindow - start + 1;//6
                    subStr = start;//0
                }
                char deleted = s.charAt(start++);//A
                if (map.containsKey(deleted)) {//false
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
}
}
