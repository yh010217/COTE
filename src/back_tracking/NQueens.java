package back_tracking;

import java.util.HashSet;
import java.util.Scanner;
//3344 근데 99999 이러면 못품... 문제 틀림
class NQueensSolver {
    private int[] queenPos;
    private int n;

    public void setQueenPos(int[] queenPos) {
        this.queenPos = queenPos;
    }

    public void setN(int n) {
        this.n = n;
    }

    private HashSet<Integer> colSet = new HashSet<>();
    //row col을 0부터 시작으로 두자...
    public boolean solve(int row){
        // 현재 row에서의 컬럼 확인하는 작업
        for(int i = 0 ; i < n ; i ++){
            // col중복 확인
            if(!colSet.contains(i)){
                boolean continuePoint = false;
                //대각선 확인
                for(int j = 0 ; j < row ; j++){
                    // 원래 절댓값으로 접근해야겠지만 일단은...
                    if(queenPos[j] + j == row + i || queenPos[j] - j == i - row) {
                        continuePoint = true;
                        break;
                    }
                }
                if(continuePoint) continue;

                //위의 조건을 거치고 오면 백트래킹 시작
                queenPos[row] = i;
                colSet.add(i);
                if(row + 1 == n){
                    return true;
                }else {
                    boolean result = solve(row+1);
                    if(result){
                        return true;
                    }else{
                        colSet.remove(i);
                    }
                }
            }
        }
        return false;
    }
}
public class NQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] queenPos = new int[n];
        NQueensSolver solver = new NQueensSolver();
        solver.setQueenPos(queenPos);
        solver.setN(n);
        solver.solve(0);
        for(int i = 0 ; i < n ; i ++){
            System.out.println(queenPos[i] + 1);
        }
    }
}
