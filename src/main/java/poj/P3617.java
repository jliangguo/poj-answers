package poj;

import java.util.Scanner;

/**
 * Created by andy on 2017/3/1.
 */
public class P3617 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        char[] S = new char[N];

        for (int i = 0; i < N; i++) {
            S[i] = in.next().charAt(0);
        }

        int a = 0, b = N - 1, lineNum = 0;
        while (a <= b) {
            boolean left = false;
            for (int i = 0; a + i <= b; i++) {
                if (S[a + i] < S[b - i]) {
                    left = true;
                    lineNum++;
                    break;
                } else if (S[a + i] > S[b - i]) {
                    left = false;
                    lineNum++;
                    break;
                }
            }
            if (left) System.out.print(S[a++]);
            else System.out.print(S[b--]);

            if (lineNum % 80 == 0)
                System.out.println();
        }
        System.out.println();
    }
}
