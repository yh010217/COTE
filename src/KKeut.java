import java.util.Arrays;
import java.util.LinkedList;

class Solution3 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int answer1 = 0;
        LinkedList<String> list = new LinkedList();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            boolean itIsGreat = true;
            boolean finish = false;
            if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                answer1 = i;
                break;
            }
            for (int j = 0; j < i; j++) {
                if (words[i].compareTo(list.get(j)) > 0) {
                    list.add(j, words[i]);
                    itIsGreat = false;
                    break;
                } else if (words[i].compareTo(list.get(j)) == 0) {
                    answer1 = i;
                    finish =true;
                    break;
                }
            }
            if (finish) break;
            if (itIsGreat) list.add(words[i]);
        }

        if (answer1 == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = answer1 % n + 1;
            answer[1] = answer1 / n + 1;
        }
        return answer;
    }
}

public class KKeut {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] answer = solution.solution(2, new String[]{
                "hello", "one", "even", "never", "now", "world", "draw"
        });
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
