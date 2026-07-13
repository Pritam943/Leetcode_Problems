class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;
        int ans = -1; // Default to -1 if no solution is found

        // FIX 1: Cast to long before multiplication to prevent integer overflow
        long val = (long) m * k;
        if (val > n)
            return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int pBouquets = possibleBouquets(bloomDay, mid, k);

            if (pBouquets >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int possibleBouquets(int[] arr, int day, int k) {

        int ans = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= day) {
                count = count + 1;
            } else {
                ans += count / k;
                count = 0;
            }
        }

        ans += count / k;

        return ans;
    }
}