class Solution {
    public int findContentChildren(int[] g, int[] s) {

        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0; // pointer for cookies (s)
        int right = 0; // pointer for children (g)

        while (left < m && right < n) {
            if (s[left] >= g[right]) {
                right++; // child is content, move to the next child
            }
            left++; // move to the next cookie regardless
        }

        return right;
    }
}