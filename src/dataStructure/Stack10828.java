package dataStructure;


import java.io.*;

//10828 스택
class StackImpl10828 {
    BufferedWriter bw;

    public StackImpl10828(BufferedWriter bw) {
        this.bw = bw;
    }

    private int[] stack = new int[10000];
    private int size = 0;

    public void pushX(int x) {
        stack[size] = x;
        size++;
    }

    public void pop() throws IOException {
        if (size == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(stack[size - 1] + "\n");
            size--;
        }
    }

    public void size() throws IOException {
        bw.write(size + "\n");
    }

    public void empty() throws IOException {
        if (size == 0) bw.write(1 + "\n");
        else bw.write(0 + "\n");
    }

    public void top() throws IOException {
        if (size == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(stack[size - 1] + "\n");
        }
    }
}

public class Stack10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StackImpl10828 stack = new StackImpl10828(bw);
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line.equals("top")) {
                stack.top();
            } else if (line.equals("size")) {
                stack.size();
            } else if (line.equals("empty")) {
                stack.empty();
            } else if (line.equals("pop")) {
                stack.pop();
            } else {
                int value = Integer.parseInt(line.split(" ")[1]);
                stack.pushX(value);
            }
        }
        bw.flush();
        bw.close();
    }
}