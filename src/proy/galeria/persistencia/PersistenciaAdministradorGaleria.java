package proy.galeria.persistencia;
import java.io.FileWriter;
import org.json.JSONObject;

import java.io.IOException;

import proy.galeria.modelo.Pieza;
import proy.galeria.modelo.empleado.AdministradorGaleria;

public class PersistenciaAdministradorGaleria {

    private static final String ARCHIVO_JSON = "administrador_galeria.json";

   
    public static void guardarAdministrador(AdministradorGaleria administrador) throws IOException {
        JSONObject jsonObject = new JSONObject();

       
        jsonObject.put("nombre", administrador.getNombre());
        jsonObject.put("identificacion", administrador.getIdentificacion());
        jsonObject.put("edad", administrador.getEdad());
        
        JSONArray jsonArray = new JSONArray();
        for (Pieza pieza : administrador.getInventario()) {
            JSONObject jsonPieza = new JSONObject();
            jsonPieza.put("tituloObra", pieza.getTituloObra());
            jsonPieza.put("precio", pieza.getPrecio());
            jsonPieza.put("vendida", pieza.isVendida());
            jsonPieza.put("devuelta", pieza.isDevuelta());
            
 
            jsonArray.put(jsonPieza);
        }
        jsonObject.put("inventario", jsonArray);

   
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON)) {
            writer.write(jsonObject.toString());
        }
    }

    
    
}