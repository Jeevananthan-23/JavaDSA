import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] hash = new char[26];
            for(char c: s.toCharArray()){
                hash[c-'a']++;
            }
            String key = new String(hash);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        result.addAll(map.values());
       
        return result;
    }

    public List<String> removeAnagrams(String[] words) {
        String prev="";
        List<String> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        for(String s:words ){
            char[] c= s.toCharArray();
            Arrays.sort(c);
            String curr = new String(c);
                if(!curr.equals(prev)){
                    result.add(s);
                    prev=curr;
                }
              
        }
        return result;
    }
}
//time complexity: O(n*n)
//space complexity: O(n)