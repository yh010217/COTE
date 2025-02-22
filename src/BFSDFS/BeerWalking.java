package BFSDFS;

import java.io.*;
import java.util.*;

class BeerConvPos{
    int x;
    int y;

    public BeerConvPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class BeerWalkingSolver {
    int startX;
    int startY;
    ArrayList<BeerConvPos> convList;
    int endX;
    int endY;
    int n;

    HashMap<BeerConvPos, Boolean> visited;

    public BeerWalkingSolver(int startX, int startY, ArrayList<BeerConvPos> convList, int endX, int endY, HashMap<BeerConvPos, Boolean> visited) {
        this.startX = startX;
        this.startY = startY;
        this.convList = convList;
        this.endX = endX;
        this.endY = endY;
        this.visited = visited;
        n = convList.size();
    }

    public boolean solve(){

        int startEndX = startX - endX;
        startEndX = startEndX < 0 ? -1 * startEndX : startEndX;
        int startEndY = startY - endY;
        startEndY = startEndY < 0 ? -1 * startEndY : startEndY;
        if(startEndX + startEndY <= 1000) return true;

        //1000 미터 안에 편의점이 항상 있어야함
        Queue<BeerConvPos> queue = new LinkedList<>();
        queue.add(new BeerConvPos(startX,startY));

        while(!queue.isEmpty()){
            BeerConvPos currentPos = queue.poll();
            int currentX = currentPos.x;
            int currentY = currentPos.y;
            Iterator<BeerConvPos> iterator = convList.iterator();
            while (iterator.hasNext()){
                BeerConvPos listConvPos = iterator.next();


                int xDiff = listConvPos.x - currentX;
                xDiff = xDiff < 0 ? -1 * xDiff : xDiff;
                int yDiff = listConvPos.y - currentY;
                yDiff = yDiff < 0 ? -1 * yDiff : yDiff;
                if(xDiff + yDiff <= 1000 && !visited.get(listConvPos)){

                    int xAnsDiff = listConvPos.x - endX;
                    xAnsDiff = xAnsDiff < 0 ? -1 * xAnsDiff : xAnsDiff;
                    int yAnsDiff = listConvPos.y - endY;
                    yAnsDiff = yAnsDiff < 0 ? -1 * yAnsDiff : yAnsDiff;
                    if(xAnsDiff + yAnsDiff <= 1000) return true;

                    queue.add(listConvPos);
                    visited.put(listConvPos,true);
                }
            }
        }

        return false;
    }

}

// 9205 맥주 마시면서 걸어가기
public class BeerWalking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] startXY = br.readLine().split(" ");
            int startX = Integer.parseInt(startXY[0]);
            int startY = Integer.parseInt(startXY[1]);

            ArrayList<BeerConvPos> convList = new ArrayList<>();
            HashMap<BeerConvPos,Boolean> visited = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                BeerConvPos conv = new BeerConvPos(x,y);
                convList.add(conv);
                visited.put(conv,false);
            }
            String[] endXY = br.readLine().split(" ");
            int endX = Integer.parseInt(endXY[0]);
            int endY = Integer.parseInt(endXY[1]);


            BeerWalkingSolver solver = new BeerWalkingSolver(startX, startY, convList, endX, endY, visited);
            boolean testAnswer = solver.solve();
            if(testAnswer) answer.append("happy\n");
            else answer.append("sad\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
