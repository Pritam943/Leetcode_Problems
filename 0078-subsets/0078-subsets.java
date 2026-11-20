class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        foundSubset(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void foundSubset(int index, int[] nums, List<Integer> list, List<List<Integer>> ans){

        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        foundSubset(index+1, nums, list, ans);
        list.remove(list.size()-1);
        foundSubset(index+1, nums, list, ans);
    }
}