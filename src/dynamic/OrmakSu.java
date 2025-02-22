package dynamic;

import java.util.Scanner;

//11057 오르막 수
public class OrmakSu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		if(n == 1){
			System.out.println(10);
			return;
		}

		int[][] dpArr = new int [n+1][10]; // 직관과 맞추기 위해 0은 사용하지 않기 위한 10
		dpArr[1] = new int[]{1,1,1,1,1,1,1,1,1,1};

		for(int i = 0 ; i <= 9 ; i ++){
			int j = 2;
			while(j <= n){
				int value = 0;
				for(int k = 0; k <= i ; k ++){
					value += dpArr[j-1][k];
				}
				dpArr[j][i] = value % 10_007;
				j++;
			}
		}
		int answer = 0;
		for(int i = 0; i <= 9 ; i ++){
			answer += dpArr[n][i];
		}

		System.out.println(answer % 10_007);
	}
}
