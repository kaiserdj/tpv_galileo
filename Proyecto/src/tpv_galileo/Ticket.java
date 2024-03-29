/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpv_galileo;

import com.itextpdf.text.DocumentException;
import java.awt.Container;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonfe
 */
public class Ticket extends javax.swing.JFrame {

    private Container Terminal = null;
    private Factura Factura = null;
    private int numFactura = 0;

    /**
     * Creates new form Ticket
     */
    public Ticket() {
        initComponents();
    }

    public Ticket(Container Terminal, Factura Factura, int numFactura) {
        initComponents();
        this.numFactura = numFactura;
        this.Terminal = Terminal;
        Terminal.setEnabled(false);
        Txt_user.setText(Login.User);
        Txt_NumTicket.setText(Integer.toString(numFactura));
        ArrayList<String[]> PrecioTotal = Conexion.leerTabla(Login.conexion, "SELECT sum(round((PRODUCTOS.Precio+((PRODUCTOS.Precio*PRODUCTOS.Iva)/100))*DET_FACTURAS.Cantidad,2)) AS Res_iva FROM `DET_FACTURAS`,PRODUCTOS WHERE DET_FACTURAS.Id_Producto=PRODUCTOS.Id and Id_Factura=" + numFactura);
        DecimalFormat formato = new DecimalFormat("#.00");
        Txt_Total.setText(String.valueOf(formato.format(Double.parseDouble(PrecioTotal.get(1)[0]))));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        Txt_user = new javax.swing.JTextField();
        Txt_Total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Txt_NumTicket = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Btn_ImprimirFactura = new javax.swing.JButton();
        Btn_Cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.POPUP);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Usuario: ");

        Txt_user.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_user.setEnabled(false);
        Txt_user.setFocusable(false);

        Txt_Total.setEditable(false);
        Txt_Total.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        Txt_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("NºTicket: ");

        Txt_NumTicket.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Txt_NumTicket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_NumTicket.setEnabled(false);
        Txt_NumTicket.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL:");

        Btn_ImprimirFactura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_ImprimirFactura.setText("Imprimir Factura");
        Btn_ImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ImprimirFacturaActionPerformed(evt);
            }
        });

        Btn_Cerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Cerrar.setText("Cerrar");
        Btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_NumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_ImprimirFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txt_Total)
                            .addComponent(Btn_Cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Txt_NumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_ImprimirFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CerrarActionPerformed
        Terminal.setVisible(false);
        Terminal main = new Terminal();
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Btn_CerrarActionPerformed

    private void Btn_ImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ImprimirFacturaActionPerformed
        try {
            Factura.generarPDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_ImprimirFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cerrar;
    private javax.swing.JButton Btn_ImprimirFactura;
    public static javax.swing.JTextField Txt_NumTicket;
    private javax.swing.JTextField Txt_Total;
    private static javax.swing.JTextField Txt_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
