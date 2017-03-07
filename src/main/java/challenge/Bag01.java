package challenge;

import java.util.Scanner;

/**
 * 01背包问题：
 * <p>
 * TestCase：
 * 4 5
 * 2 3 1 2 3 4 2 2
 * <p>
 * Created by andy on 2017/3/8.
 */
public class Bag01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int W = in.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }

        // memory array
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = new int[W + 1];
        }

        // normal logic
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[0][W]);
    }
}
