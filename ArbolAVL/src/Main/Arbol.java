package Main;
import java.util.ArrayList;

import Main.Nodo;

public class Arbol {
	private Nodo raiz;
	public void insertar(float clave) {
		raiz = insertar(clave,raiz);
	}
	private Nodo insertar(float clave, Nodo nuevo) {
		if(nuevo == null) {
			nuevo = new Nodo(clave,null,null);
		} else if (clave < nuevo.clave) {
			nuevo.izq = insertar(clave,nuevo.izq);
			if(altura(nuevo.izq) - altura(nuevo.der) == 2) {
				if (clave < nuevo.izq.clave) {
					nuevo = rotarizq(nuevo);
				}else {
					nuevo = doblerotarizq(nuevo);
				}
			}
		} else if( clave > nuevo.clave) {
			nuevo.der = insertar(clave,nuevo.der);
			if(altura (nuevo.der)-altura(nuevo.izq) == 2) {
				if (clave > nuevo.der.clave) {
					nuevo = rotarder(nuevo);
				}else {
					nuevo = doblerotarder(nuevo);
				}
			}
				
		} else {
			System.out.println("Ya se encuentra el valor : "+clave);
		}
		nuevo.altura = Math.max(altura(nuevo.izq),altura(nuevo.der))+1;
		
		return nuevo;
	
	}
	
	private Nodo rotarizq( Nodo k2 ){
    	Nodo k1 = k2.izq;
        k2.izq = k1.der;
        k1.der = k2;
        k2.altura = Math.max( altura(k2.izq), altura(k2.der)) + 1;
        k1.altura = Math.max( altura( k1.izq ), k2.altura ) + 1;
        return k1;
    }
	private Nodo rotarder( Nodo k1 ){
    	Nodo k2 = k1.der;
        k1.der = k2.izq;
        k2.izq = k1;
        k1.altura = Math.max( altura(k1.izq), altura(k1.der) ) + 1;
        k2.altura = Math.max( altura( k2.der ), k1.altura ) + 1;
        return k2;
    }
	private Nodo doblerotarizq( Nodo k3 ){
        k3.izq = rotarder( k3.izq );
        return rotarizq( k3 );
    }
	private Nodo doblerotarder( Nodo k1 ){
        k1.der = rotarizq( k1.der );
        return rotarder( k1 );
    }

	private int altura( Nodo t ){
		if (t==null) {
			return -1;
		} else {
			return t.altura;
		}
    }
	
	private int calcularAltura(Nodo actual ){
	       if (actual == null)
	            return -1;
	       else
	            return 1 + Math.max(calcularAltura(actual.izq), calcularAltura(actual.der));
	}
	
	public Nodo retornarraiz(){
        return raiz;
    }

	public void imprimirPorNiveles(Nodo nodo){
        int max = 0;
        int nivel = calcularAltura(raiz);

        for ( ; nivel >= 0; nivel--)
            max += Math.pow(2, nivel);
        max++;

        Nodo arreglo[] = new Nodo[ max ];

        arreglo[1] = nodo;
        int x = 1;
        for (int i = 2; i < max; i += 2, x++){
            if (arreglo[x] == null){
            	arreglo[i] = null;
            	arreglo[i + 1] = null;
            }
            else{
            	arreglo[i]   = arreglo[x].izq;
            	arreglo[i + 1] = arreglo[x].der;
            }
        }
        nivel = 0;

        for (int i = 1; i < max; i++){
            if(i == Math.pow(2, nivel)){
            	System.out.print("\n Nivel " + (nivel) + ": ");
                nivel++;
            }
            if( arreglo[i] != null ){
            	calbal(arreglo[i]);
                System.out.print("[" + arreglo[i].clave +" : " + arreglo[i].bal + "]");

            }
        }
    }
	public void calbal(Nodo t) {
		t.bal  = altura(t.der) - altura(t.izq);
	}

}
    

