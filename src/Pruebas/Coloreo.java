package Pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Coloreo extends Generador{
	static final int MATULA = 0;
	static final int WELSHPOWELL = 1;
	static final int VORAZ = 2;
	private int [] color;//coloreo
	private int cantColoresUsados;
	
	public Coloreo(int nodo, int porcentaje) {
		super(nodo, porcentaje);
		color = new int[nodo];
		// TODO Auto-generated constructor stub
	}

	public void solucion(Integer[] secuencia) {
		
		
		for (Integer nodoAct : secuencia) {
			color[nodoAct] = algoritmo(nodoAct);
		}
		
	}
	
	
	public void solucion(int algorit) {
		Integer [] secuencia = null;
		switch(algorit) {
			case MATULA:
				secuencia = matula();
			break;
			
			case WELSHPOWELL:
				secuencia = welshPowell();
			break;
			
			case VORAZ:
				secuencia = voraz();
			break;
			
			default:
				return;
		}
		solucion(secuencia);
	}
	
	private Integer[] voraz() {
		Integer [] voraz = new Integer[cantNodos];
		for(int i=0;i<cantNodos;i++)
			voraz[i] = i;
		return voraz;
	}

	private Integer[] welshPowell() {
		Integer [] welshPowell = new Integer[cantNodos];
		Nodo [] ordenarPorGrado = new Nodo[cantNodos];
		for(int i=0;i<cantNodos;i++)
			ordenarPorGrado[i] = new Nodo(listAdy[i].size(),i);////reutilizo lo que ya tenia para no perder el grado y el nodo
		
		Arrays.sort(ordenarPorGrado,Collections.reverseOrder());///ordeno de mayor a menor por grado, 
		
		for(int i=0;i<cantNodos;i++)
			welshPowell [i] = ordenarPorGrado[i].getCosto();///aunque dice costo realmente en este caso obtengo el nodo
		return welshPowell;
	}

	private Integer[] matula() {
		
		List<Grafos> list = new ArrayList<Grafos>();
		boolean [] nodosVisitados = new boolean[cantNodos];
		Integer [] matula = new Integer[cantNodos];
		int j=0;
		for (int i = 0; i < cantNodos; i++) {
			for (Nodo g : listAdy[i]) 
				list.add(new Grafos(i,g.getNodoAdy(),g.getCosto()));
			if(listAdy[i].size() == 0)
				list.add(new Grafos(i,i,0));
		}

		Collections.sort(list, Collections.reverseOrder());
		
		for (Grafos g : list) {

			if(!nodosVisitados[g.getNodoInicial()]) {
				nodosVisitados[g.getNodoInicial()] = true;
				matula[j++] = g.getNodoInicial();
			}
				
			if(!nodosVisitados[g.getNodoFinal()]) {
				nodosVisitados[g.getNodoFinal()] = true;
				matula[j++] = g.getNodoFinal();
			}
				
		}
		
		for (int i = 0; i < matula.length; i++) {
			
		}
		list.clear();
		return matula;
	}

	public int algoritmo(Integer nodoAct) {
		Set<Integer> coloresOrdenados = new TreeSet<Integer>();
		int menor = 0;
		int cantColores=0;
		int j=1;
		
		
		for (Nodo n : listAdy[nodoAct]) {
			Integer nodoAdy = n.getNodoAdy();
			if(color[nodoAdy] != 0) {
				coloresOrdenados.add(color[nodoAdy]);
			}
		}
		
		cantColores = coloresOrdenados.size();
		
		for (Integer color : coloresOrdenados) {
			if(color != j) {///note que si tengo 1,2 y tengo el 3 o mas colores usados  a menor nose le asigna nada
				menor = j;////1,3,4  me quedo con 2.......1,2,3,7,8,9 me quedo con 4////cada numero representa un color distinto
				break;
			}
			j++;
		}	
		
		///resuelve el problema  de 1,2 y tengo 3 o mas colores usados, para este caso lo tendria que pintar del colores 3
		///resulve el caso cuando el nodoAct no tiene adyacente pintados y hay colores usados
		if(j<=cantColoresUsados || menor == 0)
			menor = j;
		System.out.println(menor);
		///resuelve el caso cuando tengo 1,2,3 y tengo la 3 colores usados, tengo que agregar otro color. otro caso es cuando tengo nada en Lista y no tengo colores usados 
		menor = cantColores == cantColoresUsados ?++cantColoresUsados:menor;
		
		return menor;
	}
	
	public void mostrarColores() {
		for(int i=1;i<=cantColoresUsados;i++) {
			System.out.print("color numDeColor: "+i+"  nodos Con ese color: ");
			for (int nodo=0 ; nodo<color.length;nodo++) 
				if(i==color[nodo]) 
					System.out.print(" "+nodo);
			System.out.println("");
			
		}
	}
	
	
	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}

	

	
}
