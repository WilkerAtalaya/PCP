package modelo.usuario;

public class Dato {
    private boolean disponible; //disponible para lectura
    private String nombre;
    private String contraseña;
    private String valor;
    
    public Dato(){
        disponible = false;
    }
    
    public synchronized String obtener(){
        if(!disponible){
            try{
                wait();
            }
            catch(Exception e){}
        }
        System.out.println(valor);
        disponible = false;
        notify();
        return valor;
    }
    
    public synchronized void asignar(String n, String c){
        if(disponible){
            try{
                wait();
            }catch(Exception e){}
        }
        nombre = n;
        contraseña = c;
        valor = "User: " + n + " / " + "Contraseña: " + c;
        disponible = true;
        notify();
    }
}
