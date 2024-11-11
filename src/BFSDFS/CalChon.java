package BFSDFS;

import java.util.*;

//2644 촌수 계산
class ChonCalculator{
    private int[] visited;

    public int[] getVisited() {
        return visited;
    }

    public void setVisited(int[] visited) {
        this.visited = visited;
    }

    public int chonBFS(int firstPerson, int secondPerson, List<List<Integer>> relation){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{firstPerson,0});
        visited[firstPerson] = 1;

        while(!queue.isEmpty()) {
            int[] currentPerson = queue.poll();

            List<Integer> currentRelation = relation.get(currentPerson[0]);

            for (int i = 0; i < currentRelation.size(); i++) {
                int nextPerson = currentRelation.get(i);

                if(nextPerson == secondPerson){
                    return currentPerson[1] + 1;
                }

                if(visited[nextPerson] == 0){
                    queue.add(new int[]{nextPerson,currentPerson[1] + 1});
                    visited[nextPerson] = 1;
                }
            }
        }
        return -1;
    }
}

public class CalChon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String twoPeople = scanner.nextLine();
        int firstPerson = Integer.parseInt(twoPeople.split(" ")[0]);
        int secondPerson = Integer.parseInt(twoPeople.split(" ")[1]);


        List<List<Integer>> relation = new ArrayList<>();
        relation.add(null);
        for(int i = 1 ; i <= n ; i ++){
            relation.add(new ArrayList<>());
        }

        int m = Integer.parseInt(scanner.nextLine());

        for(int i = 0 ; i < m ; i++){
            String relString = scanner.nextLine();
            int strFirst = Integer.parseInt(relString.split(" ")[0]);
            int strSecond = Integer.parseInt(relString.split(" ")[1]);

            relation.get(strFirst).add(strSecond);
            relation.get(strSecond).add(strFirst);
        }

        ChonCalculator chonCalculator = new ChonCalculator();
        chonCalculator.setVisited(new int[n+1]);
        int result = chonCalculator.chonBFS(firstPerson, secondPerson, relation);

        System.out.println(result);

    }
}
