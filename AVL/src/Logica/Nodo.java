/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author win7
 */

public class Nodo {

    public int clave;
    public int altura;
    public Nodo izq;
    public Nodo der;
    public int bal;
        
      
    public Nodo(int clave, Nodo izq, Nodo der ){
        this.clave = clave;
        this.izq = izq;
        this.der = der;
        altura   = 0; 
        bal = 0;
    }
          
    public int nodosCompletos(Nodo n) {
        if (n == null)
            return 0;
        else {
            if (n.izq != null && n.der != null)
                return nodosCompletos(n.izq) + nodosCompletos(n.der) + 1;
            return nodosCompletos(n.izq) + nodosCompletos(n.der);
        }
    }
    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
    
}
