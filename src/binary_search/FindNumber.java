package binary_search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//1920 수 찾기
class NumberExistFunc{
    private void numberBinarySearch(List<Integer> nArray, int target){
        // nArray는 정렬돼있음
        int highIndex = nArray.size()-1;
        int lowIndex = 0;
        int midIndex = (highIndex + lowIndex) / 2;
        if(nArray.get(highIndex) == target || nArray.get(lowIndex) == target
                || nArray.get(midIndex) == target){
            System.out.println(1);
        }else{
            while(true){
                if(highIndex == lowIndex){
                    System.out.println(0);
                    break;
                }else{
                    int midValue = nArray.get(midIndex);
                    if(target > midValue){
                        lowIndex = midIndex + 1;
                        midIndex = (highIndex + lowIndex) / 2;
                    }else if(target < midValue){
                        highIndex = midIndex;
                        midIndex = (highIndex + lowIndex) / 2;
                    }else{
                        System.out.println(1);
                        break;
                    }
                }
            }
        }
    }
    public void numbersExistFunc(List<Integer> nArray, int[] mArray){
        nArray.sort(Integer::compareTo);
        for(int i = 0 ; i < mArray.length ; i ++){
            numberBinarySearch(nArray,mArray[i]);
        }
    }
}

public class FindNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] nStrArr = scanner.nextLine().split(" ");
        List<Integer> nArray = new ArrayList<>();
        for(int i = 0; i < n ; i ++){
            nArray.add(Integer.parseInt(nStrArr[i]));
        }

        int m = Integer.parseInt(scanner.nextLine());
        String[] mStrArr = scanner.nextLine().split(" ");
        int[] mArray = new int[m];
        for(int i = 0 ; i < m ; i++){
            mArray[i] = Integer.parseInt(mStrArr[i]);
        }
        NumberExistFunc numberExistFunc = new NumberExistFunc();
        numberExistFunc.numbersExistFunc(nArray,mArray);

    }
}
