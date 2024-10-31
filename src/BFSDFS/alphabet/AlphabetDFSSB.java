package BFSDFS.alphabet;

import java.util.*;

//1987 번.
class AlphabetBuilder {
    private int row;
    private int col;
    private int move;
    private StringBuilder path;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getMove() {
        return move;
    }

    public StringBuilder getPath() {
        return path;
    }

    public AlphabetBuilder(int row, int col, int move, StringBuilder path) {
        this.row = row;
        this.col = col;
        this.move = move;
        this.path = path;
    }
}

class AlphabetDFSBuilder {
    private int maxMove = 1;

    public int getMaxMove() {
        return maxMove;
    }

    private boolean[] visited = new boolean[26];

    private char[][] board;
    private int row;
    private int col;

    public AlphabetDFSBuilder(char[][] board, int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;
    }

    // 뭐... board 가지고 row,col 알아낼 수 있기야 하겠지만 귀찮음....ㅋ
    // 어디를 가든 알파벳 기준으로만 생각해서 visited를 생각해도 괜찮지 않을까?
    public void calculateByDFS(AlphabetBuilder currentInfo) {

        int currentMove = currentInfo.getMove();
        maxMove = currentMove > maxMove ? currentMove : maxMove;
        StringBuilder path = currentInfo.getPath();
        visited[path.charAt(0)-'A'] = true;

        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < 4; i++) {
            int nextRow = currentInfo.getRow() + direction[i][0];
            int nextCol = currentInfo.getCol() + direction[i][1];

            if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col) {
                char nextAlphabet = board[nextRow][nextCol];

                if (!visited[nextAlphabet-'A']) {
                    visited[nextAlphabet-'A'] = true;
                    path.append(nextAlphabet);
                    calculateByDFS(new AlphabetBuilder(nextRow, nextCol, currentMove + 1, path));
                    path.deleteCharAt(path.length()-1);
                    visited[nextAlphabet-'A'] = false;
                }
            }
        }
    }

}

public class AlphabetDFSSB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        int row = Integer.parseInt(firstLine.split(" ")[0]);
        int col = Integer.parseInt(firstLine.split(" ")[1]);

        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            String currentLine = scanner.nextLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = currentLine.charAt(j);
            }
        }

        AlphabetDFSBuilder dfsBuilder = new AlphabetDFSBuilder(board, row, col);

        char firstAlphabet = board[0][0];
        StringBuilder sb = new StringBuilder();
        sb.append(firstAlphabet);
        AlphabetBuilder firstInfo = new AlphabetBuilder(0, 0, 1, sb);
        dfsBuilder.calculateByDFS(firstInfo);
        System.out.println(dfsBuilder.getMaxMove());
    }
}
