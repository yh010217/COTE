package back_tracking;

import java.util.Arrays;
import java.util.Scanner;

class SudokuSolver {
    public void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("========================");
    }

    //백트래킹 할거임
    public boolean backTracking(int[][] board, int row, int col) {

        boolean result = false;

        boolean[] nextProcess = new boolean[10];
        Arrays.fill(nextProcess, true);
        // 내가 소속된 가로 줄 판별
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != 0) nextProcess[board[row][i]] = false;
        }

        // 내가 소속된 세로 줄 판별
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != 0) nextProcess[board[i][col]] = false;
        }

        // 내가 소속된 사각형 판별
        int rectFirstRow = (row / 3) * 3;
        int rectFirstCol = (col / 3) * 3;
        for (int i = rectFirstRow; i < rectFirstRow + 3; i++) {
            for (int j = rectFirstCol; j < rectFirstCol + 3; j++) {
                if (board[i][j] != 0) nextProcess[board[i][j]] = false;
            }
        }

        //지금 col이 끝에 와있으면 다음줄 처음부터
        int nextRow = row + (col == 8 ? 1 : 0);
        int nextCol = col == 8 ? 0 : col + 1;

        boolean breakPoint = false;
        for (; nextRow < 9; nextRow++) {
            for (; nextCol < 9; nextCol++) {
                if (board[nextRow][nextCol] == 0) {
                    breakPoint = true;
                    break;
                }
            }
            if (breakPoint) break;
            nextCol = 0;
        }

        // 가능한 거 넣어보고 백트래킹 돌리기
        for (int i = 1; i <= 9; i++) {
            if (nextProcess[i]) {
                board[row][col] = i;

                if (nextRow == 9) return true; // 이 다음 게 없다는 거니깐. 근데 채워지긴 했으니깐
                result = backTracking(board, nextRow, nextCol);

                if (result) return true;
                else board[row][col] = 0;
            }
        }
        return result;
    }
}

// 그냥 스도쿠... 코드없는 프로그래밍 , 백준 2580
public class Sudoku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] board = new int[9][9];
        boolean firstZeroFound = false;
        int firstRow = 0;
        int firstCol = 0;
        for (int i = 0; i < 9; i++) {
            String line = scanner.nextLine();
            line = line.replace(" ", "");
            for (int j = 0; j < 9; j++) {
                int value = line.charAt(j) - '0';
                board[i][j] = value;
                if (value == 0 && !firstZeroFound) {
                    firstZeroFound = true;
                    firstRow = i;
                    firstCol = j;
                }
            }
        }
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.backTracking(board, firstRow, firstCol);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
