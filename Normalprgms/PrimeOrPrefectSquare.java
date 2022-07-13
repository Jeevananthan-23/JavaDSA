package Normalprgms;

import java.util.Scanner;


public class PrimeOrPrefectSquare {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N =sc.nextInt();
        int Q= sc.nextInt();
        int[] Narray= new int[N];
        for(int i=0;i<N;i++){
            Narray[i]=sc.nextInt();
        }
        int[] Qarray= new int[Q];
        for(int i=0;i<Q;i++){
            Qarray[i]=sc.nextInt();
        }
      int resut=  avgSubarray( N, Q, Narray, Qarray);
      System.out.println(resut);
    }

    

    private static int avgSubarray(int n, int q, int[] Narray, int[] Qarray) {
        int result=404;
        if(n!=0){
            result= minSubArrayLen(n,Narray);
        }
        if(q!=0){
            result=minSubArrayLen(q, Qarray);
        }
    return result;
    }
    public static int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
   return 0;
 
 int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
 
 while (j < a.length) {
   sum += a[j++];
   
   while (sum >= s) {
     min = Math.min(min, j - i);
     sum -= a[i++];
   }
 }
 
 return min == Integer.MAX_VALUE ? 0 : min;
   }
}
