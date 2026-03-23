/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package grupo5;

import java.awt.Color;
import java.io.File;
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
    private Color colorTextoModificado;
    private Color colorPanelModificado;
    private boolean invertirColores = false;
    File archivoActual = null;
    
    public boolean isInvertirColores() {
        return invertirColores;
    }
    
    public void setInvertirColores(boolean invertirColores) {
        this.invertirColores = invertirColores;
    }
    
    public Color getColorPanelModificado() {
        return colorPanelModificado;
    }
    
    public void setColorPanelModificado(Color colorPanelModificado) {
        this.colorPanelModificado = colorPanelModificado;
    }
    
    public Color getColorTextoModificado() {
        return colorTextoModificado;
    }
    
    public void setColorTextoModificado(Color colorTextoModificado) {
        this.colorTextoModificado = colorTextoModificado;
    }
    
    public Interfaz() {
        initComponents();
    }
    
    public void cambiarColorTexto() {
        setColorTextoModificado(JColorChooser.showDialog(this, "Cambiar color del texto", Color.BLACK));
        jlblTest.setForeground(getColorTextoModificado());
    }
    
    public void cambiarColorPanel() {
        setColorPanelModificado(JColorChooser.showDialog(this, "Cambiar Color del Panel", Color.BLUE));
        jpnlPrincipal.setBackground(getColorPanelModificado());
    }
    
    public void invertirColorPanel() {
        if (isInvertirColores() == false) {
            jlblTest.setForeground(Color.WHITE);
            jpnlPrincipal.setBackground(Color.BLACK);
            setInvertirColores(true);
        } else {
            jlblTest.setForeground(Color.BLACK);
            jpnlPrincipal.setBackground(Color.WHITE);
            setInvertirColores(false);
        }
    }
    
    public void cargarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Abrir archivo de texto");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Solo archivos .txt", "txt");
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo seleccionado");
            }
        }
    }
    
    public void guardarComo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Guardar mi archivo de texto");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Solo archivos .txt", "txt");
        fc.setFileFilter(filtro);
        
        int eleccion = fc.showSaveDialog(this);
        if (eleccion == JFileChooser.APPROVE_OPTION) {
            File archivoDestino = fc.getSelectedFile();
            String rutaCompleta = archivoDestino.getAbsolutePath();
            
            if (rutaCompleta.endsWith(".txt")) {
                archivoDestino = new File(rutaCompleta + ".txt");
            }
            
            try (PrintWriter escritor = new PrintWriter(archivoDestino)) {
                escritor.print(jtxtAArchivo.getText());
                JOptionPane.showMessageDialog(this, "Archivo guardado con exito");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se pudo guardar el archivo");
            }
        }
    }
    
    public void guardar() {
        if (archivoActual != null) {
            try (PrintWriter escritor = new PrintWriter(archivoActual)) {
                escritor.print(jtxtAArchivo.getText());
                JOptionPane.showMessageDialog(this, "Archivo guardado con exito");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se pudo guardar el archivo");
            }
        } else {
            guardarComo();
        }
    }
    
    public void limpiarArea() {
        int respuesta = JOptionPane.showConfirmDialog(this,
                "Estas seguro de limpiar el area de texto",
                "Limpiar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            jtxtAArchivo.setText("");
        }
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
        jbtnCambiarColorTexto = new javax.swing.JButton();
        jbtnCambiarColorPanel = new javax.swing.JButton();
        jbtnInvertirColorPanel = new javax.swing.JButton();
        jpnlSecundario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtFRuta = new javax.swing.JTextField();
        jbtnRuta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAArchivo = new javax.swing.JTextArea();
        jbtnGuardar = new javax.swing.JButton();
        jbtnGuardarComo = new javax.swing.JButton();
        jbtnLipiarArea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlblTest.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlblTest.setText("TEST");

        jbtnCambiarColorTexto.setText("Cambiar color texto");
        jbtnCambiarColorTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCambiarColorTextoActionPerformed(evt);
            }
        });

        jbtnCambiarColorPanel.setText("Cambiar color panel");
        jbtnCambiarColorPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCambiarColorPanelActionPerformed(evt);
            }
        });

        jbtnInvertirColorPanel.setText("Invertir color panel");
        jbtnInvertirColorPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInvertirColorPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlPrincipalLayout = new javax.swing.GroupLayout(jpnlPrincipal);
        jpnlPrincipal.setLayout(jpnlPrincipalLayout);
        jpnlPrincipalLayout.setHorizontalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlPrincipalLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jlblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnCambiarColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jbtnCambiarColorTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnInvertirColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jpnlPrincipalLayout.setVerticalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTest)
                    .addComponent(jbtnInvertirColorPanel))
                .addGap(10, 10, 10)
                .addComponent(jbtnCambiarColorTexto)
                .addGap(18, 18, 18)
                .addComponent(jbtnCambiarColorPanel)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jpnlSecundario.setBackground(new java.awt.Color(255, 255, 255));
        jpnlSecundario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Pulsa el boton y elige una ruta");

        jbtnRuta.setText(".....");
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

        jbtnLipiarArea.setText("Limpiar Area");
        jbtnLipiarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLipiarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlSecundarioLayout = new javax.swing.GroupLayout(jpnlSecundario);
        jpnlSecundario.setLayout(jpnlSecundarioLayout);
        jpnlSecundarioLayout.setHorizontalGroup(
            jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                        .addComponent(jbtnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnGuardarComo))
                    .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                        .addComponent(jtxtFRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnRuta))
                    .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlSecundarioLayout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnLipiarArea))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jpnlSecundarioLayout.setVerticalGroup(
            jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlSecundarioLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbtnLipiarArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtFRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGuardar)
                    .addComponent(jbtnGuardarComo))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jpnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jpnlSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCambiarColorTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCambiarColorTextoActionPerformed
        // TODO add your handling code here:
        cambiarColorTexto();
    }//GEN-LAST:event_jbtnCambiarColorTextoActionPerformed

    private void jbtnCambiarColorPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCambiarColorPanelActionPerformed
        // TODO add your handling code here:
        cambiarColorPanel();
    }//GEN-LAST:event_jbtnCambiarColorPanelActionPerformed

    private void jbtnInvertirColorPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInvertirColorPanelActionPerformed
        // TODO add your handling code here:
        invertirColorPanel();
    }//GEN-LAST:event_jbtnInvertirColorPanelActionPerformed

    private void jbtnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRutaActionPerformed
        // TODO add your handling code here:
        cargarArchivo();
    }//GEN-LAST:event_jbtnRutaActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarComoActionPerformed
        // TODO add your handling code here:
        guardarComo();
    }//GEN-LAST:event_jbtnGuardarComoActionPerformed

    private void jbtnLipiarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLipiarAreaActionPerformed
        // TODO add your handling code here:
        limpiarArea();
    }//GEN-LAST:event_jbtnLipiarAreaActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCambiarColorPanel;
    private javax.swing.JButton jbtnCambiarColorTexto;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnGuardarComo;
    private javax.swing.JButton jbtnInvertirColorPanel;
    private javax.swing.JButton jbtnLipiarArea;
    private javax.swing.JButton jbtnRuta;
    private javax.swing.JLabel jlblTest;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlSecundario;
    private javax.swing.JTextArea jtxtAArchivo;
    private javax.swing.JTextField jtxtFRuta;
    // End of variables declaration//GEN-END:variables
}
