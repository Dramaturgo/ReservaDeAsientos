package ReservaDeAsientos;

public class Reserva {

    private int numeroDeReserva;
    private String fechaReserva;
    private Bus bus;
    private Vecino vecino;
    private Asiento asiento;

    public Reserva (int numeroDeReserva, String fechaReserva) {
        this.numeroDeReserva = numeroDeReserva;
        this.fechaReserva = fechaReserva;

    }
    //Metodos de asignacion
    public void asignarVecino(Vecino vecino){
        this.vecino=vecino;
    }
    public void asignarBus(Bus bus){
        this.bus=bus;
    }

    public void asignarAsiento(Asiento asiento){
        this.asiento=asiento;
    }


    public int getNumeroDeReserva () {
        return numeroDeReserva;
    }

    public String getFechaReserva () {
        return fechaReserva;
    }

    public Bus getBus () {
        return bus;
    }

    public Vecino getVecino () {
        return vecino;
    }

    public Asiento getAsiento () {
        return asiento;
    }


    @Override
    public String toString () {
        return "\nReservacion Nro 000" + getNumeroDeReserva () + ":" +
                "\nFecha de reservación:" + getFechaReserva () +
                "\nDatos del bus Nro " + bus.getNumero () + ":" +
                "\nNombre del chofer: " + bus.getChofer () +
                "\nNombre del copiloto" + bus.getCopiloto () +
                "\nHora de partida: " + bus.getHora_de_partida () + ":00" +
                "\nDatos del vecino:" + vecino.toString () +
                "\nNumero de asiento reservado: " + asiento.getNumero ();
    }



}
