package challenge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 多重部分和问题
 * <p>
 * TestCase:
 * 3 17
 * 3 3 5 2 8 2
 * <p>
 * Created by andy on 2017/3/22.
 */
public class MultiPartialSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] a = new int[N];
        int[] m = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
            m[i] = in.nextInt();
        }

        // dp[i+1][j]:=用前i种数加和得到j时第i种数最多还剩多少个（不能加和得到j的情况下为-1）
        int[] dp = new int[K + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[j] >= 0) {
                    dp[j] = m[i];
                } else if (j < a[i] || dp[j - a[i]] <= 0) {
                    dp[j] = -1;
                } else {
                    dp[j] = dp[j - a[i]] - 1;
                }
            }
        }

        if (dp[K] >= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
