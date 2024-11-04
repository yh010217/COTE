package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Coord2 implements Comparable {
    int x;
    int y;

    public Coord2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        Coord2 other = (Coord2) o;
        if (this.y > other.y) {
            return 1;
        } else if (this.y == other.y) {
            return this.x > other.x ? 1 : -1;
        } else {
            return -1;
        }
    }
}

class Coord2SortSolver {
    public static void sort(List<Coord2> list, int start, int end) {
        if(start == end) return;
        Coord2 pivot = list.get(start);
        int smallIndex = end;
        int largeIndex = start + 1;
        while (true) {
            boolean breakPoint = false;
            for (; smallIndex >= start + 1; smallIndex--) {
                if (pivot.compareTo(list.get(smallIndex)) > 0) break;
            }
            for (; largeIndex <= end; largeIndex++) {
                if (pivot.compareTo(list.get(largeIndex)) < 0) break;
            }
            if (largeIndex < smallIndex) {
                Coord2 temp = list.get(largeIndex);
                list.set(largeIndex, list.get(smallIndex));
                list.set(smallIndex, temp);
            } else {
                Coord2 temp = list.get(smallIndex);
                list.set(smallIndex, pivot);
                list.set(start, temp);
                if (smallIndex != start)
                    Coord2SortSolver.sort(list, start, smallIndex - 1);
                if (smallIndex != end)
                    Coord2SortSolver.sort(list, smallIndex + 1, end);
                breakPoint = true;
            }
            if(breakPoint) break;
        }
    }
}

//11651
public class SortCoord2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Coord2> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            list.add(new Coord2(x, y));
        }
//        Collections.sort(list);
        Collections.shuffle(list);
        Coord2SortSolver.sort(list, 0, n - 1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Coord2 coord : list) {
            bw.write(coord.x + " " + coord.y + "\n");
        }
        bw.flush();
        bw.close();
    }
}
