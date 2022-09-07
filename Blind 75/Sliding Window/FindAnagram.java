import java.util.*;

public class FindAnagram {
    public static void main(String[] args) {
        String s = "baa";
        String t = "aa";
        System.out.println(findAnagrams(s, t));
    }
    // public static List<Integer> findAnagrams(String s, String p) {
    //     List<Integer> res = new ArrayList<>();
    //    HashMap <Character, Integer> map = new HashMap<>();
    //      for(char c: p.toCharArray()){
    //           map.put(c, map.getOrDefault(c, 0) + 1);
    //      }
    //         int left = 0, right = 0;
    //         int count = p.length();
    //         while(right < s.length()){
    //             char c = s.charAt(right);
    //             if(map.containsKey(c)){
    //                 map.put(c, map.get(c) - 1);
    //                 if(map.get(c) == 0) count--;
    //             }
    //             right++;
    //             while(count == 0){
    //                 if(right - left == p.length()) res.add(left);
    //                 char d = s.charAt(left);
    //                 if(map.containsKey(d)){
    //                     map.put(d, map.get(d) + 1);
    //                     if(map.get(d) > 0) count++;
    //                 }
    //                 left++;
    //             }
    //         }
    //         return res;
    // }
    

//tc: O(n)
//sc: O(1)
public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int[] count = new int[26];
    for(char c: p.toCharArray()){
        count[c - 'a']++;
    }
    int left = 0, right = 0;
    int len = p.length();
    while(right < s.length()){
        char c = s.charAt(right);
        if(count[c - 'a'] > 0){
            len--;
        }
        count[c - 'a']--;
        right++;
        while(len == 0){
            if(right - left == p.length()){
                res.add(left);
            }
            char d = s.charAt(left);
            count[d - 'a']++;
            if(count[d - 'a'] > 0){
                len++;
            }
            left++;
        }
    }
    return res;
}
}
