package dynamic;

import java.util.Scanner;

//2193 이친수
public class PinaryNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		if(n == 1){
			System.out.println(1);
			return;
		}

		long[] endWith0 = new long[n]; //n-1 까지만 받고  n 번째는 마무리 계산만
		long[] endWith1 = new long[n];

		endWith0[1] = 0;
		endWith1[1] = 1;

		for(int i = 2 ; i < n ; i ++){
			endWith0[i] = endWith0[i-1] + endWith1[i-1];
			endWith1[i] = endWith0[i-1];
		}
		System.out.println(endWith0[n-1] * 2 + endWith1[n-1]);

	}
}