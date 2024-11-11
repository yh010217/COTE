package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2468 안전영역

class SafetyZoneSolver {
    private int maxHeight;
    int[][] board;
    int n;
    boolean[][] visited;

    public SafetyZoneSolver(int maxHeight, int[][] board) {
        this.maxHeight = maxHeight;
        this.board = board;
        n = board.length;
    }

    private int maxArea = 0;

    public int getMaxArea() {
        return maxArea;
    }

    int currentArea = 0;
    int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve() {
        // 뭐... maxHeight랑 똑같으면 다 잠기겄지...?
        for (int i = 0; i < maxHeight; i++) {
            currentArea = 0;
            visited = new boolean[n][n];
            int row = 0;
            int col = 0;
            while (row < n) {
                boolean breakSignal = false;
                for (; row < n; row++) {
                    for (; col < n; col++) {
                        if (board[row][col] > i && !visited[row][col]) {
                            breakSignal = true;
                            break;
                        }
                    }
                    if (breakSignal) break;
                    col = 0;
                }
                if (row != n) {
                    currentArea++;
                    // 이 타이밍에 visited를 안올려놓은게 패착
                    visited[row][col] = true;
                    dfs(i, row, col);
                }
            }
            maxArea = maxArea > currentArea ? maxArea : currentArea;
        }
    }

    public void dfs(int rainHeight, int row, int col) {
        for (int i = 0; i < direction.length; i++) {
            int nextRow = row + direction[i][0];
            int nextCol = col + direction[i][1];
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n
                    && board[nextRow][nextCol] > rainHeight
                    && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                dfs(rainHeight, nextRow, nextCol);
            }
        }
    }

}

public class SafetyZone {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(line[j]);
                board[i][j] = value;
                if (value > maxHeight) maxHeight = value;
            }
        }
        SafetyZoneSolver solver = new SafetyZoneSolver(maxHeight, board);
        solver.solve();
        System.out.println(solver.getMaxArea());

    }
}
