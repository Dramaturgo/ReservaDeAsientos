package ReservaDeAsientos;

public class FactoriaVecino {

    public static Vecino createVecino (int opcion,String... datos) {
        return switch (opcion) {
            case 1 -> new MiembroClubEcologia (datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt (datos[5]), datos[6]);
            case 2 -> new AdultoMayor (datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt (datos[5]), datos[6]);
            default -> null;
        };
    }

    public static Vecino obtenerInstancia (String dni) {
        for (Vecino v : Municipalidad.getInstance ().getListaDeVecinos ()) {
            if (v.getDni ().equals (dni)) {
                return v;
            }
        }
        return null;
    }

}