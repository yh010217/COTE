package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//요세푸스 순열 11866
public class Josephus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        List<Integer> list = new LinkedList<>();
        for(int i = 1 ; i <= n ; i ++){
            list.add(i);
        }
        int toRemove = k-1;
        int[] removeOrder = new int[n];
        for(int i = 0 ; i < n ; i++){
            int value = list.get(toRemove);
            removeOrder[i] = value;
            list.remove(toRemove);
            if(i == n-1) break;
            toRemove = (toRemove + k - 1) % list.size();
        }

        System.out.print("<");
        for(int i = 0 ; i < n-1 ; i++){
            System.out.print(removeOrder[i]+", ");
        }
        System.out.print(removeOrder[n-1] +">");

    }
}
