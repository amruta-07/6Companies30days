Is Sudoku Valid 

// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int isValid(vector<vector<int>> mat){
        int row[9][9]={0},col[9][9]={0},box[9][9]={0};
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(mat[i][j]!=0){
                row[i][mat[i][j]-1]++;
                col[j][mat[i][j]-1]++;
                box[(i/3)*3 + j/3][mat[i][j]-1]++;
                if(row[i][mat[i][j]-1]>1 || col[j][mat[i][j]-1]>1 || box[(i/3)*3 + j/3][mat[i][j]-1]>1)
                return 0;
                }
                
            }
        }
        return 1;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        vector<vector<int>> mat(9, vector<int>(9, 0));
        for(int i = 0;i < 81;i++)
            cin>>mat[i/9][i%9];
        
        Solution ob;
        cout<<ob.isValid(mat)<<"\n";
    }
    return 0;
}  // } Driver Code Ends