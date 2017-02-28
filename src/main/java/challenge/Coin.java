package challenge;

import java.util.Scanner;

/**
 * 硬币问题
 * <p>
 * Created by andy on 2017/3/1.
 */
public class Coin {
    private static int[] COIN_VALUES = {1, 5, 10, 50, 100, 500};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = in.nextInt();
        }

        int result = 0;
        for (int i = 5; i >= 0; i--) {
            int t = Math.min(A / COIN_VALUES[i], nums[i]); // 当前最优
            A -= t * COIN_VALUES[i];
            result += t;
        }
        System.out.println(result);
    }
}
