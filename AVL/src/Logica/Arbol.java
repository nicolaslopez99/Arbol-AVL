/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
/**
 * @author win7
 */

public class Arbol<T> {
    private Nodo raiz;
    Nodo padre = null;
    public void insertar(int clave) {
		raiz = insertar(clave,raiz);
	}
	private Nodo insertar(int clave, Nodo nuevo) {
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
	public void eliminar(int clave) {
		raiz = eliminar(clave,raiz);
	}
	private Nodo eliminar(int clave, Nodo nuevo) {
		
		if(nuevo == null) {
			System.out.println("No se encontro el valor: "+clave);
			return null;
		} else if (clave < nuevo.clave) {
			padre = nuevo;
			nuevo.izq = eliminar(clave,nuevo.izq);
			if(-altura(nuevo.izq) + altura(nuevo.der) >= 2) {
				if (altura(nuevo.der.izq)-altura(nuevo.der.der)<=0) {
					nuevo = rotarder(nuevo);
				}else {
					nuevo = doblerotarder(nuevo);					
				}
			}
			nuevo.altura = Math.max(altura(nuevo.izq),altura(nuevo.der))+1;
			return nuevo;
		} else if( clave > nuevo.clave) {
			padre = nuevo;
			nuevo.der = eliminar(clave,nuevo.der);			
			if(-altura (nuevo.der) + altura(nuevo.izq) >= 2) {
				if (-altura(nuevo.izq.izq)+altura(nuevo.izq.der)<=0) {
					nuevo = rotarizq(nuevo);
				}else {
					nuevo = doblerotarizq(nuevo);
				}
			}
			nuevo.altura = Math.max(altura(nuevo.izq),altura(nuevo.der))+1;
			return nuevo;	
		} else {
			System.out.println("Se encontro el valor: "+nuevo.clave);
			Nodo r = eliminarnodo(nuevo);
			
			try {
				if(altura(r.izq) - altura(r.der) >= 2 ){
					if (altura(r.izq.izq) - altura(r.izq.der)>=0) {
						r = rotarizq(r);
					}else {
						r = doblerotarizq(r);
					}
				}else if(altura(r.der)-altura(r.izq)>=2) {
					if (altura(r.der.der)- altura(r.der.izq)>=0) {
						r = rotarder(r);
					}else {
						r = doblerotarder(r);
					}
				}
			}catch(Exception e) {
			}
			
			return r;	
		}
		

	}
	public Nodo eliminarnodo(Nodo elim) {
		Nodo p = buscarp(elim.clave);
		if (elim.izq == null && elim.der == null) {
			if (p.clave == elim.clave) {
				raiz = null;
			}else {
				if (elim.clave < p.clave) {
					p.izq = null;
				}else {
					p.der = null;
				}
			}
			return null;
		} else if(elim.der == null) {
			return elim.izq;
		} else {
			Nodo aux = elim;
			
			aux = aux.der;
			Nodo aux1 = aux;
			while(aux1!=null) {
				aux = aux1;
				aux1 = aux1.izq;
			}
			Nodo paux = buscarp(aux.clave);
			if (paux.clave == elim.clave) {
				if (p.clave == elim.clave) {
					aux.izq = raiz.izq;
				}else {
					aux.izq = elim.izq;
				}
				return aux;
			}else {
				if(p.clave == elim.clave) {
					paux.izq = aux.der;
					aux.izq = raiz.izq;
					aux.der = raiz.der;
				}else {
					paux.izq = aux.der;
					aux.izq = elim.izq;
					aux.der = elim.der;
				}
				return aux;
			}
		}
	}
	
	public Nodo buscarp(int clave) {
		Nodo a = raiz;
		Nodo p= raiz;
		while(a.clave!= clave) {
			p = a;
			if (a.clave<clave) {
				a= a.der;
			}else if(a.clave>clave) {
				a = a.izq;
			}
		}
		return p;
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
	            return 0;
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
	public float calbal(Nodo t) {
		t.bal  = altura(t.der) - altura(t.izq);
        return t.bal;
	}
        
    
    public Nodo getRaiz() {
        return raiz;
    }
    public void inorden(Nodo p) {
    	if(p != null) {
    		inorden(p.izq);
    		System.out.print(p.clave+" ");
    		inorden(p.der);
    	}
    }
  
    public void preorden(Nodo p) {
    	if(p != null) {
    		System.out.print(p.clave+" ");
    		inorden(p.izq);
    		inorden(p.der);
    	}
    }
    public void posorden(Nodo p) {
    	if(p != null) {
    		inorden(p.izq);
    		inorden(p.der);
    		System.out.print(p.clave+" ");
    	}
    }
}
