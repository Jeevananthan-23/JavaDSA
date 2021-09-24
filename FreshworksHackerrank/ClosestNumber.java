package FreshworksHackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n;i++) {
            array[i] = sc.nextInt();
        }
        // List<List<Integer>> ans= minimumAbsDifference(array);
        // for(List<Integer> i:ans){
        //     System.out.println(i.toString().replace("[","").replace("]","").replace(",", " "));
        // }
        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<array.length-1; i++){
           min = Math.min(min,array[i+1]-array[i]);
        }
        StringBuilder sb=new StringBuilder("");
        for(int i=0; i<array.length-1; i++){
           if(array[i+1]-array[i]==min);
                sb.append(array[i]+" "+array[i+1]+"\n");
         }
         System.out.println(sb.toString());

    }
    public static List<List<Integer>>  minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            int dif = Math.abs(arr[i-1]-arr[i]);
            if(dif < min) {
                min=dif;
                res.clear(); 
                res.add(new ArrayList<>(Arrays.asList(arr[i-1],arr[i])));
            } else if(dif == min) res.add(new ArrayList<>(Arrays.asList(arr[i-1],arr[i])));
        }
        return res;
    }
}
