package uva.eda;

public class cvaca {

	public static void main(String[] args) {
		long tpo1, tpo2, tpo3, tpo4;
		int huella;
		System.out.println("PRUEBA CON STRING");
		tpo1 = System.currentTimeMillis();
		String cad = "";
		for (int i = 1; i < 30000; i++) {
			cad += "Este es un ejemplo de lo que puede ser una cadena de texto, en este caso estamos hablando de la linea numero "
					+ i;
		}
		tpo2 = System.currentTimeMillis();
		huella = 0;

		for (int i = 0; i < cad.length(); i++) {
			huella = huella * 23 + cad.charAt(i);
		}
		tpo3 = System.currentTimeMillis();
		System.out.println("Concatenar: " + (tpo2 - tpo1) + " mseg.");
		System.out.println("Recorrer: " + (tpo3 - tpo2) + " mseg.");
		System.out.println("Huella = " + huella);
		System.out.println();

		System.out.println("PRUEBA CON ROPES");
		tpo1 = System.currentTimeMillis();
		Rope rop = new Rope("");
		for (int i = 1; i < 30000; i++) {
			rop = rop.concatenate(new Rope(
					"Este es un ejemplo de lo que puede ser una cadena de texto, en este caso estamos hablando de la linea numero "
							+ i));
		}
		tpo2 = System.currentTimeMillis();
		rop = rop.balance();
		tpo3 = System.currentTimeMillis();
		huella = 0;
		for (int i = 0; i < rop.length(); i++) {
			huella = huella * 23 + rop.getChar(i);
		}
		tpo4 = System.currentTimeMillis();
		System.out.println("Concatenar: " + (tpo2 - tpo1) + " mseg.");
		System.out.println("Balancear: " + (tpo3 - tpo2) + " mseg.");
		System.out.println("Recorrer: " + (tpo4 - tpo3) + " mseg.");
		System.out.println("Huella = " + huella);
	}

}
