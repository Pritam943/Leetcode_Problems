class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        backtrack(num, target, 0, 0, 0, "", result);

        return result;
    }

    private void backtrack(
            String num,
            int target,
            int index,
            long currentValue,
            long previousOperand,
            String expression,
            List<String> result) {

        // Base case: All digits are used
        if (index == num.length()) {

            if (currentValue == target) {
                result.add(expression);
            }

            return;
        }

        // Generate all possible numbers starting at index
        for (int end = index; end < num.length(); end++) {

            // Avoid numbers with leading zeros
            if (end > index && num.charAt(index) == '0') {
                break;
            }

            // Extract current number
            String currentStr = num.substring(index, end + 1);

            long currentNum = Long.parseLong(currentStr);

            // First number: no operator required
            if (index == 0) {

                backtrack(
                        num,
                        target,
                        end + 1,
                        currentNum,
                        currentNum,
                        currentStr,
                        result);

            } else {

                // Case 1: Addition
                backtrack(
                        num,
                        target,
                        end + 1,
                        currentValue + currentNum,
                        currentNum,
                        expression + "+" + currentStr,
                        result);

                // Case 2: Subtraction
                backtrack(
                        num,
                        target,
                        end + 1,
                        currentValue - currentNum,
                        -currentNum,
                        expression + "-" + currentStr,
                        result);

                // Case 3: Multiplication
                backtrack(
                        num,
                        target,
                        end + 1,
                        currentValue - previousOperand
                                + previousOperand * currentNum,
                        previousOperand * currentNum,
                        expression + "*" + currentStr,
                        result);
            }
        }
    }
}
