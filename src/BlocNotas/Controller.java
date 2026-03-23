/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BlocNotas;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Lenovo LOQ
 */
public class Controller {

    public static void nuevaPestaña() {
        HomeView nuevaPestaña = new HomeView();
        nuevaPestaña.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevaPestaña.setVisible(true);
    }

    public static void abrirArchivo(JTextArea area, JFrame parent) {
        JFileChooser fc = new JFileChooser();
        int seleccion = fc.showOpenDialog(parent);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            try (
                    BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                area.read(br, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent, "Error al abrir el archivo.");
            }
        }
    }

    public static void guardarArchivo(JTextArea area, JFrame parent) {
        JFileChooser fc = new JFileChooser();
        int seleccion = fc.showSaveDialog(parent);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            try {
                FileWriter escribir = new FileWriter(archivo);
                escribir.write(area.getText());
                escribir.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(parent, "Error al guardar el archivo");
            }
        }
    }

    public static void cambiarColor(JTextArea area, JFrame parent) {
        Color nuevoColor = JColorChooser.showDialog(parent, "Elige un color", area.getForeground());
        if (nuevoColor != null) {
            area.setForeground(nuevoColor);
        }
    }

    public static void cambiarTamanoLetra(JTextArea area, JFrame parent) {
        int tamanoActual = area.getFont().getSize();
        String tamañoStr = JOptionPane.showInputDialog(parent, "Tamaño de letra:", tamanoActual);
        try {
            int tamano = Integer.parseInt(tamañoStr);
            Font fuente = area.getFont();
            area.setFont(new Font(fuente.getName(), Font.PLAIN, tamano));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "Tamaño Invalido");
        }

    }
    
}
