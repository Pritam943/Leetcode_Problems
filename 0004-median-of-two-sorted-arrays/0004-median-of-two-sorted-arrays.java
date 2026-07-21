class Solution { 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        int n1 = nums1.length; 
        int n2 = nums2.length; 
        
        // Ensure binary search runs on the smaller array for O(log(min(n1, n2))) complexity
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1); 
        
        int low = 0; 
        int high = n1; 
        int left = (n1 + n2 + 1) / 2; 
        int n = n1 + n2; 
        
        while (low <= high) { 
            int mid1 = (low + high) / 2; 
            int mid2 = left - mid1; 
            
            // Assign actual array values or boundaries
            int l1 = (mid1 - 1 >= 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1 >= 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE; 
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE; 
            
            // Valid partition achieved
            if (l1 <= r2 && l2 <= r1) { 
                if (n % 2 == 1) {
                    return Math.max(l1, l2); 
                }
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0; 
            } 
            // Binary search range adjustment
            else if (l1 > r2) {
                high = mid1 - 1; 
            } else {
                low = mid1 + 1; 
            }
        } 
        return 0.0; 
    } 
}
