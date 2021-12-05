package ReservaDeAsientos;

public class Vista {


    public void mostrarPromedioAdultos (double promedio) {
        System.out.println ("\nEl promedio de edad en Adultos mayores es : "+promedio);
    }
    public void mostrarPromedioClub (double promedio) {
        System.out.println ("\nEl promedio de edad en Miembros del club de ecologia que no obtuvieron obsequio es : "+promedio);
    }
    public void mostrarClase (String clase) {
        if(clase.equals ("AdultoMayor")){
            System.out.println ("\nEl vecino pertenece al grupo de Adultos mayores");
        }else if(clase.equals ("MiembroClubEcologia")){
            System.out.println ("\nEl vecino pertenece al grupo de Miembros del club de Ecologia");
        }
    }
    public void muestraMensaje (String message) {
        System.out.println (message);
    }
    public void mensajeExitoso () {
        System.out.println ("\nRegistrado exitosamente!!!");
    }
    public void mensajeFaltaInformacion(){
        System.out.println ("\nNo se encontro informacion");
    }
    public void mostrarTableList (TableList t1) {
        t1.print ();
    }

}
