Generate Binary Numbers


// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        //Taking input using class Scanner 
        Scanner sc = new Scanner(System.in);
        
        //Taking the number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking the range
            int n = sc.nextInt();
            
            //creating an ArrayList
            ArrayList<String> res = new ArrayList<String>();
            
            //calling the generate method of class solve
            //and storing the result in an ArrayList
            res = new solve().generate(n);
            
            //printing all the elements of the ArrayList
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends




class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int n)
    {
        ArrayList<String> res = new ArrayList<>(); 
        Queue<String> q = new ArrayDeque<>(); 
        q.add("1");
        int count = 0;
        
        while(q.size() > 0){
            String rem = q.remove(); 
            res.add(rem); 
            count++; 
            if(count == n) return res; 
            q.add(rem + "0"); 
            q.add(rem + "1"); 
        }
         return res; 
    }
    
}
