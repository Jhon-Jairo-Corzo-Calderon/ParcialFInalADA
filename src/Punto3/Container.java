package Punto3;

public class Container {
    private int peso;
    private String name;

    public Container(String name, int peso){
        this.peso = peso;
        this.name = name;
    }

    public int getPeso() {
        return peso;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return "| Container#" + name + ", peso: " + peso +" |";
    }
}
