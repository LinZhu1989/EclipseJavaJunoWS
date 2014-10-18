package dfs;

import java.util.ArrayList;

public class Node {

	public String value;
	public ArrayList<Node> child;
	
	public Node(String v){
		value=v;
		child=new ArrayList<Node>(1);
	}
	
	public Node(String v,ArrayList<Node> c){
		value=v;
		child=c;
	}
}
