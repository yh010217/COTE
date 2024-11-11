package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//7569
class TomatoCalculator {
    public int calculateByBFS(int[][][] tomatoBox
            , Queue<int[]> queue, int[][][] visited) {

        int m = tomatoBox[0][0].length;
        int n = tomatoBox[0].length;
        int h = tomatoBox.length;

        int[][] direction = new int[][]{
                {-1, 0, 0}, {1, 0, 0}
                , {0, -1, 0}, {0, 1, 0}
                , {0, 0, -1}, {0, 0, 1}
        };
        //일단 다 돌아보고 0이 남아있으면 -1 을 리턴하는 방식으로 ㄱㄱ
        int[] currentTomato = null;
        while (!queue.isEmpty()) {
            currentTomato = queue.poll();
            int currentDepth = currentTomato[3];
            for(int i = 0 ; i < direction.length ; i++){
                int nextH = currentTomato[0] + direction[i][0];
                int nextN = currentTomato[1] + direction[i][1];
                int nextM = currentTomato[2] + direction[i][2];

                if(nextH >= 0 && nextH < h
                && nextN >= 0 && nextN < n
                && nextM >= 0 && nextM < m

                && tomatoBox[nextH][nextN][nextM] == 0
                && visited[nextH][nextN][nextM] == 0){

                    queue.add(new int[]{nextH,nextN,nextM,currentDepth+1});
                    visited[nextH][nextN][nextM] = 1;
                    // 좀이따 토마토박스에 0이 없는거로 판단할 거여서...
                    // 스토리상으로도 맞긴 하잖아? 익으면 1로 바꿔야지... ㅋ
                    tomatoBox[nextH][nextN][nextM] = 1;


                }
            }
        }


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(tomatoBox[i][j][k] == 0) return -1;
                }
            }
        }
        //위에서 리턴 안됐으면 마지막 토마토에서 날짜 세면 됨
        return (currentTomato == null) ? -1 : currentTomato[3];

    }
}

public class Tomato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();

        int m = Integer.parseInt(firstLine.split(" ")[0]);
        int n = Integer.parseInt(firstLine.split(" ")[1]);
        int h = Integer.parseInt(firstLine.split(" ")[2]);

        int[][][] tomatoBox = new int[h][n][m];
        int[][][] visited = new int[h][n][m];

        // 그냥 박스 만들때 큐 만들자
        // h,n,m,일자
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String oneLine = scanner.nextLine();
                String[] oneLineSplit = oneLine.split(" ");
                for (int k = 0; k < m; k++) {
                    int value = Integer.parseInt(oneLineSplit[k]);
                    tomatoBox[i][j][k] = value;
                    if (value == 1) {
                        queue.add(new int[]{i, j, k, 0});
                        visited[i][j][k] = 1;
                    }
                }
            }
        }

        TomatoCalculator calculator = new TomatoCalculator();
        int result = calculator.calculateByBFS(tomatoBox, queue, visited);

        System.out.println(result);

    }
}
