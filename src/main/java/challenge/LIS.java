package challenge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长上升子序列
 * <p>
 * TestCase:
 * 5
 * 4 2 3 1 5
 * <p>
 * Created by andy on 2017/3/22.
 */
public class LIS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }

        // dp[i]:=长度为i+1的上升子序列中末尾元素的最小值（不存在的话就是INF）
        int INF = 10000000;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);
        for (int i = 0; i < N; i++) {
            int lb = lowerBound(dp, a[i]);
            dp[lb] = a[i];
        }
        System.out.println(lowerBound(dp, INF));
    }

    // 返回大于等于key的第一个元素的索引
    private static int lowerBound(int[] a, int key) {
        int LEN = a.length;
        int lo = 0, hi = LEN - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
