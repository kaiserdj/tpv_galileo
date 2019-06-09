/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpv_galileo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gonfe
 */
public class Factura {

    DefaultTableModel Tbl_factura = new DefaultTableModel();
    private static int num_factura = 0;
    DecimalFormat formato = new DecimalFormat("#.00");

    public Factura() {
        getTbl_factura();
        numeroFactura();
    }

    public void genTableModel() {
        Tbl_factura = new DefaultTableModel();
        Tbl_factura.addColumn("Id");
        Tbl_factura.addColumn("Producto");
        Tbl_factura.addColumn("Cantidad");
        Tbl_factura.addColumn("Unidad");
        Tbl_factura.addColumn("Precio");
        Tbl_factura.addColumn("Borrar");
        Terminal.Tbl_Factura.setModel(Tbl_factura);
    }

    public void numeroFactura() {
        ArrayList<String[]> Facturas = Conexion.leerTabla(Login.conexion, "Select * from FACTURAS");
        if (Facturas.size() > 1) {
            num_factura = Integer.parseInt(Facturas.get(Facturas.size() - 1)[0]);
            Terminal.Txt_NumTicket.setText(Facturas.get(Facturas.size() - 1)[0]);
            if (Facturas.get(Facturas.size() - 1)[3].equals("1") || Facturas.get(Facturas.size() - 1)[3].equals("-1")) {
                Conexion.ModificarDato(Login.conexion, "INSERT INTO `FACTURAS` (`Id`, `Id_Usuario`, `Fecha`) VALUES (NULL, '" + Login.Id + "', CURRENT_TIMESTAMP);");
                Facturas = Conexion.leerTabla(Login.conexion, "Select * from FACTURAS");
                num_factura = Integer.parseInt(Facturas.get(Facturas.size() - 1)[0]);
                Terminal.Txt_NumTicket.setText(Facturas.get(Facturas.size() - 1)[0]);
            } else {
                ArrayList<String[]> check_detFac = Conexion.leerTabla(Login.conexion, "Select * from DET_FACTURAS where DET_FACTURAS.Id_Factura = " + num_factura);
                if (check_detFac.size() > 1) {
                    System.out.println("Sin terminar");
                    num_factura = Integer.parseInt(Facturas.get(Facturas.size() - 1)[0]);
                    Terminal.Txt_NumTicket.setText(Facturas.get(Facturas.size() - 1)[0]);
                    RegFactura();
                } else {
                    System.out.println("Factura vacia");
                }
            }
        } else {
            Conexion.ModificarDato(Login.conexion, "INSERT INTO `FACTURAS` (`Id`, `Id_Usuario`, `Fecha`) VALUES (1, '" + Login.Id + "', CURRENT_TIMESTAMP);");
            num_factura = 1;
            Terminal.Txt_NumTicket.setText("1");
        }
    }

    /*IVA
            SELECT DET_FACTURAS.Id_Factura, DET_FACTURAS.Id_Producto, DET_FACTURAS.Cantidad, PRODUCTOS.Precio, PRODUCTOS.Iva, round((PRODUCTOS.Precio+((PRODUCTOS.Precio*PRODUCTOS.Iva)/100))*DET_FACTURAS.Cantidad,2) AS Res_iva FROM `DET_FACTURAS`,PRODUCTOS WHERE DET_FACTURAS.Id_Producto=PRODUCTOS.Id
     */
    public static double precioTotal() {
        ArrayList<String[]> check = Conexion.leerTabla(Login.conexion, "select DET_FACTURAS.Id_Producto from DET_FACTURAS,PRODUCTOS where Id_Producto=PRODUCTOS.Id and Id_Factura=" + num_factura);
        ArrayList<String[]> PrecioTotal = Conexion.leerTabla(Login.conexion, "select sum(round(Cantidad*PRODUCTOS.Precio,2)) from DET_FACTURAS,PRODUCTOS where Id_Producto=PRODUCTOS.Id and Id_Factura=" + num_factura);
        if (check.size() <= 1) {
            double a = 0.00;
            return a;
        } else {
            return Double.parseDouble(PrecioTotal.get(1)[0]);
        }
    }

    public static double precioTotalIva() {
        ArrayList<String[]> check = Conexion.leerTabla(Login.conexion, "select DET_FACTURAS.Id_Producto from DET_FACTURAS,PRODUCTOS where Id_Producto=PRODUCTOS.Id and Id_Factura=" + num_factura);
        ArrayList<String[]> PrecioTotal = Conexion.leerTabla(Login.conexion, "SELECT sum(round((PRODUCTOS.Precio+((PRODUCTOS.Precio*PRODUCTOS.Iva)/100))*DET_FACTURAS.Cantidad,2)) AS Res_iva FROM `DET_FACTURAS`,PRODUCTOS WHERE DET_FACTURAS.Id_Producto=PRODUCTOS.Id and Id_Factura=" + num_factura);
        if (check.size() <= 1) {
            double a = 0.00;
            return a;
        } else {
            return Double.parseDouble(PrecioTotal.get(1)[0]);
        }
    }

    public void RegFactura() {
        genTableModel();
        ArrayList<String[]> Factura = Conexion.leerTabla(Login.conexion, "Select DET_FACTURAS.Id_Producto, DET_FACTURAS.Cantidad, PRODUCTOS.Nombre, PRODUCTOS.Precio, PRODUCTOS.Iva, DET_FACTURAS.Id  from DET_FACTURAS,PRODUCTOS WHERE Id_Producto=PRODUCTOS.Id and DET_FACTURAS.Id_Factura = " + num_factura);
        ArrayList<String[]> IdBD = new ArrayList<String[]>();
        for (int i = 1; i < Factura.size(); i++) {
            String[] str_pro = Factura.get(i);
            Producto producto = new Producto(str_pro, Integer.parseInt(str_pro[1]));
            ImageIcon Btn_borrar = Utilidades.UrlIcon("https://i.imgur.com/7oPuGO4.png", 20, 20);
            Terminal.Tbl_Factura.setDefaultEditor(Object.class, null);
            Tbl_factura.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCantidad(), formato.format(producto.getUnidad()), formato.format(producto.getPrecio()), Btn_borrar});
            Tbl_factura.setValueAt(Btn_borrar, (i - 1), 5);
            IdBD.add(new String[]{producto.getIdBD(), producto.getNombre()});
        }
        MouseListener[] mls = Terminal.Tbl_Factura.getMouseListeners();
        if (mls != null) {
            for (MouseListener ml : mls) {
                Terminal.Tbl_Factura.removeMouseListener(ml);
            }
        }
        Terminal.Tbl_Factura.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int check = 0;
                int row = Terminal.Tbl_Factura.rowAtPoint(evt.getPoint());
                int col = Terminal.Tbl_Factura.columnAtPoint(evt.getPoint());
                if (col == 5) {
                    if (check == 0) {
                        eliminarProducto(IdBD.get(row));
                        check++;
                    }
                }
                if (col == 2) {
                    cambiarCantidadProducto(IdBD.get(row));
                }
            }
        });
        Terminal.Tbl_Factura.setModel(Tbl_factura);
        Terminal.Tbl_Factura.getColumnModel().getColumn(5).setCellRenderer(Terminal.Tbl_Factura.getDefaultRenderer(ImageIcon.class));
        Terminal.Tbl_Factura.getColumnModel().getColumn(0).setPreferredWidth(1);
        Terminal.Tbl_Factura.getColumnModel().getColumn(1).setPreferredWidth(200);
        Terminal.Tbl_Factura.getColumnModel().getColumn(2).setPreferredWidth(13);
        Terminal.Tbl_Factura.getColumnModel().getColumn(3).setPreferredWidth(13);
        Terminal.Tbl_Factura.getColumnModel().getColumn(4).setPreferredWidth(13);
        Terminal.Tbl_Factura.getColumnModel().getColumn(5).setPreferredWidth(7);
        Terminal.Tbl_Factura.setRowHeight(23);
        Terminal.TxfTotal.setText(String.valueOf(formato.format(precioTotal())));
        Terminal.Txt_ToalIva.setText(String.valueOf(formato.format(precioTotalIva())));
    }

    public void añadirProducto(Producto producto) {
        Conexion.ModificarDato(Login.conexion, "INSERT INTO `DET_FACTURAS` (`Id`, `Id_Factura`, `Id_Producto`, `Cantidad`) VALUES (NULL, '" + num_factura + "', '" + producto.getId() + "', '1');");
        RegFactura();
    }

    public void cambiarCantidadProducto(String[] producto) {
        String ans = JOptionPane.showInputDialog(null, "¿Que cantidad desea de: " + producto[1] + "?", "1");
        if (ans != null) {
            Conexion.ModificarDato(Login.conexion, "UPDATE `DET_FACTURAS` SET `Cantidad` = '" + ans + "' WHERE `DET_FACTURAS`.`Id_Factura` = " + num_factura + " and `DET_FACTURAS`.`Id` = " + producto[0]);
            RegFactura();
        }
    }

    public void eliminarProducto(String[] producto) {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el producto: " + producto[1] + ", de la factura?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resp == 0) {
            Conexion.ModificarDato(Login.conexion, "DELETE FROM `DET_FACTURAS` WHERE `DET_FACTURAS`.`Id_Factura` = " + num_factura + " and `DET_FACTURAS`.`Id` = " + producto[0]);
            RegFactura();
        }
    }

    public void TerminarFactura(Container Terminal) {
        ArrayList<String[]> check = Conexion.leerTabla(Login.conexion, "select DET_FACTURAS.Id_Producto from DET_FACTURAS,PRODUCTOS where Id_Producto=PRODUCTOS.Id and Id_Factura=" + num_factura);
        if (check.size() > 1) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de terminar la factura?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == 0) {
                Conexion.ModificarDato(Login.conexion, "UPDATE `FACTURAS` SET `Cerrado` = '1' WHERE `FACTURAS`.`Id` = " + num_factura + ";");
                Ticket ticket = new Ticket(Terminal, this, num_factura);
                ticket.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La factura esta vacia", "Error Factura", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelarFactura() {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cancelar la factura?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == 0) {
            Conexion.ModificarDato(Login.conexion, "UPDATE `FACTURAS` SET `Cerrado` = '-1' WHERE `FACTURAS`.`Id` = " + num_factura + ";");
            numeroFactura();
            RegFactura();
            Terminal.TxfTotal.setText("");
            Terminal.Txt_ToalIva.setText("");
        }
    }

    public static void generarPDF() throws FileNotFoundException, DocumentException, IOException {
        JFileChooser elegirRuta = new JFileChooser();
        elegirRuta.setDialogTitle("Nombre de la factura");
        elegirRuta.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
        elegirRuta.addChoosableFileFilter(filter);
        int eleccion = elegirRuta.showSaveDialog(null);
        if (eleccion == JFileChooser.APPROVE_OPTION) {
            FileOutputStream escribirPDF = new FileOutputStream(elegirRuta.getSelectedFile());
            com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
            PdfWriter.getInstance(documento, escribirPDF).setInitialLeading(20);
            documento.open();
            ArrayList<String[]> Factura = Conexion.leerTabla(Login.conexion, "Select * from FACTURAS WHERE `FACTURAS`.`Id` = " + num_factura + ";");
            String line = Factura.get(1)[2];
            Timestamp ts = Timestamp.valueOf(line.replace("T", " ").replace("Z", ""));
            String Fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(ts);
            documento.add(new Paragraph("FACTURA: " + num_factura + "      Empleado: " + Login.User + "      Fecha: " + Fecha, FontFactory.getFont("Calibri", 14, Font.ITALIC, BaseColor.BLACK)));
            documento.add(new Paragraph("Artículos:", FontFactory.getFont("arial", 22, BaseColor.RED)));
            documento.add(new Paragraph());
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Artículo");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio unidad/kg");
            tabla.addCell("IVA");
            tabla.addCell("Precio final sin iva");
            tabla.addCell("Precio final con iva");
            ArrayList<String[]> Productos = Conexion.leerTabla(Login.conexion, "Select PRODUCTOS.Nombre, DET_FACTURAS.Cantidad, PRODUCTOS.Precio, PRODUCTOS.Iva, round(PRODUCTOS.Precio*DET_FACTURAS.Cantidad,2) as \"Precio sin iva\", round((PRODUCTOS.Precio+((PRODUCTOS.Precio*PRODUCTOS.Iva)/100))*DET_FACTURAS.Cantidad,2) as \"Precio con iva\" from DET_FACTURAS,PRODUCTOS WHERE Id_Producto=PRODUCTOS.Id and DET_FACTURAS.Id_Factura = " + num_factura);
            for (int i = 1; i < Productos.size(); i++) {
                tabla.addCell(Productos.get(i)[0]);
                tabla.addCell(Productos.get(i)[1]);
                tabla.addCell(Productos.get(i)[2] + "€");
                tabla.addCell(Productos.get(i)[3] + "%");
                tabla.addCell(Productos.get(i)[4] + "€");
                tabla.addCell(Productos.get(i)[5] + "€");
            }
            documento.add(tabla);
            documento.add(new Paragraph("Precio total sin IVA: " + precioTotal() + "€", FontFactory.getFont("arial", 22, BaseColor.BLACK)));
            documento.add(new Paragraph("Precio total: " + precioTotalIva() + "€", FontFactory.getFont("arial", 22, BaseColor.BLACK)));
            documento.close();
            int elegirAbrir = JOptionPane.showConfirmDialog(null, "¿Quieres abrir el archivo PDF de la factura generada?", "Abrir PDF", JOptionPane.OK_CANCEL_OPTION);
            if (elegirAbrir == JOptionPane.OK_OPTION) {
                Desktop.getDesktop().open(elegirRuta.getSelectedFile());
            }
        }
    }

    public DefaultTableModel getTbl_factura() {
        return Tbl_factura;
    }

}
