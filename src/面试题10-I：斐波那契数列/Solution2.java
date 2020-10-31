public class Solution2 {
    public static int fib(int n) {
        int a = 0, b = 1;
        for(int i = 0; i <= n; i++) {
            int s = (a+b) %1000000007;
            System.out.println(s);
            a = b;
            b = s;
        }
        return a;
    }

    public static void main(String[] args) {
        int res = fib(5);
    }
}
