package uva.eda;

public class evaluation {

	public static void main(String[] args) {
		Rope a = new Rope("ABC");
		Rope b = new Rope("DE");
		Rope c = new Rope("");
		Rope d = new Rope("FEG");
		
		Rope bc = b.concatenate(c);
		Rope abc = a.concatenate(bc);
		Rope abcd = abc.concatenate(d);
		
		abcd = abcd.balance();
		
		System.out.println(abcd.toString());

	}

}
