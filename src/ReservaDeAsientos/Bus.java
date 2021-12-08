package ReservaDeAsientos;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    private String chofer;
    private String copiloto;
    private int numero_de_bus;
    private String hora_de_partida;
    private List<Asiento>listaDeAsientos;
    private String[][]cuadroDeAsientos;

    public Bus (int numero_de_bus, String hora_de_partida,String nombre_de_chofer,String nombre_de_copiloto) {
        this.numero_de_bus = numero_de_bus;
        this.hora_de_partida = hora_de_partida;
        this.chofer =nombre_de_chofer;
        this.copiloto =nombre_de_copiloto;
        this.listaDeAsientos = new ArrayList<> (40);
        this.cuadroDeAsientos=generarCuadroDeAsientos ();
    }
    public void validarHora()throws Exception{
       String[]parts=hora_de_partida.split (":");
       int hora=Integer.parseInt (parts[0]);
       if(hora>15||hora<9)throw new Exception ("\n\nlos horarios de circulacion son de 9:00 am a 15:00pm,Ingrese un horario valido");

    }
    public void registrarAsiento(int numero)throws Exception{
        boolean existe = registroDeNumerosDeAsiento ().contains (numero);
        if(existe) throw new Exception("Asiento ya reservado");
        else {
            Asiento asiento = new Asiento (numero);
            this.listaDeAsientos.add (asiento);
        }
    }
    public List<Integer> registroDeNumerosDeAsiento (){
        List<Integer>numeros=new ArrayList<>(40);
        for(Asiento asiento:this.listaDeAsientos){
            numeros.add(asiento.getNumeroDeAsiento ());
        }
        return numeros;
    }
    public Asiento obtenerAsiento(int numero){
        for(Asiento a:listaDeAsientos){
            if(a.getNumeroDeAsiento ()==numero){
                return a;
            }
        }return null;
    }
    public String [][] generarCuadroDeAsientos(){
        String [][] matriz=new String[11][5];
        for(int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++ ) {
                matriz[i][j]="O";
            }
        }
        matriz[0][0]=" ";
        matriz[1][0]="A";
        matriz[2][0]="B";
        matriz[3][0]="C";
        matriz[4][0]="D";
        matriz[5][0]="E";
        matriz[6][0]="F";
        matriz[7][0]="G";
        matriz[8][0]="H";
        matriz[9][0]="I";
        matriz[10][0]="J";
        matriz[0][1]="1";
        matriz[0][2]="2";
        matriz[0][3]="3";
        matriz[0][4]="4";
        return matriz;
    }
    public int obtenerNumeroDeAsiento(String coordenadas){
        String letra=coordenadas.substring(0,1).toUpperCase();
        int x=Integer.parseInt(coordenadas.substring(1));
        int y;
        switch(letra){
            case "A"->y=1;
            case "B"->y=2;
            case "C"->y=3;
            case "D"->y=4;
            case "E"->y=5;
            case "F"->y=6;
            case "G"->y=7;
            case "H"->y=8;
            case "I"->y=9;
            case "J"->y=10;
            default->y=0;
        }
        this.cuadroDeAsientos[y][x]="X";
        int a=(y-4+y);
        int b=(y*2+x)+a;
        return b;

    }
    public static void mostrarCuadroDeAsientos (String [][] matriz){
        for(int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++ ) {
                System.out.print("   "+matriz[i][j]);
            }
            System.out.println("");
        }}
    public int asientosDisponibles(){
        return 40-listaDeAsientos.size ();
    }
    public int getNumero_de_bus () {
        return numero_de_bus;
    }
    public String getHora_de_partida () {
        return hora_de_partida;
    }
    public List<Asiento> getListaDeAsientos () {
        return listaDeAsientos;
    }
    public String getChofer () {
        return chofer;
    }
    public String getCopiloto () {
        return copiloto;
    }
    public String[][] getCuadroDeAsientos () {
        return cuadroDeAsientos;
    }


}
