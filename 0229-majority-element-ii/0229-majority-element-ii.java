class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int ele1 = 0;
        int ele2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (count1 == 0 && ele2 != nums[i]) {
                ele1 = nums[i];
                count1++;
            } else if (count2 == 0 && ele1 != nums[i]) {
                ele2 = nums[i];
                count2++;
            } else if (nums[i] == ele1)
                count1++;
            else if (nums[i] == ele2)
                count2++;
            else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;

        for (int num : nums) {

            if (num == ele1)
                count1++;
            else if (num == ele2)
                count2++;
        }

        List<Integer> ans = new ArrayList<>();
        int size = (int)(nums.length / 3)+1;


        if (count1 >= size) {
            ans.add(ele1);
        }
        if (count2 >= size) {
            ans.add(ele2);
        }

        Collections.sort(ans);

        return ans;

    }
}