

import java.lang.*;
import java.util.*;


public class TernaryTree<T> implements TernaryTreeInterface<T> {
	
	private TernaryNode<T> root;
	
	public TernaryTree(){
		root = null;
	}
	
	public TernaryTree(T rootData){
		root = new TernaryNode<T>(rootData);
	}
	
	public TernaryTree(T rootData, TernaryTree<T> leftTree, TernaryTree<T> middleTree, TernaryTree<T> rightTree){
		privateSetTree(rootData, leftTree, middleTree, rightTree);
	}
	
	public void setTree(T rootData){
		setTree(rootData, null, null, null);
	}
	
	public void setTree(T rootData, TernaryTreeInterface<T> leftTree, TernaryTreeInterface<T> middleTree, TernaryTreeInterface<T> rightTree){
		privateSetTree(rootData, (TernaryTree<T>)leftTree, (TernaryTree<T>)middleTree, (TernaryTree<T>)rightTree);
	}
	
	private void privateSetTree(T rootData, TernaryTree<T> leftTree, TernaryTree<T> middleTree, TernaryTree<T> rightTree){
		root = new TernaryNode<T>(rootData);
		
	
		
		if((leftTree!=null) && !leftTree.isEmpty()){
			root.setLeftChild(leftTree.root);
		}
		if(middleTree!= null && !middleTree.isEmpty()){
			if(middleTree!=leftTree){
				root.setMiddleChild(middleTree.root);
			}
			else{
				root.setMiddleChild(middleTree.root.copy());
			}
		}
		if(rightTree!= null && !rightTree.isEmpty()){
			if(rightTree!=middleTree && rightTree!=leftTree){
				root.setRightChild(rightTree.root);
			}
			else{
				root.setRightChild(rightTree.root.copy());
			}
		}
		
		/*  if((leftTree!=null) &&(leftTree!=this)){
			leftTree.clear();
		}
		if((middleTree!=null)&&(middleTree!=this)){
			middleTree.clear();
		}
		if((rightTree!=null)&&(rightTree!=this)){
			rightTree.clear();
		}  */
		
	}
	
	public T getRootData() {
		if(isEmpty()){
			
			throw new EmptyTreeException();
		}
		else{
			
			return root.getData();
		}
	}
	
	public boolean isEmpty(){
		return (root == null);
	}
	
	public int getHeight(){
		int height = 0;
		
		if(!isEmpty()){
			
			 height = root.getHeight();
		}
		return height;
	}
	
	public int getNumberOfNodes(){
		int numberOfNodes = 0;
		
		if(!isEmpty()){
			numberOfNodes= root.getNumberOfNodes();
		}
		
		return numberOfNodes;
	}
	
	public void clear(){
		root = null;
	}
	
	public Iterator<T> getPreorderIterator(){
		return new PreorderIterator();
	}
	
	public Iterator<T> getPostorderIterator(){
		return new PostorderIterator();
	}
	
	public Iterator<T> getInorderIterator(){
		/* You cannot do this operation because of the fact that traversals require you to (by the end of traversing) output all the nodes of a tree. 
		In a binary tree, in-order traversal works because the definition of in-order traversal is to go to the left subtree, then the current node
		(which is the parent of the two subtrees),and then to go to the right subtree. This is impossible in a ternary tree. 
		Since you have left, middle, and right subtrees you would go to the left subtree, go to the middle subtree, and then go to the right subtree, 
		but would never go to the node that is the parent for these three subtrees. Essentially you would always skip the parent node of the subtrees. */
		throw new UnsupportedOperationException();	
	}
	
	public Iterator<T> getLevelOrderIterator(){
		return new LevelOrderIterator();
	}
	
	private class PreorderIterator implements Iterator<T>{
		private StackInterface<TernaryNode<T>> nodeStack;
		
		public PreorderIterator(){
			nodeStack = new LinkedStack<TernaryNode<T>>();
			if(root!=null){
				nodeStack.push(root);
			}
		}
		
		public boolean hasNext(){
			return !nodeStack.isEmpty();
		}
		
		public T next() {
			TernaryNode<T> nextNode;
			if(hasNext()){
				nextNode = nodeStack.pop();
				@SuppressWarnings("unchecked")
				TernaryNode<T>[] children = (TernaryNode<T>[]) new TernaryNode<?>[3];
				children[0] = nextNode.getLeftChild();
				children[1] = nextNode.getMiddleChild();
				children[2] = nextNode.getRightChild();
				
				if(children[2]!= null){
					nodeStack.push(children[2]);
				}
				if(children[1]!= null){
					nodeStack.push(children[1]);
				}
				if(children[0]!=null){
					nodeStack.push(children[0]);
				}
				
			}
			else{
				throw new NoSuchElementException();
			}
			
			return nextNode.getData();
			
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}

	 private class PostorderIterator implements Iterator<T> {
		private StackInterface<TernaryNode<T>> nodeStack;
		private TernaryNode<T> currentNode;
		
		public PostorderIterator(){
			nodeStack= new LinkedStack<TernaryNode<T>>();
			currentNode = root;
		}
		
		public boolean hasNext(){
			return (!nodeStack.isEmpty()||currentNode!=null);
		}
		
		public T next(){
			boolean foundNext = false;
			@SuppressWarnings("unchecked")
			TernaryNode<T>[] children = (TernaryNode<T>[]) new TernaryNode<?>[3];
			TernaryNode<T> nextNode = null;
			
			while(currentNode!=null){
				nodeStack.push(currentNode);
				children[0] = currentNode.getLeftChild();
				if(children[0] == null){
					children[1]= currentNode.getMiddleChild();
					if(children[1]!= null){
						currentNode = children[1];
					}
					else{
						children[2] = currentNode.getRightChild();
						currentNode = children[2];
					}
					
				}
				else{
						currentNode = children[0];
				}
			}
			
			if(!nodeStack.isEmpty()){
				nextNode = nodeStack.pop();
				
				TernaryNode<T> parent = null;
				
				if(!nodeStack.isEmpty()){
					parent = nodeStack.peek();
					if(nextNode==parent.getLeftChild()){
						currentNode = parent.getMiddleChild();
						if(currentNode==null){
							currentNode = parent.getRightChild();
							
						}
						
					}
					else if(nextNode ==parent.getMiddleChild()){
						currentNode = parent.getRightChild();
					}
					else{
						currentNode = null;
					}
				}
				else{
					currentNode = null;
				}
			}
			else{
				throw new NoSuchElementException();
			}
			
			return nextNode.getData();
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	
	} 
	
	private class LevelOrderIterator implements Iterator<T> {
		
		private QueueInterface<TernaryNode<T>> nodeQueue;
		
		public LevelOrderIterator(){
			nodeQueue = new LinkedQueue<TernaryNode<T>>();
			if(root!=null){
				nodeQueue.enqueue(root);	
			}
		}
		public boolean hasNext(){
			return !nodeQueue.isEmpty();
		}
		
		public T next(){
			TernaryNode<T> nextNode;
			
			if(hasNext()){
				nextNode = 	nodeQueue.dequeue();
				TernaryNode<T> leftChild = nextNode.getLeftChild();
				TernaryNode<T> middleChild = nextNode.getMiddleChild();
				TernaryNode<T> rightChild = nextNode.getRightChild();
				
				if(leftChild!=null){
					nodeQueue.enqueue(leftChild);
				}
				if(middleChild!=null){
					nodeQueue.enqueue(middleChild);
				}
				if(rightChild!=null){
					nodeQueue.enqueue(rightChild);
				}
			}
			else{
				throw new NoSuchElementException();
			}
			return nextNode.getData();
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}