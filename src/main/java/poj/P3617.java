package poj;

import java.util.Scanner;

/**
 * 给定长度为N的字符串S，要构造一个长度为N的字符串T。起初，T是一个字符串，随后反复进行下列任意操作。
 *
 * - 从S的头部删除一个字符，加到T的尾部
 * - 从S的尾部删除一个字符，加到T的尾部
 *
 * 目标是要构造字典序尽可能小的字符串T。
 *
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
        //TODO  如何破解双重循环的思维障碍？
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
