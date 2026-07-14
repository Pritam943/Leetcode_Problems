class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int ans = 0;

        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int reqDay = leastCapacity(weights, mid, days);

            if (reqDay <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans;

    }

    public int leastCapacity(int[] arr, int w, int day) {

        int sum = 0;
        int count = 1;

        for (int num : arr) {

            if ((sum + num) > w) {
                sum = 0;
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }

        return count;
    }
}