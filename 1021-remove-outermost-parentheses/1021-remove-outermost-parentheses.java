class Solution {
    public String removeOuterParentheses(String s) {

        int counter = 0;
        String ans = "";

        for(char ch : s.toCharArray()){

             if(ch == '('){

                  if(counter!=0){
                       counter++;
                       ans += ch;
                  }
                  else{
                    counter++;
                  }
             }
             else if(ch == ')'){

                 counter = counter-1;
                 
                 if(counter!=0){
                     ans += ch;
                 }
             }
        }

        return ans;
        
    }
}