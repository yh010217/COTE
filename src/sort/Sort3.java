package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//10989
public class Sort3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i = 0 ; i < n ; i ++){
            int value = Integer.parseInt(br.readLine());
            arr[value]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1 ; i <= 10000 ; i++){
            if (arr[i] != 0){
                for(int j = 0 ; j < arr[i] ; j++){
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
