package uva.eda;


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
		// depth = 0;
	}
	
	/**
	 * Initializes a new Rope joining two Ropes given
	 * @param left
	 * @param right
	 */
	public Rope(Rope left, Rope right){
		
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
	
	/**
	 * Concatenates two Ropes by putting the Rope given on the left of this Rope
	 * @param left
	 * @return
	 */
	public Rope concatenateLeft(Rope left){
		return new Rope(left, this);
	}
	
	/**
	 * Concatenates two Ropes by putting the Rope given on the right of this Rope
	 * @param right
	 * @return
	 */
	public Rope concatenateRight(Rope right){
		return new Rope(this, right);
	}
	
	/**
	 * Returns the character allocated in the position given
	 * @param position
	 * @return
	 */
	public char getChar(int position){
		return 'a'; // CHANGE THIS
	}
	
	
	// BALANCE: public or private method
	
}
