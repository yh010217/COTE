package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11053 가장 긴 증가하는 부분 수열
public class LongestAscending {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if(n == 1){
			System.out.println(1);
			return;
		}

		int[] sequence = new int[n];
		String line = br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line," ");
		int sequenceIndex = 0;
		while (tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			sequence[sequenceIndex] = Integer.parseInt(token);
			sequenceIndex++;
		}

		int[] dpArr = new int[n];
		int answer = 0;
		dpArr[0] = 1;
		for(int i = 1 ; i < n ; i ++){
			int index = -1;
			int maxSize = 0;
			for(int j = 0; j < i; j++){
				if(sequence[j] < sequence[i] && dpArr[j] > maxSize){
					maxSize = dpArr[j];
					index = j;
				}
			}
			if(index == -1){
				dpArr[i] = 1;
			}else{
				dpArr[i] = maxSize + 1;
			}
			if(dpArr[i] > answer) answer = dpArr[i];
		}
		System.out.println(answer);

	}
}
