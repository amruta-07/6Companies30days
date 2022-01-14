Bridge edge in a graph 


// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);
        
        vis[c] = true;
        
        //removing c fron d and d from c 
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        
        // Simple BFS
        while(!q.isEmpty()){
            int it = q.poll();
            for(Integer v: adj.get(it)){
                if(!vis[v]){
                    q.offer(v);
                    vis[v] = true;
                }
            }
        }
        
        // Only check for vis[d]
        if(vis[d])
            return 0;
        return 1;
    }
}