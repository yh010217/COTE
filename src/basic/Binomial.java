package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 이항계수 11050
public class Binomial {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int kPact = 1;
        for(int i = 1 ; i <= k ; i++){
            kPact *= i;
        }
        int nPerm = 1;
        for(int i = n; i >= n-k+1 ; i--){
            nPerm *= i;
        }
        System.out.println(nPerm / kPact);
    }
}
