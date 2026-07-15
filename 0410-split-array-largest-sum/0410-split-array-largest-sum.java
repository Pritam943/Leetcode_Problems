class Solution {
    public int splitArray(int[] nums, int k) {

        int ans = 0;

        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low <= high){

             int mid = low + (high - low)/2;

             if(possibleSubArray(nums, mid, k)){
                 ans = mid;
                 high = mid-1;
             }
             else{
                low = mid+1;
             }
        }

        return ans;
        
    }

    public boolean possibleSubArray(int[] arr, int val, int k){

          int sum = 0; 
          int count = 1;

          for(int i=0; i<arr.length; i++){

               if(arr[i] > val) return false;

               if(sum + arr[i] > val){
                   count++;
                   sum = arr[i];
               }
               else{
                   sum = sum + arr[i];
               }
          }

          if(count > k) return false;

          return true;
    }
}