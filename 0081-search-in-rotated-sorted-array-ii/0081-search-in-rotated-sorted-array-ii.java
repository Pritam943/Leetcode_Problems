class Solution {
    public boolean search(int[] nums, int target) {

        int len = nums.length;

        int low = 0;
        int high = len - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (target == nums[mid])
                return true;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                //check condition for duplication when nums[low] == nums[mid] == nums[high] , where we not able to find the sorted part so trim down like below

                low = low + 1;
                high = high - 1;
                continue;
            }

            if (nums[low] <= nums[mid]) {

                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {

                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}