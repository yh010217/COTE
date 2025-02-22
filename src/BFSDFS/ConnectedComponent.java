package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
//11724
class ConnectedComponentSolver{
	ArrayList<ArrayList<Integer>> connectedList;
	boolean[] visitedNode;

	public ConnectedComponentSolver(ArrayList<ArrayList<Integer>> connectedList) {
		this.connectedList = connectedList;
		visitedNode = new boolean[connectedList.size()];
		visitedNode[0] = true; // 0 이라는 노드는 없게 하고 싶으니깐, 근데 사실 하나 안하나 결과에는 차이 없을듯
	}
	public int hasLeftNode(){
		int result = 0;
		for(int i = 1 ; i < visitedNode.length ; i++){
			if(!visitedNode[i]){
				result = i;
				break;
			}
		}
		return result;
	}
	private void pushListToStack(Stack<Integer> stack, int node){
		ArrayList<Integer> nodeList = connectedList.get(node);
		for(int connectedNode : nodeList){
			if(!visitedNode[connectedNode]) stack.push(connectedNode);
		}
	}
	public void findUnion(Stack<Integer> stack, int node){
		visitedNode[node] = true;
		pushListToStack(stack,node);
		if(!stack.isEmpty())	findUnion(stack, stack.pop());
	}
}

public class ConnectedComponent {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstLine = br.readLine();
		String[] splitFirstLine =firstLine.split(" ");
		int n = Integer.parseInt(splitFirstLine[0]);
		int m = Integer.parseInt(splitFirstLine[1]);

		ArrayList<ArrayList<Integer>> connectedList = new ArrayList<>();
		connectedList.add(null);
		for(int i = 0 ; i < n ; i ++){
			connectedList.add(new ArrayList<>());
		}

		for (int i = 0 ; i < m ; i ++){
			String line = br.readLine();
			String[] splitLine = line.split(" ");
			int u = Integer.parseInt(splitLine[0]);
			int v = Integer.parseInt(splitLine[1]);
			connectedList.get(u).add(v);
			connectedList.get(v).add(u);
		}

		ConnectedComponentSolver solver = new ConnectedComponentSolver(connectedList);
		int answer = 0;

		int nextNode = 1;
		while(nextNode != 0){
			answer++;
			Stack<Integer> stack = new Stack<>();
			solver.findUnion(stack,nextNode);
			nextNode = solver.hasLeftNode();
		}
		System.out.println(answer);

	}
}
