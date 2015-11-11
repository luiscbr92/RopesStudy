package uva.eda;

public class Rope {

	private String subcadena;
	private Rope nodoI;
	private Rope nodoD;
	private int tamaño;
	private int profundidad;

	/**
	 * Crea un nodo de tipo hoja.
	 * @param texto
	 * @param longitud
	 */
	public Rope(String texto, int longitud){
		subcadena = texto;
		tamaño = longitud;
	}
	
	/**
	 * Crea un nodo interno, con referencias a nuevos nodos internos.
	 * @param nodoI
	 * @param nodoD
	 * @param n
	 * @param h
	 */
	public Rope(Rope nodoI, Rope nodoD, int n, int h){
		this.nodoI = nodoI;
		this.nodoD = nodoD;
		tamaño = n;
		profundidad = h;
	}
	
	public String getsubcadena(Rope nodo){
		return subcadena;
	}
	
	public Rope getnodoI(Rope nodo){
		return nodoI;
	}
	
	public Rope getnodoD(Rope nodo){
		return nodoD;
	}
	
	public int gettamaño(Rope nodo){
		return tamaño;
	}
	
	public int getprofundidad(Rope nodo){
		return profundidad;
	}
	
	public Rope concatenar(Rope nodoI, Rope nodoD){
		
		//return new Rope(nodoI, nodoD);
		return nodoI;
	}
	
}
