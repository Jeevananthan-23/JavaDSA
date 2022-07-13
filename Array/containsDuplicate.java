package Array;
import java.util.*;
public class containsDuplicate {
    public static void main(String[] args) {
       int []array={1,2,3,4,5,2,4};
        int n=8;
      boolean result1=IsValid(array);
      List<Integer> vals= findDuplicates(array);
     // boolean result2=containsNearbyDuplicate(array,n);
       System.out.println(result1);
       System.out.println(vals);
          
    }
    public static boolean IsValid(int[] nums) {
      HashSet<Integer> map=new HashSet<>();
        for(int i:nums)
            if(!map.add(i))
                return true;
      return false;      
}
public static List<Integer> findDuplicates(int[] nums) {
  HashSet<Integer> set = new HashSet<>();
  List<Integer> result = new ArrayList<>();
  
  for(int num: nums){
      if(set.contains(num)){
          result.add(num);
      }else{
          set.add(num);
      }
  }
  return result;
}
}
