import java.util.HashMap;
import java.util.Map;

public class Equipo {

    private Jugador jugador;
    private String codigo,descripcion,nombre,apellidos,ciudad,email,tlf;
    private Map<String, Jugador> misJugadores;

    public Equipo(String codigo, String descripcion, String nombre, String apellidos, String ciudad, String email, String tlf) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.email = email;
        this.tlf = tlf;

        misJugadores = new HashMap<String, Jugador>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public Map<String, Jugador> getMisJugadores() {
        return misJugadores;
    }

    public void setMisJugadores(Map<String, Jugador> misJugadores) {
        this.misJugadores = misJugadores;
    }

    public boolean crearJugador(Jugador miJugador){
        if(!misJugadores.containsKey(miJugador.getDni())){
            misJugadores.put(miJugador.getDni(), miJugador);
            return true;
        }
        return false;
    }

    public boolean eliminarJugador(String dni){
        if (misJugadores.containsKey(dni)) {
            misJugadores.remove(dni);
            return true;
        }
        return false;

    }


    @Override
    public String toString() {
        return "Equipo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", email='" + email + '\'' +
                ", tlf='" + tlf + '\'';
    }
}
