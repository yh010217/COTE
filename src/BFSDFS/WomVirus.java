package BFSDFS;
//2606

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class VirusDFS{
    private int[] visited;
    public void setVisited(int[] visited){
        this.visited = visited;
    }
    public int infected(List<List<Integer>> adj, int node, int count){
        visited[node] = 1;
        count++;

        List<Integer> nodeAdj = adj.get(node);

        for(int i = 0 ; i < nodeAdj.size() ; i++){
            int nextNode = nodeAdj.get(i);
            if(visited[nextNode] == 0){
                count = infected(adj,nextNode,count);
            }
        }

        return count;
    }
}
public class WomVirus {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nodesStr = scanner.nextLine();
        int nodes = Integer.parseInt(nodesStr);
        String edgesStr = scanner.nextLine();
        int edges = Integer.parseInt(edgesStr);

        List<List<Integer>> adj = new ArrayList<>(); // 0은 안넣을 거여서
        for(int i = 0 ; i <= nodes ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges ; i++){
            String twoNodes = scanner.nextLine();
            int first = Integer.parseInt(twoNodes.split(" ")[0]);
            int second = Integer.parseInt(twoNodes.split(" ")[1]);

            adj.get(second).add(first);
            adj.get(first).add(second);
        }

        VirusDFS virusDFS = new VirusDFS();
        int[] visited = new int[nodes+1];
        virusDFS.setVisited(visited);
        int infected = virusDFS.infected(adj, 1, 0);

        System.out.println(infected - 1);

    }
}
