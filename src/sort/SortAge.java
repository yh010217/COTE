package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//10814
public class SortAge {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String>[] listArray = new List[201];
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i ++){
            String line = br.readLine();
            int age = Integer.parseInt(line.split(" ")[0]);
            String name = line.split(" ")[1];
            if(listArray[age] == null) listArray[age] = new ArrayList<>();
            listArray[age].add(name);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1 ; i <= 200 ; i ++){
            if(listArray[i] != null){
                for(String name : listArray[i]){
                    bw.write(i + " " + name +"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
