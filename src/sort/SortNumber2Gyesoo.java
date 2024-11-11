package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortNumber2Gyesoo {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        boolean[] gyesoo = new boolean[2000001];

        for(int i = 0 ; i < n ; i++){
            int ithNum = Integer.parseInt(bf.readLine());
            gyesoo[ithNum+1000000] = true;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i <= 2000000 ; i++){
            if(gyesoo[i]) {
                bw.write(i - 1000000 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
