class Solution {
    public double myPow(double x, int n) {

        long N = n;

        if (N < 0) {
            N = -n;
        }

         double ans = fastPow(x, N);
        
        // FIX: Invert the final computed answer once at the end 
        // instead of transforming the base x at the beginning.
        if (n < 0) {
            return 1.0 / ans;
        }
        
        return ans;

    }

    public double fastPow(double x, long n) {

        if (n == 0)
            return 1.0;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}