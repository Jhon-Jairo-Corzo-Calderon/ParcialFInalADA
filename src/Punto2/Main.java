package Punto2;

public class Main {
    public static void main(String[] args) {

        Carguero co;
        co = new Carguero(700);

        Container[] containers = new Container[]{new Container("C1",100),new Container("C2",155), new Container("C3",50),new Container("C4",112),
                new Container("C5",70),new Container("C6",80),new Container("C7",60), new Container("C8",118), new Container("C9",110),
                new Container("C10",55)};


        MergeSort.sort(containers, 0, containers.length-1);

        containers = reverseArr(containers);

        maxCarga(co,containers);
        System.out.println("---Carga maxima para el carguero---");
        System.out.println(co.stringCarga());
    }

    public static void maxCarga(Carguero co, Container[] cr){
        int cap = co.getCapCarga();
        int i = 0;
        Container temp;
        boolean loop = true;
        int cant;

        while(i<= cr.length-1){
            temp = cr[i];
            cant = cap/temp.getPeso();
            cap -= cant*temp.getPeso();
            i++;

            co.addContainer(new Container(temp.getName(),temp.getPeso()),cant);
        }
    }

    public static Container[] reverseArr(Container[] cr){
        int len = cr.length;
        Container[] b = new Container[len];
        int j = len;
        for (int i = 0; i < len; i++) {
            b[j - 1] = cr[i];
            j = j - 1;
        }

        return b;
    }
}
