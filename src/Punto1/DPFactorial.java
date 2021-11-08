package Punto1;

import java.util.ArrayList;

public class DPFactorial {
    private ArrayList<Integer> calculated;

    public DPFactorial(){
        calculated = new ArrayList<>();
        calculated.add(1);
        calculated.add(1);
        calculated.add(2);

    }
    public int factorial(int num){

        if(num==0)
            return calculated.get(num);
        if(num<calculated.size()-1)
            return calculated.get(num);

        int temp;
        for(int i = calculated.size()-1; i<num; i++){
            calculated.add(calculated.get(i)*(i+1));
        }
        return calculated.get(num);

    }
}
