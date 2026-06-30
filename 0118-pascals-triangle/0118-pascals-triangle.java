class Solution {
    public List<List<Integer>> generate(int numRows) {

        //use nCr method

        List<List<Integer>> ansList = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            ansList.add(getRow(i));
        }

        return ansList;

    }

    public List<Integer> getRow(int n) {

        List<Integer> list = new ArrayList<>();

        int ans = 1;
        list.add(ans);

        for (int i = 1; i < n; i++) { // n -> 5 =  1
                                      //= 1*(5-1)/1 = 4
                                      // = 4 * (5-2) / 2 = 6
            ans = ans * (n - i); // = 6 * (5-3) / 3 = 4
            ans = ans / i; // = 4 * (5-4) / 4 = 1
            list.add(ans);
        }

        return list;
    }
}