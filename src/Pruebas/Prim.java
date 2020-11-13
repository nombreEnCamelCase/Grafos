package Pruebas;

import java.util.PriorityQueue;

public class Prim extends Generador{
	private Integer [] arbolMin;
	
	public Prim(int nodo, int porcentaje) {
		super(nodo, porcentaje);
		// TODO Auto-generated constructor stub
		arbolMin = new Integer [nodo];
	}



	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}
	
	public  void solucion(int nodo) {
//		nodosVisitados [nodo] = true;
		PriorityQueue<Grafos> colaP= new PriorityQueue<Grafos>();
		colaP.add(new Grafos(-1,nodo,0));
		while(!colaP.isEmpty()) {
			Grafos g = colaP.poll();
			Integer nodoAct = g.getNodoFinal();
			if(!nodosVisitados[nodoAct]) {
				nodosVisitados[nodoAct] = true;
				arbolMin[nodoAct] = g.getNodoInicial();
				for (Nodo nodoAdy : listAdy[nodoAct]) 
					if(!nodosVisitados[nodoAdy.getNodoAdy()]) 
						colaP.add(new Grafos(nodoAct,nodoAdy.getNodoAdy(),nodoAdy.getCosto()));
			}
		}
	}
	
	public void mostarArbolMin() {
		System.out.println("\n\nAristas:\n\n");
		for (int i = 0 ; i<arbolMin.length; i++) {
			System.out.println("["+i+","+arbolMin[i]+"]");
		}
	}
	
	
}
