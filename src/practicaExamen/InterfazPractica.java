/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practicaExamen;

import ComponentesGrupo1.MiException;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo LOQ
 */
public class InterfazPractica extends javax.swing.JFrame {

    /**
     * Creates new form InterfazPractica
     */
    DefaultComboBoxModel comboBox;
    DefaultListModel lista = new DefaultListModel();
    DefaultListModel listaVRAM = new DefaultListModel();
    DefaultTableModel tabla;
    DefaultTableModel tablaComputadora;
    int resultadoSuma;
    int mesesDiferidos;

    public int getMesesDiferidos() {
        return mesesDiferidos;
    }

    public void setMesesDiferidos(int mesesDiferidos) {
        this.mesesDiferidos = mesesDiferidos;
    }

    public int getResultadoSuma() {
        return resultadoSuma;
    }

    public void setResultadoSuma(int resultado) {
        this.resultadoSuma = resultado;
    }

    public InterfazPractica() {
        initComponents();
        cargarLista();
        cargarColumnas();
        cargarComboBoxModelo();
        cargarListaVRAM();
        diferir();
        cargarColumnasComputadora();
        devolverDatosTablaComputadora();
    }

    //APARTADO 2 COMPONENTES GRUPO3
    public void cargarComboBoxModelo() {
        String[] valoresComboBox = {"ASUS", "LENOVO", "DELL", "MSI"};
        comboBox = new DefaultComboBoxModel(valoresComboBox);
        jcbxModelo.setModel(comboBox);
    }

    public void cargarListaVRAM() {
        String[] valoresListaVRAM = {"2GB", "4GB", "6GB", "8GB"};

        for (String valor : valoresListaVRAM) {
            listaVRAM.addElement(valor);
        }
        jlstVRAM.setModel(listaVRAM);
    }

    public void diferir() {
        if (jtBtnDiferir.isSelected()) {
            jtBtnDiferir.setText("ON");
            jtBtnDiferir.setBackground(Color.GREEN);
            jscrBMeses.setEnabled(true);
            setMesesDiferidos(jscrBMeses.getValue());

        } else {
            jtBtnDiferir.setText("OF");
            jtBtnDiferir.setBackground(Color.RED);
            jscrBMeses.setEnabled(false);
        }
    }

    public void cargarColumnasComputadora() {
        String[] columnas = {"Almacenamiento", "Modelo", "Regalo", "Meses Diferidos", "VRAM", "Estado TGL"};
        tablaComputadora = new DefaultTableModel(null, columnas);
        jtblComputadora.setModel(tablaComputadora);
    }

    public String regalosElegidos() {
        String regalos = "";
        if (jchbxMouse.isSelected()) {
            regalos += "Mouse ";
        }
        if (jchbxAuriculares.isSelected()) {
            regalos += "Audifonos";
        }
        if (jchbxTeclado.isSelected()) {
            regalos += "Teclado ";
        }
        return regalos;
    }

    public String tomarAlmacenamiento() {
        String almacenamiento = jrBtn1TB.isSelected() ? jrBtn1TB.getText() : jrBtn512GB.isSelected() ? jrBtn512GB.getText() : jrBtn256GB.isSelected() ? jrBtn256GB.getText() : "Campo no seleccionado";
        return almacenamiento;
    }

    public void cargarFilasComputadora() {
        String[] filas = new String[6];
        filas[0] = tomarAlmacenamiento();
        filas[1] = String.valueOf(jcbxModelo.getSelectedItem());
        filas[2] = regalosElegidos();
        filas[3] = String.valueOf(getMesesDiferidos());
        filas[4] = jlstVRAM.getSelectedValue();
        filas[5] = jtBtnDiferir.getText();
        tablaComputadora.addRow(filas);
    }

    public void devolverDatosTablaComputadora() {
        jtblComputadora.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtblComputadora.getSelectedRow() != -1) {
                    int fila = jtblComputadora.getSelectedRow();

                    //Devolver RadioButon
                    String almacenamiento = jtblComputadora.getValueAt(fila, 0).toString();
                    jrBtn256GB.setSelected(almacenamiento.equals("256 GB"));
                    jrBtn512GB.setSelected(almacenamiento.equals("512 GB"));
                    jrBtn1TB.setSelected(almacenamiento.equals("1 TB"));

                    // Devolver ComboBox
                    String modeloComputadora = jtblComputadora.getValueAt(fila, 1).toString();
                    jcbxModelo.setSelectedItem(modeloComputadora);

                    // Devolver CheckBox
                    String regalo = jtblComputadora.getValueAt(fila, 2).toString();
                    jchbxAuriculares.setSelected(regalo.contains("Audifonos"));
                    jchbxMouse.setSelected(regalo.contains("Mouse"));
                    jchbxTeclado.setSelected(regalo.contains("Teclado"));
                    
                    //Devolver Scroll Bar y ToggleButton
                    int meses = Integer.valueOf(jtblComputadora.getValueAt(fila, 3).toString());
                    jscrBMeses.setValue(meses);
                    jtBtnDiferir.setSelected(meses > 0);
                    diferir();
                    
                    //Devolver JList
                    String vram = jtblComputadora.getValueAt(fila, 4).toString();
                    jlstVRAM.setSelectedValue(vram, true);

                }
            }
        });
    }

    //APARTADO 1 COMPONENTES GRUPO 4
    public void cargarLista() {
        String[] valoresLista = {"Suma", "Resta", "Multiplicacion", "Division"};

        for (String valor : valoresLista) {
            lista.addElement(valor);
        }
        jlistPrincipal.setModel(lista);
    }

    public void cargarColumnas() {
        String[] columnas = {"Numero 1", "Numero 2", "Resultado", "Operacion"};
        tabla = new DefaultTableModel(null, columnas);
        jtblPrincipal.setModel(tabla);

    }

    public void cargarFilas() {
        String[] filas = new String[4];
        filas[0] = jtxtFNumero1.getText();
        filas[1] = jtxtFNumero2.getText();
        filas[2] = jtxtFResultado.getText();
        filas[3] = jlistPrincipal.getSelectedValue();
        tabla.addRow(filas);
    }

    public void suma(int numero1, int numero2) throws MiException {
        setResultadoSuma(numero1 + numero2);
        jtxtFResultado.setText(String.valueOf(getResultadoSuma()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAlmacenamiento = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenuItem();
        jtxtFNumero1 = new javax.swing.JTextField();
        jtxtFNumero2 = new javax.swing.JTextField();
        jtxtFResultado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistPrincipal = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblPrincipal = new javax.swing.JTable();
        jtxtFIndice = new javax.swing.JTextField();
        jbtnIndice = new javax.swing.JButton();
        jbtnSuma = new javax.swing.JButton();
        jrBtn256GB = new javax.swing.JRadioButton();
        jrBtn512GB = new javax.swing.JRadioButton();
        jrBtn1TB = new javax.swing.JRadioButton();
        jcbxModelo = new javax.swing.JComboBox<>();
        jchbxMouse = new javax.swing.JCheckBox();
        jchbxTeclado = new javax.swing.JCheckBox();
        jchbxAuriculares = new javax.swing.JCheckBox();
        jscrBMeses = new javax.swing.JScrollBar();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlstVRAM = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblComputadora = new javax.swing.JTable();
        jtBtnDiferir = new javax.swing.JToggleButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        Eliminar.setText("Eliminar Producto");
        jPopupMenu1.add(Eliminar);

        Editar.setText("Editar Producto");
        jPopupMenu1.add(Editar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtxtFNumero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFNumero1ActionPerformed(evt);
            }
        });

        jtxtFResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFResultadoActionPerformed(evt);
            }
        });

        jlistPrincipal.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlistPrincipal);

        jtblPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtblPrincipal);

        jbtnIndice.setText("Buscar Indice");

        jbtnSuma.setText("Sumar");
        jbtnSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSumaActionPerformed(evt);
            }
        });

        btnGroupAlmacenamiento.add(jrBtn256GB);
        jrBtn256GB.setText("256 GB");

        btnGroupAlmacenamiento.add(jrBtn512GB);
        jrBtn512GB.setText("512 GB");
        jrBtn512GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrBtn512GBActionPerformed(evt);
            }
        });

        btnGroupAlmacenamiento.add(jrBtn1TB);
        jrBtn1TB.setText("1 TB");

        jcbxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jchbxMouse.setText("Mouse");

        jchbxTeclado.setText("Teclado");

        jchbxAuriculares.setText("Auriculares");

        jscrBMeses.setBackground(new java.awt.Color(204, 204, 255));
        jscrBMeses.setBlockIncrement(3);
        jscrBMeses.setMaximum(13);
        jscrBMeses.setMinimum(3);
        jscrBMeses.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        jscrBMeses.setUnitIncrement(3);
        jscrBMeses.setVisibleAmount(3);

        jButton2.setText("Comprar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jlstVRAM.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jlstVRAM);

        jtblComputadora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblComputadora.setComponentPopupMenu(jPopupMenu1);
        jScrollPane5.setViewportView(jtblComputadora);

        jtBtnDiferir.setText("Diferir");
        jtBtnDiferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBtnDiferirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtxtFNumero1)
                        .addComponent(jtxtFNumero2)
                        .addComponent(jtxtFResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtFIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnIndice))
                    .addComponent(jbtnSuma)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jrBtn256GB, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jrBtn512GB, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jrBtn1TB, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jchbxMouse)
                                            .addComponent(jchbxTeclado)
                                            .addComponent(jchbxAuriculares)))
                                    .addComponent(jButton2))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jscrBMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtBtnDiferir))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtFNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtFNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtFResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtFIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnIndice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSuma)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jscrBMeses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jrBtn256GB)
                                                .addComponent(jcbxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jchbxMouse)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jrBtn512GB)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jrBtn1TB))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jchbxTeclado)
                                                    .addComponent(jtBtnDiferir))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jchbxAuriculares)))
                                        .addGap(36, 36, 36)
                                        .addComponent(jButton2)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtFNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtFNumero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtFNumero1ActionPerformed

    private void jtxtFResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtFResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtFResultadoActionPerformed

    private void jbtnSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSumaActionPerformed
        // TODO add your handling code here:
        String texto1 = jtxtFNumero1.getText();
        String texto2 = jtxtFNumero2.getText();
        if (texto1.isEmpty() || texto2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo vacio");
            return;
        }
        try {
            int numero1 = Integer.valueOf(texto1);
            int numero2 = Integer.valueOf(texto2);
            suma(numero1, numero2);
            cargarFilas();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Solo numeros");
        } catch (MiException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jbtnSumaActionPerformed

    private void jtBtnDiferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBtnDiferirActionPerformed
        // TODO add your handling code here:
        diferir();
    }//GEN-LAST:event_jtBtnDiferirActionPerformed

    private void jrBtn512GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrBtn512GBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrBtn512GBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cargarFilasComputadora();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazPractica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPractica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPractica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPractica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPractica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.ButtonGroup btnGroupAlmacenamiento;
    private javax.swing.JButton jButton2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnIndice;
    private javax.swing.JButton jbtnSuma;
    private javax.swing.JComboBox<String> jcbxModelo;
    private javax.swing.JCheckBox jchbxAuriculares;
    private javax.swing.JCheckBox jchbxMouse;
    private javax.swing.JCheckBox jchbxTeclado;
    private javax.swing.JList<String> jlistPrincipal;
    private javax.swing.JList<String> jlstVRAM;
    private javax.swing.JRadioButton jrBtn1TB;
    private javax.swing.JRadioButton jrBtn256GB;
    private javax.swing.JRadioButton jrBtn512GB;
    private javax.swing.JScrollBar jscrBMeses;
    private javax.swing.JToggleButton jtBtnDiferir;
    private javax.swing.JTable jtblComputadora;
    private javax.swing.JTable jtblPrincipal;
    private javax.swing.JTextField jtxtFIndice;
    private javax.swing.JTextField jtxtFNumero1;
    private javax.swing.JTextField jtxtFNumero2;
    private javax.swing.JTextField jtxtFResultado;
    // End of variables declaration//GEN-END:variables
}
