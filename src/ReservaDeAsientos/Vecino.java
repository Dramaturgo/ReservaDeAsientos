package ReservaDeAsientos;

public abstract class Vecino {

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String estadoCivil;//soltero o casado
    private int edad;
    private String correoElectronico;

    //Constructor
    public Vecino (String nombre, String apellido, String dni, String telefono, String estadocivil, int edad, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.estadoCivil = estadocivil;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
    }

    //Metodo abstracto para la promocion
    public abstract String promocionEspecial ();

    //Validaciones
    public void validarEdad () throws Exception {
        if (edad < 18) throw new Exception ("\nEl usuario no puede ser menor de edad");
    }
    public void validarEstado() throws Exception{
        if(! estadoCivil.equalsIgnoreCase ("Soltero")&&! estadoCivil.equalsIgnoreCase ("Casado")
                &&! estadoCivil.equalsIgnoreCase ("Soltera")&&! estadoCivil.equalsIgnoreCase ("Casada"))
                  throw new Exception (("\nEstado civil invalido"));
    }

    //Getters
    public String getNombre () {
        return nombre;
    }
    public String getApellido () {
        return apellido;
    }
    public String getDni () {
        return dni;
    }
    public String getTelefono () {
        return telefono;
    }
    public String getEstadoCivil () {
        return estadoCivil;
    }
    public int getEdad () {
        return edad;
    }
    public String getCorreoElectronico () {
        return correoElectronico;
    }


}