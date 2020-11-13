package Pruebas;


public class Grafos implements Comparable<Grafos>{
	private int nodoInicial;
	private int nodoFinal;
	private int costo;
	public Grafos(int inicio,int fin,int c) {
		nodoInicial = inicio;
		nodoFinal = fin;
		costo = c;
	}
	
	@Override
	public String toString() {
		return "Grafos [nodoInicial=" + nodoInicial + ", nodoFinal=" + nodoFinal + ", costo=" + costo + "]";
	}
	@Override
	public int compareTo(Grafos o) {
		// TODO Auto-generated method stub
		return this.costo-o.costo;
	}

	public int getNodoInicial() {
		return nodoInicial;
	}

	public void setNodoInicial(int nodoInicial) {
		this.nodoInicial = nodoInicial;
	}

	public int getNodoFinal() {
		return nodoFinal;
	}

	public void setNodoFinal(int nodoFinal) {
		this.nodoFinal = nodoFinal;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	

	
}
