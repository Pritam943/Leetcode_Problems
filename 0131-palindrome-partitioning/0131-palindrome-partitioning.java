class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        findResult(0, s, list, res);
        return res;
    }

    public void findResult(int ind, String s, List<String> list, List<List<String>> res){

         
          if(ind == s.length()){
              res.add(new ArrayList<>(list));
              return;
          }

          for(int i=ind; i<s.length(); ++i){

             if(isPalindrome(s, ind, i)){

                 list.add(s.substring(ind, i+1));
                 findResult(i+1, s, list, res);
                 list.remove(list.size()-1);
             }
          }
    }

    public boolean isPalindrome(String s, int start, int end){

         while(start <= end){

             if(s.charAt(start++) != s.charAt(end--)){
                return false;
             }
         }

         return true;
    }
}