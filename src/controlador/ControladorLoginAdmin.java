/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Sistema.Sistema_DatosProductos;
import Sistema.Sistema_DatosUsuarios;
import javax.swing.JOptionPane;
import modelo.usuario.Dato;
import modelo.usuario.HiloEscritor;
import modelo.usuario.HiloLector;
import vista.vistaInventario;
import vista.vistaLoginAdmin;
import vista.vistaTipoUsuario;

/**
 * @author OSCAR
 */
public class ControladorLoginAdmin {

    private vistaLoginAdmin vista;

    public ControladorLoginAdmin(vistaLoginAdmin vista, Sistema_DatosUsuarios datosUsuarios) {
        this.vista = vista;
        this.vista.txtUsuario.requestFocus();

        this.vista.btnIngresar.addActionListener(e -> {
            String usuario = vista.txtUsuario.getText();
            String contraseña = vista.txtContraseña.getText();

            if (usuario.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Campo usuario vacio, ingrese sus credenciales nuevamente");
                vista.txtUsuario.requestFocus();
                return;
            }
            if(contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Campo contraseña vacio, ingrese sus credenciales nuevamente");
                vista.txtContraseña.requestFocus();
                return;
            }

            Sistema_DatosUsuarios.conectado = datosUsuarios.verificarSesionAdmin(usuario, contraseña);
            if(Sistema_DatosUsuarios.conectado == null){
                JOptionPane.showMessageDialog(vista, "Campo(s) incorrecto(s), ingrese sus credenciales nuevamente");
                return;
            }

            JOptionPane.showMessageDialog(vista,"Correcto, Bienvenido " + datosUsuarios.datosAdmin(usuario).getUser());

            vista.dispose();
            vistaInventario vista1 = new vistaInventario();
            Sistema_DatosProductos datosProductos = new Sistema_DatosProductos();
            ControladorInventario ci = new ControladorInventario(vista1, datosProductos, null);
            ci.iniciar();



        });

        this.vista.btnCerrar.addActionListener(e -> {
            vista.dispose();
            vistaTipoUsuario abrir = new vistaTipoUsuario();
            ControladorTipoUsuario cabrir = new ControladorTipoUsuario(abrir);
            cabrir.iniciar();
        });
        
        this.vista.btnAyuda.addActionListener(e -> {
            System.out.println("Creando usuarios administradores...");
            Dato d = new Dato();
            HiloEscritor escribe = new HiloEscritor(d);
            HiloLector lee = new HiloLector(d);
            lee.start();
            escribe.start();
        });

    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}
