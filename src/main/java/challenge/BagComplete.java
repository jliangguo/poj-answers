package challenge;

import java.util.Scanner;

/**
 * 完全背包问题
 * TestCase:
 * 3 7
 * 3 4 4 5 2 3
 * <p>
 * Created by andy on 2017/3/18.
 */
public class BagComplete {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();// [1, 100]
        int W = in.nextInt();// [1, 10000]
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

//        solve1(N, W, w, v, dp);
        solve2(N, W, w, v, dp);
    }

    // 复杂度$$O(nW^2)$$
    private static void solve1(int N, int W, int[] w, int[] v, int[][] dp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                for (int k = 0; k * w[i] <= j; k++) { // k表示可取的物品数量
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - k * w[i]] + k * v[i]);
                }
            }
        }
        System.out.println(dp[N][W]);
    }

    // 复杂度$$O(nW)$$，注意演算关系
    private static void solve2(int N, int W, int[] w, int[] v, int[][] dp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[N][W]);
    }
}
