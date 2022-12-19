
import Sistema.Sistema_DatosProductos;
import Sistema.Sistema_DatosUsuarios;
import controlador.ControladorTipoUsuario;
import java.util.concurrent.atomic.AtomicInteger;
import modelo.producto.Producto;
import modelo.usuario.Dato;
import modelo.usuario.FactoryAdministrador;
import modelo.usuario.FactoryCliente;
import modelo.usuario.HiloEscritor;
import modelo.usuario.HiloLector;

import vista.vistaTipoUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OSCAR
 */
public class App extends Thread{
    public void run(){
        //Creacion de administradores TERMINADO
        FactoryAdministrador factoryAdministrador = new FactoryAdministrador();
        try {
            factoryAdministrador.crearUsuario("oscar.yanfer", "admin1");
            factoryAdministrador.crearUsuario("luiggi", "123456");
            factoryAdministrador.crearUsuario("diego.montalvo", "admin3");
            factoryAdministrador.crearUsuario("rodrigo.reyes", "admin4");
            factoryAdministrador.crearUsuario("juan.alfaro", "admin5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        FactoryCliente factoryCliente = new FactoryCliente();
        try{
            factoryCliente.crearUsuario("luiggi", "pasache", "luiggi", "123456", 
                    "los olivos", "123456789", "luiggip2108@gmail.com");
        }catch( Exception e){
            e.printStackTrace();
        }
        // a, b, c, d, e = 12, 12, 12, 12, 12
        AtomicInteger a = new AtomicInteger(12);
        AtomicInteger b = new AtomicInteger(12);
        AtomicInteger c = new AtomicInteger(12);
        AtomicInteger d = new AtomicInteger(12);
        AtomicInteger e = new AtomicInteger(12);
        //Creacion de productos
        Producto p1 = new Producto("Detergente", (float) 2.0, a, "Articulos de limpieza");
        Producto p2 = new Producto("Lejia", (float) 3.5, b, "Articulos de limpieza");
        Producto p3 = new Producto("Sacagrasa", (float) 3.0, c, "Articulos de limpieza");
        Producto p4 = new Producto("Deshumecedor", (float) 6.0, d, "Articulos de limpieza");
        Producto p5 = new Producto("Ambientador", (float) 5.0, e, "Articulos de limpieza");
        Sistema_DatosProductos.products.add(p1);
        Sistema_DatosProductos.products.add(p2);
        Sistema_DatosProductos.products.add(p3);
        Sistema_DatosProductos.products.add(p4);
        Sistema_DatosProductos.products.add(p5);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.start();
        //Iniciar sistema
        vistaTipoUsuario abrir = new vistaTipoUsuario();
        ControladorTipoUsuario cabrir = new ControladorTipoUsuario(abrir);
        cabrir.iniciar();
    }
}
