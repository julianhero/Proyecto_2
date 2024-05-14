package testPlataforma;

import org.junit.jupiter.api.Test;

import proy.galeria.modelo.Artista;
import proy.galeria.modelo.Escultura;
import proy.galeria.modelo.usuario.Comprador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;




public class testVenta {
	
	private Artista mA = new Artista("Miguel Angel", "escultor");
	private Escultura d = new Escultura(517, 198, 5660, false, false, "David", 1504, "Florencia", mA, true, "biblica", 1500000000);
	private Comprador comprador1 = new Comprador("Felipe García", 21436587, 32, "f.garcia", "FG32G", "3101234567", "f.garcia@gmail.com", 950000000);
	private Comprador comprador2 = new Comprador("María Fernanda López", 98765432, 27, "m.fernanda", "MF27A", "3178901234", "m.fernanda@gmail.com", 1050000000);
	private Comprador comprador3 = new Comprador("Carlos Sánchez", 54879632, 39, "c.sanchez", "CS39R", "3145678901", "c.sanchez@gmail.com", 1600000000);
	private Comprador comprador4 = new Comprador("Luisa Martínez", 12348765, 31, "l.martinez", "LM31H", "3198765432", "l.martinez@gmail.com", 220000000);
	private Comprador comprador5 = new Comprador("Andrés Gómez", 36985214, 42, "a.gomez", "AG42P", "3112345678", "a.gomez@gmail.com", 230000000);
	
	//implementar fecha
	//arreglar administrador 
	@Test
	public void venderPiezaFallo() throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outputStream));
		
		admin.registrarPiezaInventario(d);
		admin.verificarUsuario(comprador1);
		comprador1.hacerOfertaVenta(d, null);
		String[] outputs = outputStream.toString().split(System.lineSeparator());
		assertEquals("Oferta rechazada o inválida para la pieza: David por el comprador: Felipe Garcia", outputs[1].trim());
		
	}
		@Test
		public void venderPiezaExito() throws Exception {
			
			admin.registrarPiezaInventario(d);
			admin.verificarUsuario(comprador5);
			comprador5.solicitarAumentoLimite();
			comprador5.hacerOfertaVenta(d, null);
			assertEquals(1, comprador5.getPiezasCompradas().size());
			assertEquals(true, d.isVendida());
		}
		
		
		@Test
		public void casoDevolucion() throws Exception {
			admin.registrarPiezaInventario(d);
			admin.verificarUsuario(comprador5);
			comprador5.solicitarAumentoLimite();
			comprador5.hacerOfertaVenta(d, null);
			comprador5.solicitarDevolucion(d);
			assertEquals(0, comprador5.getPiezasCompradas().size());
			assertEquals(false, d.isVendida());
		}
	
	
	
	


}