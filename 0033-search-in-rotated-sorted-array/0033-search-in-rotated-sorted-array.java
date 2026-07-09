class Solution {
    public int search(int[] nums, int target) {

        int len = nums.length;
        int ans = -1;

        int low = 0;
        int high = len - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
                
            } else if (nums[low] <= nums[mid]) {

                 if(nums[low] <= target && target <= nums[mid]){
                     high = mid - 1;
                 }
                 else{
                    low = mid+1;
                 }
            } else {
                
                  if(target >= nums[mid] && target <= nums[high]){
                    low = mid+1;
                  }
                  else{
                     high = mid - 1;
                  }
            }
        }

        return ans;
    }
}