package dataStructure;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String testNumStr = scanner.nextLine();
        int testNum = Integer.parseInt(testNumStr);

        int[] answers = new int[testNum];
        for (int i = 0; i < testNum; i++) {
            String nm = scanner.nextLine();
            int n = Integer.parseInt(nm.split(" ")[0]);
            int m = Integer.parseInt(nm.split(" ")[1]);

            int answer = 0;
            int mValue = 0;
            String[] queueStr = scanner.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            int[] priorityNum = new int[10];
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(queueStr[j]);
                if (j == m) mValue = value;
                list.add(j);
                priorityNum[value]++;
            }
            for (int j = 9; j > mValue; j--) {
                if (priorityNum[j] > 0) {
                    for (int k = list.size() - 1; k >= 0; k--) {
                        if (Integer.parseInt(queueStr[list.get(k)]) == j) {
                            List<Integer> tempSubListToBack = list.subList(0, k);
                            List<Integer> tempSubListToFront = list.subList(k, list.size());
                            list = new ArrayList<>(tempSubListToFront);
                            list.addAll(tempSubListToBack);
                            break;
                        }
                    }
                }
            }
            for (int j = 0; j < list.size(); j++) {
                if (Integer.parseInt(queueStr[list.get(j)]) == mValue) {
                    answer++;
                    if (list.get(j) == m) break;
                }
            }

            for (int j = 9; j > mValue; j--) {
                answer += priorityNum[j];
            }
            answers[i] = answer;
        }
        for (int i = 0; i < testNum; i++) {
            System.out.println(answers[i]);
        }
    }
}
