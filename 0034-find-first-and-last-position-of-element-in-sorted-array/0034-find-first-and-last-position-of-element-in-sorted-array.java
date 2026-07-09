class Solution {
    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int[] ans = new int[2];

        int ind1 = -1;
        int ind2 = -1;

        int low = 0;
        int high = len - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {

                if (nums[mid] == target)
                    ind1 = mid;
                    
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = len - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {

                if (nums[mid] == target)
                    ind2 = mid;

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        ans[0] = ind1;
        ans[1] = ind2;

        return ans;
    }
}