package BFSDFS.alphabet;

import java.util.*;

//1987 번. 근데 BFS 로 풀다가 망한듯... ㅋㅋ
/*
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
}*/

class AlphabetBFS {
    public int maxMove(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        Queue<AlphabetInfo> queue = new LinkedList<>();
        List<Character> firstPath = new ArrayList<>();
        firstPath.add(board[0][0]);
        queue.add(new AlphabetInfo(0, 0, 1, firstPath));

        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ansMove = 1;

        while (!queue.isEmpty()) {
            AlphabetInfo currentInfo = queue.poll();
            int currentRow = currentInfo.getRow();
            int currentCol = currentInfo.getCol();
            int currentMove = currentInfo.getMove();
            List<Character> currentPath = currentInfo.getPath();

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + direction[i][0];
                int nextCol = currentCol + direction[i][1];
                if (nextRow >= 0 && nextRow < r && nextCol >= 0 && nextCol < c) {

                    char nextAlphabet = board[nextRow][nextCol];

                    if (!currentPath.contains(nextAlphabet)) {
                        List<Character> nextPath = new ArrayList<>(currentPath);
                        nextPath.add(nextAlphabet);
                        queue.add(new AlphabetInfo(nextRow, nextCol
                                , currentMove + 1, nextPath));
                        ansMove = currentMove + 1;
                    }

                }
            }
            System.out.print("");
        }

        return ansMove;
    }

}

public class AlphabetBoardBFSTry {
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

        AlphabetBFS bfs = new AlphabetBFS();
        System.out.println(bfs.maxMove(board));

    }
}
