
public class Node {

	public int value;
	public Node leftChild;
	public Node rightChild;

	public Node(int v) {
		this.value = v;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node(int v, Node l, Node r) {

		this.value = v;
		this.leftChild = l;
		this.rightChild = r;

	}
}
