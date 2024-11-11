package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class IcebergSolver{

    int n;
    int m;
    int[][] current;

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 어딘가에서 시작해서 다 돌고 왔는데 exist보다 적게 찾아지면 두덩어리가 된것
    int exist;
    private int year = 0;
    public int getYear(){
        return year;
    }
    public IcebergSolver(int[][] current, int exist) {
        this.current = current;
        n = current.length;
        m = current[0].length;
        this.exist = exist;
    }
    public void solve(){
        // 돌고 오기
        // 한번 돌았는데 존재하는 얼음들 다 못돌고 왔다는건 두덩이가 됐단 것
        if(exist == 0) {
            year = 0;
            return;
        }
        if(exist != around()) return;

        // 내년으로 ㄱㄱ, exist까지 계산
        year++;
        int nextYearExist = 0;
        int[][] melt = new int[n][m];
        for(int i = 1 ; i < n-1 ; i++){
            for(int j = 1 ; j < m-1 ; j++){
                if(current[i][j]!=0){
                    int iceValue = current[i][j];
                    for(int k = 0 ; k < 4 ; k++){
                        int aroundRow = i + directions[k][0];
                        int aroundCol = j + directions[k][1];
                        if(current[aroundRow][aroundCol] == 0 && iceValue != 0){
                            iceValue --;
                        }
                    }
                    melt[i][j] = iceValue;
                    if(iceValue != 0) nextYearExist++;
                }
            }
        }
        exist = nextYearExist;
        current = melt;
        solve();
    }
    private int around(){
        int answer = 0;

        boolean firstIceFind = false;
        int i = 1;
        int j = 1;
        for( ; i < n-1 ; i ++){
            for( ; j < m-1 ; j++){
                if(current[i][j] != 0){
                    firstIceFind = true;
                    break;
                }
            }
            if(firstIceFind) break;
            j = 1;
        }
        if(!firstIceFind) return 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        answer++;
        while (!queue.isEmpty()){
            int[] currentRowCol = queue.poll();
            int currentRow = currentRowCol[0];
            int currentCol = currentRowCol[1];
            for(int k = 0 ; k < 4 ; k++){
                int nextRow = currentRow + directions[k][0];
                int nextCol = currentCol + directions[k][1];
                if(current[nextRow][nextCol] != 0 && !visited[nextRow][nextCol]){
                    queue.add(new int[]{nextRow,nextCol});
                    visited[nextRow][nextCol] = true;
                    answer++;
                }
            }
        }


        return answer;
    }
}

//2573 빙산
public class Iceberg {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] iceberg = new int[n][m];
        int exist = 0;
        for(int i = 0 ; i < n ; i ++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j ++){
                int value = Integer.parseInt(line[j]);
                iceberg[i][j] = value;
                if(value != 0) exist++;
            }
        }

        IcebergSolver solver = new IcebergSolver(iceberg,exist);
        solver.solve();
        System.out.println(solver.getYear());

    }
}
