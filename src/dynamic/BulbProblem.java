package dynamic;

//2449 전구

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BulbProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nk = br.readLine().split(" ");

		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		String colorLine = br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(colorLine," ");
		// 현재 있는걸 그룹화 시키기 - 지금 내가 하는 게 앞에서 한 것과 다르면 새로운 걸 list 에 추가
		ArrayList<Integer> groupList = new ArrayList<>();
		int firstColor = Integer.parseInt(tokenizer.nextToken());
		groupList.add(firstColor);
		while (tokenizer.hasMoreTokens()){
			int currentColor = Integer.parseInt(tokenizer.nextToken());
			if(groupList.get(groupList.size() - 1) != currentColor) groupList.add(currentColor);
		}

		// DP 배열 만들기
		int totSize = groupList.size();
		int[][] dpArr = new int[totSize][totSize];

		for(int i = 0 ; i < totSize ; i ++){
			for(int j = 0 ; j < totSize ; j++){
				if(i != j) dpArr[i][j] = 999; // 만드는 김에 size 1짜리는 0에서 변화 없게끔
			}
		}
		int size = 2;
		while(true){
			if(size > totSize) break;
			int i = 0;
			while(true){
				int j = i + size - 1;
				if(j == totSize) break;
				int toCompare = dpArr[i][j];
				for(int h = i ; h < j; h++){
					boolean leftEqual = groupList.get(i) == groupList.get(h+1);
					int value = dpArr[i][h] + dpArr[h+1][j] + (leftEqual?0:1);
					if(value < toCompare) toCompare = value;
				}
				dpArr[i][j] = toCompare;
				i++;
			}
			size++;
		}

		System.out.println(dpArr[0][totSize-1]);
		br.close();
	}
}

