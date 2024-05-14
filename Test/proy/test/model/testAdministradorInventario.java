package proy.test.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import proy.galeria.modelo.Artista;
import proy.galeria.modelo.Inventario;
import proy.galeria.modelo.Pieza;
import proy.galeria.modelo.empleado.AdministradorInventario;

public class testAdministradorInventario 
{
	Artista artista = new Artista("Leonardo Da Vinci", "Pintor");
	Pieza pieza = new Pieza(false, "La Mona Lisa", 1503, "Italia", artista,true, "Humanismo", 19890786);
	AdministradorInventario adminInventario = new AdministradorInventario("Armando Reyes", 1054685947, 30);
	Inventario inv = new Inventario();
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testBuscarPiezaInventario() {
		inv.agregarPiezaInventario(pieza);
		Pieza piezaEncontrada = adminInventario.buscarPiezaInventario(pieza);
		assertNotNull(piezaEncontrada, "La pieza debería haber sido encontrada");
		assertEquals(pieza.getTituloObra(), piezaEncontrada.getTituloObra(), "El título de la obra debe coincidir");
	}
	
	public void testBuscarPiezaPorString() {
		
	}
	
	@SuppressWarnings("static-access")
	@Test
    public void testBuscarPiezaInventarioNoExistente() {
        Pieza piezaNoEncontrada = adminInventario.buscarPiezaInventario(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));
        assertNull(piezaNoEncontrada); 
    }
}

