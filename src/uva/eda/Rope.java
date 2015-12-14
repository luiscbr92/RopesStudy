package uva.eda;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Implements texts Strings as Ropes
 * 
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
	 */
	public Rope(String text) {
		subString = text;
		length = text.length();
		depth = 0;
	}

	/**
	 * Initializes a new Rope joining two Ropes given
	 */
	public Rope(Rope left, Rope right) {
		this.left = left;
		this.right = right;
		length = left.length() + right.length();
		if (left.depth() > right.depth())
			depth = left.depth() + 1;
		else
			depth = right.depth() + 1;
	}

	/**
	 * USE WHEN DEPTH=0!! Returns the substring of this Rope
	 */
	public String getSubString() {
		return subString;
	}

	/**
	 * USE WHEN DEPTH>0!! Returns the left Rope of this Rope
	 */
	public Rope getLeft() {
		return left;
	}

	/**
	 * USE WHEN DEPTH>0!! Returns the right Rope of this Rope
	 */
	public Rope getRight() {
		return right;
	}

	/**
	 * Returns the length of this Rope
	 */
	public int length() {
		return length;
	}

	/**
	 * Returns the depth of this Rope
	 */
	public int depth() {
		return depth;
	}

	/**
	 * Checks if this rope has depth 0.
	 */
	public boolean isLeaf() {
		return depth() == 0;
	}

	/**
	 * Concatenates two Ropes by putting the Rope given on the right of this
	 * Rope
	 */
	public Rope concatenate(Rope right) {
		return new Rope(this, right);
	}

	/**
	 * Returns the character allocated in the position given
	 */
	public char getChar(int position) {
		if (isLeaf())
			return getSubString().charAt(position);
		else {
			if (position < getLeft().length())
				return getLeft().getChar(position);
			else {
				position -= getLeft().length();
				return getRight().getChar(position);
			}
		}
	}

	/**
	 * Returns the Rope perfectly balanced
	 */
	public Rope balance() {
		Stack<Rope> myStack = new Stack<Rope>();
		List<Rope> myList = new ArrayList<Rope>();
		Rope tmp;

		myStack.push(this);
		while (!myStack.empty()) {
			tmp = myStack.pop();
			if (tmp.isLeaf())
				myList.add(tmp);
			else {
				myStack.push(tmp.getRight());
				myStack.push(tmp.getLeft());
			}
		}

		return getTree(myList);
	}

	/**
	 * Returns this rope as String
	 */
	public String toString() {
		if (isLeaf())
			return getSubString();
		else
			return getLeft().toString() + getRight().toString();
	}

	private Rope getTree(List<Rope> original) {
		if (original.size() == 1)
			return original.get(0);
		else {
			return new Rope(getTree(original.subList(0, original.size() / 2)),
					getTree(original.subList(original.size() / 2, original.size())));
		}
	}

}
