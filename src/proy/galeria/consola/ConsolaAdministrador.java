package proy.galeria.consola;

import java.util.Scanner;
import java.util.ArrayList;

import proy.galeria.modelo.empleado.AdministradorGaleria;
import proy.galeria.modelo.Pieza;

public class ConsolaAdministrador {
    
    public static void main(String[] args) {
        AdministradorGaleria administrador = AdministradorGaleria.obternerAdmin();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú que se muestra en bucle hasta que el usuario elige salir
        while (true) {
            // Imprime el menú
            System.out.println("Menú:");
            System.out.println("1. Ingresar una pieza al inventario");
            System.out.println("2. Confirmar venta Pieza");
            System.out.println("3. Confirmar devolucion Pieza");
            System.out.println("4. Ver historia de una Pieza");
            System.out.println("5. Ver historia de un Artista");
            System.out.println("6. Ver historia de un Comprador");
            System.out.println("7. Guardar administrador");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la Opción 1.");
                    // Pendiente: agregar lógica para ingresar una pieza al inventario
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2.");
                    System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                    String nombrePiezaVenta = scanner.nextLine();
                    boolean rtaVenta = administrador.confirmarVenta(nombrePiezaVenta);
                    if (rtaVenta) {
                        System.out.println("La pieza consultada ya fue vendida.");
                    } else {
                        System.out.println("La pieza consultada NO ha sido vendida.");
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado la Opción 3.");
                    System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                    String nombrePiezaDevolucion = scanner.nextLine();
                    boolean rtaDevolucion = administrador.confirmarDevolucion(nombrePiezaDevolucion);
                    if (rtaDevolucion) {
                        System.out.println("La pieza consultada ha sido devuelta por el comprador anterior.");
                    } else {
                        System.out.println("La pieza consultada NO ha sido devuelta a la galería.");
                    }
                    break;
                case 4:
                    System.out.println("Has seleccionado la Opción 4.");
                    System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                    String nombrePiezaConsulta = scanner.nextLine();
                    Pieza piezaConsulta = administrador.ConsultarPieza(nombrePiezaConsulta);
                    if (piezaConsulta != null) {
                        System.out.println("Información de la pieza:");
                        System.out.println("Título: " + piezaConsulta.getTituloObra());
                        System.out.println("Año de creación: " + piezaConsulta.getAño());
                        System.out.println("Lugar de creación: " + piezaConsulta.getLugarCreacion());
                        System.out.println("Autor: " + piezaConsulta.getAutor().getNombre());
                        System.out.println("Tématica: " + piezaConsulta.getTematica());
                        if (piezaConsulta.isVendida()) {
                            System.out.println("La pieza fue vendida por un valor de " + piezaConsulta.getPrecio() + " el día " + piezaConsulta.getFecha() + ".");
                            // Agregar lógica para mostrar al dueño actual
                        } else {
                            System.out.println("La pieza no ha sido vendida. Tiene un valor de " + piezaConsulta.getPrecio() + ".");
                        }
                    } else {
                        System.out.println("La pieza consultada no se encuentra en el inventario.");
                    }
                    break;
                case 5:
                    System.out.println("Has seleccionado la Opción 5.");
                    System.out.print("Por favor, ingresa el nombre del Artista a consultar: ");
                    String nombreArtista = scanner.nextLine();
                    ArrayList<Pieza> piezasArtista = administrador.consultarHistoriaArtista(nombreArtista);
                    if (piezasArtista == null || piezasArtista.isEmpty()) {
                        System.out.println("El artista NO tiene o ha tenido ninguna pieza en la galería.");
                    } else {
                        System.out.println("Historia del artista " + nombreArtista + ":");
                        for (Pieza pieza : piezasArtista) {
                            System.out.println("Título: " + pieza.getTituloObra() + ", Año: " + pieza.getAño());
                            if (pieza.isVendida()) {
                                System.out.println("  - Vendida por " + pieza.getPrecio() + " el día " + pieza.getFecha() + ".");
                            } else {
                                System.out.println("  - No vendida. Valor: " + pieza.getPrecio() + ".");
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Has seleccionado la Opción 6.");
                    // Pendiente: agregar lógica para consultar la historia de un comprador
                    break;
                case 7:
                    System.out.println("Has seleccionado la Opción 7.");
                    // Pendiente: agregar lógica para guardar el administrador
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }

            System.out.println();
        }
    }
}