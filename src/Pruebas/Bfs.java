package Pruebas;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs extends Generador{
	
	
	
	
	
	
	
	
	
	public Bfs(int nodo, int porcentaje) {
		super(nodo, porcentaje);
		// TODO Auto-generated constructor stub
	}

	public void bfs(Matriz m,int nodoIni) {
		nodosVisitados[nodoIni] = true;
		Queue<Integer> cola = new LinkedList<Integer>();
		cola.add(nodoIni);
		while(cola.isEmpty()) {
			Integer nodoAct = cola.poll();
			for(Integer nodoAdy: m.listAdy[nodoAct]) {
				if(!nodosVisitados[nodoAdy]) {
					nodosVisitados[nodoAdy] = true;
					cola.add(nodoAdy);
				}
			}
				
		}
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}
	
	

}
