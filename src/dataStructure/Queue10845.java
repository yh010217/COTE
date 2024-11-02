package dataStructure;

import java.io.*;

class QueueImpl10845 {
    BufferedWriter bw;

    private int[] queue = new int[10000];
    private int size = 0;

    int front = 0;
    int back = 0;

    public QueueImpl10845(BufferedWriter bw) {
        this.bw = bw;
    }

    public void pushX(int x) throws IOException{
        queue[back] = x;
        size++;
        back++;
    }
    public void pop() throws IOException {
        if (size == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(queue[front] + "\n");
            size--;
            front ++;
        }
    }
    public void front() throws IOException {
        if (size == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(queue[front] + "\n");
        }
    }

    public void back() throws IOException {
        if (size == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(queue[back - 1] + "\n");
        }
    }

    public void size() throws IOException {
        bw.write(size + "\n");
    }
    public void empty() throws IOException {
        if(size == 0){
            bw.write(1 + "\n");
        }else{
            bw.write(0 + "\n");
        }
    }


}

public class Queue10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        QueueImpl10845 queue = new QueueImpl10845(bw);
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line.equals("front")) {
                queue.front();
            } else if (line.equals("back")) {
                queue.back();
            } else if (line.equals("size")) {
                queue.size();
            } else if (line.equals("empty")) {
                queue.empty();
            } else if (line.equals("pop")) {
                queue.pop();
            } else {
                int value = Integer.parseInt(line.split(" ")[1]);
                queue.pushX(value);
            }
        }
        bw.flush();
        bw.close();
    }
}
