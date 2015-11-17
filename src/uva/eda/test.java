package uva.eda;

public class test {
	
	public static void printRope(Rope r){
		for(int i=0; i < r.length(); i++)
			System.out.print(r.getChar(i));
		System.out.println();
	}

	public static void main(String[] args) {
		Rope leaf1 = new Rope("En ");
		Rope leaf2 = new Rope("un lug");
		Rope leaf3 = new Rope("ar ");
		Rope leaf4 = new Rope("de");
		
		Rope concat1 = leaf3.concatenateRight(leaf4);
		Rope concat2 = leaf2.concatenateRight(concat1);
		Rope rop = leaf1.concatenateRight(concat2);
		
		Rope balanced = rop.balance();
		
		printRope(rop);
		printRope(balanced);
		
		System.out.println(rop.depth());
		System.out.println(balanced.depth());
	}

}
