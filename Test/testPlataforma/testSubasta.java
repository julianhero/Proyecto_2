package testPlataforma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.TestMethodOrder;

import proy.galeria.modelo.Artista;
import proy.galeria.modelo.Pintura;
import proy.galeria.modelo.empleado.OperadorGaleria;
import proy.galeria.modelo.usuario.Comprador;

import org.junit.jupiter.api.MethodOrderer;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;




public class testSubasta {

	private Artista vG = new Artista("Leonardo da Vinci", "Pintor");
	private Pintura lNE = new Pintura("óleo sobre lienzo", "renacimiento", 77.0, 92.0, false, "La Última Cena", 1498, "Milán", vG, true, "Religioso", 900000000);
	private OperadorGaleria operador = new OperadorGaleria("María Sánchez", 22548796, 40);
	private Comprador comprador1 = new Comprador("Laura González", 21547896, 30, "l.gon", "LG30G", "3124257895", "l.gon@gmail.com", 950000000);
	private Comprador comprador2 = new Comprador("Pedro Gómez", 36521478, 32, "p.gomez", "PG32A", "3156781234", "pedro.gomez@gmail.com", 1100000000);
	private Comprador comprador3 = new Comprador("María Rodríguez", 98745632, 48, "m.rodriguez", "MR48R", "3175498765", "maria.rodriguez@gmail.com", 1600000000);
	private Comprador comprador4 = new Comprador("Andrés Fernández", 74589632, 25, "a.fernandez", "AF25H", "3109876543", "andres.fernandez@gmail.com", 1800000000);
	private Comprador comprador5 = new Comprador("Sofía Martínez", 36987452, 42, "s.martinez", "SM42P", "3123475689", "sofia.martinez@gmail.com", 220000000);
	
	//arreglar test (implementar fecha)
	//actualizar precio en subasta 
	
	@Test 
	public void testPiezaASubastar() throws Exception {
		operador.iniciarSubasta(lNE);
		operador.registrarOfertasSubasta(comprador1, lNE, 800000000, null);
		operador.registrarOfertasSubasta(comprador2, lNE, 900000000, null);
		operador.registrarOfertasSubasta(comprador3, lNE, 1000000000, null);
		operador.registrarOfertasSubasta(comprador4, lNE, 1100000000, null);
		operador.registrarOfertasSubasta(comprador5, lNE, 2000000000, null);
		assertEquals(comprador5.getNombre(), operador.identificarPostorGanador(lNE, null).getNombre());
		operador.finalizarSubasta(lNE);

}
	
	@Test 
	public void testPiezaASubastarFalla() throws Exception {
		operador.iniciarSubasta(lNE);
		operador.registrarOfertasSubasta(comprador1, lNE, 800000000, null);
		operador.registrarOfertasSubasta(comprador2, lNE, 900000000, null);
		Exception exception = assertThrows(Exception.class, () -> {operador.identificarPostorGanador(lNE, null);});
}}
