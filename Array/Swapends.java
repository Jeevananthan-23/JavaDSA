package Array;


import java.util.*;
public class Swapends {
    public static void main(String[] args) {
    List<Integer> arr =new ArrayList<>();
      arr.add(1);
      arr.add(2);
      arr.add(3);
      arr.add(4);
      int n=arr.size();
   List<Integer> res= shifLeft(arr,n);
     System.out.println("methodimple");
      for (Integer integer : res) {
        System.out.println(integer);
      }
        int x1=arr.remove(0);
        int x2=arr.remove(arr.size()-1);
        arr.add(0,x2);
        arr.add(arr.size(),x1);
        System.out.println("inbuilt");
       for (Integer integer : arr) {
           System.out.println(integer);
       }
    }

    private static List<Integer> shifLeft(List<Integer> arr, int n) {
      if(n<1||n>arr.size())
          return arr;
      int x=arr.remove(0);
      arr.add(n-1,x);
     return shifLeft(arr,n-1);  
    }
}
