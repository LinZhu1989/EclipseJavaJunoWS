package dfs;
 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class dfs {

	public static void dfsPrintTree(Node n, int level) {

		if (n == null) {
			return;
		} else {

			printString(level, n);

			for (Node node : n.child) {

				dfsPrintTree(node, level + 1);
			}

		}

	}
	
	public static void bfsPrintTree(Node n) {

		Node p = n;
		int depth = 1; // 深度
		int currentLevelNodes = 1; // 当前Level，node的数量
		int nextLevelNodes = 0; // 下一层Level，node的数量

		if (p != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(n);
			while (!queue.isEmpty()) {

				String dot = "";
				for (int i = 1; i <= depth; i++) {
					dot += ".. ";
				}

				p = queue.poll();
				System.out.println(dot + p.value);
				currentLevelNodes--;

				
				if(p.child.size()>0){
					for(Node c:p.child) 
					{
						queue.add(c);
						nextLevelNodes++;
					}					
				}
				
				

				if (currentLevelNodes == 0) { // 说明已经遍历完当前层的所有节点
					depth++; // 增加高度
					currentLevelNodes = nextLevelNodes; // 初始化下一层的遍历
					nextLevelNodes = 0;
				}
			}

		}

	}


	private static void printString(int level, Node n) {
		String dot = "";
		for (int i = 1; i <= level; i++) {
			dot += ".. ";
		}
		System.out.println(dot + n.value);
	}

	public static void main(String[] args) {

		ArrayList<Node> temp1 = new ArrayList<Node>(1);
		ArrayList<Node> temp2 = new ArrayList<Node>(1);
		ArrayList<Node> temp3 = new ArrayList<Node>(1);
		ArrayList<Node> temp4 = new ArrayList<Node>(1);
		ArrayList<Node> temp5 = new ArrayList<Node>(1);
		// Create Node Tree
		Node n9 = new Node("9");
		temp1.add(n9);
		Node n8 = new Node("8");
		Node n7 = new Node("7", temp1);

		temp2.add(n7);
		temp2.add(n8);
		Node n6 = new Node("6");
		Node n5 = new Node("5");
		Node n4 = new Node("4", temp2);

		temp3.add(n4);
		temp3.add(n5);
		Node n2 = new Node("2", temp3);

		temp4.add(n6);
		Node n3 = new Node("3", temp4);

		temp5.add(n2);
		temp5.add(n3);
		Node n1 = new Node("1", temp5);

		// Here we know n1 is the root

		dfsPrintTree(n1, 1);
		bfsPrintTree(n1);

	}

}
