package proy.galeria.modelo.pago;

import proy.galeria.modelo.empleado.CajeroGaleria;
import proy.galeria.modelo.usuario.Comprador;

public class Pago 
{
	
	private int numeroFactura = 1;
	private int precio;
	private CajeroGaleria cajero; 
	
	public Pago(Comprador comprador, int nPrecio) {
		this.precio = nPrecio;
		this.numeroFactura += 1;
		comprador.actualizarSaldo(nPrecio);
		cajero = CajeroGaleria.obternerCajero();
		cajero.registrarPago(comprador, this);
		
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public int getPrecio() {
		return precio;
	}
	

}
