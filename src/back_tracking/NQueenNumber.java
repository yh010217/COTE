package back_tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

//9663
class NQueenNumberSolver {
    int answer = 0;
    private char[] queenPos;
    private int n;

    public int getAnswer() {
        return answer;
    }

    public void setQueenPos(char[] queenPos) {
        this.queenPos = queenPos;
    }

    public void setN(int n) {
        this.n = n;
    }

    private ArrayList<Integer> colSet = new ArrayList<>();

    //row col을 0부터 시작으로 두자...
    public void solve(int row) {
        // 현재 row에서의 컬럼 확인하는 작업
        for (int i = 0; i < n; i++) {
            // col중복 확인
            if (!colSet.contains(i)) {
                boolean continuePoint = false;
                //대각선 확인
                for (int j = 0; j < row; j++) {
                    // 원래 절댓값으로 접근해야겠지만 일단은...
                    if (queenPos[j] + j == row + i || queenPos[j] - j == i - row) {
                        continuePoint = true;
                        break;
                    }
                }
                if (continuePoint) continue;

                //위의 조건을 거치고 오면 백트래킹 시작
                queenPos[row] = (char)i;
                colSet.add(i);
                if (row + 1 == n) {
                    answer++;
                    colSet.remove((Object) i);
                } else {
                    solve(row + 1);
                    colSet.remove((Object) i);
                }
            }
        }
    }
}

public class NQueenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] queenPos = new char[n];
        NQueenNumberSolver solver = new NQueenNumberSolver();
        solver.setQueenPos(queenPos);
        solver.setN(n);
        solver.solve(0);
        System.out.println(solver.getAnswer());
    }
}
