package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BlackJack {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int m = Integer.parseInt(firstLine.split(" ")[1]);
        String[] secondLine = br.readLine().split(" ");
        int[] cards = new int[n];
        for(int i = 0 ; i < n ; i ++){
            cards[i] = Integer.parseInt(secondLine[i]);
        }
        int max = 0;
        for(int i = 0 ; i < n-2 ; i ++){
            for(int j = i+1 ; j < n-1 ; j++){
                for(int k = j+1 ; k < n ; k++){
                    int value = cards[i]+cards[j]+cards[k];
                    if(value > max && value <= m) max = value;
                }
            }
        }
        System.out.println(max);
    }
}
