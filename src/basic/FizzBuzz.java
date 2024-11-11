package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FizzBuzz {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numAns = 0;
        String firstLine = br.readLine();
        String secondLine = br.readLine();
        String thirdLine = br.readLine();
        if(!firstLine.contains("zz")) numAns = Integer.parseInt(firstLine) + 3;
        else if(!secondLine.contains("zz")) numAns = Integer.parseInt(secondLine) + 2;
        else if(!thirdLine.contains("zz")) numAns = Integer.parseInt(thirdLine) + 1;

        if(numAns % 3 == 0 && numAns % 5 == 0) System.out.println("FizzBuzz");
        else if(numAns % 3 == 0) System.out.println("Fizz");
        else if(numAns % 5 == 0) System.out.println("Buzz");
        else System.out.println(numAns);

    }
}
