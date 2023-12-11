
package com.mycompany.supermercado;

import domain.Caja;
import domain.Cliente;
import domain.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Supermercado {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        

        int option = -1;
        long initialTime = System.currentTimeMillis();        
            
        List<Cliente> clientes = new ArrayList<>();
        List<Caja> cajas = new ArrayList<>();
        List <Producto> productos = new ArrayList<>();        
                
        
        
       

        
        while (option != 0) {
            
            System.out.println(
                    "    Menú\n"
                    + "         1. Iniciar procesos de compra\n"
                    + "         2. Crear cliente\n"
                    + "         3. Leer clientes\n"
                    + "         4. Leer cliente por id\n"
                    + "         5. Crear caja\n"
                    + "         6. Leer cajas activas\n"
                    + "         0. Salir"
            );
         
            
            System.out.print(" Respuesta: ");
            option = sc.nextInt();

            sc.nextLine();
            

            switch(option) {
                

                case 0:  System.out.println("\nCerrando servicio...\n");

                case 1: iniciarHilos(cajas, initialTime);

                case 2: clientes.add(crearCliente());

                case 3: leerClientes(clientes);
  
                case 4: leerCliente(obtenerClienteById(clientes));
              
                case 5: crearCaja(cajas, obtenerClienteById(clientes), initialTime);
                case 6: leerCajas(cajas);
                default: System.out.println("- El numero no es valido, intente nuevamente...");
    
            }        
                
        }        
        
    }

    private static void leerClientes(List<Cliente> listaClientes){
        
        System.out.println("\nListado de clientes: \n");
        

        if(!listaClientes.isEmpty()){
            
            for (Cliente cliente : listaClientes){            
                System.out.println( cliente);            
            }

        } else {
            System.out.println("No se encuentran clientes...");
        }    
        
        System.out.println("");
      
    }
    

    private static void leerCliente(Cliente cliente) {
        

        if(cliente != null){
            System.out.println("");
            System.out.println(cliente);
            System.out.println("     Productos: ");
            for (Producto producto : cliente.getProductos()){
                
                System.out.println( producto);
                
            }
            

        }  
        
        System.out.println("");        
        
    }  
    

    private static Cliente obtenerClienteById(List<Cliente> listaClientes) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\n Digite el numero del cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();
        
    
        if(!listaClientes.isEmpty()){
            
            for (Cliente cliente : listaClientes){ 
                
                if (idCliente == cliente.getId()){
                    
                    return cliente;
                    
                }                
          
            }            

        } 
        
        
        System.out.println("El cliente no existe...");
        System.out.println("");
        

        return null;        
    }  
        

    private static Cliente crearCliente() {
        System.out.println("");

        System.out.print(" Digite numero: ");
        int idCliente = sc.nextInt();
        sc.nextLine();
  
        System.out.print(" Digite nombre: ");
        String nombreCliente = sc.nextLine();
        
        System.out.println("\n Que producto esta interesado el cliente?");

        List<Producto> productosCliente = crearProductos();
        

        Cliente nuevoCliente = new Cliente(idCliente, nombreCliente, productosCliente);
        

        return nuevoCliente;        
    }

    private static List<Producto> crearProductos() {
        
        List<Producto> productosNuevos = new ArrayList<>();
        int option;       
 
        do{

            System.out.print("\nDigite nombre del producto: ");
            String nombreProducto = sc.nextLine();


            System.out.print("Digite precio del producto: ");
            float precioProducto = sc.nextFloat();


            Producto productoNuevo = new Producto(nombreProducto, precioProducto);
            productosNuevos.add(productoNuevo);
            

            System.out.println("\n Desea añadir otro producto? (1 = si / 0 = no)");            
            System.out.print("\n Respuesta: ");
            option = sc.nextInt();            
            sc.nextLine(); 
                        
        } while (option != 0);
        

        System.out.println("");        
        

        return productosNuevos;
        
    }

    private static void crearCaja(List<Caja> listaCajas, Cliente cliente, long time) {
        
 
        int idCaja = listaCajas.size() + 1;        

        Caja cajaNueva = new Caja(idCaja, cliente, time);

        listaCajas.add(cajaNueva);
        
        System.out.println("\n Se creo la caja exitosamente ...\n");
        
    }
    

    private static void leerCajas(List<Caja> listaCajas){
        
        System.out.println("\n Listado de cajas: \n");

        if(!listaCajas.isEmpty()){
            
            for (Caja caja : listaCajas){            
                System.out.println(caja);            
            }
            

        } else {
            System.out.println(" No hay cajas en la lista...");
        }    
        
        System.out.println("");
      
    }    

    private static void iniciarHilos(List<Caja> listaCajas, long time) {
        time = System.currentTimeMillis(); 

        System.out.println("");
        
        for (Caja caja : listaCajas) {
            caja.setInitialTime(time); 
            caja.run();
            System.out.println("");
        }
    }
    
}
