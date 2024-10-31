package basic;//1546 세준이의 이상한 평균값

import java.util.Scanner;

public class SejunAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] nString = scanner.nextLine().split(" ");
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            int ithInt = Integer.parseInt(nString[i]);
            max = ithInt>max ? ithInt : max;
            sum += ithInt;
        }
        System.out.println((sum * 100.0) / (max * n));

    }
}
