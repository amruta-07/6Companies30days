Spirally traversing a matrix 

// { Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
   //Function to return a list of integers denoting spiral traversal of matrix.
   static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
   {
       // code here 
       ArrayList<Integer> list=new ArrayList<>();
       int count=0,i=0,j=0,k=0,l=r-1,E=0;
       while(count<r*c)
       {
           if(j<c-E)
           {
               list.add(matrix[i][j]);
               j++;
               count++;
           }
           else if(i<r-1-E)
           {
               i++;k=j-1;
               list.add(matrix[i][k]);
               count++;
           }
           else if(k>E)
           {
               k--;
               list.add(matrix[i][k]);
               count++;
           }
           else if(l>E+1)
           {
               l--;
               list.add(matrix[l][k]);
               count++;
           }
           else
           {
               E++;
               j=E;i=E;l=r-1-E;
           }
       }
       return list;
   }
}
