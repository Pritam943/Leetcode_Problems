class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n];

        int pos = 0;
        int neg = 1;

        for (int i = 0; i < n; i++) {

            if (nums[i] < 0 && neg < n) {

                arr[neg] = nums[i];
                neg += 2;
            }
            if (nums[i] > 0 && pos < n) {

                arr[pos] = nums[i];
                pos += 2;
            }

        }

        return arr;

    }
}