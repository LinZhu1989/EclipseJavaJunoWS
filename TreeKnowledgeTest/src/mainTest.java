import java.util.LinkedList;
import java.util.Queue;

public class mainTest {

	public static void dfsPrintTree(Node n, int level) {

		if (n == null) {
			return;
		} else {

			String dot = "";
			for (int i = 1; i <= level; i++) {
				dot += ".. ";
			}

			System.out.println(dot + n.value);
			dfsPrintTree(n.leftChild, level + 1); // First search left child
			dfsPrintTree(n.rightChild, level + 1); // Then search right child
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

				if (p.leftChild != null) {
					queue.add(p.leftChild);
					nextLevelNodes++;
				}

				if (p.rightChild != null) {
					queue.add(p.rightChild);
					nextLevelNodes++;
				}

				if (currentLevelNodes == 0) { // 说明已经遍历完当前层的所有节点
					depth++; // 增加高度
					currentLevelNodes = nextLevelNodes; // 初始化下一层的遍历
					nextLevelNodes = 0;
				}
			}

		}

	}

	public static void testCase1() {

		// Create Node Tree
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n3 = new Node(3, n5, n6);
		Node n4 = new Node(4, n7, null);
		Node n2 = new Node(2, n3, n4); // Here we know n2 is the root

		// Search method 1
		System.out.println("===== DFS print tree =====");
		dfsPrintTree(n2, 1);
		System.out.println("===== BFS print tree =====");
		bfsPrintTree(n2);

	}

	public static void main(String[] args) {

		testCase1();

	}

}
