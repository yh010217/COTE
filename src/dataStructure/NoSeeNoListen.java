package dataStructure;

import java.io.*;
import java.util.*;

//1764 듣보잡
public class NoSeeNoListen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        HashSet<String> noSee = new HashSet<>();
        for(int i = 0 ; i < n; i ++){
            String person = br.readLine();
            noSee.add(person);
        }
        HashSet<String> noSeeNoListen = new HashSet<>();
        for(int i = 0 ; i < m ; i++){
            String person = br.readLine();
            if(noSee.contains(person)){
                noSeeNoListen.add(person);
            }
        }
        ArrayList<String> sorted = new ArrayList<>();
        Iterator<String> nsnlIter = noSeeNoListen.iterator();
        while (nsnlIter.hasNext()){
            String nsnlPerson = nsnlIter.next();
            sorted.add(nsnlPerson);
        }
        Collections.sort(sorted);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sorted.size() + "\n");
        for(String str : sorted){
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
    }
}
