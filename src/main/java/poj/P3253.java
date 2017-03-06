package poj;

import java.util.Scanner;

/**
 * Created by andy on 2017/3/6.
 */
public class P3253 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] L = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = in.nextInt();
        }

        // normal logic
        long result = 0;
        while (N > 1) {
            // 找到最短的板1和次短的板2
            int min1 = 0, min2 = 1;
            if (L[min1] > L[min2]) swap(L, min1, min2);
            for (int i = 2; i < N; i++) {
                if (L[i] < L[min1]) {
                    min2 = min1;
                    min1 = i;
                } else if (L[i] < L[min2]) {
                    min2 = i;
                }
            }

            // 求和
            int t = L[min1] + L[min2];
            result += t;

            // 更新最短板为中间结果，次短板为N-1位的值；如果最短板就是N-1位的板，仅更新次短为中间结果。
            if (min1 == N - 1) {
                L[min2] = t;
            } else {
                L[min1] = t;
                L[min2] = L[N - 1];
            }
            N--;
        }
        System.out.println(result);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
