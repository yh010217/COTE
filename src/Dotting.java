class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(int ak = 0; ak <= d ; ak+=k){
            int current = 1 + (int)Math.floor(Math.sqrt((d*d - ak*ak))/(k*1.0));
            answer+=current;
        }

        return answer;
    }
}

public class Dotting {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.solution(2,10);
        System.out.println(result);
    }
}
