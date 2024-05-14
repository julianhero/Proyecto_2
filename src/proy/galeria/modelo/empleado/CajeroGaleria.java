package proy.galeria.modelo.empleado;

import java.util.ArrayList;
import java.util.HashMap;

import proy.galeria.modelo.Inventario;
import proy.galeria.modelo.Pieza;
import proy.galeria.modelo.pago.Pago;
import proy.galeria.modelo.usuario.Comprador;

public class CajeroGaleria extends Empleado 
{

	private static CajeroGaleria cajero;
	private Inventario inventarioGaleria;
    private HashMap<String, Pago>registroPagos;

    private CajeroGaleria(String nombre, int identificacion, int edad) {
        super("Cajero", nombre, identificacion, edad);
        registroPagos = new HashMap<>();
        this.inventarioGaleria = Inventario.obtenerInstanciaInv();        
    }
    
    public static synchronized CajeroGaleria obternerCajero() {
    	if (cajero == null) {
    		cajero = new CajeroGaleria("Sebastian Rios", 11364587, 40);
    	}
    	return cajero;
    } 

   
    public void registrarPago(Comprador comprador, Pago pago) {     
        try { String idComprador = String.valueOf(comprador.getIdentificacion());
            registroPagos.put(idComprador, pago);
            
        } catch (Exception e) {
        	System.out.println("No se puso vender la pieza");
        	
    
        }}
    
    public Pieza ConsultarPieza(String nombre) {
    	return inventarioGaleria.buscarPieza(nombre);
    }
    
    public ArrayList<Pieza> consultarHistoriaArtista(String nombre){
    	return inventarioGaleria.historiaArtista(nombre);
    }

}

