Possible Words From Phone Digits

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   static String codes[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
   static ArrayList <String> possibleWords(int a[], int N)
   {
     ArrayList<String> list=new ArrayList<String>();
     String ques="";
     for(int i=0;i<N;i++)
      ques+=a[i];
     solve(list,ques,"");
     return list;
   }
   static void solve(ArrayList<String> list,String ques,String ans)
   {
      if(ques.length()==0)
      {
          list.add(new String(ans));
          return;
      }
      
      char ch=ques.charAt(0);
      String res=ques.substring(1);
      String codeforeach=codes[ch-'0'];
      for(int i=0;i<codeforeach.length();i++)
      {
          char cho=codeforeach.charAt(i);
          solve(list,res,ans+cho);
      }
       
       
   }
}


