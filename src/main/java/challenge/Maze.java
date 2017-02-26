package challenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 迷宫的最短路径
 * TestCase：
 * 10 10
 * #S######.#
 * ......#..#
 * .#.##.##.#
 * .#........
 * ##.##.####
 * ....#....#
 * .#######.#
 * ....#.....
 * .####.###.
 * ....#...G#
 * <p>
 * Created by andy on 2017/2/26.
 */
public class Maze {
    private static final int INF = 100000000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        char[][] maze = new char[N][M];
        int sx = 0, sy = 0;
        int gx = 0, gy = 0;
        for (int i = 0; i < N; i++) {
            maze[i] = new char[M];
            String line = in.next();
            for (int j = 0; j < M; j++) {
                char tmp = line.charAt(j);
                maze[i][j] = tmp;
                if (tmp == 'S') {
                    sx = i;
                    sy = j;
                } else if (tmp == 'G') {
                    gx = i;
                    gy = j;
                }
            }
        }

        System.out.println(bfs(maze, N, M, sx, sy, gx, gy));
    }

    private static int bfs(char[][] maze, int N, int M, int sx, int sy, int gx, int gy) {
        int[][] distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            distance[i] = new int[M];
            for (int j = 0; j < M; j++) {
                distance[i][j] = INF;
            }
        }
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

        Queue<Integer> q = new LinkedList<>();
        q.offer((sx << 8) + sy);
        distance[sx][sy] = 0;

        while (q.size() > 0) {
            int e = q.poll();
            int x = e / 256, y = e % 256;
            if (x == gx && y == gy) break;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && maze[nx][ny] != '#' &&
                        distance[nx][ny] == INF) {
                    q.offer((nx << 8) + ny);
                    distance[nx][ny] = distance[x][y] + 1;
                }
            }
        }
        return distance[gx][gy];
    }
}
