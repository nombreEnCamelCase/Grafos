package Pruebas;

public class Nodo implements Comparable<Nodo>{
	private Integer nodoAdy;
	private Integer costo;
	
	public Nodo(Integer nAdy,Integer c) {
		nodoAdy = nAdy;
		costo = c;
	}

	public Integer getNodoAdy() {
		return nodoAdy;
	}

	public void setNodoAdy(Integer nodoAdy) {
		this.nodoAdy = nodoAdy;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	@Override
	public int compareTo(Nodo n) {
		return this.getNodoAdy()-n.getNodoAdy();
	}
	
	
	
	
}
