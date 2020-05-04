package Main;
import java.util.ArrayList;

public class Arbol {
	private Nodo raiz;
	public void insertar(float clave) {
		raiz = insertar(clave,raiz);
	}
	private Nodo insertar(float clave, Nodo nuevo) {
		if(nuevo == null) {
			nuevo = new Nodo(clave,null,null);
		} else if (clave > nuevo.clave) {
			nuevo.izq = insertar(clave,nuevo.izq);
			if(altura(nuevo.izq) - altura(nuevo.der) == 2) {
				if (clave > nuevo.izq.clave) {
					nuevo = rotarizq(nuevo);
				}else {
					nuevo = doblerotarizq(nuevo);
				}
			}
		} else if( clave < nuevo.clave) {
			nuevo.der = insertar(clave,nuevo.der);
			if(altura (nuevo.der)-altura(nuevo.izq) == 2) {
				if (clave < nuevo.der.clave) {
					nuevo = rotarder(nuevo);
				}else {
					nuevo = doblerotarder(nuevo);
				}
			}
				
		} else
			;
		nuevo.altura = max(altura(nuevo.izq),altura(nuevo.der))+1;
		return nuevo;
	
	}
	private static int max( int lhs, int rhs ){
        return lhs > rhs ? lhs : rhs;
    }
	private Nodo rotarizq( Nodo k2 ){
    	Nodo k1 = k2.izq;
        k2.izq = k1.der;
        k1.der = k2;
        k2.altura = max( altura(k2.izq), altura(k2.der)) + 1;
        k1.altura = max( altura( k1.izq ), k2.altura ) + 1;
        return k1;
    }
	private Nodo rotarder( Nodo k1 ){
    	Nodo k2 = k1.der;
        k1.der = k2.izq;
        k2.izq = k1;
        k1.altura = max( altura(k1.izq), altura(k1.der) ) + 1;
        k2.altura = max( altura( k2.der ), k1.altura ) + 1;
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
        return t == null ? -1 : t.altura;
    }
	public void imprimir(){
        imprimir(raiz);
    }
	private void imprimir(Nodo nodo){
        if ( nodo != null ){
            imprimir(nodo.der);
            System.out.println("["+ nodo.clave + "]");
            imprimir(nodo.izq);
        }
    }
	public void imprimirXaltura(){
        imprimirXaltura (raiz);
    }
	private void imprimirXaltura(Nodo nodo){
        if ( nodo != null ){
            imprimirXaltura(nodo.der);
            System.out.println( replicate(" ",altura(raiz) - altura(nodo)) +"["+ nodo.clave + "]");
            imprimirXaltura(nodo.izq);
        }
    }
	
	private String replicate (String a, int cnt){
        String x = new String("");

        for ( int i = 0; i < cnt; i++ )
            x = x + a;
        return x;
    }
    
	public int calcularAltura(){
        return calcularAltura(raiz);
    }
	private int calcularAltura(Nodo actual ){
	       if (actual == null)
	            return -1;
	       else
	            return 1 + Math.max(calcularAltura(actual.izq), calcularAltura(actual.der));
	}
	public void imprimirPorNiveles(){
        imprimirPorNiveles(raiz);
    }
	@SuppressWarnings("unchecked")
	private void imprimirPorNiveles(Nodo nodo){
        int max = 0;
        int nivel = calcularAltura();

        for ( ; nivel >= 0; nivel--)
            max += Math.pow(2, nivel);
        max++;

        Nodo cola[] = new Nodo[ max ];

        cola[1] = nodo;
        int x = 1;
        for (int i = 2; i < max; i += 2, x++){
            if (cola[x] == null){
                cola[i] = null;
                cola[i + 1] = null;
            }
            else{
                cola[i]   = cola[x].izq;
                cola[i + 1] = cola[x].der;
            }
        }
        nivel = 0;
        int cont = 0;
        int cantidad = 1;
        int ultimaPosicion = 1;

        for (int i = 1; i < max; i++){
            if(i == Math.pow(2, nivel)){
            	System.out.print("\n Nivel " + (nivel) + ": ");
                nivel++;
            }
            if( cola[i] != null ){
                System.out.print("[" + cola[i].clave + "]");
                cont++;
            }
            if(ultimaPosicion == i  && cantidad == Math.pow(2, --nivel)){
                if(cantidad == 1)
                    System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
                else
                    System.out.print(" Cantidad de nodos: " +  cont);
                cont = 0;
                cantidad *= 2;
                ultimaPosicion += (int)Math.pow(2, ++nivel);
            }
        }
    }
}
    

