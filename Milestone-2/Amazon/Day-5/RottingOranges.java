Rotting Oranges


class Solution {
    
      public class Pair {
    int row;
    int col;

    Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }

  }

    public int orangesRotting(int[][] grid) {
            
    //   Step1:- we are going to add those element index in the queue whose value is 2 and along with that we are also going to the value on how many times 1 is present and we will use it further to see if it is possible to rotten all the oranges or not
    
    ArrayDeque <Pair> q=new ArrayDeque<>();
    int fone=0;//frequency of one
    
    for(int i =0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==2){
                q.add(new Pair(i,j));
            }
            else if(grid[i][j]==1){
                fone++;
            }
        }
    }
    
    if(fone==0){
        return 0; //no one i.e nothing is fresh so nothing will got rotten
    }
    
    // here we have used 2 loops first loop is just used to find level and in 2nd loop we are applying BFS algo levelwise
    
    int level=-1;

    int [][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
    while(q.size()!=0){
        int size=q.size();
        level++;
        
        // Inner loop
        while(size>0){
            Pair rem=q.removeFirst();
            
            // Now we will travel in all 4 direction
            
            for(int i =0;i<dirs.length;i++){
                int newrow=rem.row+dirs[i][0];
                int newcoloum=rem.col+dirs[i][1];
                
                if(newrow>=0 && newcoloum>=0 && newrow<grid.length && newcoloum<grid[0].length && grid[newrow][newcoloum]==1){
                    // whose value is 1 we will change its value 0 to as now they would be rotted
                q.add(new Pair(newrow,newcoloum));
                fone--;//as if(fone==0) then all fresh would be rottened so we are decreasing its value
                grid[newrow][newcoloum]=0;
                    
                }
            }
            size--;
        }
    }
    
    if(fone!=0){
        return -1;
    }
    return level;
    
    }
}