/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;


/**
 * @author win7
 */
public final class Lienzo extends JPanel {
   
    private Arbol objArbol;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;
    private JLabel datos, bal1, bal2;
    private JTextArea numeros;
    
   
    
    public void setObjArbol(Arbol objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 150, objArbol.getRaiz());
    }
    
    private void pintar(Graphics g, int x, int y, Nodo n) {
        if (n == null)
        {}
        else {            
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
            g.setColor(Color.BLACK);
            if(objArbol.calbal(n)== -1){
            g.setColor(Color.RED);}
            if(objArbol.calbal(n)== 1){
            g.setColor(Color.BLUE);}
            g.fillOval(x, y, DIAMETRO, DIAMETRO);
            g.setColor(Color.white);          
            g.drawString(Integer.toString(n.getClave()), x + 10, y + 18);
            g.setColor(Color.black);
            if (n.getIzq() != null)
                g.drawLine(x  , y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);
            if (n.getDer()!= null)
                g.drawLine(x + 2*RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            pintar(g, x - ANCHO - EXTRA,  y + ANCHO, n.getIzq());
            pintar(g, x + ANCHO + EXTRA,  y + ANCHO, n.getDer());
                        
        }
    }

    void add(Arbol objArbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void setPanelProperties(){
        this.setBackground(Color.GRAY);
        this.setBounds(100, 20, 1000, 600);
        this.setVisible(true);
    }
    
    
}
