package ReservaDeAsientos;

public class Vista {


    public void mostrarPromedioAdultos (double promedio) {
        System.out.println ("\nEl promedio de edad en Adultos mayores es : "+promedio);
    }
    public void mostrarPromedioClub (double promedio) {
        System.out.println ("\nEl promedio de edad en Miembros del club de ecologia es : "+promedio);
    }

    public void mostrarClase (String clase) {
        if(clase.equals ("AdultoMayor")){
            System.out.println ("\nEl vecino pertenece al grupo de Adultos mayores");
        }else if(clase.equals ("MiembroClubEcologia")){
            System.out.println ("\nEl vecino pertenece al grupo de Miembros de Ecologia");
        }else{
            System.out.println ("\nNo se encontro grupo de registro");
        }
    }


}
