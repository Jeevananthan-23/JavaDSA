package Array;
import java.util.*;
public class containsDuplicate {
    public static void main(String[] args) {
       int []array={1,2,3,4,5};
        int n=8;
      boolean result1=IsValid(array);
     // boolean result2=containsNearbyDuplicate(array,n);
       System.out.println(result1);
          
    }
    public static boolean IsValid(int[] nums) {
      HashSet<Integer> map=new HashSet<>();
        for(int i:nums)
            if(!map.add(i))
                return true;
      return false;      
}
}
