package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//18870 - list 의 indexOf 쓰는거 은근 오래걸리네....
public class CompressCoord {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        String[] nStr = bf.readLine().split(" ");
        int[] nInt = new int[n];

        Set<Integer> intSet = new HashSet<>();
        for(int i = 0 ; i < n ; i ++){
            int value = Integer.parseInt(nStr[i]);
            nInt[i] = value;
            intSet.add(value);
        }
        ArrayList<Integer> intList = new ArrayList<>(intSet);
        intList.sort(Integer::compareTo);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < intList.size() ; i ++){
            hashMap.put(intList.get(i),i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < n ; i ++){
            bw.write(hashMap.get(nInt[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
