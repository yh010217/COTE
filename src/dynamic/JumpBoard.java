package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1890 점프
public class JumpBoard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstLine = br.readLine();
		int n = Integer.parseInt(firstLine);

		int[][] board = new int[n+1][n+1];
		for(int i = 1 ; i <= n ; i ++){
			String[] line = br.readLine().split(" ");
			for(int j = 1 ; j <= n ; j ++){
				board[i][j] = Integer.parseInt(line[j-1]);
			}
		}

		boolean[][] canReach = new boolean[n+1][n+1];
		//왼 위에서 오 아래 로 진행되니까
		// [i][j] 에서 false 면다음 칸으로 점프할 수 있는지 확인 안해봐도 됨
		canReach[1][1] = true;

		long[][] dpArr = new long[n+1][n+1];
		dpArr[1][1] = 1;
		for(int i = 1; i <= n ; i ++){
			for(int j = 1; j <= n ; j++){
				if(!canReach[i][j] || board[i][j] == 0) continue;

				long currentCaseNum = dpArr[i][j];

				int jumpValue = board[i][j];
				if(j + jumpValue <= n){
					canReach[i][j+jumpValue] = true;
					dpArr[i][j+jumpValue] += currentCaseNum;
				}
				if(i + jumpValue <= n){
					canReach[i+jumpValue][j] = true;
					dpArr[i+jumpValue][j] += currentCaseNum;
				}
			}
		}
		System.out.println(dpArr[n][n]);
		br.close();
	}
}
