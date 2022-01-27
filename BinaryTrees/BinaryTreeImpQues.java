import java.util.*;
class Main {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class Pair {
		Node node;
		int state;

		Pair(Node node , int state){
			this.node = node;
			this.state = state;
		}
	}

	
	public static Node construct(Integer[]arr) {
		//Integer[] arr = {50,25 ,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		Stack<Pair> st = new Stack<>();
		Node root = new Node(arr[0] , null , null); // firt node  or root node 
		Pair rtp = new Pair(root,1); //firt pair that we push in stack

		int idx = 0;
		st.push(rtp);
		while(st.size() > 0){
			Pair top = st.peek(); 

			if(top.state == 1){
				idx++;
				if(arr[idx]!= null){
					top.node.left= new Node(arr[idx],null,null);
					Pair lp = new Pair(top.node.left,1);
					st.push(lp);
				}else{
					top.node.left = null;
				}
				top.state++;
			}else if(top.state == 2){
				idx++;
				if(arr[idx]!= null){
					top.node.right = new Node(arr[idx],null,null);
					Pair rp = new Pair(top.node.right,1);
					st.push(rp);
				}else{
					top.node.right = null;
				}
				top.state++;
			}else{
				st.pop();
			}
		}

		return root;
	}

	public static void display(Node node){
		if(node == null){
			return;
		}
		String str  = "";
		str += node.left == null ? ".":node.left.data + "";
		str += " <-" + node.data + "-> ";
		str += node.right == null ? ".":node.right.data + "";

		System.out.println(str);
		//display left part
		display(node.left);
		display(node.right);
	}

	
	public static int size(Node node) {
		// write your code here
		if(node == null){
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);


		int ts = ls+rs+1;
		return ts; 


	  }
	
	  public static int sum(Node node) {
		// write your code here
		if(node == null){
			return 0;
		}
		int ls = sum(node.left);
		int rs = sum(node.right);
		int ts = ls+rs+node.data;
		return ts;
	  }
	
	  public static int max(Node node) {
		// write your code here
		if(node == null){
			return Integer.MIN_VALUE;
		}

		int ltmax = max(node.left);
		int rtmax = max(node.right);

		int max = Math.max(ltmax,Math.max(rtmax,node.data));

		return max;
	  }
	
	  public static int height(Node node) {
		// write your code here
		if(node == null){
			return -1;
		}
		int lh = height(node.left);
		int rh = height(node.right);

		int th = Math.max(lh,rh)+1;
		return th;
	  }
	   
		  //diameter of binary tree  O(N^2)
		  public static int diameter(Node node){
	  
			  if(node == null){
				  return 0 ;
			  }
	  
	  
			  int ld = diameter(node.left); // maximum distance bt two nodes of left half
			  int rd = diameter(node.right); //mmaximum distance bt two nodes of right half
	  
	  
			  int f = height(node.left) + height(node.right) + 2;
	  
			  return Math.max(f,Math.max(ld,rd));
		  }
		    //diameter of binary tree effecient O(N)
	  static  class DiaPair{ 
		  int ht;
		  int dia;
	  }

	  public static DiaPair diameter2(Node node){

		if(node == null){
			DiaPair bp = new DiaPair();
			bp.ht = -1;
			bp.dia = 0;
			return bp;
		}

		 DiaPair lp = diameter2(node.left);
		 DiaPair rp = diameter2(node.right);

		 DiaPair mp = new DiaPair();
		 mp.ht = Math.max(lp.ht,rp.ht) +1;

		 int height = lp.ht + rp.ht + 2;
		 mp.dia = Math.max(height,Math.max(lp.dia,rp.dia));
		

		 return mp; 
	  }

	  public static void iterativePrePostInTraversal(Node node) {
		  if(node == null){
			  return;
		  }
			System.out.println(node.data) ;  //preOrder
			iterativePrePostInTraversal(node.left);
		//	System.out.println(node.data);  // inorder traversal  //euler between
			iterativePrePostInTraversal(node.right);
		//	System.out.println(node.data);  //Post order traversal

	  }


	  //in level order traversal we follow rpa rule remove print add in queue
	  public static void levelOrder(Node node) {
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(node);
	
		while (mq.size() > 0) {
		  int cicl = mq.size();
	
		  for (int i = 0; i < cicl; i++) {
			node = mq.remove();
			System.out.print(node.data + " ");
	
			if(node.left != null){
			  mq.add(node.left);
			}
	
			if(node.right != null){
			  mq.add(node.right);
			}
		  }
	
		  System.out.println();
		}
	  }

	  
    // Delete leaf nodes from binary search tree.
   public static Node leafDelete(Node root)
    {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
 
        // Else recursively delete in left and right
        // subtrees.
        root.left = leafDelete(root.left);
        root.right = leafDelete(root.right);
        return root;
    }


	public static void main(String[] args) {
		Integer[] arr = {50,25 ,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};                                
		Node root = construct(arr);
		//display(root);

		
		// int size = size(root);
		// int sum = sum(root);
		// int max = max(root);
		// int ht = height(root);
		// System.out.println(size);
		// System.out.println(sum);
		// System.out.println(max);
		// System.out.println(ht);
		//	iterativePrePostInTraversal(root);
		DiaPair p = diameter2(root);
		System.out.println(p.dia);

	//	levelOrder(root);
	}
}
