package Array;

import java.util.ArrayList;
import java.util.Scanner;
 public class ArrayListDemo {
 public static void main(String[] args) {
           //declaring Arraylist of String objects
           ArrayList<String> myList = new ArrayList<String>();
           Scanner sc=new Scanner(System.in);
           //Adding objects to Array List at default index
           int Friuts = sc.nextInt(); sc.nextLine();
           //Consume the new line after the int value 
           for (int counter = 0; counter <Friuts; counter++) 
           {
                myList.add(sc.nextLine()); 
              } 
           myList.add("Apple");
           myList.add("Mango");
           myList.add("Orange");
           myList.add("Grapes");
           //Adding object at specific index
           myList.add(1, "Orange");
           myList.add(2,"Pinapple");
           System.out.println("Print All the Objects:");
String[] words={"Jeeva","Badeye","Pollathavan","Jeevananthan"};
        int vav=  words[0].length();
           for(String s:myList){
           System.out.println(s);
           }
           sc.close();
           System.out.println("Object at index 3 element from list: "+ myList.get(3));
           System.out.println("Is Chicku is in list: " + myList.contains("Chicku"));
           System.out.println("Size of ArrayList: " + myList.size());
           myList.remove("Papaya");
           System.out.println("New Size of ArrayList: "+ myList.size());
      }
 }
 
