package FreshworksHackerrank;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DIskSpace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n;i++) {
            array[i] = scan.nextInt();
        }
    //     OptionalInt res=maxSlidingWindow(array, k);
    //    System.out.println(res);
    System.out.println("first   "+FindMax(array, k));
    System.out.println("second  "+ maxSlidingWindow(array, k));
    }
    public static int maxSlidingWindow(int[] a, int k) {		
		
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
       int max = Arrays.stream(r).max().getAsInt();
		return max;
	}
    public static int FindMax(int[] space, int x)
{
    int chunkNum = 1;
    Stack<Integer> s = new Stack<Integer>();
    s.push(0);

    for (int i = 1; i < space.length; i++)
    {
        // first chunk
        if (i < x)
        {
            if (space[i] < space[s.peek()])
            {
                s.pop();
                s.push(i);
            }
        }
        // other chunks
        else
        {
            // if found minimum is member of current chunk we just need to compare current number with it
            var peek = s.peek();
            if (peek >= chunkNum)
            {
                s.push(space[i] < space[peek] ? i: peek);
            }
            // we have to loop through current chunk to find minimum number
            else
            {                
                s.push(i);
                
                int j = chunkNum;
                int count = 0;
                while (count++ < x)
                {
                    if (space[j] < space[s.peek()])
                    {
                        s.pop();
                        s.push(j);
                    }
                    j++;
                }
            }
            // we are ready to go to next chunk
            chunkNum++;
        }
    }
    
    return s.stream().map(c->space[c]).max(Integer::compare).get();
}
}
