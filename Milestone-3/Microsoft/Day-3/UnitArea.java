Unit Area of largest region of 1's


// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find unit area of the largest region of 1s.
   public int findMaxArea(int[][] grid)
   {
       int result=0;
       for(int i=0;i<grid.length;i++) {
           for(int j=0;j<grid[0].length;j++) {
               if(grid[i][j] == 1) {
                   int num = search(i,j,grid);
                   result = result > num ? result : num;
               }
           }
       }
       return result;
   }
   public int search(int i,int j, int[][]grid) {
       
       if(i < 0 || j<0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 ) 
           return 0;
       
       grid[i][j] = 0;
       int sum = 0;
       sum += search(i+1,j,grid);
       sum += search(i,j+1,grid);
       sum += search(i,j-1,grid);
       sum += search(i-1,j,grid);
       
       sum += search(i+1,j+1,grid);
       sum += search(i-1,j-1,grid);
       sum += search(i+1,j-1,grid);
       sum += search(i-1,j+1,grid);
       return sum + 1;
   }
}