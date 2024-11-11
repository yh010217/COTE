package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11399
public class InhaATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] timeSort = new int[1001];
        for(String str : line){
            timeSort[Integer.parseInt(str)]++;
        }
        int sum = 0;
        int myWait = 0;
        for(int i = 1 ; i <= 1000 ; i ++){
            int thisTimePeople = timeSort[i];
            for(int j = 0 ; j < thisTimePeople ; j ++){
                myWait += i;
                sum += myWait; // sum 에서 바로 시작하면 내가 기다리는 시간 자체가 늘어나니깐
            }
        }
        System.out.println(sum);
    }
}
