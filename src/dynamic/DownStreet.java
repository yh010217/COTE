package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DownStreetDFS{
	private int [][] map;
	// 아마도 visited 없어도 될듯

	private int m,n;

	public DownStreetDFS(int[][] map) {
		this.map = map;
		this.m = map.length-1;
		this.n = map[0].length-1;
	}
	int answer = 0;

	int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

	public void dfs(int currentRow, int currentCol){
		int currentHeight = map[currentRow][currentCol];
		if(currentRow == m && currentCol == n){
			answer++;
			return;
		}
		for(int i = 0 ; i < 4; i ++){
			int nextRow = currentRow+direction[i][0] ;
			int nextCol = currentCol+direction[i][1] ;
			if(nextRow >0 && nextRow <= m
			&& nextCol > 0 && nextCol <= n
			&& map[nextRow][nextCol] < currentHeight){
				dfs(nextRow,nextCol);
			}
		}
	}
}

// 1520 내리막 길
public class DownStreet {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		int m = Integer.parseInt(firstLine[0]);
		int n = Integer.parseInt(firstLine[1]);

		int[][] map = new int[m+1][n+1];
		for(int i = 1 ; i <= m ; i ++){
			String[] line = br.readLine().split(" ");
			for(int j = 1 ; j <= n ; j ++){
				map[i][j] = Integer.parseInt(line[j-1]);
			}
		}
		// 어차피 내리막을 걸었다면 높이가 낮아진 것이니 내 위치로 다시 못옴. 오르막이 되잖아
		DownStreetDFS solver = new DownStreetDFS(map);
		solver.dfs(1,1);
		System.out.println(solver.answer);

	}
}
