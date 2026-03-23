/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ComponentesGrupo5;

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
    Color colorTextoModificado;
    File archivoActual = null;

    public Interfaz() {
        initComponents();
        botonesActivos();
    }

    public void botonesActivos() {
        jtxtFRuta.setEnabled(false);
    }

    //JColorChooser()
    //Crea el selector de color con el color blanco seleccionado por defecto.
    //Cuando no te importa con qué color inicie el selector o si es la primera vez que el usuario lo va a abrir en tu programa.
    //JColorChooser(Color initialColor)
    //Permite que el selector se abra mostrando directamente un color específico que tú elijas.
    //JColorChooser(ColorSelectionModel model)
    //Se emplea cuando quieres compartir el mismo color seleccionado entre varios componentes diferentes al mismo tiempo (si cambias el color en un selector, se cambia automáticamente en otro porque comparten el mismo "modelo").
    public void cambiarColorTexto() {
        colorTextoModificado = JColorChooser.showDialog(this, "Ingresa el color por el cual deseas cambiar", Color.BLUE);
        jtxtTexto.setForeground(colorTextoModificado);
    }

    public void invertirColores() {
        jpnlPrincipal.setBackground(Color.BLACK);
        jtxtTexto.setForeground(Color.WHITE);
    }

    public void cambiarColorPanelPrincipal() {
        Color colorPanelModificado = JColorChooser.showDialog(this, "Escoje un nuevo color para el panel", Color.WHITE);
        jpnlPrincipal.setBackground(colorPanelModificado);
    }

    public void cargarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Abrir mi archivo de texto");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
        fc.setFileFilter(filtro);

        int eleccion = fc.showOpenDialog(this);
        if (eleccion == JFileChooser.APPROVE_OPTION) {
            archivoActual = fc.getSelectedFile();
            String rutaCompletaArchivo = archivoActual.getAbsolutePath();

            jtxtFRuta.setToolTipText(rutaCompletaArchivo);
            jtxtFRuta.setText(rutaCompletaArchivo);

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
        fc.setDialogTitle("Guardar mi archivo modificado");

        // Filtro para que se guarde como .txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Texto", "txt");
        fc.setFileFilter(filtro);

        int eleccion = fc.showSaveDialog(this); // Aquí usamos SAVE

        if (eleccion == JFileChooser.APPROVE_OPTION) {
            File archivoDestino = fc.getSelectedFile();

            // Asegurarnos de que termine en .txt si el usuario no lo escribió
            String ruta = archivoDestino.getAbsolutePath();
            if (!ruta.endsWith(".txt")) {
                archivoDestino = new File(ruta + ".txt");
            }

            // --- AQUÍ ESCRIBIMOS EL CONTENIDO DEL TEXT AREA AL DISCO ---
            try (PrintWriter escritor = new PrintWriter(archivoDestino)) {
                escritor.print(jtxtAArchivo.getText()); // Tomamos todo del JTextArea
                JOptionPane.showMessageDialog(this, "¡Archivo guardado con éxito!");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Error al intentar guardar.");
            }
        }
    }

    public void guardarCambios() {
        if (archivoActual != null) {
            try (PrintWriter escritor = new PrintWriter(archivoActual)) {
                escritor.print(jtxtAArchivo.getText());
                JOptionPane.showMessageDialog(this, "Cambios guardados en: " + archivoActual.getName());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al guardar");
            }
        } else {
            guardarComo();
        }
    }

    //JOptionPane.showMessageDialog(this, "Error al guardar"); muestra un mensaje 
    public void limpiarAreaTexto() {
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de limpiar el área? Perderás los cambios.",
                "Confirmar limpieza",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            jtxtAArchivo.setText("");
        }
    }

    public void cambiarTexto() {
        String textoNuevo = JOptionPane.showInputDialog(this, "Escribe tu nombre", "Identificacion", JOptionPane.INFORMATION_MESSAGE);
        if (textoNuevo != null) {
            jtxtTexto.setText(textoNuevo);
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
        jbtnColorTexto = new javax.swing.JButton();
        jtxtTexto = new javax.swing.JLabel();
        jbtnInvertirColorPanel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbtnCambiarTexto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbtnRuta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtFRuta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAArchivo = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtnColorTexto.setText("Cambiar de color texto");
        jbtnColorTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnColorTextoActionPerformed(evt);
            }
        });

        jtxtTexto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jtxtTexto.setText("CARLITOSSSSS");

        jbtnInvertirColorPanel.setText("Invertir Colores");
        jbtnInvertirColorPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInvertirColorPanelActionPerformed(evt);
            }
        });

        jButton1.setText("Cambiar color Panel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Configura tu Nombre");

        jbtnCambiarTexto.setText("Cambiar Texto");
        jbtnCambiarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCambiarTextoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlPrincipalLayout = new javax.swing.GroupLayout(jpnlPrincipal);
        jpnlPrincipal.setLayout(jpnlPrincipalLayout);
        jpnlPrincipalLayout.setHorizontalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnColorTexto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnInvertirColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jbtnCambiarTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnlPrincipalLayout.setVerticalGroup(
            jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jbtnInvertirColorPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnColorTexto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnCambiarTexto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtnRuta.setText(".......");
        jbtnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRutaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Pulsa el boton y elige una ruta");

        jtxtAArchivo.setColumns(20);
        jtxtAArchivo.setRows(5);
        jScrollPane1.setViewportView(jtxtAArchivo);

        jButton2.setText("Guardar como");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Limpiar Area");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxtFRuta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnRuta)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtFRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jpnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnColorTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnColorTextoActionPerformed
        // TODO add your handling code here:
        cambiarColorTexto();
    }//GEN-LAST:event_jbtnColorTextoActionPerformed

    private void jbtnInvertirColorPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInvertirColorPanelActionPerformed
        // TODO add your handling code here:
        invertirColores();
    }//GEN-LAST:event_jbtnInvertirColorPanelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cambiarColorPanelPrincipal();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRutaActionPerformed
        // TODO add your handling code here:
        cargarArchivo();
    }//GEN-LAST:event_jbtnRutaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        guardarComo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        guardarCambios();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        limpiarAreaTexto();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbtnCambiarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCambiarTextoActionPerformed
        // TODO add your handling code here:
        cambiarTexto();
    }//GEN-LAST:event_jbtnCambiarTextoActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCambiarTexto;
    private javax.swing.JButton jbtnColorTexto;
    private javax.swing.JButton jbtnInvertirColorPanel;
    private javax.swing.JButton jbtnRuta;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JTextArea jtxtAArchivo;
    private javax.swing.JTextField jtxtFRuta;
    private javax.swing.JLabel jtxtTexto;
    // End of variables declaration//GEN-END:variables
}
