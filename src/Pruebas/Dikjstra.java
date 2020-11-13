package Pruebas;

import java.util.PriorityQueue;
import java.util.TreeSet;


public class Dikjstra extends Generador{
	private Integer [] distancia;//dijkstra
	private Integer [] camino;//dijkstra
	int nodo;
	
	public Dikjstra(int nodo, int porcentaje) {
		super(nodo, porcentaje);
		distancia = new Integer[nodo];
		camino = new Integer[nodo];
		for (int i=0; i<nodo ; i++) {
			distancia [i] = INFINITO;
			camino [i] = -1;
		}
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}
	
	public void solucion(int nodo) {
		PriorityQueue<Nodo> colaP = new PriorityQueue<Nodo>();
		colaP.add(new Nodo(nodo,0));
		distancia[nodo]=0;
		while(!colaP.isEmpty()) {
			Integer nodoAct = colaP.poll().getNodoAdy();
			if(!nodosVisitados[nodoAct]) {
				nodosVisitados[nodoAct] = true;
				for(Nodo n: listAdy[nodoAct]) {
					Integer costo = n.getCosto();
					Integer nodoAdy  = n.getNodoAdy(); 
					if(!nodosVisitados[n.getNodoAdy()] && distancia[nodoAct]+costo<distancia[nodoAdy]) {
						distancia[nodoAdy] = distancia[nodoAct]+costo;
						camino[nodoAdy] = nodoAct;
						colaP.add(new Nodo(nodoAdy,distancia[nodoAdy]));
					}
				}
			}
		}
		this.nodo = nodo;
	}
	
	public void mostrarCaminoYDistancia() {
		System.out.println("\n\ndistancia :");
		for (int i = 0; i < cantNodos; i++) {
			System.out.println("de el nodo "+nodo+" al nodo "+i+"  distancia  :" + distancia[i]);
		}
		System.out.println("\n\ncamino :");
		for (int i = 0; i < cantNodos; i++) {
			System.out.println("["+i+","+camino[i]+"]");
		}
	}
	
	
}
