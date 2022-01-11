Minimum sum partition


// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{

  public:
	int minDifference(int arr[], int n)  { 
	    int sum = 0;
	    for(int i = 0; i < n; i++) sum += arr[i];
	    // Iterate till sum / 2
	    vector<bool> dp(sum / 2 + 1, false);
	    dp[0] = true;
	    for(int i = 1; i <= n; i++) {
	        for(int j = sum / 2; j >= arr[i - 1]; j--) {
	            if(j == 0) dp[j] = false;
	            else dp[j] = dp[j] || dp[j - arr[i - 1]];
	        }
	    }
	    int minDiff;
	    for(int j = 0; j <= sum / 2; j++) {
	        if(dp[j]) minDiff = sum - 2 * j;
	    }
	    return minDiff;
	} 
};


// { Driver Code Starts.
int main() 
{
   
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.minDifference(a, n) << "\n";
	     
    }
    return 0;
}  // } Driver Code Ends