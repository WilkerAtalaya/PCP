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
import modelo.usuario.Cliente;
import vista.vistaLogin;
import vista.vistaProductos;
import vista.vistaRegistro;
import vista.vistaTipoUsuario;

/**
 *
 * @author OSCAR
 */
public class ControladorLogin {

    private vistaLogin vista;
    private Sistema_DatosUsuarios sistemaUsuario;

    public ControladorLogin(vistaLogin vista, Sistema_DatosUsuarios sistemaUsuario) {
        this.vista = vista;
        this.sistemaUsuario = sistemaUsuario;
        this.vista.btnIngresar.addActionListener(e -> {

            String usuario = vista.txtUsuario.getText();
            String contraseña = vista.txtContraseña.getText();
            if ("".equals(usuario) || "".equals(contraseña)) {
                JOptionPane.showMessageDialog(vista, "Campo(s) vacio(s), ingrese sus credenciales nuevamente");
            } else {
                Sistema_DatosUsuarios.conectado = sistemaUsuario.verificarSesion(vista.txtUsuario.getText(), vista.txtContraseña.getText());
                if (Sistema_DatosUsuarios.conectado != null) {
                    Cliente cliente = (Cliente) sistemaUsuario.datosUsuario(usuario);
                    System.out.println("Correcto, Bienvenido " + cliente.getNombre());
                    vista.dispose();
                    vistaProductos vista1 = new vistaProductos();
                    Sistema_DatosProductos s = new Sistema_DatosProductos();
                    ControladorProductos ci = new ControladorProductos(vista1, s, cliente);
                    ci.iniciar();

                } else {
                    JOptionPane.showMessageDialog(vista, "Campo(s) incorrecto(s), ingrese sus credenciales nuevamente");
                }
            }

        });

        this.vista.btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaRegistro registrar = new vistaRegistro();
                Sistema_DatosUsuarios s = new Sistema_DatosUsuarios();
                ControladorRegistro cr = new ControladorRegistro(registrar, s);
                cr.iniciar();
            }

        });

        this.vista.btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaTipoUsuario abrir = new vistaTipoUsuario();
                ControladorTipoUsuario cabrir = new ControladorTipoUsuario(abrir);
                cabrir.iniciar();
            }
        });

    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}
