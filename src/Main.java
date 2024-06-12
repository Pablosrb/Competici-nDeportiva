import java.util.Scanner;

public class Main {
    private static Competicion competion;


    public static void main(String[] args) {

        boolean exit = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("A. Proporcionar datos de la competición.");
            System.out.println("B. Añadir un nuevo equipo.");
            System.out.println("C. Eliminar un equipo existente.");
            System.out.println("D. Buscar equipos de una localidad.");
            System.out.println("E. Listar todos lo equipos.");
            System.out.println("F. Dar de alta un nuevo jugador en un equipo.");
            System.out.println("G. Eliminar un jugador en un equipo");
            System.out.println("H. Cambiar disponibilidad de jugador");
            String menu = sc.nextLine();

            if (menu.toUpperCase().compareTo("A")==0){
                altaComp(competion);
            } else if(menu.toUpperCase().compareTo("B")==0){
                altaEquipo(competion);
            } else if(menu.toUpperCase().compareTo("C")==0){
                delEquipo(competion);
            } else if(menu.toUpperCase().compareTo("D")==0){
                buscarEquipo(competion);
            } else if(menu.toUpperCase().compareTo("E")==0){
                todosEquipos(competion);
            } else if(menu.toUpperCase().compareTo("F")==0){
                altaJugador(competion);
            } else if(menu.toUpperCase().compareTo("G")==0){
                eliminarJugador(competion);
            } else if(menu.toUpperCase().compareTo("H")==0){
                estadoJugador(competion);
            }
        }while (exit);

    }

    public static boolean altaComp(Competicion competicion){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nivel de competición:");
        System.out.println("A. BENJAMINES");
        System.out.println("B. MINI");
        System.out.println("C. JUVENILES");
        System.out.println("D. CADETES");
        String menu = sc.nextLine();
        String nivel = null;

        if (menu.toUpperCase().compareTo("A")==0){
            nivel = "Benjamines";
        } else if(menu.toUpperCase().compareTo("B")==0){
            nivel = "Mini";
        } else if(menu.toUpperCase().compareTo("C")==0){
            nivel = "Juveniles";
        } else if(menu.toUpperCase().compareTo("D")==0){
            nivel = "Cadetes";
        }

        boolean seguir = true;
        String codigo = null;
        do {

            System.out.println("Codigo de la competición");
            System.out.println("Introduce el nombre del deporte:");
            String dep = sc.nextLine();
            System.out.println("Introduce un numero, máximo 3 cifras");
            int num = Integer.parseInt(sc.nextLine());


            if (num >= 1 && num <= 999){
                codigo = dep.substring(0,2).toLowerCase()+num;
                seguir = false;
            } else {
                System.out.println("Tiene que insertar un numero del 1 - 999");
            }


        } while (seguir);

        System.out.println("Descripción:");
        String descripcion = sc.nextLine();

        System.out.println("Provincia:");
        String provincia = sc.nextLine();


        competion = new Competicion(nivel,codigo,descripcion,provincia);
        return true;
    }

    public static boolean altaEquipo(Competicion c){
        Scanner sc = new Scanner(System.in);
        String codigo,descripcion,nombre,apellidos,ciudad,email,tlf;

        System.out.println("Introduce el codigo del equipo: ");
        codigo = sc.nextLine();
        if (codigo.length() < 5) {

            System.out.println("Descripcion: ");
            descripcion = sc.nextLine();
            System.out.println("Nombre del representante del equipo");
            nombre = sc.nextLine();
            System.out.println("Apellidos del representante del equipo");
            apellidos = sc.nextLine();
            System.out.println("Ciudad: ");
            ciudad = sc.nextLine();
            System.out.println("Email: ");
            email = sc.nextLine();
            System.out.println("Telefono: ");
            tlf = sc.nextLine();


            c.crearEquipo(new Equipo(codigo,descripcion,nombre,apellidos,ciudad,email,tlf));
            return true;
        } else {
            System.out.println("El codigo debe de ser de una longitud maxima de 5 caracteres.");
            System.out.println("Vuelva a intentarlo más tarde.");
        }

        return false;
    }

    public static boolean delEquipo(Competicion c){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo del equipo");
        String codigo = sc.nextLine();


        if (c.eliminarEquipo(codigo)){
            System.out.println("Se ha eliminado correctamente.");
            return true;
        } else {
            System.out.println("No se puede eliminar el equipo porque tiene jugadores o porque el equipo no existe.");
            return false;
        }

    }

    public static Equipo[] buscarEquipo(Competicion c){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ciudad para buscar a los equipos");
        String ciudad = sc.nextLine();

        Equipo[] equipos = c.filtraEquipos(ciudad);
        if (equipos.length > 0) {
            System.out.println("Equipos en " + ciudad + ":");
            for (Equipo equipo : equipos) {
                System.out.println("---------------------------");
                System.out.println("Código: " + equipo.getCodigo());
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Ciudad: " + equipo.getCiudad());
                System.out.println("Email: " + equipo.getEmail());
                System.out.println("Teléfono: " + equipo.getTlf());
            }
            System.out.println("---------------------------");
        } else {
            System.out.println("No se encontraron equipos en la ciudad " + ciudad);
        }

        return equipos;
    }

    public static boolean todosEquipos(Competicion c){
        if(c.getMisEquipos().isEmpty()){

            System.out.println("No hay equipos registrados");
            return false;
        }

        for (Equipo equipo : c.getMisEquipos()) {
            System.out.println("---------------------------");
            System.out.println("Codigo: " + equipo.getCodigo());
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Ciudad: " + equipo.getCiudad());
            System.out.println("Email: " + equipo.getEmail());
            System.out.println("Telefono: " + equipo.getTlf());
        }
        System.out.println("---------------------------");
        return true;
    }

    public static boolean altaJugador(Competicion c){
        Scanner sc = new Scanner(System.in);

        System.out.println("Codigo del equipo donde juega: ");
        String cod = sc.nextLine();

        if(c.estaEquipo(cod)){
            System.out.println("nombre");
            String nombre = sc.nextLine();
            System.out.println("apellidos");
            String apellidos = sc.nextLine();

            int dorsal;
            do {
                System.out.println("dorsal");
                dorsal = Integer.parseInt(sc.nextLine());
                if (dorsal < 0 || dorsal>99){

                    System.out.println("Introduce un dorsal desde el 1 al 99");
                }



            }while (dorsal < 0 || dorsal>99);



            System.out.println("dni");
            String dni = sc.nextLine();
            System.out.println("Email");
            String email = sc.nextLine();
            System.out.println("Telefono de contacto");
            String tlf = sc.nextLine();
            boolean activo = true;

            Jugador nuevoJugador = new Jugador(nombre, apellidos, dorsal, dni, email, tlf, activo);
            for (Equipo equipo : c.getMisEquipos()) {
                if (equipo.getCodigo().equals(cod)) {
                    equipo.getMisJugadores().put(dni, nuevoJugador);
                    System.out.println("Jugador añadido correctamente.");
                    return true;
                }
            }
        }




        return false;
    }

    public static boolean eliminarJugador(Competicion c){
        Scanner sc = new Scanner(System.in);

        System.out.println("Equipo donde juega: ");
        String codigo = sc.nextLine();
        System.out.println("DNI jugador: ");
        String dni = sc.nextLine();

        if (c.eliminarJugadorEquipo(codigo,dni)){
            System.out.println("Jugador eliminado");
            return true;

        }

//        c.eliminarJugadorEquipo(codigo,dni);
        System.out.println("Error al encontrar el jugador, el equipo o la información del jugador es erronea");
        return false;

    }

    public static boolean estadoJugador(Competicion c){
        Scanner sc = new Scanner(System.in);

        System.out.println("Equipo donde juega: ");
        String codigo = sc.nextLine();
        System.out.println("DNI del jugador: ");
        String dni = sc.nextLine();

        for (Equipo equipo : c.getMisEquipos()) {

            if (equipo.getCodigo().equals(codigo)) {
                Jugador jugador = equipo.getMisJugadores().get(dni);

                if (jugador != null) {

                    jugador.setAtivo(!jugador.isAtivo());
                    System.out.println("Estado de disponibilidad del jugador actualizado correctamente.");

                    if (jugador.isAtivo()) {
                        System.out.println("Nuevo estado: Activo");
                    } else {
                        System.out.println("Nuevo estado: Inactivo");
                    }

                    return true;

                } else {

                    System.out.println("Jugador no encontrado en el equipo.");
                    return false;

                }
            }
        }

        System.out.println("Equipo no encontrado.");
        return false;

    }

}