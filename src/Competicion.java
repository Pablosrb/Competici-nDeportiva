import java.util.ArrayList;
import java.util.List;

public class Competicion {

    private String nivel,codigo,descripcion,provincia;
    private List<Equipo> misEquipos;

    public Competicion(String nivel,String codigo, String descripcion, String provincia) {
        this.nivel = nivel;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.provincia = provincia;

        misEquipos = new ArrayList<Equipo>();
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public List<Equipo> getMisEquipos() {
        return misEquipos;
    }

    public void setMisEquipos(List<Equipo> misEquipos) {
        this.misEquipos = misEquipos;
    }

    //CRUD Equipos
    //alta
    public boolean crearEquipo(Equipo miEquipo){
        if(!estaEquipo(miEquipo.getCodigo())){
            misEquipos.add(miEquipo);
            return true;
        }
        return false;
    }

    //Esta?
    public boolean estaEquipo(String codigo){
        for (Equipo equipo : misEquipos) {
            if (equipo.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    //Eliminar

    public boolean eliminarEquipo(String codigo){
        for (Equipo equipo : misEquipos) {
            if (equipo.getCodigo().equals(codigo)) {
                if (equipo.getMisJugadores().isEmpty()) {
                    misEquipos.remove(equipo);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }



    //buscar (Por provincia)
    public Equipo[] filtraEquipos(String ciudad) {
        ArrayList<Equipo> equiposfiltrados = new ArrayList<>();
        for (Equipo e : misEquipos) {
            if (e.getCiudad().equals(ciudad)) {
                equiposfiltrados.add(e);
            }
        }
        return equiposfiltrados.toArray(new Equipo[0]);
    }

    public boolean eliminarJugadorEquipo(String codigo, String dni){

        for (Equipo equipo : getMisEquipos()) {
            if (equipo.getCodigo().equals(codigo)) {
                if (equipo.eliminarJugador(dni)){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
