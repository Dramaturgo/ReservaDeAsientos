package ReservaDeAsientos;

public class Controlador {

    private Municipalidad municipalidad;
    private Vista vista;

    public Controlador (Municipalidad municipalidad, Vista vista) {
        this.municipalidad = municipalidad;
        this.vista = vista;
    }

    public void registrarVecino(int opcion,String...args){
       Vecino vecino=FactoriaVecino.createVecino (opcion,args);
        try {
            municipalidad.registroVecino (vecino);
            vista.mensajeExitoso();
        } catch (Exception e) {
            vista.muestraMensaje(e.getMessage ());
        }
    }
    public void resgistrarBus(int nroDeBus,String horaDePartida,String nombreChofer,String copiloto){
        try {
            municipalidad.registroDeBuses (nroDeBus,horaDePartida,nombreChofer,copiloto);
            vista.mensajeExitoso ();
        } catch (Exception e) {
            vista.muestraMensaje (e.getMessage ());
        }

    }
    public void promedioDeAdultosMayores(){
        double promedio=municipalidad.obtenerpromedioEdadAdultoMayor ();
        vista.mostrarPromedioAdultos (promedio);
    }
    public void promedioDeClubEcologia(){
        double promedio= municipalidad.obtenerpromedioEdadMiembroClubEcologia ();
        vista.mostrarPromedioClub (promedio);
    }
    public void mostrarDatosDeVecinoBuscado(String dni){
       TableList t1= municipalidad.listarDatosDeVecinoBuscado (dni);
       String clase= municipalidad.obtenerClase (dni);
       if(t1!=null){
           vista.mostrarTableList(t1);
           vista.mostrarClase (clase);
       }else{
           vista.mensajeFaltaInformacion ();
       }
    }
    public void mostrarPasajerosPorFechaYhora(String fecha,int numeroDeBus){
        TableList t2= municipalidad.listarPasajerosPorFechaYnroBus (fecha,numeroDeBus);
        if(t2!=null){
            vista.mostrarTableList (t2);
        }else{
            vista.mensajeFaltaInformacion ();
        }

    }
    public void mostrarPasajerosConPremio(){
        TableList t3=municipalidad.listarVecinosConPremio ();
        if(t3!=null){
            vista.mostrarTableList (t3);
        }else{
            vista.mensajeFaltaInformacion ();
        }
    }
    public void mostrarAsientosDisponiblesPorBus(){
        TableList t4= municipalidad.listarAsientosDisponiblePorBus ();
        if(t4!=null){
            vista.mostrarTableList (t4);
        }else{
            vista.mensajeFaltaInformacion ();
        }
    }
    public void mostrarBaseDeDatosDeVecinos(){
        TableList t5= municipalidad.listarBaseDeDatosDeVecinos ();
        if(t5!=null){
            vista.mostrarTableList (t5);
        }else{
            vista.mensajeFaltaInformacion ();
        }
    }
}
