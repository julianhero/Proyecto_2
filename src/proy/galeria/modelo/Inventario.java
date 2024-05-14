package proy.galeria.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventario {

    private static Inventario instanciaInventario;
    private ArrayList<Pieza> inventarioPiezas;
    private HashMap<String, ArrayList<Pieza>> inventarioArtistas;

    public Inventario() {
        inventarioPiezas = new ArrayList<>();
        inventarioArtistas = new HashMap<>();
    }

    public static synchronized Inventario obtenerInstanciaInv() {
        if (instanciaInventario == null) {
            instanciaInventario = new Inventario();
        }
        return instanciaInventario;
    }

    public void agregarPiezaInventario(Pieza pieza) {
        inventarioPiezas.add(pieza);
        String artista = pieza.getAutor().getNombre();
        inventarioArtistas.computeIfAbsent(artista, k -> new ArrayList<>()).add(pieza);
    }

    public void eliminarPiezaInventario(Pieza pieza) {
        inventarioPiezas.remove(pieza);
        String artista = pieza.getAutor().getNombre();
        if (inventarioArtistas.containsKey(artista)) {
            inventarioArtistas.get(artista).remove(pieza);
        }
    }

    public ArrayList<Pieza> getInventarioPiezas() {
        return new ArrayList<>(inventarioPiezas);
    }

    public Pieza buscarPieza(String nombrePieza) {
        for (Pieza pieza : inventarioPiezas) {
            if (pieza.getTituloObra().equalsIgnoreCase(nombrePieza)) {
                return pieza;
            }
        }
        return null;
    }

    public ArrayList<Pieza> historiaArtista(String nombreArtista) {
        return inventarioArtistas.getOrDefault(nombreArtista, new ArrayList<>());
    }
}