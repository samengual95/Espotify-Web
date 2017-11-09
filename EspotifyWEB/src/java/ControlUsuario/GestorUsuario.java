package ControlUsuario;
import Excepciones.UsuarioNoEncontrado;
import clases.*;
import interfaz.Interfaz;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

/**
 *
 * @author Clara
 */
public class GestorUsuario {
    
    private static GestorUsuario instancia;
    
    public static GestorUsuario getInstance() {
        if(instancia==null)
                instancia = new GestorUsuario();
        return instancia;
    }
    
    private Map <String,Usuario> usuarios; 
    
    private Interfaz sistema;
    
    public GestorUsuario(){
        Fabrica fabrica = Fabrica.getInstance();
        sistema = fabrica.getInterfaz();
        usuarios = new HashMap<String, Usuario>();
        ArrayList<Usuario> nuevo = sistema.getUsuarios();
        Iterator<Usuario> it = nuevo.iterator();
        Usuario u=null;
        while(it.hasNext()){
            u = it.next();
            usuarios.put(u.getEmail(), u);
        }
    }
    public Collection<Usuario> getUsuarios(){
        return usuarios.values();
    }
    
    public Usuario buscarUsuario(String mailnick) throws UsuarioNoEncontrado{ 
        Usuario res = usuarios.get(mailnick);
        if(res == null)
            throw new UsuarioNoEncontrado(mailnick);
        return res;
        
    } 
   
}
