class Solution {
    public int beautySum(String s) {

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] arr = new int[26];

            for (int j = i; j < s.length(); j++) {

                arr[s.charAt(j) - 'a']++;

                int maxF = Arrays.stream(arr).max().getAsInt();
                int minF = Arrays.stream(arr).filter(num -> num != 0).min().getAsInt();

                sum += maxF - minF;
            }
        }

        return sum;
    }
}