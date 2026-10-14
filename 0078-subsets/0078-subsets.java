class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        findSubsets(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void findSubsets(int ind, int[] arr, List<List<Integer>> ans, List<Integer> ds) {

        if (ind == arr.length) {

            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(arr[ind]);
        findSubsets(ind + 1, arr, ans, ds);
        ds.remove(ds.size() - 1);
        findSubsets(ind + 1, arr, ans, ds);

    }
}