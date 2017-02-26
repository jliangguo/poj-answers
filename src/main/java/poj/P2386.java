package poj;

import java.util.Scanner;

/**
 * Created by andy on 2017/2/24.
 */
public class P2386 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        // read field
        char[][] a = new char[N][M];
        for (int i = 0; i < N; i++) {
            a[i] = new char[M];
            String line = in.next();
            for (int j = 0; j < M; j++) {
                a[i][j] = line.charAt(j);
            }
        }

        // solve
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 'W') {
                    dfs(a, N, M, i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(char[][] a, int N, int M, int x, int y) {
        a[x][y] = '.';

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx, ny = y + dy;
                if (0 <= nx && nx < N && 0 <= ny && ny < M && a[nx][ny] == 'W')
                    dfs(a, N, M, nx, ny);
            }
        }
    }
}
