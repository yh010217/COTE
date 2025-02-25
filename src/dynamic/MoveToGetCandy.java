package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11048 이동하기
public class MoveToGetCandy {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		int n = Integer.parseInt(firstLine[0]);
		int m = Integer.parseInt(firstLine[1]);

		int[][] maze = new int[n+1][m+1];
		for(int i = 1 ; i <= n ; i ++){
			String[] line = br.readLine().split(" ");
			for(int j = 1 ; j <= m ; j ++){
				maze[i][j] = Integer.parseInt(line[j-1]);
			}
		}
		//준규 이동방향은 우, 하, 대각선 우하만 가능
		int[][] dpArr = new int[n+1][m+1];
		for(int i = 1; i <= m ; i++){
			dpArr[1][i] = dpArr[1][i-1]+maze[1][i];
		}
		for(int i = 2; i <= n ; i ++){
			for(int j = 1; j <= m; j++){
				int currentMazeCandy = maze[i][j];
				int maxValue = 0;
				maxValue =  dpArr[i][j-1] > maxValue ? dpArr[i][j-1] : maxValue;
				maxValue =  dpArr[i-1][j-1] > maxValue ? dpArr[i-1][j-1] : maxValue;
				maxValue =  dpArr[i-1][j] > maxValue ? dpArr[i-1][j] : maxValue;
				dpArr[i][j] = maxValue + currentMazeCandy;
			}
		}
		System.out.println(dpArr[n][m]);
		br.close();
	}
}
