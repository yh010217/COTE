package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//5014
class StartLinkSolver{
    int f;
    int s;
    int g;
    int u;
    int d;

    private int answer = 0;

    boolean[] visited;
    Queue<int[]> queue;
    public StartLinkSolver(int f, int s, int g, int u, int d) {
        this.f = f;
        this.s = s;
        this.g = g;
        this.u = u;
        this.d = d;
        visited = new boolean[f+1];
        visited[s] = true;
        queue = new LinkedList<>();
        queue.add(new int[]{s,1});
    }
    public int solve(){
        if(s == g) return 0;
        while(!queue.isEmpty()){
            int[] currentFloor = queue.poll();
            answer = currentFloor[1];
            int nextUpFloor = currentFloor[0] + u;
            int nextDownFloor = currentFloor[0] - d;
            if(nextUpFloor == g || nextDownFloor == g){
                return answer;
            }
            if(nextUpFloor <= f && !visited[nextUpFloor]){
                visited[nextUpFloor] = true;
                queue.add(new int[]{nextUpFloor, currentFloor[1] + 1});
            }
            if(nextDownFloor >= 1 && !visited[nextDownFloor]){
                visited[nextDownFloor] = true;
                queue.add(new int[]{nextDownFloor, currentFloor[1] + 1});
            }
        }
        return -1;
    }
}
public class StartLink {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 최고층
        int f = Integer.parseInt(input[0]);
        // 강호가 있는 현재 층
        int s = Integer.parseInt(input[1]);
        // 스타트링크가 있는 층
        int g = Integer.parseInt(input[2]);
        // u버튼
        int u = Integer.parseInt(input[3]);
        // d버튼
        int d = Integer.parseInt(input[4]);

        StartLinkSolver solver = new StartLinkSolver(f,s,g,u,d);
        int result = solver.solve();
        if(result == -1){
            System.out.println("use the stairs");
        }else{
            System.out.println(result);
        }
    }
}
