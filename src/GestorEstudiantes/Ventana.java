/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GestorEstudiantes;

import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author braya
 */
public class Ventana extends javax.swing.JFrame {

    private List<Estudiante> listaEstudiantes = new ArrayList<>();

    private DefaultTableModel tableModel;
    private DefaultListModel listModel;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        initPopupTable();
        initList();
        tableModel = (DefaultTableModel) tablaEstudiantes.getModel();
    }

    public void initList() {
        listModel = new DefaultListModel<>();
        Carrera carrera1 = new Carrera();
        Carrera carrera2 = new Carrera();
        Carrera carrera3 = new Carrera();
        carrera1.setNombre("MEDICINA");
        carrera2.setNombre("CONTABILIDAD");
        carrera3.setNombre("COMUNICACIÓN");

        jListCarreras.setModel(listModel);

        listModel.addElement(carrera1);
        listModel.addElement(carrera2);
        listModel.addElement(carrera3);
    }

    private void agregarRegistro() {
        Estudiante estudiante;
        try {
            estudiante = new Estudiante();
        } catch (Exception e) {
            return;
        }
        Carrera carreraSeleccionada = jListCarreras.getSelectedValue();
        estudiante.setNombre(jTxtNombre.getText());
        estudiante.setCedula(jTxtCedula.getText());
        estudiante.setCarrera(carreraSeleccionada);

        if (estudiante.getNombre().isEmpty() || estudiante.getCedula().isEmpty() || estudiante.getCarrera() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Estudiante e : listaEstudiantes) {
            if (e.getCedula().equals(estudiante.getCedula())) {
                JOptionPane.showMessageDialog(this, "Ya existe un estudiante con esa cédula.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Agregar datos a la tabla
        int contadorRegistro = (tablaEstudiantes.getRowCount()) + 1;
        Object[] fila = {contadorRegistro++, estudiante.getNombre(), estudiante.getCedula(), estudiante.getCarrera()};
        tableModel.addRow(fila);

        listaEstudiantes.add(estudiante);
        carreraSeleccionada.getEstudiantes().add(estudiante);
        carreraSeleccionada.setCantEdudiantes(carreraSeleccionada.getCantEdudiantes() + 1);

        // Limpiar campos
        jTxtNombre.setText("");
        jTxtCedula.setText("");
        jListCarreras.clearSelection();
    }

    public void initPopupTable() {
        tablaEstudiantes.setComponentPopupMenu(jPopupOpciones);
    }

    public void agregarCarrera() {
        String nombreCarrera = JOptionPane.showInputDialog(this, "Ingrese una carrera:");

        if (nombreCarrera != null && !nombreCarrera.trim().isEmpty()) {
            Carrera carrera = new Carrera();
            carrera.setNombre(nombreCarrera.trim());
            listModel.addElement(carrera);
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese los datos de la carrera",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void seleccionarRegistro() {
        int fila = tablaEstudiantes.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para editar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Estudiante estudiante = listaEstudiantes.get(fila);
        jTxtNombre.setText(estudiante.getNombre());
        jTxtCedula.setText(estudiante.getCedula());
        jListCarreras.setSelectedValue(estudiante.getCarrera(), true);
    }

    private void editarRegistro() {
        int fila = tablaEstudiantes.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para editar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = jTxtNombre.getText();
        String cedula = jTxtCedula.getText();
        Carrera carrera = jListCarreras.getSelectedValue();

        if (nombre.isEmpty() || cedula.isEmpty() || carrera == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Estudiante estudiante = listaEstudiantes.get(fila);

        if (!estudiante.getCarrera().equals(carrera)) {
            estudiante.getCarrera().getEstudiantes().remove(estudiante);
            carrera.getEstudiantes().add(estudiante);

            estudiante.getCarrera().setCantEdudiantes(estudiante.getCarrera().getCantEdudiantes() - 1);
            carrera.setCantEdudiantes(carrera.getCantEdudiantes() + 1);
        }

        estudiante.setNombre(nombre);
        estudiante.setCedula(cedula);
        estudiante.setCarrera(carrera);

        tableModel.setValueAt(nombre, fila, 1);
        tableModel.setValueAt(cedula, fila, 2);
        tableModel.setValueAt(carrera, fila, 3);

        jTxtNombre.setText("");
        jTxtCedula.setText("");
        jListCarreras.clearSelection();
    }

    private void eliminarRegistro() {
        int fila = tablaEstudiantes.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para eliminar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar este registro?", "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            Estudiante estudiante = listaEstudiantes.get(fila);
            estudiante.getCarrera().getEstudiantes().remove(estudiante);
            listaEstudiantes.remove(fila);
            tableModel.removeRow(fila);
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

        jPopupOpciones = new javax.swing.JPopupMenu();
        jMiEditar = new javax.swing.JMenuItem();
        jMiEliminar = new javax.swing.JMenuItem();
        jLabelNombre = new javax.swing.JLabel();
        jSrlpRegistros = new javax.swing.JScrollPane();
        tablaEstudiantes = new javax.swing.JTable();
        jTxtNombre = new javax.swing.JTextField();
        jLabelCedula = new javax.swing.JLabel();
        jTxtCedula = new javax.swing.JTextField();
        jLabelCarrera = new javax.swing.JLabel();
        jSrlpCarreras = new javax.swing.JScrollPane();
        jListCarreras = new javax.swing.JList<>();
        jBtnIngresar = new javax.swing.JButton();
        jBtnAñadir = new javax.swing.JButton();

        jPopupOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPopupOpcionesMouseClicked(evt);
            }
        });

        jMiEditar.setText("Editar");
        jMiEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiEditarActionPerformed(evt);
            }
        });
        jPopupOpciones.add(jMiEditar);

        jMiEliminar.setText("Eliminar");
        jMiEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiEliminarActionPerformed(evt);
            }
        });
        jPopupOpciones.add(jMiEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNombre.setText("Ingrese el nombre");

        tablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estudiante", "Cédula", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEstudiantes.setToolTipText("");
        tablaEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEstudiantesMouseClicked(evt);
            }
        });
        jSrlpRegistros.setViewportView(tablaEstudiantes);

        jLabelCedula.setText("Ingrese la cédula");

        jTxtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCedulaActionPerformed(evt);
            }
        });

        jLabelCarrera.setText("Seleccione una carrera");

        jSrlpCarreras.setViewportView(jListCarreras);

        jBtnIngresar.setText("Ingresar");
        jBtnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnIngresarMouseClicked(evt);
            }
        });
        jBtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIngresarActionPerformed(evt);
            }
        });

        jBtnAñadir.setText("Añadir Carrera");
        jBtnAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAñadirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNombre)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jBtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnAñadir))
                        .addComponent(jTxtCedula)
                        .addComponent(jTxtNombre)
                        .addComponent(jSrlpCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelCarrera)
                                .addComponent(jLabelCedula))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSrlpRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNombre)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCarrera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSrlpCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSrlpRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnIngresar)
                    .addComponent(jBtnAñadir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnIngresarMouseClicked
        agregarRegistro();
    }//GEN-LAST:event_jBtnIngresarMouseClicked

    private void jPopupOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupOpcionesMouseClicked

    }//GEN-LAST:event_jPopupOpcionesMouseClicked

    private void tablaEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEstudiantesMouseClicked
        seleccionarRegistro();
    }//GEN-LAST:event_tablaEstudiantesMouseClicked

    private void jBtnAñadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAñadirMouseClicked
        agregarCarrera();
    }//GEN-LAST:event_jBtnAñadirMouseClicked

    private void jMiEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiEditarActionPerformed
        editarRegistro();
    }//GEN-LAST:event_jMiEditarActionPerformed

    private void jMiEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiEliminarActionPerformed
        eliminarRegistro();
    }//GEN-LAST:event_jMiEliminarActionPerformed

    private void jTxtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCedulaActionPerformed

    private void jBtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAñadir;
    private javax.swing.JButton jBtnIngresar;
    private javax.swing.JLabel jLabelCarrera;
    private javax.swing.JLabel jLabelCedula;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JList<Carrera> jListCarreras;
    private javax.swing.JMenuItem jMiEditar;
    private javax.swing.JMenuItem jMiEliminar;
    private javax.swing.JPopupMenu jPopupOpciones;
    private javax.swing.JScrollPane jSrlpCarreras;
    private javax.swing.JScrollPane jSrlpRegistros;
    private javax.swing.JTextField jTxtCedula;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTable tablaEstudiantes;
    // End of variables declaration//GEN-END:variables
}
