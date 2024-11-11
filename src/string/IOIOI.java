package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();


        int ans = 0;
        for (int i = 0; i < m - (2 * n); i++) {
            boolean continuePoint = false;
            int seq = 0;
            int j = i;
            for (; j < i + (2 * n + 1); j++) {
                if( !(seq % 2 == 0 && s[j] == 'I')
                        && !(seq % 2 == 1 && s[j] == 'O') ){
                    continuePoint = true;
                    break;
                }
                seq++;
            }
            if(continuePoint){
                if(s[j] == 'O') i = j;
                else i = j-1;
                continue;
            }
            ans++;
            while(true){
                if(j<m-1 && s[j] == 'O' && s[j+1] == 'I'){
                    j = j + 2;
                    ans++;
                }else{
                    i = j-1;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
