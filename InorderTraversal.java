//Given a binary tree, return the in order traversal of its nodes' values.
//Keep in mind that the in order Traversal goes through the left subtree, then root, then right subtree


package com.tutorial.main;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root){ 
		ArrayList<Integer> list = new ArrayList<Integer>(); //We will return the result in an ArrayList, we need the size to be able to change
		if(root==null) return list; //Of course, if root is null, then we just return the list which is empty
		Stack<TreeNode> stack = new Stack<TreeNode>(); //We use the stack as an optimal data structure here
		
		TreeNode curr = root;
		while(curr!=null||!stack.isEmpty()){
			if(curr!=null){
				stack.push(curr);
				curr = curr.left; //Here, we go until the leftmost node. Since the in order traversal first starts with the left sub-tree
				//Hence, we keep the if condition as long as the current node has a left child
			}  else {
				TreeNode t = stack.pop(); //This node is the top one in the stack, and takes it out with the "pop" function
				list.add(t.val); //We add the result to the list that will be returned: you guess that the first one will be the left-most node
				curr = t.right;
			}
		}
		return list;
	}
}
