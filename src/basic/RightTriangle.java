package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 4153 직각삼각형
public class RightTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();

            if(line.contains("0 0 0")) break;

            String[] strNum = line.split(" ");
            List<Integer> list = new ArrayList<>();
            int a = Integer.parseInt(strNum[0]);
            int max = a;
            int b = Integer.parseInt(strNum[1]);
            if(b > max){
                list.add(a);
                max = b;
            }else{
                list.add(b);
            }
            int c = Integer.parseInt(strNum[2]);
            if(c > max){
                list.add(max);
                max = c;
            }else{
                list.add(c);
            }

            if(max * max == list.get(0)*list.get(0) + list.get(1)*list.get(1) ){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }



        }
    }
}
