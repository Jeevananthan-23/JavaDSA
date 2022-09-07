package Trees;

import java.util.Scanner;
import java.util.*;

public class Binary_Search {
public static int search(int[] ar, int n, int ele) {
int l=0;
int r=n-1;
if(l==r){
    return l;
}
while(l<=r){
    int m=(l+r)/2;
    if (ar[m] == ele) 
    return m; 
    
if (ar[m] < ele) 
    //l = m + 1; 
    search(ar,m+1,l);


else
    //r = m - 1; 
    search(ar,m-1,r);
} 


return -1; 
}


public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
  
    int n = s.nextInt();
    int[] ar = new int[n];
    for (int i = 0; i < n; i++) {
        ar[i] = s.nextInt();
        
    }
    int ele = s.nextInt();
    int result= Binary_Search.search(ar, n, ele);
    if(result==-1){
        System.out.println("No ele found");
    }
    else{
        System.out.println("ele found @ index " +result);
    }
    s.close();
    }
}
