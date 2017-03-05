package poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TestCase:
 * <p>
 * 0 3
 * 10 20 20
 * 10 7
 * 70 30 1 7 15 20 50
 * -1 -1
 * <p>
 * Created by andy on 2017/3/5.
 */
public class P3069 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int N = in.nextInt();

        while (true) {
            // check loop
            if (R == -1 && N == -1)
                break;

            // read location x[i] and sort
            int[] x = new int[N];
            for (int i = 0; i < N; i++) {
                x[i] = in.nextInt();
            }
            Arrays.sort(x);

            // main logic
            int i = 0, result = 0;
            while (i < N) {
                int s = x[i++]; // s是最左边没有被覆盖的点
                // 一直向右前进直到距s的距离大于R的点
                while (i < N && x[i] <= s + R) i++;

                int p = x[i - 1];// p是新加上标记的点的位置
                // 一直向右前进直到距p的距离大于R的点
                while (i < N && x[i] <= p + R) i++;

                result++;
            }
            System.out.println(result);

            R = in.nextInt();
            N = in.nextInt();
        }
    }
}
