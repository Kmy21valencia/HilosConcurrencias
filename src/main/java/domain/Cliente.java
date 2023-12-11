package domain;

import java.util.List;

public class Cliente {
    

    private final int id;
    private final String nombre;
    private final List<Producto> productos;
    

    public Cliente(int id, String nombre, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }


  
        @Override
    public String toString(){
        
        return "Cliente Numero" + this.id + ": " + this.nombre ;
    
    }
    
    
}
