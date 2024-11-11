package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 1463 ... 다이나믹인데 BFS 로 풀어도 풀어지네...?
class MakeOneSolver{
    int n;

    public MakeOneSolver(int n) {
        this.n = n;
    }
    public int solve(){
        if(n == 1) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(n);
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentOpNum = current[1];
            if(currentX == 1) return currentOpNum;
            if(currentX % 3 == 0 && !visited.contains(currentX / 3)){
                queue.add(new int[]{currentX / 3 , currentOpNum + 1});
                visited.add(currentX / 3);
            }
            if(currentX % 2 == 0 && !visited.contains(currentX / 2)){
                queue.add(new int[]{currentX / 2 , currentOpNum + 1});
                visited.add(currentX / 2);
            }
            if(!visited.contains(currentX - 1)){
                queue.add(new int[]{currentX - 1 , currentOpNum + 1});
                visited.add(currentX - 1);
            }
        }
        return -1;
    }
}
public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MakeOneSolver solver = new MakeOneSolver(n);
        int result = solver.solve();
        System.out.println(result);
    }
}
