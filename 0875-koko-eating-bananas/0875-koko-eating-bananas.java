class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        //  // Find max using Stream API
        // int max = Arrays.stream(numbers)
        //                 .max()
        //                 .getAsInt(); // Throws exception if array is empty

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int totalTime = requiredTime(piles, mid);

            if (totalTime <= h) {

                ans = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }

        }

        return ans;

    }

    public int requiredTime(int piles[], int k) {

        int totalTime = 0;
        for (int i = 0; i < piles.length; i++) {

            totalTime += Math.ceil((double) piles[i] / k);
        }

        return totalTime;
    }
}