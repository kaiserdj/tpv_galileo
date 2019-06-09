package tpv_galileo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gonfe
 */
public class Terminal extends javax.swing.JFrame {

    private static Factura factura = null;

    private static void Inicio() {
        factura = new Factura();
        Txt_user.setText(Login.User);
        Carga_Codigo();
        Carga_categorias();
        Tbl_Factura.setModel(factura.getTbl_factura());
    }

    private static void Carga_Codigo() {
        ArrayList<String[]> productos = Conexion.leerTabla(Login.conexion, "Select * from PRODUCTOS");
        ArrayList<Producto> codigos = new ArrayList<Producto>();
        DefaultTableModel CodigosTabla = new DefaultTableModel();
        CodigosTabla.addColumn("Codigo");
        CodigosTabla.addColumn("Producto");

        for (int i = 1; i < productos.size(); i++) {
            CodigosTabla.addRow(new Object[]{productos.get(i)[0], productos.get(i)[1]});
            codigos.add(new Producto(productos.get(i)));
        }

        Terminal.Tbl_CodigosProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = Terminal.Tbl_CodigosProductos.rowAtPoint(evt.getPoint());
                factura.añadirProducto(codigos.get(row));
            }
        });
        Tbl_CodigosProductos.setDefaultEditor(Object.class, null);
        Tbl_CodigosProductos.setModel(CodigosTabla);
        Terminal.Tbl_CodigosProductos.getColumnModel().getColumn(0).setPreferredWidth(1);
    }

    private static void Carga_categorias() {
        ArrayList<String[]> categorias = Conexion.leerTabla(Login.conexion, "Select * from CATEGORIAS");
        int position_x = 0;

        for (int i = 1; i < categorias.size(); i++) {
            Categoria categoria = new Categoria(categorias.get(i));

            JButton boton = new JButton(categoria.getNombre());
            boton.setName("btn" + categoria.getNombre());
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Carga_productos(categoria.getId());
                }
            });
            boton.setBounds(position_x, 0, 100, 100);
            boton.setText("");
            boton.setVisible(true);
            boton.setIcon(Utilidades.UrlIcon(categoria.getImagen(), 90, 90));
            Categorias.add(boton);

            JLabel nombre = new JLabel(categoria.getNombre());
            nombre.setText(categoria.getNombre());
            nombre.setBounds(position_x, 100, 100, 15);
            nombre.setVisible(true);
            nombre.setHorizontalAlignment(SwingConstants.CENTER);
            nombre.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    Carga_productos(categoria.getId());
                }
            });
            Categorias.add(nombre);

            position_x = position_x + 100;
        }
        Categorias.setPreferredSize(new Dimension(position_x, 100));
        Categorias.updateUI();
    }

    private static void Carga_productos(int puntero_categoria) {
        ArrayList<String[]> productos = Conexion.leerTabla(Login.conexion, "select * from PRODUCTOS where Id_Categoria=" + puntero_categoria);
        int position_x = 0;
        int position_y = 0;
        int total_position_x = 115;

        Productos.removeAll();
        for (int i = 1; i < productos.size(); i++) {
            Producto producto = new Producto(productos.get(i));
            JButton boton = new JButton(producto.getNombre());
            boton.setName("btn" + producto.getNombre());
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    factura.añadirProducto(producto);
                }
            });
            boton.setBounds(position_x, position_y, 100, 100);
            boton.setText("");
            boton.setVisible(true);
            boton.setIcon(Utilidades.UrlIcon(producto.getImagen(), 90, 90));
            Productos.add(boton);

            JLabel nombre = new JLabel(producto.getNombre());
            nombre.setText(producto.getNombre());
            nombre.setBounds(position_x, position_y + 100, 100, 15);
            nombre.setVisible(true);
            nombre.setHorizontalAlignment(SwingConstants.CENTER);
            nombre.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    factura.añadirProducto(producto);
                }
            });
            Productos.add(nombre);

            if (position_x < 300) {
                position_x = position_x + 100;
            } else {
                position_x = 0;
                position_y = position_y + 115;
                total_position_x = total_position_x + 115;
            }
        }
        Productos.setPreferredSize(new Dimension(400, total_position_x));
        Productos.updateUI();
    }

    /**
     * Creates new form Terminal
     */
    public Terminal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Categorias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Productos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_CodigosProductos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        Txf_Codigo = new javax.swing.JTextField();
        Btn_añadirCodigo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Factura = new javax.swing.JTable();
        TxfTotal = new javax.swing.JTextField();
        TxtTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Txt_user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Txt_NumTicket = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Txt_ToalIva = new javax.swing.JTextField();
        Btn_TerminarFactura = new javax.swing.JButton();
        Btn_CancelarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Terminal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Categorias.setBackground(new java.awt.Color(204, 204, 255));
        Categorias.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout CategoriasLayout = new javax.swing.GroupLayout(Categorias);
        Categorias.setLayout(CategoriasLayout);
        CategoriasLayout.setHorizontalGroup(
            CategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        CategoriasLayout.setVerticalGroup(
            CategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(Categorias);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 420, 140));

        jScrollPane2.setToolTipText("");

        Productos.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout ProductosLayout = new javax.swing.GroupLayout(Productos);
        Productos.setLayout(ProductosLayout);
        ProductosLayout.setHorizontalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        ProductosLayout.setVerticalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(Productos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 420, 320));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("PRODUCTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CATEGORIAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        jTabbedPane1.addTab("Productos", jPanel1);

        Tbl_CodigosProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(Tbl_CodigosProductos);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Id Producto");

        Txf_Codigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Btn_añadirCodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Btn_añadirCodigo.setText("Añadir");
        Btn_añadirCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_añadirCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(Txf_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_añadirCodigo)
                        .addGap(48, 48, 48))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txf_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(Btn_añadirCodigo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Codigo producto", jPanel2);

        Tbl_Factura.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Tbl_Factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tbl_Factura);

        TxfTotal.setEditable(false);
        TxfTotal.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TxfTotal.setFocusable(false);

        TxtTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TxtTotal.setText("Total: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Usuario: ");

        Txt_user.setEditable(false);
        Txt_user.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Txt_user.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("NºTicket: ");

        Txt_NumTicket.setEditable(false);
        Txt_NumTicket.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Txt_NumTicket.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Total con Iva:");

        Txt_ToalIva.setEditable(false);
        Txt_ToalIva.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Txt_ToalIva.setFocusable(false);

        Btn_TerminarFactura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Btn_TerminarFactura.setText("Terminar Factura");
        Btn_TerminarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_TerminarFacturaActionPerformed(evt);
            }
        });

        Btn_CancelarFactura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Btn_CancelarFactura.setText("Cancelar Factura");
        Btn_CancelarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CancelarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Txt_NumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TxtTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Txt_ToalIva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Btn_CancelarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_TerminarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Txt_NumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTotal)
                            .addComponent(TxfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(Txt_ToalIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_TerminarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_CancelarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Inicio();
    }//GEN-LAST:event_formWindowOpened

    private void Btn_CancelarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CancelarFacturaActionPerformed
        factura.cancelarFactura();
    }//GEN-LAST:event_Btn_CancelarFacturaActionPerformed

    private void Btn_TerminarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_TerminarFacturaActionPerformed
        Container parent = this;
        factura.TerminarFactura(parent);
    }//GEN-LAST:event_Btn_TerminarFacturaActionPerformed

    private void Btn_añadirCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_añadirCodigoActionPerformed
        ArrayList<String[]> productos = Conexion.leerTabla(Login.conexion, "Select * from PRODUCTOS");
        int check=0;
        for(int i=1;i<productos.size();i++){
            if(productos.get(i)[0].equals(Txf_Codigo.getText())){
                factura.añadirProducto(new Producto(productos.get(i)));
                check=1;
            }            
        }
        if(check==0){
            JOptionPane.showMessageDialog(null, "Error: Ese codigo de producto no esta en la base de datos", "Error codigo de producto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Btn_añadirCodigoActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Terminal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_CancelarFactura;
    private javax.swing.JButton Btn_TerminarFactura;
    private javax.swing.JButton Btn_añadirCodigo;
    public static javax.swing.JPanel Categorias;
    private static javax.swing.JPanel Productos;
    private static javax.swing.JTable Tbl_CodigosProductos;
    public static javax.swing.JTable Tbl_Factura;
    public static javax.swing.JTextField TxfTotal;
    private static javax.swing.JTextField Txf_Codigo;
    private javax.swing.JLabel TxtTotal;
    public static javax.swing.JTextField Txt_NumTicket;
    public static javax.swing.JTextField Txt_ToalIva;
    private static javax.swing.JTextField Txt_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
