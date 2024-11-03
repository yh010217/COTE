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
        if ((this.weight > person.weight && this.height > person.height)
                || (this.weight == person.weight && this.height > person.height)
                || (this.weight > person.weight && this.height == person.height)) {
            return 1;
        } else if ((this.weight < person.weight && this.height < person.height)
                || (this.weight == person.weight && this.height < person.height)
                || (this.weight < person.weight && this.height == person.height)){
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
        ArrayList<WeightHeight> toSort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int weight = Integer.parseInt(line[0]);
            int height = Integer.parseInt(line[1]);
            WeightHeight person = new WeightHeight(weight, height);
            people[i] = person;
            toSort.add(person);
        }
        Collections.sort(toSort);
        HashMap<WeightHeight, Integer> hashMap = new HashMap<>();
        WeightHeight beforePerson = toSort.get(n - 1);
        hashMap.put(beforePerson, 1);
        int currentRank = 1;
        int currentStack = 1;
        for (int i = n - 2; i >= 0; i--) {
            WeightHeight currentPerson = toSort.get(i);
            int compareResult =beforePerson.compareTo(currentPerson);
            if(compareResult > 0){
                //확실히 클 때
                // 다음건 rank + stack 부터 시작해야함
                currentRank += currentStack;
                currentStack = 1;
            }else{
                // 0 이겠지. 확실히 비교하기 어려울 때
                // 여전히 rank는 그대로, stack은 쌓고
                currentStack ++;
            }
            hashMap.put(currentPerson,currentRank);
            beforePerson = currentPerson;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (WeightHeight person : people){
            bw.write(hashMap.get(person) +" ");
        }
        bw.flush();
        bw.close();
    }
}
