package ReservaDeAsientos;

public class Prueba {

    public static void main (String[] args) {

        int a=53;
        int b=2;

        double resultado=(double)a/2;

        System.out.println (resultado);

        Municipalidad muni=Municipalidad.getInstance ();

        System.out.println (muni.obtenerpromedioEdadMiembroClubEcologia ());
    }
}
