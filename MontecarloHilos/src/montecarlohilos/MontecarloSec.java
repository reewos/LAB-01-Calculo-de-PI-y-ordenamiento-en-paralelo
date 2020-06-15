/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlohilos;

import java.util.Random;

/**
 *
 * @author user
 */
public class MontecarloSec {
    private Random valRandom = null;
    private long cantidadT = 0;
    private long cantidadIn = 0;
    
    public MontecarloSec(Random valRandom,long cantidadT) {
        this.valRandom = valRandom;
        this.cantidadT =cantidadT;
        
    }
    private double dist_radio_vector(double valx,double valy){
       double expr = valx*valx + valy*valy;
        return Math.sqrt(expr);
    }
   public double calcular_pi(){
         long count = 0;
        while(count< cantidadT){
            double x = valRandom.nextDouble();
            double y = valRandom.nextDouble();
            if (dist_radio_vector(x, y) <= 1) {
                cantidadIn +=1;
            }
            count +=1;
        }
        return 4*cantidadIn/cantidadT;
    }
}
