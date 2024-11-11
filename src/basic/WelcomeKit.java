package basic;

import java.util.Scanner;

//30802 웰컴키트
public class WelcomeKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strTNeeds = scanner.nextLine().split(" ");

        String thirdLine = scanner.nextLine();
        int tBundle = Integer.parseInt(thirdLine.split(" ")[0]);
        int pBundle = Integer.parseInt(thirdLine.split(" ")[1]);

        int buyTBundle = 0;
        for(int i = 0; i<6 ; i ++){
            int ithInt = Integer.parseInt(strTNeeds[i]);
            buyTBundle += ithInt / tBundle + (ithInt % tBundle == 0 ? 0 : 1);
        }

        int buyPBundle = n / pBundle;
        int buyPSolo = n % pBundle;

        System.out.println(buyTBundle + "\n" + buyPBundle +" " + buyPSolo);



    }
}
