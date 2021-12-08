package ReservaDeAsientos;

public class MiembroClubEcologia extends Vecino {

    public MiembroClubEcologia (String nombre, String apellido, String dni, String telefono, String estadoCivil, int edad, String correoElectronico) {
        super (nombre, apellido, dni, telefono, estadoCivil, edad, correoElectronico);
    }


    @Override
    public String promocionEspecial () {
        String premio ;
        if (super.getEstadoCivil ().equalsIgnoreCase ("Casado")||super.getEstadoCivil ().equalsIgnoreCase ("Casada")) {
            premio = "Chocolate Sublime";
        } else {
            premio = "-";
        }
        return premio;
    }


}