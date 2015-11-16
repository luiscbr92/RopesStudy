package uva.eda;

public class test {

	public static void main(String[] args) {
		Rope a = new Rope("Juanito me");
		Rope b = new Rope(" quiere pegar");
		
		Rope c = a.concatenateLeft(b);
		c.getChar(5);

	}

}
