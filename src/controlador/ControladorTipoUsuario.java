/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Sistema.Sistema_DatosUsuarios;
import vista.vistaLogin;
import vista.vistaLoginAdmin;
import vista.vistaTipoUsuario;

/**
 *
 * @author OSCAR
 */
public class ControladorTipoUsuario {

    vistaTipoUsuario vista;

    public ControladorTipoUsuario(vistaTipoUsuario vista) {
        this.vista = vista;

        this.vista.btnAdministrador.addActionListener(e -> {
            //vista.dispose();
            vistaLoginAdmin abrir = new vistaLoginAdmin();
            Sistema_DatosUsuarios sistemaUsuario = new Sistema_DatosUsuarios();
            ControladorLoginAdmin cabrir = new ControladorLoginAdmin(abrir, sistemaUsuario);
            cabrir.iniciar();
        });

        this.vista.btnCliente.addActionListener(e -> {
            //vista.dispose();
            vistaLogin abrir = new vistaLogin();
            Sistema_DatosUsuarios sistemaUsuario = new Sistema_DatosUsuarios();
            ControladorLogin cabrir = new ControladorLogin(abrir, sistemaUsuario);
            cabrir.iniciar();
        });
        
        

        this.vista.btnCerrar.addActionListener(e -> System.exit(0));
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}
