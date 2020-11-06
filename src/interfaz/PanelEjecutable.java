/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import hojas.NumeracionLineas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisGonzalez
 */
public class PanelEjecutable extends javax.swing.JPanel {

    private NumeracionLineas numeracion;
    private String direccion;
    private String nombre;

    /**
     * Creates new form PanelEjecutable
     */
    public PanelEjecutable(String direccion, String nombre) {
        initComponents();
        this.direccion = direccion;
        this.nombre = nombre;
        mostrarContenido();
        numeracion = new NumeracionLineas(txtCodigo);
        jScrollPane1.setRowHeaderView(numeracion);
        String[] cmd2 = {"g++", "-o", nombre, direccion};
        try {
            Runtime.getRuntime().exec(cmd2);
        } catch (IOException ex) {
            Logger.getLogger(PanelEjecutable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarContenido() {
        File archivo = new File(direccion);
        FileReader reader = null;
        BufferedReader buffer = null;
        String texto = "";
        try {
            reader = new FileReader(archivo.toString());
            buffer = new BufferedReader(reader);
            while (buffer.ready()) {
                texto += buffer.readLine() + "\n";
            }
            txtCodigo.setText(texto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelEjecutable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelEjecutable.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextArea();
        btnEjecutar = new javax.swing.JButton();

        txtCodigo.setColumns(20);
        txtCodigo.setRows(5);
        jScrollPane1.setViewportView(txtCodigo);

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEjecutar)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        try {
            String[] cmd3 = {"xterm", "./" + nombre};
            Runtime.getRuntime().exec(cmd3);
        } catch (IOException ex) {
            Logger.getLogger(PanelEjecutable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEjecutarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtCodigo;
    // End of variables declaration//GEN-END:variables
}