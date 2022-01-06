 Longest Mountain in Array



class Solution {
    public int longestMountain(int[] arr) {
        int res = 0;
        if(arr.length < 2) return 0;
        for(int i=1; i<arr.length-1;i++){
            boolean isPeak = false;
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                isPeak = true;
            }
            if(isPeak){   
                int j =i-1;
                int currPeak = 1;
                while(j>=0 && arr[j+1]>arr[j]){
                    currPeak++;
                    j--;
                }
                j=i+1;
                while(j<arr.length && arr[j-1] > arr[j]){
                    currPeak++;
                    j++;
                }
                 res = Math.max(currPeak,res);
            }  
        }
        return res;
    }
}