package proy.galeria.modelo.usuario;

public class Usuario {
    protected String nombre;
    protected int identificacion;
    protected int edad;
    protected String nombreUsuario;
    protected String password;
    private String road;
    private Subasta subasta = new Subasta();


    public Usuario(String nombre, int identificacion, int edad, String nombreUsuario, String password, String road) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.road = road;

    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

  
   public void ofertarSubasta(Pieza pieza, Usuario usuario, int precio) {
        
       
        
        if (subasta != null && precio>=pieza.getPrecio()) {
            subasta.agregarOfertaSubasta(usuario, precio, pieza);
        }
    }


    
}


