package Trees;

// insert operation in binary 
// search tree 
import java.util.*;
class BinarySearchTree { 

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
	BinarySearchTree() {
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

	// This method mainly calls InorderRec()
	void inorder() {
		inorderRec(root);
	}

	// A utility function to
	// do inorder traversal of BST sorted order
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
			
		}
		
	}
	/*void Preorder(Node root) {
		if (root != null) {	
			System.out.print(root.key + " ");
			preorder(root.left);
			preoder(root.right);
			
		}
		
	}*/
	/*void Postorder(Node root) {
		if (root != null) {
			Postorder(root.left);
			Postorder(root.right);
			System.out.print(root.key + " ");
		}
		
	}*/
	Node prev;
	boolean isBST(){
		prev=null;
		return isBST(root);
	}
	 /* Returns true if given search tree is binary 
       search tree (efficient version) */
	   boolean isBST(Node node) 
	   { 
		   // traverse the tree in inorder fashion and 
		   // keep a track of previous node 
		   if (node != null) 
		   { 
			   if (!isBST(node.left)) 
				   return false; 
	 
			   // allows only distinct values node 
			   if (prev != null && node.key <= prev.key ) 
				   return false; 
			   prev = node; 
			   return isBST(node.right); 
		   } 
		   return true; 
	   } 

	// Driver Code
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n>0){
			tree.insert(in.nextInt());
			n--;
		}
		in.close();
		// print inorder traversal of the BST
		tree.inorder();
		// tree.findmin(root);
		// tree.findmax(root);
		int res=tree.findheight(root);
		// System.out.println();
		// boolean res=tree.isBST();
		System.out.println(res);
		// 3

	}
	int countLeaves(Node root)
	{
	if(root==null)return 0;
	if(root.left==null && root.right==null)return 1;
	return countLeaves(root.left)+countLeaves(root.right);
}


	public int findmin(Node root) {
		if(root==null){
			return -1;
		}
		else if(root.left==null){
			return root.key;
		}
		//recussion way
		return findmin(root.left);

	}
	public int findmax(Node root){
		if(root==null){
			return -1;
		}
		Node current = root; 
  
        /* loop down to find the leftmost leaf */
        while (current.right != null) { 
            current = current.right; 
        } 
        return (current.key); 
	}
	public int findheight(Node root) {
		if(root==null){
			return -1;
		}
		return Math.max(findheight(root.left),findheight(root.right))+1;
		
	}
}
