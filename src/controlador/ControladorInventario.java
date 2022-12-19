/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Sistema.Sistema_DatosProductos;
import Sistema.Sistema_DatosUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.producto.IProducto;
import modelo.usuario.Cliente;
import vista.vistaCliente;
import vista.vistaInventario;
import vista.vistaLoginAdmin;

/**
 *
 * @author OSCAR REFNAY
 */
public class ControladorInventario {

    private vistaInventario vista;
    Sistema_DatosProductos sistemaProducto;
    Cliente cliente;
    public ControladorInventario(vistaInventario vista, Sistema_DatosProductos sistemaProducto, Cliente cliente) {
        this.vista = vista;
        this.sistemaProducto = sistemaProducto;
        this.cliente = cliente;
        this.vista.btnNuevo.addActionListener(e -> {
            System.out.println("Proximamente");
        });

        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int fila = vista.tblProd.getSelectedRow();
                    int col = vista.tblProd.getSelectedColumn();
                    String nomProd = vista.tblProd.getValueAt(fila, 1).toString();
                    sistemaProducto.eliminarProductoxNombre(nomProd);
                    iniciar();
                    limpiarControles();
                } catch (ArrayIndexOutOfBoundsException a) {
                    System.out.println("No ha seleccionado un producto");
                }

            }
        });

        this.vista.btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Proximamente");
            }
        });

        this.vista.btnVolver.addActionListener(e -> {
            Sistema_DatosUsuarios.conectado.cerrarSesion();
            vista.dispose();
            vistaLoginAdmin abrir = new vistaLoginAdmin();
            Sistema_DatosUsuarios sistemaUsuario = new Sistema_DatosUsuarios();
            ControladorLoginAdmin cabrir = new ControladorLoginAdmin(abrir, sistemaUsuario);
            cabrir.iniciar();
        });
        
        this.vista.btnRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] datos = sistemaProducto.getDatos();
                String[] cabecera = sistemaProducto.getCabecera();
                DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
                vista.tblProd.setModel(modeloProducto);
            }
        });
        
        this.vista.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Proximamente");
            }
        });
        
        this.vista.btnServer.addActionListener(e -> {
            vistaCliente abrir = new vistaCliente();
            ControladorCliente c_abrir = new ControladorCliente(abrir);
            c_abrir.iniciar();
        });
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        String[][] datos = sistemaProducto.getDatos();
        String[] cabecera = sistemaProducto.getCabecera();
        DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
        vista.tblProd.setModel(modeloProducto);

    }

    public void limpiarControles() {
        String[][] datos = sistemaProducto.getDatos();
        String[] cabecera = sistemaProducto.getCabecera();
        DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
        vista.tblProd.setModel(modeloProducto);
    }

}
