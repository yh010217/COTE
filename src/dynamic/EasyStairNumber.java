package dynamic;

import java.util.Scanner;

// 10844 쉬운 계단 수
public class EasyStairNumber {
	public static void main(String[] args) {

		final int divNum = 1_000_000_000;

		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		int[][] dpArr = new int[n+1][10]; // 0 번은 안하고 N 은 [N] 에 접근하기 위한 n+1

		for(int i = 1 ; i <= 9 ; i++){
			dpArr[1][i] = 1;
		}

		for(int i = 2; i <= n ; i++){
			dpArr[i][0] = dpArr[i-1][1];
			for(int j = 1 ; j <= 8 ; j++){
				dpArr[i][j] = (dpArr[i-1][j-1] + dpArr[i-1][j+1]) % divNum;
			}
			dpArr[i][9] = dpArr[i-1][8];
		}

		int answer = 0;
		for(int i = 0 ; i <= 9 ; i ++){
			answer = (answer + dpArr[n][i]) % divNum;
		}
		System.out.println(answer);
	}
}
