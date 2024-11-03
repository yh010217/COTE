package dataStructure;

import java.io.*;
import java.util.HashMap;

public class PocketmonMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        String[] orderPocketMon = new String[m];
        HashMap<String,Integer> pocketMonMap = new HashMap<>();
        for(int i = 0 ; i < m ; i ++){
            String line = br.readLine();
            orderPocketMon[i] = line;
            pocketMonMap.put(line,i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(firstLine[1]);
        for(int i = 0; i < n ; i ++){
            String line = br.readLine();
            try{
                int num = Integer.parseInt(line);
                bw.write(orderPocketMon[num-1]+"\n");
            }catch (NumberFormatException e){
                bw.write(pocketMonMap.get(line)+1+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
