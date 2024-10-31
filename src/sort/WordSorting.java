package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class WordSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strN = scanner.nextLine();
        int n = Integer.parseInt(strN);

        List<String>[] inputs = new List[51];
        for(int i = 0 ; i < n ; i ++){
            String word = scanner.nextLine();
            if(inputs[word.length()] == null){
                inputs[word.length()] = new ArrayList<>();
            }
            if(!inputs[word.length()].contains(word)) {
                inputs[word.length()].add(word);
            }
        }

        for(int i = 1 ; i <= 50 ; i++){
            if(inputs[i] != null){
                List<String> ithList = inputs[i];
                ithList.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
            }
        }

        for(int i = 1 ; i <= 50 ; i++){
            if(inputs[i] != null){
                List<String> ithList = inputs[i];
                for(String str : ithList){
                    System.out.println(str);
                }
            }
        }


    }
}
