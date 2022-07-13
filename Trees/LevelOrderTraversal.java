package Trees;

import java.util.*;

class LevelOrderTraversal { 

	/* Class containing left 
	and right child of current node 
	* and key value*/
	class Node 
	{ 
		int key; 
		Node left, right; 

		public Node(int item) 
		{ 
			key = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	static Node root;

	// Constructor
	LevelOrderTraversal() {
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}

	/*
	 * A recursive function to insert a new key in BST
	 */
	Node insertRec(Node root, int key) {

		/*
		 * If the tree is empty, return a new node
		 */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}
   
    public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n>0){
			tree.insert(in.nextInt());
			n--;
		}
		in.close();
        System.out.println("Result:"+levelOrder(root));
    }


public static List<List<Integer>> levelOrder(Node root){
	List<List<Integer>> ans=new ArrayList<List<Integer>>();
	if(root==null){
		return ans;
	}
	Queue<Node> q=new LinkedList<Node>();
	q.add(root);
	while(!q.isEmpty()){
		int size=q.size();
		LinkedList<Integer> levelList=new LinkedList<Integer>();
		while(size>0){
			Node cur=q.remove();
			levelList.addFirst(cur.key);
			levelList.add(cur.key);
			if(cur.left!=null){
				q.add(cur.left);
			}
			if(cur.right!=null){
				q.add(cur.right);
			}
			size--;
		}
		ans.add(levelList);
	}
	return ans;
}
}

//Time Complexity: O(n)
//Space Complexity: O(n)

