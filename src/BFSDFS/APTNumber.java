package BFSDFS;

import java.util.*;

class RowCol {
    public int row;
    public int col;
    public RowCol(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
class APTFind {
    private int[][] visited;

    public void setVisited(int[][] visited) {
        this.visited = visited;
    }
    public int[][] getVisited(){
        return visited;
    }

    private int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public int oneAptBfs(int[][] apt, int rowPos, int colPos) {
        int n = apt.length;
        int currentRow = rowPos;
        int currentCol = colPos;

        Queue<RowCol> rowCols= new LinkedList<>();
        RowCol first = new RowCol(currentRow,currentCol);
        rowCols.add(first);

        visited[currentRow][currentCol] = 1;

        int num = 1;

        while(!rowCols.isEmpty()){
            RowCol current = rowCols.poll();
            currentRow = current.row;
            currentCol = current.col;
            for(int i = 0 ; i < direction.length ; i++){
                int nextRow = currentRow + direction[i][0];
                int nextCol = currentCol + direction[i][1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n
                        && apt[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == 0){
                    rowCols.add(new RowCol(nextRow,nextCol));
                    visited[nextRow][nextCol] = 1;
                    num++;
                }
            }
        }


        return num;
    }

}

public class APTNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] apt = new int[n][n];
        for (int i = 0; i < n; i++) {
            String scannerLine = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                apt[i][j] = scannerLine.charAt(j) - '0';
            }
        }

        int totNum = 0;
        List<Integer> numPerApt = new ArrayList<>();
        APTFind aptFind = new APTFind();
        aptFind.setVisited(new int[n][n]);

        int thisApt = 0;
        for(int rowPos = 0 ; rowPos < n ; rowPos ++){
            for(int colPos = 0; colPos < n ; colPos ++){

                // 집이 있는 곳이고 && 단지를 순회하면서 안둘러본 곳이어야함
                if(apt[rowPos][colPos] == 1 && aptFind.getVisited()[rowPos][colPos] == 0){

                    thisApt = aptFind.oneAptBfs(apt, rowPos,colPos);

                    numPerApt.add(thisApt);
                    totNum++;

                }
            }
        }
        numPerApt.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : o1 == o2 ? 0 : -1;
            }
        });
        System.out.println(totNum);
        for(int i = 0 ; i < totNum ; i ++){
            System.out.println(numPerApt.get(i));
        }
    }
}
