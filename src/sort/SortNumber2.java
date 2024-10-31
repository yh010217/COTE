package sort;

import java.util.Scanner;

//2751 수 정렬하기 2
//근데 일단은 list 이용할거긴 한데... 그래도 되나...?

class SortNumber2ByQuick{
    public void quickSort(int[] array, int start, int end){
        if(start == end) return;
        int pivotValue = array[start];
        int largeIndex = start+1;
        int smallIndex = end;
        while(true){
            for( ; largeIndex <= end ; largeIndex ++){
                if(array[largeIndex] >= pivotValue){
                    break;
                }
            }
            for( ; smallIndex > start ; smallIndex --){
                if(array[smallIndex] < pivotValue){
                    break;
                }
            }
            if(largeIndex < smallIndex){
                //large - small swap, continue
                int temp = array[largeIndex];
                array[largeIndex] = array[smallIndex];
                array[smallIndex] = temp;
            }else{
                //pivot - small swap, recursion

                array[start] = array[smallIndex];
                array[smallIndex] = pivotValue;
                if(smallIndex != start){
                    quickSort(array,start,smallIndex -1);
                }
                if(smallIndex != end){
                    quickSort(array,smallIndex + 1, end);
                }
                break;
            }
        }
    }
}

public class SortNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] array = new int[n];

        for(int i = 0 ; i < n ; i++){
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        SortNumber2ByQuick quick = new SortNumber2ByQuick();
        quick.quickSort(array,0,n-1);
        for(int i = 0 ; i < n ; i++){
            System.out.println(array[i]);
        }

    }
}

/*
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        list.sort(Integer::compareTo);
        for(int i = 0 ; i < n ; i++){
            System.out.println(list.get(i));
        }
 */
