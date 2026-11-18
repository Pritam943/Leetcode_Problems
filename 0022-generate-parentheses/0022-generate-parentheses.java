class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backTrack("", 0, 0, n, ans);
        return ans;
    }

    public void backTrack(String s, int left, int right, int n, List<String> ans){

         
         if(s.length() == 2*n){
            ans.add(new String(s));
            return;
         }

         if(left < n){
            backTrack(s+"(", left+1, right, n, ans);
         }

         if(right < left){
            backTrack(s+")", left, right+1, n, ans);
         }
    }
}