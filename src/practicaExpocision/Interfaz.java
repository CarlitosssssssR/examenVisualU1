/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practicaExpocision;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Lenovo LOQ
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    Color colorPanelModificado;
    Color colorTextoModificado;
    private boolean coloresInvertidos = false;
    File archivoActual = null;

    public boolean isColoresInvertidos() {
        return coloresInvertidos;
    }

    public void setColoresInvertidos(boolean coloresInvertidos) {
        this.coloresInvertidos = coloresInvertidos;
    }

    public Color getColorPanelModificado() {
        return colorPanelModificado;
    }

    public void setColorPanelModificado(Color colorPanelModificado) {
        this.colorPanelModificado = colorPanelModificado;
    }

    public Color getColorTextoModificado() {
        return colorPanelModificado;
    }

    public void setColorTextoModificado(Color colorTextoModificado) {
        this.colorPanelModificado = colorTextoModificado;
    }

    public Interfaz() {
        initComponents();
    }

    public void cambiarColorPanel() {
        setColorTextoModificado(JColorChooser.showDialog(this, "Ingrese el nuevo color del panel", Color.BLACK));
        jpnlPrincipal.setBackground(getColorTextoModificado());
    }

    public void cambiarColorTexto() {
        setColorTextoModificado(JColorChooser.showDialog(this, "Ingrese el nuevo color del texto", Color.CYAN));
        jlblTest.setForeground(getColorTextoModificado());
    }

    public void invertirColorPanel() {
        if (isColoresInvertidos() == false) {
            jpnlPrincipal.setBackground(Color.BLACK);
            jlblTest.setForeground(Color.WHITE);
            setColoresInvertidos(true);
        } else {
            jpnlPrincipal.setBackground(Color.WHITE);
            jlblTest.setForeground(Color.BLACK);
            setColoresInvertidos(false);
        }
    }

    public void cargarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Abrir archivo de texto");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto plano", "txt");
        fc.setFileFilter(filtro);

        int eleccion = fc.showOpenDialog(this);
        if (eleccion == JFileChooser.APPROVE_OPTION) {
            archivoActual = fc.getSelectedFile();
            String rutaCompletaArchivo = archivoActual.getAbsolutePath();

            jtxtFRuta.setText(rutaCompletaArchivo);
            jtxtFRuta.setToolTipText(rutaCompletaArchivo);

            try (Scanner lector = new Scanner(archivoActual)) {
                jtxtAArchivo.setText("");
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    jtxtAArchivo.append(linea + "\n");
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo");
            }
        }
    }

    public void guardarComo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Guardar mi archivo como");

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de texto", "txt");
        fc.setFileFilter(filtro);

        int eleccion = fc.showSaveDialog(this);

        if (eleccion == JFileChooser.APPROVE_OPTION) {
            File archivoDestino = fc.getSelectedFile();

            String ruta = archivoDestino.getAbsolutePath();
            if (ruta.endsWith(".txt")) {
                archivoDestino = new File(ruta + ".txt");
            }

            try (PrintWriter escritor = new PrintWriter(archivoDestino)) {
                escritor.print(jtxtAArchivo.getText());
                JOptionPane.showMessageDialog(this, "Archivo guardado con exito");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar");
            }
        }
    }

    public void guardar() {
        if (archivoActual != null) {
            try (PrintWriter escritor = new PrintWriter(archivoActual)) {
                escritor.print(jtxtAArchivo.getText());
                JOptionPane.showMessageDialog(this, "Cambios guardados en: " + archivoActual.getName());
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar");
            }
        } else {
            guardarComo();
        }
    }

    public void limpiarArea() {
        int respuesta = JOptionPane.showConfirmDialog(this, 
                "Estas seguro de limpiar el area? Perderas los cambios", 
                "Confirmar Limpieza", 
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            jtxtAArchivo.setText("");
        }
    }
    
    public void cambiarTitulo() {
    jlblTest.setText(JOptionPane.showInputDialog(this, "Escribe un nuevo Titulo", "Titulo", JOptionPane.INFORMATION_MESSAGE));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPrincipal = new javax.swing.JPanel();
        jlblTest = new javax.swing.JLabel();
        jbtnInvertirColor = new javax.swing.JButton();
        jbtnColorPanel = new javax.swing.JButton();
        jbtnColorTexto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbtnCambiarTitulo = new javax.swing.JButton();
        jpnlSecundario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtFRuta = new javax.swing.JTextField();
        jbtnRuta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAArchivo = new javax.swing.JTextArea();
        jbtnGuardar = new javax.swing.JButton();
        jbtnGuardarComo = new javax.swing.JButton();
        jbtnLimpiarArea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlblTest.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlblTest.setText("TEST");

        jbtnInvertirColor.setText("Invertir Colores");
        jbtnInvertirColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInvertirColorActionPerformed(evt);
            }
        });

        jbtnColorPanel.setText("Color Panel");
        jbtnColorPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnColorPanelActionPerformed(evt);
            }
        });

        jbtnColorTexto.setText("Color Texto");
        jbtnColorTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnColorTextoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Configura tu nombre");

        jbtnCambiarTitulo.setText("Cambiar Titulo");
        jbtnCambiarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCambiarTituloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlPrincipalLayout = new javax.swing.GroupLayout(jpnlPrincipal);
        jpnlPrincipal.setLayout(jpnlPrincipalLayout);
        jpnlPrincipalLayout.setHorizontalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlPrincipalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbtnColorTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnInvertirColor, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addComponent(jbtnColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbtnCambiarTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnlPrincipalLayout.setVerticalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jlblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtnInvertirColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnColorPanel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnColorTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnCambiarTitulo)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jpnlSecundario.setBackground(new java.awt.Color(255, 255, 255));
        jpnlSecundario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Pulsa el boton y elige una ruta");

        jbtnRuta.setText("......");
        jbtnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRutaActionPerformed(evt);
            }
        });

        jtxtAArchivo.setColumns(20);
        jtxtAArchivo.setRows(5);
        jScrollPane1.setViewportView(jtxtAArchivo);

        jbtnGuardar.setText("Guardar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnGuardarComo.setText("Guardar Como");
        jbtnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarComoActionPerformed(evt);
            }
        });

        jbtnLimpiarArea.setText("Limpiar Area");
        jbtnLimpiarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimpiarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlSecundarioLayout = new javax.swing.GroupLayout(jpnlSecundario);
        jpnlSecundario.setLayout(jpnlSecundarioLayout);
        jpnlSecundarioLayout.setHorizontalGroup(
            jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnLimpiarArea))
                    .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                        .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                                .addComponent(jtxtFRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnRuta))
                            .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                                .addComponent(jbtnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnGuardarComo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnlSecundarioLayout.setVerticalGroup(
            jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbtnLimpiarArea))
                .addGap(18, 18, 18)
                .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtFRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGuardar)
                    .addComponent(jbtnGuardarComo))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jpnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnColorPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnColorPanelActionPerformed
        // TODO add your handling code here:
        cambiarColorPanel();
    }//GEN-LAST:event_jbtnColorPanelActionPerformed

    private void jbtnColorTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnColorTextoActionPerformed
        // TODO add your handling code here:
        cambiarColorTexto();
    }//GEN-LAST:event_jbtnColorTextoActionPerformed

    private void jbtnInvertirColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInvertirColorActionPerformed
        // TODO add your handling code here:
        invertirColorPanel();
    }//GEN-LAST:event_jbtnInvertirColorActionPerformed

    private void jbtnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRutaActionPerformed
        // TODO add your handling code here:
        cargarArchivo();
    }//GEN-LAST:event_jbtnRutaActionPerformed

    private void jbtnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarComoActionPerformed
        // TODO add your handling code here:
        guardarComo();
    }//GEN-LAST:event_jbtnGuardarComoActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnLimpiarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarAreaActionPerformed
        // TODO add your handling code here:
        limpiarArea();
    }//GEN-LAST:event_jbtnLimpiarAreaActionPerformed

    private void jbtnCambiarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCambiarTituloActionPerformed
        // TODO add your handling code here:
        cambiarTitulo();
    }//GEN-LAST:event_jbtnCambiarTituloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCambiarTitulo;
    private javax.swing.JButton jbtnColorPanel;
    private javax.swing.JButton jbtnColorTexto;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnGuardarComo;
    private javax.swing.JButton jbtnInvertirColor;
    private javax.swing.JButton jbtnLimpiarArea;
    private javax.swing.JButton jbtnRuta;
    private javax.swing.JLabel jlblTest;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlSecundario;
    private javax.swing.JTextArea jtxtAArchivo;
    private javax.swing.JTextField jtxtFRuta;
    // End of variables declaration//GEN-END:variables
}
