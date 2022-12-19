/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Sistema.Sistema_DatosProductos;
import Sistema.Sistema_DatosUsuarios;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.compras.CarritoCompra;
import modelo.usuario.Cliente;
import vista.vistaCliente;
import vista.vistaLogin;
import vista.vistaProductos;
import vista.vistaServidor;

/**
 *
 * @author OSCAR
 */
public class ControladorProductos {

    private vistaProductos vista;
    private Sistema_DatosProductos sistemaProducto;
    private CarritoCompra carrito;
    private Cliente cliente;
    int[] indicesProductosSeleccionados;

    public ControladorProductos(vistaProductos vista, Sistema_DatosProductos sistemaProducto, Cliente cliente) {
        this.vista = vista;
        this.sistemaProducto = sistemaProducto;
        this.cliente = cliente;
        carrito = new CarritoCompra();
        indicesProductosSeleccionados = vista.tblProd.getSelectedRows();
        vista.lblNom.setText("Hola: "+cliente.getNombre()+" "+cliente.getContraseña());
        this.vista.btnComprar.addActionListener(e -> {
            
            System.out.println("Proximamente");
        });

        this.vista.btnBuscar.addActionListener(e -> {
            System.out.println("Proximamente");
        });

        this.vista.btnRefrescar.addActionListener(e -> {
            System.out.println("Proximamente");
        });
        
       

        this.vista.btnVolver.addActionListener(e -> {
            Sistema_DatosUsuarios.conectado.cerrarSesion();
            vista.dispose();
            vistaLogin abrir = new vistaLogin();
            Sistema_DatosUsuarios sistemaUsuario = new Sistema_DatosUsuarios();
            ControladorLogin cabrir = new ControladorLogin(abrir, sistemaUsuario);
            cabrir.iniciar();
        });
        
        this.vista.btnClient.addActionListener(e -> {
            vistaServidor abrir = new vistaServidor();
            ControladorServidor c_abrir = new ControladorServidor(abrir, this.cliente);
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
