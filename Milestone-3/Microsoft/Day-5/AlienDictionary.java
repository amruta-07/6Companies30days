Alien Dictionary

// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

 class Solution
{
    private void dfsCheck(ArrayList<ArrayList<Integer>> adj, int i, Stack<Integer> st, boolean[] vis) {
		vis[i]=true;
		
		for(int it:adj.get(i)) {
			if(vis[it]==false) {
				dfsCheck(adj,it,st,vis);
			}
		}
		
		st.push(i);
	}
	
	
	private String topologicalSort(ArrayList<ArrayList<Integer>> adj,int n) {
		Stack<Integer> st=new Stack<>();
		boolean vis[]=new boolean [n];
		
				
		for(int i=0;i<n;i++) {
			if(vis[i]==false) {
				dfsCheck(adj,i,st,vis);
			}
		}
		
		String str="";
		while(!st.isEmpty()) {
		   char c=(char)(st.pop()+'a');
		   str+=Character.toString(c);
		}
		
		return str;
		
	}
    
    
    
    public String findOrder(String [] dict, int N, int K)
    {
       		  ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		  for(int i=0;i<K;i++) {
			  adj.add(i,new ArrayList<>());
		  }
		  
		  	for(int i=0;i<dict.length-1;i++) {
		  		for(int j=0;j<Math.min(dict[i].length(),dict[i+1].length());j++) {
		  			if(dict[i].charAt(j)!=dict[i+1].charAt(j)) {
		  				adj.get(dict[i].charAt(j)-'a').add(dict[i+1].charAt(j)-'a');
		  				break;
		  			}
		  		
		  		} 
		  	}
	
		  	Solution obj=new Solution();
		  	String str=obj.topologicalSort(adj, K);
		  	
		  
	         return str;
        
    }
}