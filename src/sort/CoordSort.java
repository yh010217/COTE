package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CoordPos implements Comparable{
    int x;
    int y;

    public CoordPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        CoordPos other = (CoordPos) o;
        if(x > other.x) return 1;
        else if(x == other.x){
            return y > other.y ? 1 : -1;
        }else{
            return -1;
        }
    }
}

public class CoordSort {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<CoordPos> list = new ArrayList<>();
        for(int i = 0 ; i < n ;i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            list.add(new CoordPos(x,y));
        }
        Collections.sort(list);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(CoordPos pos : list){
            bw.write(pos.x + " " + pos.y + "\n");
        }
        bw.flush();
        bw.close();
    }
}
