Stickler Thief

// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}// } Driver Code Ends


class Solution
{
   public int FindMaxSum(int arr[], int n)
   {
      int[] b = new int[n];
      if(n==1) return arr[0];
      if(n==2) return Math.max(arr[0],arr[1]);
      b[0] = arr[0];
      b[1] = Math.max(arr[0],arr[1]);
      for(int i = 2;i<n;i++) b[i] = Math.max(b[i-1],b[i-2]+arr[i]);
      return b[n-1];
   }
}