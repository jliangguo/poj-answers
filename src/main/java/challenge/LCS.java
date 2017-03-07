package challenge;

import java.util.Scanner;

/**
 * 最长公共子序列问题：
 * <p>
 * TestCase:
 * 4 4
 * abcd becd
 * <p>
 * Created by andy on 2017/3/8.
 */
public class LCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        String s = in.next();
        String t = in.next();

        // initialize dp array
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = new int[M + 1];
        }

        // normal logic
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
