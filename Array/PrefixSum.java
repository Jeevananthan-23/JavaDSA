package Array;

import java.util.*;

public class PrefixSum {
    public int subarraySum(int[] nums, int k) {
        int res=0,curSum=0;
     Map<Integer,Integer> prefixSum= new HashMap<>();
        prefixSum.put(0,1);
    for(int i:nums){
        curSum+=i;
        res+=prefixSum.getOrDefault(curSum-k,0);
        prefixSum.put(curSum,prefixSum.getOrDefault(curSum,0)+1);
    }
return res;
} 
}
//tc:O(n)
//sc:O(n)

