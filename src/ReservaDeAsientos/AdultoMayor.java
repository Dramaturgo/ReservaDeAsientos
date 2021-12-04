package ReservaDeAsientos;

public class AdultoMayor extends Vecino {


    public AdultoMayor (String nombre, String apellido, String dni, String telefono, String estadoCivil, int edad, String correoElectronico) {
        super (nombre, apellido, dni, telefono, estadoCivil, edad, correoElectronico);

    }


    @Override
    public String promocionEspecial () {
        String premio ;
        if (super.getEdad () > 75) {
            premio = "Bebida";
        } else {
            premio = "-";
        }
        return premio;
    }

    @Override
    public String toString () {
        return "AdultoMayor{" +
                "} " + super.toString ();
    }
}