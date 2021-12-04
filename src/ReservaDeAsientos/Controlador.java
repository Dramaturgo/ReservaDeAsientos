package ReservaDeAsientos;

public class Controlador {

    private Municipalidad municipalidad;
    private Vista vista;

    public Controlador (Municipalidad municipalidad, Vista vista) {
        this.municipalidad = municipalidad;
        this.vista = vista;
    }

    public void promedioDeAdultosMayores(){
        double promedio=municipalidad.obtenerpromedioEdadAdultoMayor ();
        vista.mostrarPromedioAdultos (promedio);
    }

    public void promedioDeClubEcologia(){
        double promedio= municipalidad.obtenerpromedioEdadMiembroClubEcologia ();
        vista.mostrarPromedioClub (promedio);
    }


    public void obtenerClase(String dni){
        String clase= municipalidad.obtenerClase (dni);
        if(clase!=null){
            vista.mostrarClase (clase);
        }
    }



}
