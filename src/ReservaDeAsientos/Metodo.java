package ReservaDeAsientos;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.Scanner;
import java.util.Calendar;
import java.io.Console;
import java.io.IOException;

public class Metodo{
static Scanner sc = new Scanner (System.in);
static Municipalidad sanBorja=Municipalidad.getInstance();
static Vista vista=new Vista ();
static Controlador controlador=new Controlador (sanBorja,vista);

    public static void continuar(){
        AnsiConsole.systemInstall ();
        String seguir;
        Scanner teclado = new Scanner(System.in);
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ));
        System.out.println("\nPresiona Enter para continuar...");
        try{
            seguir = teclado.nextLine();}
        catch(Exception e){}
        AnsiConsole.systemUninstall();
    }
    public static void limpiaPantalla()throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static void logo(){
        AnsiConsole.systemInstall ();
        Calendar cal = Calendar.getInstance ();
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("╔══════════════════════════════╗"));
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("║                              ║"));
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("║       MUNICIPALIDAD DE       ║"));
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("║          SAN BORJA           ║"));
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("║                              ║"));
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("╚══════════════════════════════╝"));
        AnsiConsole.out.print(Ansi.ansi().fg(Ansi.Color.YELLOW    ));
        System.out.printf (" %tc\n", cal);
        AnsiConsole.systemUninstall();
        System.out.println();
        System.out.println();

    }
    public static void cargando2()throws IOException, InterruptedException{

        String anim= "|/-\\";
        for (int i =10 ; i < 101 ; i++) {
            String data = "\r" + anim.charAt(i % anim.length()) + " CARGANDO INFORMACION " + i+" %";
            System.out.write(data.getBytes());
            Thread.sleep(10);

        }
    }
    public static void menuPrincipal ()throws IOException, InterruptedException {

        logo ();
        AnsiConsole.systemInstall ();
        AnsiConsole.out .println (Ansi.ansi ().fg (Ansi.Color.CYAN));
        System.out.println ("1- Registro de nuevos vecinos");
        System.out.println ("2- Reserva de asientos");
        System.out.println ("3- Consulta tu reserva");
        System.out.println ("4- Acceso privado");
        System.out.println ("5- Salir del programa\n");
        System.out.println ("══════════════════════════════");
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.BLUE    ).a("Ingrese una opcion:"));
        int opcion = sc.nextInt ();
        limpiaPantalla();
        switch (opcion) {
            case 1 -> opcionRegistro();
            case 2 -> opcionReserva ();
            case 3 -> opcionConsultaReserva ();
            case 4 -> accesoPrivado();
            case 5 -> System.exit (0);
            default -> {
                AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("Opcion incorrecta!!"));
                menuPrincipal();
                AnsiConsole.systemUninstall();
            }
        }
    }
    public static void opcionRegistro()throws IOException, InterruptedException{
     logo();
     AnsiConsole.systemInstall ();
     AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
     System.out.println("1- Registro de Miembros del club de ecologia");
     System.out.println("2- Registro de Adulto Mayor");
     System.out.println("3- Regresar\n");
     System.out.println ("══════════════════════════════");
     AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.BLUE    ).a("Ingrese una opcion:"));
     int opcion=sc.nextInt();
     limpiaPantalla();
     switch(opcion) {
         case 1 :
                 logo();
                 AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.MAGENTA  ).a("Ingrese los siguientes datos:\n"));
                 AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                 System.out.print("Nombres:      ");
                 sc.nextLine();
                 String nombre=sc.nextLine();
                 System.out.print("Apellidos:    ");
                 String apellido=sc.nextLine();
                 System.out.print("DNI:          ");
                 String dni=sc.next();
                 System.out.print("Telefono:     ");
                 String telefono=sc.next();
                 System.out.print("Estado civil: ");
                 String estadoCivil=sc.next();
                 System.out.print("Edad:         ");
                 int edad=Integer.parseInt(sc.next());
                 System.out.print("Email:        ");
                 String correoElectronico=sc.next();
                 System.out.println ("══════════════════════════════");
                 controlador.registrarVecino (opcion,nombre,apellido,dni,telefono,estadoCivil,String.valueOf (edad),correoElectronico);
                 continuar();
                 limpiaPantalla();
                 opcionRegistro();
                 break;
        case 2:
                 logo();
                 AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.MAGENTA  ).a("Ingrese los siguientes datos:\n"));
                 AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                 System.out.print("Nombres:      ");
                 sc.nextLine();
                 nombre=sc.nextLine();
                 System.out.print("Apellidos:    ");
                 apellido=sc.nextLine();
                 System.out.print("DNI:          ");
                 dni=sc.next();
                 System.out.print("Telefono:     ");
                 telefono=sc.next();
                 System.out.print("Estado civil: ");
                 estadoCivil=sc.next();
                 System.out.print("Edad:         ");
                 edad=Integer.parseInt(sc.next());
                 System.out.print("Email:        ");
                 correoElectronico=sc.next();
                 System.out.println ("══════════════════════════════");
                 controlador.registrarVecino (opcion,nombre,apellido,dni,telefono,estadoCivil,String.valueOf (edad),correoElectronico);
                 continuar();
                 limpiaPantalla();
                 opcionRegistro ();
                 break;
        case 3:
                 limpiaPantalla();
                 menuPrincipal();
                 break;
        default:
                 AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("Opcion incorrecta!!"));
                 opcionRegistro();
                 AnsiConsole.systemUninstall();
                   }
                }
    public static void accesoPrivado()throws IOException,InterruptedException{
        logo();
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
        System.out.print("Usuario   : ");
        String user=sc.next();
        Console console = System.console();
        char[]password=console.readPassword("Contraseña: ");
        if(user.equals("admi")&&(String.valueOf(password)).equals("123")){
            limpiaPantalla ();
            System.out.println("Bienvenido");
            opcionPrivado();

        }else {
            limpiaPantalla ();
            AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("Contraseña o Usuario incorrecto"));
            accesoPrivado ();
        }
    }
    public static void opcionPrivado()throws IOException,InterruptedException{
    logo();
    AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
    System.out.println("1- Busqueda de Vecino");
    System.out.println("2- Listar Pasajeros");
    System.out.println("3- Registrar nuevos buses");
    System.out.println("4- Promedio de edades en adultos mayores");
    System.out.println("5- Promediar de edades de Miembros del club de ecologia sin obsequio");
    System.out.println("6- Obsequios de Vecinos");
    System.out.println("7- Asientos disponibles");
    System.out.println("8- Listar vecinos");
    System.out.println("9- Regresar\n");
    System.out.println ("══════════════════════════════");
    AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.BLUE    ).a("Ingrese una opcion"));
    int opcion=sc.nextInt();
    limpiaPantalla ();
       switch(opcion){
           case 1:
                  logo();
                  AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                  System.out.print("Ingrese el numero de DNI del pasajero buscado:     ");
                  String dniBuscado=sc.next();
                  System.out.println ("");
                  controlador.mostrarDatosDeVecinoBuscado (dniBuscado);
                  continuar ();
                  limpiaPantalla ();
                  opcionPrivado ();
                  break;
           case 2:
               logo ();
               AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
               System.out.print("Ingrese fecha de busqueda xx/xx/xxxx :");
               String fechaBuscada=sc.next ();
               System.out.print("Ingrese el numero de bus             :");
               int numeroDeBusBuscado=sc.nextInt ();
               System.out.println("\n");
               controlador.mostrarPasajerosPorFechaYhora (fechaBuscada,numeroDeBusBuscado);
               continuar ();
               limpiaPantalla ();
               opcionPrivado ();
                  break;
           case 3:
                  logo ();
                  int numero=sanBorja.getListaDeBuses ().size ()+1;
                  AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                  System.out.print("Ingrese la hora en punto de partida     : ");
                  sc.nextLine ();
                  String hora=sc.nextLine();
                  System.out.print ("Ingrese el nombre del chofer asignado   : ");
                  String chofer=sc.nextLine();
                  System.out.print("Ingrese el nombre del copiloto asignado : ");
                  String copiloto=sc.nextLine ();
                  controlador.resgistrarBus (numero,hora,chofer,copiloto);
                   continuar ();
                   limpiaPantalla ();
                   opcionPrivado ();
               break;
           case 4:
                  logo ();
                  AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                  controlador.promedioDeAdultosMayores ();
                  continuar ();
                  limpiaPantalla ();
                  opcionPrivado ();
                  break;
           case 5:
                  logo ();
                  AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                  controlador.promedioDeClubEcologia ();
                  continuar ();
                  limpiaPantalla ();
                  opcionPrivado ();
                  break;
           case 6:

               logo ();
               AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
               System.out.println ("Vecinos que obtuvieron un premio!!!\n\n");
               controlador.mostrarPasajerosConPremio ();
               continuar ();
               limpiaPantalla ();
               opcionPrivado ();
               break;
           case 7:
               logo ();
               AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
               System.out.println ("Asientos disponibles");
               System.out.println ("====================\n");
               controlador.mostrarAsientosDisponiblesPorBus ();
               continuar ();
               limpiaPantalla ();
               opcionPrivado ();
               break;
           case 8:
               logo();
               AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
               cargando2 ();
               limpiaPantalla ();
               logo ();
               AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
               controlador.mostrarBaseDeDatosDeVecinos ();
               continuar ();
               limpiaPantalla ();
               opcionPrivado ();
           case 9:
               limpiaPantalla ();
               menuPrincipal ();
               break;
           default:
               AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.RED    ).a("Opcion incorrecta !!"));
               opcionPrivado ();
       }

    }
    public static void opcionReserva()throws IOException,InterruptedException{

        logo ();
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
        System.out.println ("Bienvenido a la reserva de asientos!!\n\n");
        System.out.print ("Por favor ingresar su Dni:   ");
        String dni=sc.next ();
        if(sanBorja.validarExistencia (dni)) {
            limpiaPantalla ();
            logo ();
            AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
            System.out.println ("Lista de Buses Disponibles");
            System.out.println ("==========================");
            System.out.println ("\nBienvenido,actualmente contamos con los siguientes buses a su diponibilidad\n");
            sanBorja.listarDatosBus ();
            AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
            System.out.print ("Elija un numero de bus  ");
            int opcion = sc.nextInt ();
            limpiaPantalla ();
            logo ();
            Bus bus = sanBorja.obtenerBus (opcion);
            if (bus != null) {
                AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                System.out.println ("RESERVA DE ASIENTOS");
                System.out.println ("====================\n\n");
                String[][] mm = bus.getCuadroDeAsientos ();
                AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.GREEN    ));
                Bus.mostrarCuadroDeAsientos (mm);
                AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.WHITE    ).a ("\nO = Asientos disponibles\nX = Asientos ocupados"));
                AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                System.out.print ("\n\nIngrese su asiento de reserva ejemplo (B2) :  ");
                String coordenada = sc.next ();
                int numeroDeAsiento = bus.obtenerNumeroDeAsiento (coordenada);
                try {
                    bus.registrarAsiento (numeroDeAsiento);
                } catch (Exception e) {
                    System.out.println (e.getMessage ());
                    continuar ();
                    limpiaPantalla ();
                    opcionReserva ();
                }

                System.out.print ("Ingrese la fecha de su reservacion         :  ");
                String fechaDeReserva = sc.next ();
                int i = sanBorja.getListaDeReservaciones ().size () + 1;
                sanBorja.generarReserva (i, fechaDeReserva);
                sanBorja.asignarDatosAReserva (i, dni, opcion, numeroDeAsiento);
                limpiaPantalla ();
                logo ();
                AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                System.out.println ("Su reservacion ah sido generada con exito\n\n\n");
                AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.GREEN    ));
                sanBorja.listarDatosdeReserva (i);
                AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
                System.out.println ("\n\nGracias por usar nuestros servicios\n");
                continuar ();
                limpiaPantalla ();
                menuPrincipal ();
            } else {
                System.out.println ("\nNo hay informacion disponible!!");
                continuar ();
                limpiaPantalla ();
                menuPrincipal ();
            }
        }else{
            System.out.println ("\nUsuario no registrado");
            continuar ();
            limpiaPantalla ();
            menuPrincipal ();
        }

    }
    public static void opcionConsultaReserva()throws  IOException,InterruptedException{
      logo ();
      AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.CYAN    ));
      System.out.print ("Ingresa el numero de tu reservacion : ");
      int numeroDeReserva=sc.nextInt ();
        System.out.println ("\n");
        AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.GREEN   ));
      sanBorja.listarDatosdeReserva (numeroDeReserva);
      continuar ();
      limpiaPantalla ();
      menuPrincipal ();
    }


}