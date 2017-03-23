package challenge;

import java.util.Scanner;

/**
 * 划分数
 * <p>
 * TestCase：
 * 4 3 1000
 * <p>
 * Created by andy on 2017/3/23.
 */
public class PartitionNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int M = in.nextInt();

        // dp[i][j]:=j的i划分的总数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = new int[n + 1];
        }
        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= i) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - i]) % M;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
