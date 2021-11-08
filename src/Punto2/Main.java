package Punto2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carguero co;

        co = new Carguero(700);

        Container[] containers = new Container[]{new Container("C1",100),new Container("C2",155), new Container("C3",50),new Container("C4",112),
                new Container("C5",70),new Container("C6",80),new Container("C7",60), new Container("C8",118), new Container("C9",110),
                new Container("C10",55)};


        MergeSort sort = new MergeSort();
        sort.sort(containers, 0, containers.length-1);

        System.out.println(Arrays.toString(containers));

       

    }
}
