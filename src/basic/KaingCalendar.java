package basic;

import java.io.*;

class KaingSolver {
    public int solve(int m, int n, int x, int y) {
        int largeMN = m >= n ? m : n;
        int gongyaksu = 1;
        for(int i = largeMN ; i >= 1 ;i--){
            if(m % i == 0 && n % i == 0){
                gongyaksu = i;
                break;
            }
        }
        int gongbaesu = m * n / gongyaksu;
        for(int i = 0 ;  ; i ++){
            int maybeAnswer = m * i + x;
            if(maybeAnswer > gongbaesu) break;
            int divideN = maybeAnswer / n;
            int modN = maybeAnswer % n;
            if(modN == 0) {
                // maybeAnswer 는 0일리 없으니 modN이 0이 됐단건 divide는 1 이상으로 나눠진거
                divideN--;
                modN = n; // n이 12 라고 했을 때 y가 12까지 가니깐
            }
            if (modN == y && n * divideN + modN == maybeAnswer){
                return maybeAnswer;
            }
        }
        for(int i = 0 ; ; i ++){
            int maybeAnswer = n * i + y;
            if(maybeAnswer > gongbaesu) break;
            int divideM = maybeAnswer / m;
            int modM = maybeAnswer % m;
            if(modM == 0) {
                divideM --;
                modM = m;
            }
            if (modM == x && m * divideM + modM == maybeAnswer){
                return maybeAnswer;
            }
        }
        return -1;
    }
}

public class KaingCalendar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        KaingSolver solver = new KaingSolver();
        for (int i = 0; i < t; i++) {
            String[] mnxy = br.readLine().split(" ");
            int m = Integer.parseInt(mnxy[0]);
            int n = Integer.parseInt(mnxy[1]);
            int x = Integer.parseInt(mnxy[2]);
            int y = Integer.parseInt(mnxy[3]);
            int solve = solver.solve(m,n,x,y);
            answer.append(solve+"\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
