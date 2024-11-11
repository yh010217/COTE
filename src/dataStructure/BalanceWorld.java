package dataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

//4949
public class BalanceWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Boolean> yesNo = new ArrayList<>();
        while (true){
            String line = br.readLine();
            if(line.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            boolean currentValid = false;
            for(int i = 0 ; i < line.length() ; i++){
                char currentChar = line.charAt(i);
                if(currentChar == '(' || currentChar == '['){
                    stack.push(currentChar);
                }else if(currentChar == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        break; // false 인 채로 break
                    }
                }else if(currentChar == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        break; // false 인 채로 break
                    }
                }
                if(i == line.length() - 1 && currentChar == '.' && stack.isEmpty()){
                    currentValid = true;
                }
            }
            yesNo.add(currentValid);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Boolean valid : yesNo){
            bw.write((valid ? "yes" : "no") + "\n");
        }
        bw.flush();
        bw.close();
    }
}
