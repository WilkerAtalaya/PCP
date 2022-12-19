package modelo.usuario;

import Sistema.Sistema_DatosUsuarios;

public class HiloEscritor extends Thread{
    private Dato dato;
    
    public HiloEscritor(Dato d){
        dato = d;
    }
    
    public void run(){
        String valor;
        String nombre;
        String contraseña;
        try{
            for(int i=0; i < Sistema_DatosUsuarios.admins.size(); i++){
                Thread.sleep((int)(Math.random()*10000));
                dato.asignar(Sistema_DatosUsuarios.admins.get(i).getUser(), Sistema_DatosUsuarios.admins.get(i).getContraseña());
            }
        }catch(Exception e){
            
        }
    }
    
}
