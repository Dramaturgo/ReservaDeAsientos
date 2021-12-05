package ReservaDeAsientos;

import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.impl.CollectionASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;

import java.util.ArrayList;
import java.util.List;

public class Municipalidad  {

    private List<Vecino> listaDeVecinos;
    private List<Reserva>listaDeReservaciones;
    private List<Bus>listaDeBuses;

    private static Municipalidad municipalidad = new Municipalidad ();
    public static Municipalidad getInstance () {
        return municipalidad;
    }
    private Municipalidad () {
        this.listaDeVecinos = new ArrayList<> ();
        this.listaDeReservaciones=new ArrayList<> ();
        this.listaDeBuses=new ArrayList<> ();
        cargarBuses ();
        cargarVecinos ();
    }

    public void registroDeBuses(int  numero,String horaDeParida,String nombreDeChofer,String nombreDeCopiloto)throws Exception{
        Bus bus=new Bus (numero,horaDeParida,nombreDeChofer,nombreDeCopiloto);
        bus.validarHora ();
        this.listaDeBuses.add (bus);
    }
    public void generarReserva(int numeroDeReserva,String fecha){
        Reserva reserva=new Reserva (numeroDeReserva,fecha);
        this.listaDeReservaciones.add(reserva);
    }
    public String obtenerClase(String dni){
        String clase=null;
        for(Vecino v:this.listaDeVecinos){
            if(v.getDni ().equals (dni)){
                clase=v.getClass ().getSimpleName ();
            }
        }return clase;
    }
    public Bus obtenerBus(int numero){
        for(Bus b:this.listaDeBuses){
            if(b.getNumero ()==numero){
                return b;
            }
        }return null;
    }
    public Reserva obtenerReserva(int numeroDeReserva){
        for(Reserva r:this.listaDeReservaciones){
            if(r.getNumeroDeReserva ()==numeroDeReserva){
                return r;
            }
        }return null;
    }
    public Vecino obtenerVecino(String numeroDeDni){
        for(Vecino v:this.listaDeVecinos){
            if(v.getDni ().equals (numeroDeDni)){
                return v;
            }
        }return null;
    }
    public void asignarDatosAReserva(int numeroDeReserva,String dni,int numeroDeBus,int numeroDeAsiento){
        Reserva reserva=obtenerReserva (numeroDeReserva);
        Vecino vecino=FactoriaVecino.obtenerInstancia (dni);
        Bus bus=obtenerBus (numeroDeBus);
        Asiento asiento=bus.obtenerAsiento (numeroDeAsiento);
        if(reserva!=null){
            reserva.asignarVecino (vecino);
            reserva.asignarBus (bus);
            reserva.asignarAsiento (asiento);
        }
    }
    public List<String> registrarDni () {
        List<String> dni = new ArrayList<> ();
        for (Vecino vecino : this.listaDeVecinos) {
            dni.add (vecino.getDni ());
        }
        return dni;
    }
    public void registroVecino (Vecino vecino) throws Exception {
        boolean existe = registrarDni ().contains (vecino.getDni ());
        if (existe) throw new Exception ("\nEl usuario ya existe");
        else {
            vecino.validarEdad ();
            vecino.validarEstado ();
            listaDeVecinos.add (vecino);
        }
    }
    public boolean validarExistencia(String dni){
        boolean validar=false;
        for(Vecino vecino:this.listaDeVecinos){
            if(vecino.getDni ().equals (dni)){
                validar=true;
            }
        }return validar;
    }
    public double obtenerpromedioEdadAdultoMayor () {
        int suma = 0;
        int contadorAdultoMayor = 0;
        for (Vecino v : this.listaDeVecinos)
            if (v instanceof AdultoMayor) {
                suma += v.getEdad ();
                contadorAdultoMayor++;
            }
        return (double)suma / contadorAdultoMayor;

    }
    public double obtenerpromedioEdadMiembroClubEcologia () {
        int  suma = 0;
        int contador = 0;

        for (Vecino v : this.listaDeVecinos) {
            if(v instanceof MiembroClubEcologia) {
                if (v.promocionEspecial ().equals ("-")) {
                    contador++;
                    suma += v.getEdad ();
                }
            }
        }
        return (double)suma/contador;

    }
    public List<Vecino> getListaDeVecinos () {
        return listaDeVecinos;
    }
    public List<Reserva> getListaDeReservaciones () {
        return listaDeReservaciones;
    }
    public List<Bus> getListaDeBuses () {
        return listaDeBuses;
    }
    public void listarDatosBus(){
        IASCIITableAware asciiTableAware =
                new CollectionASCIITableAware<Bus> (listaDeBuses,
                        "numero", "hora_de_partida", "chofer", "copiloto");
        ASCIITable.getInstance ().printTable (asciiTableAware);

    }
    public TableList listarDatosDeVecinoBuscado(String dni){
        Vecino vecinoBuscado=obtenerVecino (dni);
        TableList t1=null;
        if(vecinoBuscado!=null){
            t1=new TableList (7,"Nombre","Apellido","DNI","Telefono","Estado civil","Edad","Correo electornico").sortBy (0);
        t1.addRow(vecinoBuscado.getNombre(), vecinoBuscado.getApellido (), vecinoBuscado.getDni (), vecinoBuscado.getTelefono ()
        ,vecinoBuscado.getEstadoCivil (),String.valueOf (vecinoBuscado.getEdad ()),vecinoBuscado.getCorreoElectronico ());}
        return t1;
    }
    public void listarDatosdeReserva(int numeroDeReserva){
        Reserva reserva=null;
        for(Reserva r:this.listaDeReservaciones){
            if(r.getNumeroDeReserva ()==numeroDeReserva){
                reserva=r;
            }
        }
        if (reserva!=null) {

            String numero= "000"+reserva.getNumeroDeReserva ();
            String fecha= reserva.getFechaReserva ();
            String nombre=reserva.getVecino ().getNombre ();
            String apellido=reserva.getVecino ().getApellido ();
            String dni=reserva.getVecino ().getDni ();
            String numeroBus="000"+reserva.getBus ().getNumero ();
            String horaPartida=String.valueOf (reserva.getBus ().getHora_de_partida ());
            String chofer=reserva.getBus ().getChofer ();
            String copiloto=reserva.getBus ().getCopiloto ();
            String asiento=String.valueOf (reserva.getAsiento ().getNumero ());

            TableList t2=new TableList (10,"Nro de reserva","Fecha","Nombre","Apellido","DNI","Nro de Bus","Nro de Asiento","Hora de partida","Chofer","Copiloto").sortBy (0);
            t2.addRow (numero,fecha,nombre,apellido,dni,numeroBus,asiento,horaPartida,chofer,copiloto);
            t2.print ();

        }else{
            System.out.println ("No se encontraron datos");
        }
    }
    public TableList listarPasajerosPorFechaYnroBus(String fecha,int numeroDeBus){
        List<Reserva>listaDeReservas=new ArrayList<> ();
        for(Reserva reserva:this.listaDeReservaciones){
            if(reserva.getFechaReserva ().equals (fecha)&&reserva.getBus ().getNumero ()==numeroDeBus){
                listaDeReservas.add (reserva);
            }
        }
        TableList t3=null;
        if(listaDeReservas.size ()!=0){
            t3=new TableList (8,"Nombre","Apellido","DNI","Telefono","Estado civil","Edad","Correo electornico","Obsequio").sortBy (0);
            TableList finalT = t3;
            listaDeReservas.forEach(element -> finalT.addRow(element.getVecino ().getNombre(), element.getVecino ().getApellido (), element.getVecino ().getDni (), element.getVecino ().getTelefono ()
                    ,element.getVecino ().getEstadoCivil (),String.valueOf (element.getVecino ().getEdad ()),element.getVecino ().getCorreoElectronico (),element.getVecino ().promocionEspecial ()));}

        return t3;


    }
    public TableList listarVecinosConPremio(){
        List<Vecino>listaDeVecinosConPremio=new ArrayList<> ();
        for(Vecino v:this.listaDeVecinos){
            if(!v.promocionEspecial ().equals ("-")){
                listaDeVecinosConPremio.add(v);
            }
        }
        TableList t4=null;
        if(listaDeVecinosConPremio.size ()!=0){
            t4=new TableList (8,"Nombre","Apellido","DNI","Telefono","Estado civil","Edad","Correo electornico","Obsequio").sortBy (0);
            TableList finalT=t4;
            listaDeVecinosConPremio.forEach(element ->finalT .addRow(element.getNombre(), element.getApellido (), element.getDni (), element.getTelefono ()
                    ,element.getEstadoCivil (),String.valueOf (element.getEdad ()),element.getCorreoElectronico (),element.promocionEspecial ()));
        }return t4;
    }
    public TableList listarAsientosDisponiblePorBus(){

        TableList t5=new TableList (2,"Nro de bus","Nro de asientos disponibles").sortBy (0);
        this.listaDeBuses.forEach (element ->t5.addRow (String.valueOf (element.getNumero ()),String.valueOf (element.asientosDisponibles ())));
        return  t5;

    }
    public TableList listarBaseDeDatosDeVecinos(){
        TableList t6=new TableList (8,"Nombre","Apellido","DNI","Telefono","Estado civil","Edad","Correo electornico","Grupo").sortBy (0);
        this.listaDeVecinos.forEach(element -> t6.addRow(element.getNombre(), element.getApellido (), element.getDni (), element.getTelefono ()
                ,element.getEstadoCivil (),String.valueOf (element.getEdad ()),element.getCorreoElectronico (),element.getClass ().getSimpleName ()));
        return t6;
    }
    public void cargarVecinos(){
        Vecino vecino=FactoriaVecino.createVecino (1,"Juan Carlos","Quispe Flores","40156070","961002314","Casado","25","Juan14@gmail.com");
        Vecino vecino1=FactoriaVecino.createVecino (2,"Maria Julia","Perez Loayza","40156071","970365923","Soltera","76","Maria15@gmail.com");
        Vecino vecino4=FactoriaVecino.createVecino (2,"Pedro","Quispe Almenara","40156074","980153254","Casado","65","Pedro14@gmail.com");
        Vecino vecino2=FactoriaVecino.createVecino (1,"Ruben","Garcia Lorca","40156072","970405061","Soltero","26","Ruben15@hotmail.com");
        Vecino vecino3=FactoriaVecino.createVecino (1,"Raul","Mendoza Paez","40156073","940150636","Soltero","27","Raul15@outlook.com");
        this.listaDeVecinos.add(vecino);
        this.listaDeVecinos.add(vecino1);
        this.listaDeVecinos.add(vecino2);
        this.listaDeVecinos.add(vecino3);
        this.listaDeVecinos.add(vecino4);

    }
    public void cargarBuses(){
        Bus bus1=new Bus (1,"9:00 am","Juan Carlos Mejia Suarez","Pedro Almenara Solis");
        Bus bus2=new Bus (2,"12:00 am","Ruben Garcia Lopez","Juan Rivera Mendez");
        Bus bus3=new Bus (3,"14:00 pm","Pedro Castillo Terrones","Cirilo Lopez Aliaga");
        Bus bus4=new Bus (4,"10:00 am","Emilio rojas","Gonzalo polo");
        this.listaDeBuses.add(bus1);
        this.listaDeBuses.add(bus2);
        this.listaDeBuses.add(bus3);
        this.listaDeBuses.add(bus4);
    }

}
