package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class TomatoDim2Info {
    int row;
    int col;
    // 몇일에 이 토마토에 왔는지
    int date;

    public TomatoDim2Info(int row, int col, int date) {
        this.row = row;
        this.col = col;
        this.date = date;
    }
}

class TomatoDim2Solver {
    int m;
    int n;
    int[][] tomatoBox;

    Queue<TomatoDim2Info> queue;
    boolean[][] visited;
    int toRipe;

    public TomatoDim2Solver(int m, int n, int[][] tomatoBox, Queue<TomatoDim2Info> queue, boolean[][] visited, int toRipe) {
        this.m = m;
        this.n = n;
        this.tomatoBox = tomatoBox;
        this.queue = queue;
        this.visited = visited;
        this.toRipe = toRipe;
    }

    public int solve() {
        int maxDate = 0;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ripeSuccess = 0;

        while (!queue.isEmpty()) {
            TomatoDim2Info info = queue.poll();
            int date = info.date;
            maxDate = date > maxDate ? date : maxDate;
            int currentRow = info.row;
            int currentCol = info.col;
            for (int[] dir : direction) {
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m
                        && !visited[nextRow][nextCol]
                        && tomatoBox[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new TomatoDim2Info(nextRow,nextCol,date + 1));
                    ripeSuccess++;
                }
            }
        }

        return toRipe == ripeSuccess ? maxDate : -1;

    }
}

public class TomatoDim2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        int[][] tomatoBox = new int[n][m];


        Queue<TomatoDim2Info> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int toRipe = 0;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(line[j]);
                tomatoBox[i][j] = value;
                if (value == 1) {
                    queue.add(new TomatoDim2Info(i, j, 0));
                    visited[i][j] = true;
                }else if(value == 0){
                    toRipe++;
                }
            }
        }

        TomatoDim2Solver solver = new TomatoDim2Solver(m, n, tomatoBox, queue, visited, toRipe);
        int result = solver.solve();
        System.out.println(result);

    }
}
