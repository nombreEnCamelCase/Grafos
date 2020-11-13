package Pruebas;

public class Dfs extends Generador{
	
	
	
	
	
	
	
	
	
	public Dfs(int nodo, int porcentaje) {
		super(nodo, porcentaje);
		// TODO Auto-generated constructor stub
	}
	
	

	public void dfs(Integer nodoIni) {
		nodosVisitados[nodoIni] = true;
		for (Nodo n : listAdy[nodoIni]) 
			if(!nodosVisitados[n.getNodoAdy()])
				dfs(n.getNodoAdy());
			
	}



	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}
}
