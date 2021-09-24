package Array;

import java.util.*;
public class TwoArrayIntersection {
    public static void main(String[] args) {
        int[]  num1= {1,5,3,4,3};
        int[]  num2= {1,5};
        int[] res=intersection(num1,num2);
       for (int i : res) {
           System.out.println(i);
       }
    }

    private static int[] intersection(int[] num1, int[] num2) {
       Arrays.sort(num1);
       Arrays.sort(num2);
       int i=0;
       int j=0;
       List<Integer> at=new ArrayList<>();
       while(i<num1.length&&j<num2.length){
           if(num1[i]<num2[j]) i++;
           else if(num1[i]>num2[j]) j++;
           else{
                at.add(num1[i]);
                i++;
                j++;
           }
       }
       int[] res=new int[at.size()];
       for (int l = 0; l < res.length; l++) {
           res[l]=at.get(l);
       }
       return res;
    }
}
