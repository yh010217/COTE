package dynamic;

import java.util.Scanner;

public class Nx2Tiling2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		if(n == 1){
			System.out.println(1);
			return;
		}
		long[] dp = new long[n+1];
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i <= n ; i++){
			dp[i] = (dp[i-1] + 2 * dp[i-2])%10_007;
		}
		System.out.println(dp[n]);
	}
}
