package domain;

public class Caja implements Runnable {

    private int id;
    private Cliente cliente;
    private long initialTime;

    public Caja(int id, Cliente cliente, long initialTime) {
        this.id = id;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }
    
    @Override
    public void run(){
        float Recibo = 0;
        
        System.out.println("→ La caja numero" + this.id + " comenzo"
                + "el cliente compra " + this.cliente.getNombre() 
                + " → " + (System.currentTimeMillis() - this.initialTime) / 1000 
                + " segundos");
        
        for (Producto productos : this.cliente.getProductos()) {
            
            esperarSegundos();
            
            Recibo += productos.getPrecio();
            
            System.out.println(productos.getNombre() + ", valor: " + productos.getPrecio()
            + (System.currentTimeMillis() - this.initialTime) / 1000 + " segundos");  
            
        }
        
        System.out.println(" *termino proceso de facturacion, el total fue de " + Recibo + "$"
        + " * " + (System.currentTimeMillis() - this.initialTime) / 1000 
        + " segundos");            
        
    }
    
    private void esperarSegundos() {
        try {
            Thread.sleep(1000);                
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }    
    }
    
    @Override
    public String toString(){
        
        return "* Caja numero: " + this.id 
             + "\n     * " + this.cliente ;
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }


    
    
    
    
    
    
}