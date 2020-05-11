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
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author win7
 */
public class Ventana1 extends JFrame {
	private static JTextField textField;
	private static JFrame v;
	private static JPanel panel;
	private static JButton btnNewButton;
    
	static boolean visible = true;
    public Ventana1() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(100, 100, 1000, 600);
    	v = new JFrame();
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 59);
		v.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 202, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Graficar");
		btnNewButton.setBounds(222, 11, 202, 37);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    	
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        visible = true;
        repaint();
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Ventana1 v = new Ventana1();
        int p = 0;
        Lienzo objLienzo = new Lienzo();
       // JFrame ventana = new JFrame();
        Arbol objArbol = new Arbol(); 
        while(p==0) {
        	System.out.println("1.Ingresar");
        	System.out.println("2.Elimiar");
        	String s;
        	sc = new Scanner(System.in);
        	int a=0;
        	boolean si = false;
        	while(si==false) {
        		try {
        			sc = new Scanner(System.in);
            		a = sc.nextInt();	
            		if (a==1 || a==2) {
            			si = true;
            		}else {
            			System.out.println("Dato incorrecto el numero debe ser 1 o 2");
            		}
            	}catch(Exception e) {
            		System.out.println("Dato incorrecto debe ser 1 o 2");
            	}
        	}
        	
        	
        	if(a==1) {
        		System.out.println("ingrese los numeros separados por ','");
        		sc = new Scanner(System.in);
            	s= sc.nextLine();
            	try {
                	String listNum[] = s.split(",");
                	for(int i =0;i<listNum.length;i++){
                        objArbol.insertar(Integer.parseInt(listNum[i]));
                    }  
                	objLienzo.setObjArbol(objArbol);
                	v.getContentPane().add(objLienzo);
                    v.setDefaultCloseOperation(3);
                    v.setSize(1000, 600);
                    v.setVisible(true);
                    v.setLocationRelativeTo(null);
                    System.out.println("Inorden");
                    objArbol.inorden(objArbol.getRaiz());
                    System.out.println();
                    System.out.println("Posorden");
                    objArbol.posorden(objArbol.getRaiz());
                    System.out.println();
                    System.out.println("Preorden");
                    objArbol.preorden(objArbol.getRaiz());
                    System.out.println();
                    System.out.println("Por niveles");
                    objArbol.imprimirPorNiveles(objArbol.getRaiz());
                    System.out.println();

                }catch(Exception e){
                	System.out.println("Datos de ingreso no validos");
                }
        	}else if(a==2) {
        		sc = new Scanner(System.in);
        		System.out.println("ingrese los numeros a eliminar separados por ','");
            	s = sc.nextLine();
            	try {
                	String listNum[] = s.split(",");
                	for(int i =0;i<listNum.length;i++){
                       objArbol.eliminar(Integer.parseInt(listNum[i]));
                		//objArbol.eliminar(0);
                    }  
                	objLienzo.setObjArbol(objArbol);
                	v.getContentPane().add(objLienzo);
                    v.setDefaultCloseOperation(3);
                    v.setSize(1000, 600);
                    v.setVisible(true);
                    v.setLocationRelativeTo(null);
                    System.out.println("Inorden");
                    objArbol.inorden(objArbol.getRaiz());
                    System.out.println();
                    System.out.println("Posorden");
                    objArbol.posorden(objArbol.getRaiz());
                    System.out.println();
                    System.out.println("Preorden");
                    objArbol.preorden(objArbol.getRaiz());
                    System.out.println();
                    System.out.println("Por niveles");
                    objArbol.imprimirPorNiveles(objArbol.getRaiz());
                    System.out.println();
                }catch(Exception e){
                	System.out.println("Datos de ingreso no validos");
                }
        	}else {
        		System.out.println("Dato incorrecto");
        	}
        }
        
    }
}
//90,38,40,80,73,25,30,84,100,20,88,79,85,70,89,110,87,120,95,130,140,128,97,99
