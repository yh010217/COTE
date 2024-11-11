package basic;

import java.util.Scanner;

//2231 분해합
public class SeparateSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nStr = scanner.nextLine();
        int nLen = nStr.length();
        int n = Integer.parseInt(nStr);
        for(int i = n - nLen * 9 ; i < n  ; i++){
            int sum = i; // 자기 자신은 더해야 하니
            int tempI = i;
            for(int j = 1000000 ; j >= 10 ; j = j/10){
                if(j > n){
                    continue;
                }
                sum += tempI / j;
                tempI = i % j;
            }
            sum += tempI; // 마지막 tempI 는 1의 자리만 남았을 것임
            if(sum == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
