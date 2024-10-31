package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

//10816 숫자카드
public class NumberCard {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nCards = br.readLine().split(" ");
        HashMap<String,Integer> numberMap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(!numberMap.containsKey(nCards[i])) numberMap.put(nCards[i],1);
            else numberMap.put(nCards[i],numberMap.get(nCards[i])+1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] mNumbers = br.readLine().split(" ");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < m ; i++){
            int value = numberMap.get(mNumbers[i]) == null ? 0 :numberMap.get(mNumbers[i]);
            bw.write(value+" ");
        }
        bw.flush();
        bw.close();
    }
}
