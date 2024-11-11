package BFSDFS;

import java.util.*;


//1260
class FindFunction{
    private static int[] visited;
    public static void setVisited(int[] visited){
        FindFunction.visited = visited;
    }

    public void dfs(List<Integer>[] adj, int node, List<Integer> ansDfs){
        ansDfs.add(node);
        visited[node] = 1;
        List<Integer> current = adj[node];
        for(int i = 0 ; i < current.size() ; i++){
            int next = current.get(i);
            if(visited[next] == 0){
                dfs(adj,next,ansDfs);
            }
        }
    }
    public void bfs(List<Integer>[] adj, int node, List<Integer> ansBfs){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        ansBfs.add(node);
        visited[node] = 1;

        while(!queue.isEmpty()){
            int popNode = queue.poll();
            List<Integer> popList = adj[popNode];
            for(int i = 0 ; i < popList.size(); i++){
                int toPush = popList.get(i);
                if(visited[toPush] == 0 ) {
                    queue.add(toPush);
                    ansBfs.add(toPush);
                    visited[toPush] = 1;
                }
            }
        }
    }
}
public class BasicDFSBFS {
    public static void main(String[] args) {
        //입력을 해주기 위해 인접리스트를 변수로 잡아놓을거임
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        String[] stringNMV = s.split(" ");

        int n = Integer.parseInt(stringNMV[0]);
        int m = Integer.parseInt(stringNMV[1]);
        int v = Integer.parseInt(stringNMV[2]);

        List<Integer>[] adj = new List[n + 1];

        adj[0] = null;
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        //입력값 -> adj 채워넣기
        for (int i = 1; i <= m; i++) {
            String twoNode = scanner.nextLine();
            String[] nodes = twoNode.split(" ");
            int first = Integer.parseInt(nodes[0]);
            int second = Integer.parseInt(nodes[1]);

            //adj[first].add(second);

            if (adj[first].size() == 0) {
                adj[first].add(second);
            } else {
                for (int j = 0; j < adj[first].size(); j++) {
                    if (second <= adj[first].get(j)) {
                        adj[first].add(j, second);
                        break;
                    }
                    if (second > adj[first].get(adj[first].size() - 1)) {
                        adj[first].add(second);
                        break;
                    }
                }
            }

            //adj[second].add(first);
            if (adj[second].size() == 0) {
                adj[second].add(first);
            }else {
                for (int j = 0; j < adj[second].size(); j++) {

                    if (first <= adj[second].get(j)) {
                        adj[second].add(j, first);
                        break;
                    }
                    if (first > adj[second].get(adj[second].size() - 1)) {
                        adj[second].add(first);
                        break;
                    }
                }
            }
        }

        scanner.close();

        FindFunction findFunction = new FindFunction();

        //DFS
        FindFunction.setVisited(new int[n+1]);
        List<Integer> ansDfs = new ArrayList<>();
        findFunction.dfs(adj,v,ansDfs);

        for(Integer ans : ansDfs){
            System.out.print(ans + " ");
        }
        System.out.println();

        //BFS
        FindFunction.setVisited(new int[n+1]);
        List<Integer> ansBfs = new ArrayList<>();
        findFunction.bfs(adj,v,ansBfs);

        for(Integer ans : ansBfs){
            System.out.print(ans + " ");
        }

    }
}
