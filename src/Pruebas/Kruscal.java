package Pruebas;

import java.util.PriorityQueue;

public class Kruscal extends Generador {
	Integer [] arbolMin;
	private Integer [] r;
	
	
	public Kruscal(int nodo, int porcentaje) {
		super(nodo, porcentaje);
		r = new Integer[nodo];
		for (int i = 0; i < nodo; i++) {
			r[i] = i;
		}
		arbolMin = new Integer[nodo];
		// TODO Auto-generated constructor stub
	}

	
	
	public Integer find(Integer nodo) {
		return r[nodo]==nodo?nodo:find(r[nodo]);
	}
	
	public int union(Integer inicial,Integer fin) {
		/**ulitmo*/
		
		Integer a = find(inicial);
		Integer b = find(fin);
		if(a==b)
			return 0;
		r[a] = b;
		if(arbolMin[inicial] == null)
			arbolMin[inicial] = fin;
		if(arbolMin[fin] == null)
			arbolMin[fin] = inicial;
		return 1;
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void solucion() {
		
		PriorityQueue<Grafos> colaP = new PriorityQueue<Grafos>();
		int i=0;
		
		for (int j = 0; j < cantNodos; j++) {
			for (Nodo n : listAdy[j]) {
				colaP.add( new Grafos(j,n.getNodoAdy(),n.getCosto()) );
				System.out.println(j+"  "+ n.getNodoAdy()+"  "+n.getCosto());
			}
		}
		while(!colaP.isEmpty() && i!=cantNodos-1) {
			Grafos g = colaP.poll();
			i+=union(g.getNodoInicial(),g.getNodoFinal());
				
		}
	}
	
	public void mostarArbolMin() {
		System.out.println("\n\nAristas:\n\n");
		for (int i = 0 ; i<arbolMin.length; i++) {
			System.out.println("["+i+","+arbolMin[i]+"]");
		}
	}
	
	
}
