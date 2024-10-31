package BFSDFS;//2178

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Position {
    int row, col, distance;

    Position(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
public class SearchMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringNM = scanner.nextLine();
        int n = Integer.parseInt(stringNM.split(" ")[0]);
        int m = Integer.parseInt(stringNM.split(" ")[1]);

        // 문제에서는 1,1에서 시작해서 n,m 에서 끝나는 좌표 기준인거 같지만...
        // 나는 그냥 0,0 에서 n-1,m-1 이라고 생각하고 풀게?
        int[][] maze = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String mazeOneLine = scanner.nextLine();
            for(int j = 0 ; j < m ; j++){
                int ijPossible = mazeOneLine.charAt(j)-48;
                maze[i][j] = ijPossible;
            }
        }
        scanner.close();

        //dfs 는 재귀함수가 아니니깐... 함 해보자고
        //지나가면 그냥 1이었던걸 0으로 바꾸죠?

        int ans = 0;
        Queue<Position> queue = new LinkedList();
        queue.add(new Position(0,0,0));//row, col, 몇번째에 도착했는지

        while(!queue.isEmpty()){
            Position current = queue.poll();
            int distance = current.distance + 1;
            if(current.row == n-1 && current.col == m-1) {
                ans = distance;
                break;
            }
            // 왔던 길은 0으로 둬버림. 다음에 갈 수 있는 곳이라고 판단 못하게
            //maze[current.row][current.col] = 0;
            //갈 수 있는 곳이면 큐에 넣기
            //상
            if(current.row != 0 && maze[current.row - 1][current.col] == 1){
                queue.add(new Position(current.row-1,current.col,distance));
                maze[current.row-1][current.col] = 0;
            }
            //하
            if(current.row != n-1 && maze[current.row + 1][current.col] == 1){
                queue.add(new Position(current.row+1,current.col,distance));
                maze[current.row+1][current.col] = 0;
            }
            //좌
            if(current.col != 0 && maze[current.row][current.col-1] == 1){
                queue.add(new Position(current.row,current.col-1,distance));
                maze[current.row][current.col-1] = 0;
            }
            //우
            if(current.col != m-1 && maze[current.row][current.col+1] == 1){
                queue.add(new Position(current.row,current.col+1,distance));
                maze[current.row][current.col+1] = 0;
            }

        }


        System.out.println(ans);

    }
}


// 그냥 new int[]{row,col,distance} 로 한 것들
/*
        int ans = 0;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0,ans});//row, col, 몇번째에 도착했는지

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int distance = current[2] + 1;
            if(current[0] == n-1 && current[1] == m-1) {
                ans = distance;
                break;
            }
            // 왔던 길은 0으로 둬버림. 다음에 갈 수 있는 곳이라고 판단 못하게
            maze[current[0]][current[1]] = 0;
            //갈 수 있는 곳이면 큐에 넣기
            //상
            if(current[0] != 0 && maze[current[0] - 1][current[1]] == 1){
                queue.add(new int[]{current[0]-1,current[1],distance});
            }
            //하
            if(current[0] != n-1 && maze[current[0] + 1][current[1]] == 1){
                queue.add(new int[]{current[0]+1,current[1],distance});
            }
            //좌
            if(current[1] != 0 && maze[current[0]][current[1]-1] == 1){
                queue.add(new int[]{current[0],current[1]-1,distance});
            }
            //우
            if(current[1] != m-1 && maze[current[0]][current[1]+1] == 1){
                queue.add(new int[]{current[0],current[1]+1,distance});
            }

        }


 */