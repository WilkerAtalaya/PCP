package modelo.usuario;

import Sistema.Sistema_DatosUsuarios;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luigg
 */
public class HiloLector extends Thread{
    private Dato dato;
    public HiloLector(Dato d){
        dato = d;
    }
    
    public void run(){
        String valor;
        try {
            for (int i = 0; i < Sistema_DatosUsuarios.admins.size(); i++) {
                Thread.sleep((int) (Math.random() * 10000));
                valor = dato.obtener();
            }
        } catch (Exception e) {
        }
    }
}
