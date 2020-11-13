package Pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public abstract class  Generador  {
	
	

	//Implementaciones para representar los grafos
	 Set<Nodo> [] listAdy;
	 int [][] matAdyacencia;
	 int[] vecAdyacencia;
	
	
	//Datos que ayudan a hacer mas facil el problema
	 boolean [] nodosVisitados;//todos;
	 Integer [] nodo;///secuencia

	 List<List<Integer>> colores = new ArrayList<List<Integer>>();
	
	static final int INFINITO = 800000000;
	
	int cantNodos;
	int porcentaje;
	int gradoMin;
	int gradoMax;
	int cantArista;
	int porcentajeAdyacencia;
	
	public Generador(int nodo, int porcentaje){
		this.cantNodos = nodo;
		this.porcentaje = porcentaje;
		listAdy = new TreeSet[nodo];
		nodosVisitados = new boolean [nodo];
		for (int i=0; i<nodo ; i++) 
			listAdy[i] = new TreeSet<Nodo>();
	}

	public abstract void generar();
	
	
	public void mostrarListAdy() {
		for (int i = 0; i < cantNodos; i++) {
			System.out.print("nodo: "+i+" adyacentes: ");
			for (Nodo n : listAdy[i]) 
					System.out.print(" "+n.getNodoAdy());
			System.out.println("");
		}
	}
	
	public void leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		
		int cantNodos = sc.nextInt();
		int lineas = sc.nextInt();
		int nodoAct,nodoAdy;
		
		for (int i = lineas; i > 0; i--) {
			nodoAct = sc.nextInt();
			while( (nodoAdy = sc.nextInt()) != -1) {
				///para ser simetrico
				listAdy[nodoAct-1].add(new Nodo(-1+nodoAdy,1));
				listAdy[nodoAdy-1].add(new Nodo(-1+nodoAct,1));
			}
			
		}
		sc.close();
		this.cantNodos = cantNodos;
	}
	
	public void leerCosto(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		
		int cantNodos = sc.nextInt();
		int lineas = sc.nextInt();
		int cantDragones = sc.nextInt();
		int principe = sc.nextInt();
		int princesa = sc.nextInt();
		int []ubicacionDeDragones = new int[cantDragones];
		
		for (int i = 0; i < cantDragones; i++) {
			ubicacionDeDragones[i] = sc.nextInt();
		}
		
		for (int i = 0; i < lineas; i++) {
			int nodo = sc.nextInt()-1;
			int nodoAdy = sc.nextInt()-1;
			int costo = sc.nextInt();
			listAdy[nodo].add(new Nodo(nodoAdy,costo));
			listAdy[nodoAdy].add(new Nodo(nodo,costo));
		}
		sc.close();
		this.cantNodos = cantNodos;
	}
}
