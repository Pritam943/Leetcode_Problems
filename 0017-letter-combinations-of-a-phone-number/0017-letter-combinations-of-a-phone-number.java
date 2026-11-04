class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();

        if (digits.length() == 0) {
            return list;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrackPhone(0, new StringBuffer(), digits, list, map);

        return list;
    }

    public void backTrackPhone(int index, StringBuffer sb, String digits, List<String> list,
            Map<Character, String> map) {

        if (sb.length() == digits.length()) {
            list.add(sb.toString());
        }

        else {

            for (int i = index; i < digits.length(); i++) {

                char c = digits.charAt(i);

                if (map.containsKey(c)) {

                    String st = map.get(c);

                    for (int j = 0; j < st.length(); j++) {

                        sb.append(st.charAt(j));
                        backTrackPhone(i + 1, sb, digits, list, map);
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
    }
}