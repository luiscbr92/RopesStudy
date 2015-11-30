package uva.eda;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Implements texts Strings as Ropes
 * @author Luis Alberto Centeno Bragado, Ángel Posada García
 *
 */
public class Rope {
	private String subString;
	private Rope left;
	private Rope right;
	private int length;
	private int depth;

	/**
	 * Initializes a new Rope with a String
	 * @param text
	 */
	public Rope(String text){
		subString = text;
		length = text.length();
		depth = 0;
	}
	
	/**
	 * Initializes a new Rope joining two Ropes given
	 * @param left
	 * @param right
	 */
	public Rope(Rope left, Rope right){
		this.left = left;
		this.right = right;
		length = left.length() + right.length();
		if(left.depth() > right.depth())
			depth = left.depth() + 1;
		else
			depth = right.depth() + 1;
	}
	
	/**
	 * USE WHEN DEPTH=0!! Returns the substring of this Rope
	 * @return
	 */
	public String getSubString(){
		return subString;
	}
	
	/**
	 * USE WHEN DEPTH>0!! Returns the left Rope of this Rope
	 * @return
	 */
	public Rope getLeft(){
		return left;
	}

	/**
	 * USE WHEN DEPTH>0!! Returns the right Rope of this Rope
	 * @return
	 */
	public Rope getRight(){
		return right;
	}
	
	/**
	 * Returns the length of this Rope
	 * @return
	 */
	public int length(){
		return length;
	}
	
	/**
	 * Returns the depth of this Rope
	 * @return
	 */
	public int depth(){
		return depth;
	}
	
	
	public boolean isLeaf(){
		return depth() == 0;
	}
	
	/**
	 * Concatenates two Ropes by putting the Rope given on the right of this Rope
	 * @param right
	 * @return
	 */
	public Rope concatenate(Rope right){
		return new Rope(this, right);
	}
	
	/**
	 * Returns the character allocated in the position given
	 * @param position
	 * @return
	 */
	public char getChar(int position){
		if(isLeaf())
			return getSubString().charAt(position);
		else{
			if(position < getLeft().length())
				return getLeft().getChar(position);
			else{
				position -= getLeft().length();
				return getRight().getChar(position);
			}
		}
	}
	
	/**
	 * Returns the Rope perfectly balanced
	 * @return
	 */
	public Rope balance(){
		Stack<Rope> myStack = new Stack<Rope>();
		List<Rope> myList = new ArrayList<Rope>();
		Rope tmp;
		
		myStack.push(this);
		while(!myStack.empty()){
			tmp = myStack.pop();
			if(tmp.isLeaf())
				myList.add(tmp);
			else{
				myStack.push(tmp.getRight());
				myStack.push(tmp.getLeft());
			}
		}
		
		return getTree(myList);
	}
	
	private Rope getTree(List<Rope> original){
		if(original.size() == 1)
			return original.get(0);
		else{
			return new Rope(getTree(original.subList(0, original.size()/2)), getTree(original.subList(original.size()/2, original.size())));
		}
	}
	
}
