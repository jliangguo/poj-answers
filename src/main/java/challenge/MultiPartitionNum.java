package challenge;

import java.util.Scanner;

/**
 * 多重集组合数
 * <p>
 * TestCase:
 * 3 3 10000 1 2 3
 * <p>
 * Created by andy on 2017/3/23.
 */
public class MultiPartitionNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int M = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        // dp[i][j]:=从前i种物品中取出j个的组合总数
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new int[m + 1];
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - 1 >= a[i]) {
                    dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i][j] - dp[i][j - 1 - a[i]]) % M;
                } else {
                    dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i][j]) % M;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
