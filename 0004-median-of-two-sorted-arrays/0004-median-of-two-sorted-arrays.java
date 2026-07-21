class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];

        int left = 0;
        int right = 0;

        int i=0;
        while(left <= m-1 && right <= n-1){

             if(nums1[left] <= nums2[right]){
                 arr[i++] = nums1[left];
                 left++;
             }
             else{
                arr[i++] = nums2[right];
                right++;
             }
        }

        while(left <= m-1){
             arr[i++] = nums1[left++];
        }

        while(right <= n-1){
            arr[i++] = nums2[right++];
        }

        int size = arr.length;

        if(size % 2 == 0){

             int low = (int) Math.floor((size - 1) / 2.0); 
             int high = low+1; 

             double mid = (double)(arr[low] + arr[high])/2;
             return mid;
        }

        int mid = (size/2);
        return (double)arr[mid];
        
    }
}