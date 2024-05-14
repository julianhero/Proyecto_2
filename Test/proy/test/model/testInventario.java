package proy.test.model;

import proy.galeria.modelo.Artista;
import proy.galeria.modelo.Inventario;
import proy.galeria.modelo.Pieza;
import proy.galeria.modelo.empleado.AdministradorInventario;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class testInventario {
	Artista artista = new Artista("Leonardo Da Vinci", "Pintor");
	Pieza pieza = new Pieza(false, "La Mona Lisa", 1503, "Italia", artista,true, "Humanismo", 19890786);
	AdministradorInventario adminInventario = new AdministradorInventario("Armando Reyes", 1054685947, 30);
	Inventario inv = new Inventario();
	
	@Test
	public void testAgregarPiezainventario(){
		inv.agregarPiezaInventario(pieza);
		assertTrue(inv.getInventarioPiezas().contains(pieza), "La pieza debería estar en la lista de inventario de piezas");
	}
	
	@Test
	public void testEliminarPiezaInventario() {
		inv.agregarPiezaInventario(pieza);
		assertTrue(inv.getInventarioPiezas().contains(pieza), "La pieza debería estar en la lista de inventario de piezas");
		
		inv.eliminarPiezaInventario(pieza);
		assertFalse(inv.getInventarioPiezas().contains(pieza), "La pieza no debería estar en la lista de inventario de piezas");
	}
}