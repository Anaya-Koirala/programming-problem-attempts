/* TODO: Code fails the last three test cases due to time limit :( */

import java.util.Scanner;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class TenKindsOfPeople {
    static int[][] map;
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static int rowSize, colSize;

    public static boolean eval(int r1, int c1, int r2, int c2) {
        if (map[r1][c1] != map[r2][c2])
            return false;

        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(visited[i], false);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r1, c1});
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == r2 && cur[1] == c2) return true;

            for (int[] d : delta) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < rowSize && nc >= 0 && nc < colSize &&
                    !visited[nr][nc] && map[nr][nc] == map[r1][c1]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        rowSize = in.nextInt();
        colSize = in.nextInt();
        in.nextLine();

        map = new int[rowSize][colSize];
        visited = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            String line = in.nextLine();
            for (int j = 0; j < colSize; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int r1 = in.nextInt() - 1;
            int c1 = in.nextInt() - 1;
            int r2 = in.nextInt() - 1;
            int c2 = in.nextInt() - 1;

            if (!eval(r1, c1, r2, c2)) {
                System.out.println("neither");
            } else if (map[r1][c1] == 1) {
                System.out.println("decimal");
            } else {
                System.out.println("binary");
            }
        }
        in.close();
    }
}
