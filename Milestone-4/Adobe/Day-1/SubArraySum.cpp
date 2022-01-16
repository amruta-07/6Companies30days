Subarray with given sum

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to find a continuous sub-array which adds up to a given number.
    vector<int> subarraySum(int arr[], int n, long long s)
    {
        // Your code here
        vector<int> v={-1};
      int cursum=arr[0],index=0;
      for(int i=1;i<=n;i++){
          while(cursum>s && index<i-1){
              cursum-=arr[index];
              index++;
          }
          if(cursum==s){
              v.clear();
              v.push_back(index+1);
              v.push_back(i);
              return v;
          }
          if(i<n){
              cursum+=arr[i];
          }
      }
      return v;
    }
};

// { Driver Code Starts.

int main()
 {
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        long long s;
        cin>>n>>s;
        int arr[n];
        const int mx = 1e9;
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        vector<int>res;
        res = ob.subarraySum(arr, n, s);
        
        for(int i = 0;i<res.size();i++)
            cout<<res[i]<<" ";
        cout<<endl;
        
    }
	return 0;
}  // } Driver Code Ends