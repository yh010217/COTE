package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SeekCalculator{
    boolean[] visited = new boolean[100001];
    public int getSeekTimeByBFS(int n, int k){
        if(n == k) return 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,0});
        visited[n] = true;

        int time = 0;
        while(!queue.isEmpty()){
            int[] currentInfo = queue.poll();
            int currentPos = currentInfo[0];
            int currentTime = currentInfo[1];

            int nextMinus = currentPos - 1;

            int nextPlus = currentPos + 1;

            int next2time = currentPos * 2;

            if(nextMinus == k || nextPlus == k || next2time == k) return currentTime + 1;

            if(nextMinus >= 0 && !visited[nextMinus]){
                queue.add(new int[]{nextMinus,currentTime + 1});
                visited[nextMinus] = true;
            }
            if(nextPlus <= 100000 && !visited[nextPlus]){
                queue.add(new int[]{nextPlus, currentTime + 1});
                visited[nextPlus] = true;
            }
            if(next2time <= 100000 && !visited[next2time]){
                queue.add(new int[]{next2time, currentTime + 1});
                visited[next2time] = true;
            }

        }

        return -1;
    }
}
public class HideAndSeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);

        SeekCalculator calculator = new SeekCalculator();

        int seekTime = calculator.getSeekTimeByBFS(n,k);

        System.out.println(seekTime);

    }
}
