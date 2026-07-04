class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        int maxCount = 0;

        for (int num : nums) {

            set.add(num);
        }

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int count = 0;
                int val = num;

                while (set.contains(val)) {
                    count++;
                    val++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}