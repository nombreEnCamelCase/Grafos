package Pruebas;

import java.util.ArrayList;
import java.util.List;

public class Matriz {
	List<Integer> [] listAdy;
	private int [][] matAdyacencia;
	private int[] vecAdyacencia;
	private int cantNodos;
	private Integer []nodos;
	 Integer [] color;

	public Matriz(int [][] mat, Integer [] nodos,int cantNodos) {
		matAdyacencia = mat;
		this.nodos = nodos;
		this.cantNodos = cantNodos;
		listAdy = new ArrayList[cantNodos];
		color = new Integer[cantNodos];
		for (int i=0;i<color.length;i++) 
			color[i] = -1;
	}
	
	public Matriz(int cantNodos) {
		this.cantNodos = cantNodos;
		vecAdyacencia = new int[(cantNodos-1)*cantNodos/2];
		nodos = new Integer[cantNodos];
	}
	
	public int getCantNodos() {
		return cantNodos;
	}

	public Integer[] getNodos() {
		return nodos;
	}

	public void setNodos(Integer[] nodos) {
		this.nodos = nodos;
	}

	public void setMatriz(int f, int c) {
		vecAdyacencia[getIndice(f, c)] = 1;
	}

	public void setMatriz(int f, int c, int costo) {
		vecAdyacencia[getIndice(f, c)] = costo;
	}

	public int getCosto(int f, int c) {
		return vecAdyacencia[getIndice(f, c)];
	}
 
	public boolean getEnlace(int f, int c) {
		return vecAdyacencia[getIndice(f, c)] != 0;
	}
	
	public void setColor(int pos, int color) {
		this.color[pos] = color;
	}
	
	public int getColor(int pos) {
		return color[pos];
		}
	
	public int getIndice(int f, int c) {
		int aux;
		if (f > c) {
			aux = f;
			f = c;
			c = aux;
		}
		//ecuacion para saber la posicion de mi vector en base a fila y columna
		return f*cantNodos + c - ( f*f + 3*f + 2) / 2;
	}
	
	public Matriz(int n, int v) {
		matAdyacencia = new int [n][];
		for(int i=1;i<n;i++)
			matAdyacencia[i] = new int [i];
	}

	public boolean sonAdyacentes(int f,int c) {
		int aux;
		if (f < c) {
			aux = f;
			f = c;
			c = aux;
		}
		return matAdyacencia[f][c] != 0;
	}
	
	public int getCostoM(int f, int c) {
		int aux;
		if (f < c) {
			aux = f;
			f = c;
			c = aux;
		}
		return matAdyacencia[f][c];
	}
	
	public void mostrar() {
		System.out.println("Matriz");
		for (int[] is : matAdyacencia) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
		
		
		System.out.println("\n\nnodos");
		for(Integer a:this.nodos)
			System.out.print(a + " ");
	}

}
