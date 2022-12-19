/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.vistaCliente;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import modelo.usuario.Cliente;
import vista.vistaServidor;

/**
 *
 * @author OSCAR
 */
public class ControladorCliente {
    
    vistaCliente vista;
    Socket socket = null;
    BufferedReader lector = null;
    PrintWriter escritor = null;

    public ControladorCliente(vistaCliente vista) {
        this.vista = vista;
        this.vista.btnCerrar.addActionListener(e -> {
            vista.dispose();
        });
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        Thread principal = new Thread(new Runnable() {
            public void run() {
                try {
                    socket = new Socket("localhost", 9000);
                    leer();
                    escribir();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        principal.start();

    }

    public void leer() {
        Thread leer_hilo = new Thread(new Runnable() {
            public void run() {
                try {
                    lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (true) {
                        String mensaje_recibido = lector.readLine();
                        vista.areaChat.append(">>>" + mensaje_recibido + "\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        leer_hilo.start();
    }

    public void escribir() {
        Thread escribir_hilo = new Thread(new Runnable() {
            public void run() {
                try {
                    escritor = new PrintWriter(socket.getOutputStream(), true);
                    vista.btnEnviar.addActionListener(e -> {
                        String enviar_mensaje = "Administrador: " + vista.txtMensaje.getText();
                        escritor.println(enviar_mensaje);
                        vista.txtMensaje.setText("");
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        escribir_hilo.start();
    }

}
