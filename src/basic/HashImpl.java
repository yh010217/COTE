package basic;

import java.util.Scanner;

//15829
public class HashImpl {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int l = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        long sum = 0L;
        long[] exp31 = new long[l];
        for(int i = 0 ; i < l ; i++){
            int charInt = line.charAt(i) - 'a' + 1;
            long rExp;
            if(i == 0){
                rExp = 1;
                exp31[0] = 1L;
            }else{
                exp31[i] = (exp31[i-1] * 31) % 1234567891;
                rExp = (exp31[i-1] * 31) % 1234567891;
            }
            sum = (sum + charInt * rExp) % 1234567891;
        }
        System.out.println(sum);

    }
}
