package sort;

import java.util.Scanner;

//18110
public class SolvedAc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] gyesoo = new int[31];
        for (int i = 0; i < n; i++) {
            gyesoo[Integer.parseInt(scanner.nextLine())]++;
        }
        int per15 = (int) Math.round(n * 0.15);
        int small15 = 0;
        int big15 = 0;
        for (int i = 1; i <= 30; i++) {
            if (small15 < per15 && gyesoo[i] != 0) {
                if (gyesoo[i] > per15 - small15) {
                    gyesoo[i] -= (per15 - small15);
                    small15 = per15;
                } else {
                    small15 += gyesoo[i];
                    gyesoo[i] = 0;
                }
            }
            if (big15 < per15 && gyesoo[30 - i + 1] != 0) {
                if(gyesoo[30 - i + 1] > per15 - big15){
                    gyesoo[30 - i + 1] -= (per15 - big15);
                    big15 = per15;
                }else{
                    big15 += gyesoo[30 - i + 1];
                    gyesoo[30 - i + 1] = 0;
                }
            }
        }
        int totNum = n - 2 * per15;
        int totSum = 0;
        for(int i= 1 ; i <= 30 ; i++){
            totSum += gyesoo[i] * i;
        }
        System.out.println((int)Math.round(totSum * 1.0 / totNum));
    }
}
