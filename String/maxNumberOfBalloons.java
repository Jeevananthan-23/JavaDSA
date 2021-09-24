package String;

import java.util.stream.IntStream;

public class maxNumberOfBalloons {
     public static void main(String[] args) {
         String str="loonbalxballpoon";
    int count=counterNo(str);
    System.out.println("Count:"+count);
    }

    private static int counterNo(String str) {
        int[] map = new int[26];
        for(char c : str.toCharArray()){
            map[c-'a']++;
        }
        return IntStream.of(
            map['b'-'a'],
            map['a'- 'a'], 
            map[('l'-'a')]/2,
            map[('o'-'a')]/2,
            map[('n'-'a')]
        ).min().getAsInt();
    }
   
}
