package dataStructure;

//7568 덩치

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class WeightHeight implements Comparable {
    int weight;
    int height;

    public WeightHeight(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Object o) {
        WeightHeight person = (WeightHeight) o;
        if (this.weight > person.weight && this.height > person.height) {
            return 1;
        } else if (this.weight < person.weight && this.height < person.height){
            return -1;
        } else {
            return 0;
        }
    }
}

public class BigPerson {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        WeightHeight[] people = new WeightHeight[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int weight = Integer.parseInt(line[0]);
            int height = Integer.parseInt(line[1]);
            WeightHeight person = new WeightHeight(weight, height);
            people[i] = person;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0 ; i < n ; i ++){
            WeightHeight currentPerson = people[i];
            int rank = 1;
            for(int j = 0 ; j < n ; j++){
                if(people[j].compareTo(currentPerson) > 0){
                    rank++;
                }
            }
            bw.write(rank + " ");
        }
        bw.flush();
        bw.close();
    }
}

// 아니 1 2   2 2    2 3 이면  인간적으로 3 2 1 이 돼야하는 거 아님...?
// 2 1 1 이러는게 뭔 등수여...