package Punto3;

import java.util.ArrayList;

public class Carguero {
    private int capCarga;
    private int lsContainer;
    private ArrayList<Object[]> carga;

    public Carguero(int capCarga){
        this.capCarga = capCarga;
        this.carga = new  ArrayList<Object[]>();
        lsContainer = 0;
    }

    public int getCapCarga() {
        return capCarga;
    }
    public ArrayList<Object[]> getCarga(){
        return carga;
    }

    public int getCantContainer(){
        return carga.size();
    }

    public void addContainer(Container cr, int cant){
        carga.add(new Object[]{cant,cr});
    }

    public String stringCarga(){
        String output = "Contenedores cargados: \n";
        for (Object[] ob: carga) {
            if((int) ob[0]!=0)
                output += ob[0] + " contenedores de #" + (((Container) ob[1]).getName()) +" y peso "+ (((Container) ob[1]).getPeso()) +".\n";
        }
        return output;
    }
}
