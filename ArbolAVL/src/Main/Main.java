package Main;

public class Main {

	public static void main(String[] args) {

        Arbol nuevo = new Arbol();
        nuevo.insertar(90);
        nuevo.insertar(38);
        nuevo.insertar(40);
        nuevo.insertar(80);
        nuevo.insertar(73);
        nuevo.insertar(25);
        nuevo.insertar(30);
        nuevo.insertar(84);
        nuevo.insertar(100);
        nuevo.insertar(20);
        nuevo.insertar(88);
        nuevo.insertar(79);
        nuevo.insertar(85);
        nuevo.insertar(70);
        nuevo.insertar(89);
        nuevo.insertar(110);
        nuevo.insertar(87);
        nuevo.insertar(120);
        nuevo.insertar(95);
        nuevo.insertar(130);
        nuevo.insertar(140);
        nuevo.insertar(128);
        nuevo.insertar(97);
        nuevo.insertar(99);

        /*
        nuevo.insertar(100);
        nuevo.insertar(90);
        nuevo.insertar(110);
        nuevo.insertar(80);
        nuevo.insertar(91);
        nuevo.insertar(120);
        nuevo.insertar(60);
        nuevo.insertar(81);
        nuevo.insertar(82);
*/
        
        nuevo.imprimirPorNiveles(nuevo.retornarraiz());

	}

}

