package dataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 1874
public class StackSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> stack = new LinkedList<>();
        int toInput = 1;
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        boolean isBreak = false;
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(br.readLine());
            if (isBreak) continue;
            // 스택에 없을 때
            if (current >= toInput) {
                for (; toInput <= current; toInput++) {
                    stack.add(toInput);
                    //bw.write("+\n");
                    sb.append("+\n");
                }
                stack.remove(stack.size() - 1);
                //bw.write("-\n");
                sb.append("-\n");
            } else {
                int popped = stack.get(stack.size() - 1);
                if (popped != current) {
                    isBreak = true;
                    sb=new StringBuilder("NO");
                } else {
                    stack.remove(stack.size() - 1);
                    //bw.write("-\n");
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb);

    }
}
