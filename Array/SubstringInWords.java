package Array;

import java.util.*;
public class SubstringInWords {
    public static void main(String[] args) {
       String  s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans=new ArrayList<>();
         HashMap<String,Integer> map= new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0) + 1);//keys=A,B,C: Values:1,1,1
        }
        
       
        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        int N=words.length;
        int L=words[0].length();
        for (int endWindow = 0; endWindow <= s.length()-L; endWindow++) {
        String right = s.substring(endWindow,endWindow+L);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = endWindow;
                    ans.add(subStr);
                }
                String deleted = s.substring(start++,endWindow);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
           
        }
         return ans;
    }
}
/* public static void slidingWindows(List<Integer> results, HashMap<String, Integer> map, String s, String[] words, int start){
        int lengthWords = words[0].length();
        int lengthSubstring = lengthWords * words.length;
        if(s.length() - start < lengthSubstring)
            return;
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        int countMatchedWords = 0;
        int startCurrentWord = start;
        while(startCurrentWord <= s.length() - lengthWords){
            String sub = s.substring(startCurrentWord, startCurrentWord + lengthWords);
            if(map.containsKey(sub)){
                int count_map = map.get(sub);
                int count_found = found.getOrDefault(sub, 0);
                if(count_found < count_map) {
                    found.put(sub, count_found + 1);
                    countMatchedWords += 1;
                    if(countMatchedWords == words.length)
                        results.add(start);
                    startCurrentWord += lengthWords;
                }
                else{
                    while(true) {
                        String sub_temp = s.substring(start, start + lengthWords);
                        found.put(sub_temp, found.get(sub_temp) - 1);
                        countMatchedWords -= 1;
                        start += lengthWords;
                        if (start > s.length() - lengthSubstring)
                            return;
                        if(sub_temp.compareTo(sub) == 0)
                            break;
                    }
                }
            }
            else{
                found.clear();
                countMatchedWords = 0;
                startCurrentWord += lengthWords;
                start = startCurrentWord;
                if(start > s.length() - lengthSubstring)
                    return;
            }
        }
    }
} */