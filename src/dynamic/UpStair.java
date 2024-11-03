package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//2579
class UpStairSolver {
    private int n;
    private int[] beforeOne;
    private int[] beforeTwo;
    private int[] original;

    public UpStairSolver(int[] original, int n) {
        this.n = n;
        this.beforeOne = new int[n + 1];
        this.beforeTwo = new int[n + 1];
        this.original = original;
        setBefore();
    }

    private void setBefore() {
        //첫번째 계단 말한거임
        beforeOne[1] = original[1];
        beforeOne[2] = original[1] + original[2];
        beforeTwo[2] = original[2];
        for (int i = 3; i <= n; i++) {
            beforeOne[i] = beforeTwo[i - 1] + original[i];
            int twoBeforeMax = beforeOne[i - 2] > beforeTwo[i - 2] ?
                    beforeOne[i - 2] : beforeTwo[i - 2];
            beforeTwo[i] = twoBeforeMax + original[i];
        }
    }

    public int maxScore() {
        int tempMax = beforeOne[n - 2] > beforeTwo[n - 2] ?
                beforeOne[n - 2] : beforeTwo[n - 2];
        int realMax = tempMax > beforeTwo[n - 1] ?
                tempMax : beforeTwo[n - 1];
        return realMax + original[n];
    }

}

public class UpStair {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairScore = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairScore[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        if (n > 2) {
            UpStairSolver solver = new UpStairSolver(stairScore, n);
            answer = solver.maxScore();
        } else if (n == 2) {
            answer = stairScore[1] + stairScore[2];
        } else if (n == 1) {
            answer = stairScore[1];
        }
        System.out.println(answer);
    }
}
