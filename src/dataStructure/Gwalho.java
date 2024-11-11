package dataStructure;

import java.util.Scanner;
import java.util.Stack;

//9012
public class Gwalho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean[] noYes = new boolean[n];
        for(int i = 0 ; i < n ; i ++){
            String line = scanner.nextLine();
            if(line.length() % 2 != 0 || line.charAt(0) == ')'){
                noYes[i] = false;
                continue;
            }
            Stack<Boolean> booleanStack = new Stack<>();
            boolean iNo = false;
            for(int j = 0 ; j < line.length() ; j++){
                char nowChar = line.charAt(j);
                if(nowChar == '('){
                    booleanStack.push(true);
                }
                if(nowChar == ')'){
                    if(booleanStack.empty()){
                        iNo = true;
                        break;
                    }else{
                        booleanStack.pop();
                    }
                }
            }
            if(iNo){
                noYes[i] = false;
            }else{
                if(booleanStack.empty()) {
                    noYes[i] = true;
                }else{
                    noYes[i] = false;
                }
            }
        }
        for(int i = 0 ; i < n ; i ++){
            System.out.println(noYes[i] ? "YES" : "NO");
        }
    }
}
