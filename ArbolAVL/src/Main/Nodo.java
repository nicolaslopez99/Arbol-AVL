package Main;

public class Nodo {
	public float clave;
	public int altura;
	public Nodo izq;
	public Nodo der;
    public Nodo(float clave){
    	this( clave, null, null );
    }
    public Nodo(float clave, Nodo izq, Nodo der ){
        this.clave = clave;
        this.izq = izq;
        this.der = der;
        altura   = 0;              
    }
}