class Solution {
    public String removeOuterParentheses(String s) {

        int count = 0;
        String ans = "";

        for(char ch : s.toCharArray()){

             if(ch == '('){
                 
                 if(count != 0){
                    count++;
                    ans += ch;
                 }
                 else{
                    count++;
                 }
             }
             else{
                count--;
                if(count != 0){
                    ans += ch;
                }
             }
        }

        return ans;
        
    }
}