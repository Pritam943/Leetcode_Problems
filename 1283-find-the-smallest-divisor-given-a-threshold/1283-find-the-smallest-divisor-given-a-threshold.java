class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int ans = 1;

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (foundDivisor(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    public boolean foundDivisor(int[] nums, int val, int threshold) {

        int ans = 0;

        for (int num : nums) {

            ans += (int) Math.ceil((double) num / val);
        }

        return ans <= threshold;
    }
}