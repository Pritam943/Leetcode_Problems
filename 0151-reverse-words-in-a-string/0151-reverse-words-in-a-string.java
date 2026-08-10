class Solution {
    public String reverseWords(String s) {

        // StringBuilder for final result
        StringBuilder result = new StringBuilder();

        // Pointer starting from the end
        int i = s.length() - 1;

        // Traverse from right to left
        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // If pointer goes out of bounds, break
            if (i < 0)
                break;

            // Mark end of word
            int end = i;

            // Move left until space or start of string
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Extract the word
            String word = s.substring(i + 1, end + 1);

            // Add space before appending if result is not empty
            if (result.length() > 0) {
                result.append(" ");
            }

            // Append word
            result.append(word);
        }

        return result.toString();

    }

}