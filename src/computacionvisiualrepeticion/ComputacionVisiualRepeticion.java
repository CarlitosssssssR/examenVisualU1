/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package computacionvisiualrepeticion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo LOQ
 */
public class ComputacionVisiualRepeticion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame ventana = new JFrame();
        ventana.setVisible(true);
        ventana.setSize(500, 400);
        ventana.setTitle("Computacion Visual");
        ventana.setLayout(null);
        
        JTextField texto = new JTextField();
        ventana.add(texto);
        texto.setVisible(true);
        texto.setBounds(10,10,250,45);
        texto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            JOptionPane.showMessageDialog(ventana,texto.getText());
            }
        });
        
        JButton boton = new JButton();
        ventana.add(boton);
        boton.setVisible(true);
        boton.setBounds(10,70,100,35);
        boton.setText("Aceptar");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Hola mundo");
                JOptionPane.showMessageDialog(ventana, texto.getText());
            }
        });
    }
    
}
