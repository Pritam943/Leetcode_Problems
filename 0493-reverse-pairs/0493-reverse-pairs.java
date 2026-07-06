class Solution {
    public int reversePairs(int[] nums) {

        return reverseMergeSort(nums, 0, nums.length - 1);

    }

    public int reverseMergeSort(int arr[], int low, int high) {

        int count = 0;

        if (low >= high)
            return count;

        int mid = low + (high - low) / 2;

        count += reverseMergeSort(arr, low, mid);
        count += reverseMergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high); //Modification
        mergeArray(arr, low, mid, high);

        return count;
    }

       public int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * (long)arr[right])
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public void mergeArray(int arr[], int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int i = 0;

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {

                temp[i++] = arr[left++];
            } else {
                temp[i++] = arr[right++];

            }

        }

        while (left <= mid) {
            temp[i++] = arr[left++];
        }
        while (right <= high) {
            temp[i++] = arr[right++];
        }

        for (int j = 0; j < temp.length; j++) {

            arr[low + j] = temp[j];
        }
    }

}