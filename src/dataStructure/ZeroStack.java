package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//10773 제로 - 정신없는 재민이
public class ZeroStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < k ; i++){
            int value = Integer.parseInt(br.readLine());
            if(value == 0 && !stack.empty()){
                stack.pop();
            }else{
                stack.push(value);
            }
        }

        int sum = 0;
        for(Integer item : stack){
            sum+=item;
        }
        System.out.println(sum);

    }
}
