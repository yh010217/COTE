package BFSDFS.alphabet;

import java.util.*;

//1987 번.
class AlphabetInfo {
    private int row;
    private int col;
    private int move;
    private List<Character> path;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getMove() {
        return move;
    }

    public List<Character> getPath() {
        return path;
    }

    public AlphabetInfo(int row, int col, int move, List<Character> path) {
        this.row = row;
        this.col = col;
        this.move = move;
        this.path = path;
    }
}

class AlphabetDFS {
    private int maxMove = 1;

    public int getMaxMove() {
        return maxMove;
    }

    private char[][] board;
    private int row;
    private int col;

    public AlphabetDFS(char[][] board, int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;
    }

    // 뭐... board 가지고 row,col 알아낼 수 있기야 하겠지만 귀찮음....ㅋ
    // 어디를 가든 알파벳 기준으로만 생각해서 visited를 생각해도 괜찮지 않을까?
    public void calculateByDFS(AlphabetInfo currentInfo) {

        int currentMove = currentInfo.getMove();
        maxMove = currentMove > maxMove ? currentMove : maxMove;
        List<Character> currentPath = currentInfo.getPath();

        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < 4; i++) {
            int nextRow = currentInfo.getRow() + direction[i][0];
            int nextCol = currentInfo.getCol() + direction[i][1];
            if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col) {
                char nextAlphabet = board[nextRow][nextCol];
                if (!currentPath.contains(nextAlphabet)) {
                    List<Character> nextInfo = new ArrayList<>(currentPath);
                    nextInfo.add(nextAlphabet);

                    calculateByDFS(new AlphabetInfo(nextRow, nextCol, currentMove + 1, nextInfo));
                }
            }
        }
    }

}

public class AlphabetBoardDFS {
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

        AlphabetDFS dfs = new AlphabetDFS(board, row, col);

        char firstAlphabet = board[0][0];
        List<Character> firstPath = new ArrayList<>();
        firstPath.add(firstAlphabet);
        AlphabetInfo firstInfo = new AlphabetInfo(0, 0, 1, firstPath);
        dfs.calculateByDFS(firstInfo);
        System.out.println(dfs.getMaxMove());
    }
}
