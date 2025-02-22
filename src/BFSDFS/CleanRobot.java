package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//14503 로봇 청소기

class CleanRobotSolver{
    /** false 면 벽이어서 못감. true면 갈수야 있음 */
    boolean[][] room;
    boolean[][] visited;

    public CleanRobotSolver(boolean[][] room) {
        this.room = room;
        visited = new boolean[room.length][room[0].length];
    }

    private int answer = 0;

    public int getAnswer() {
        return answer;
    }

    int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public void solve(int row, int col, int dir){
        int currentRow = row;
        int currentCol = col;
        int currentDir = dir;
        while(true){

            if(!visited[currentRow][currentCol]){
                //visit 했던 곳이어도, 후진하느라 도착할 수 있음
                answer++;
                visited[currentRow][currentCol] = true;
            }
            int nextRow;
            int nextCol;
            int nextDir;
            boolean find = false;
            for(int i = 1 ; i <= 4 ; i ++){
                nextDir = currentDir - i;
                nextDir = nextDir < 0 ? nextDir + 4 : nextDir;
                nextRow = currentRow + direction[nextDir][0];
                nextCol = currentCol + direction[nextDir][1];
                // 어차피 처음, 마지막 row,col 은 벽이 있고 그곳으로 갈 수가 없어서 index 예외는 안남
                if(room[nextRow][nextCol] && !visited[nextRow][nextCol]){
                    find = true;
                    //answer랑 visited는 solve 맨 위에서 진행할거임
                    currentRow = nextRow;
                    currentCol = nextCol;
                    currentDir = nextDir;
                    break;
                }
            }
            if(!find){
                // 후진해야함
                int backDir = currentDir - 2;
                backDir = backDir < 0 ? backDir + 4 : backDir;
                int backRow = currentRow + direction[backDir][0];
                int backCol = currentCol + direction[backDir][1];
                // 어차피 처음, 마지막 row,col 은 벽이 있고 그곳으로 갈 수가 없어서 index 예외는 안남
                if(room[backRow][backCol]){
                    currentRow = backRow;
                    currentCol = backCol;
                }
                else{
                    break;
                }
            }
        }
    }
}

public class CleanRobot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        boolean[][] room = new boolean[n][m];

        String[] rcd = br.readLine().split(" ");
        int row = Integer.parseInt(rcd[0]);
        int col = Integer.parseInt(rcd[1]);
        int dir = Integer.parseInt(rcd[2]);


        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                //갈 수 없다.
                if(line[j].equals("1")) room[i][j] = false;
                //갈 수 있다.
                else room[i][j] = true;
            }
        }

        CleanRobotSolver solver = new CleanRobotSolver(room);
        solver.solve(row,col,dir);
        System.out.println(solver.getAnswer());

    }
}
