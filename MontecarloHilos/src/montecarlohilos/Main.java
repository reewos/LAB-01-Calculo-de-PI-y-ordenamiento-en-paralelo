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
public class Main {
      public static void main(String[] args) {
        // TODO code application logic here
       
        /*long inicio = System.nanoTime();
        MontecarloHilos obj = new MontecarloHilos(2,(int)1e6);
        System.out.println("numero pi " + obj.Generar_PI());
        long fin = System.nanoTime();
        float tiempo = (float) ((fin - inicio)/1e6);
        System.out.println(tiempo +" mili segundos");
        */
        
        
        //codigo en sec
         Random number = new Random();
         long inicio = System.nanoTime();
        MontecarloSec obj = new MontecarloSec(number,(int)1e6);
        System.out.println("numero pi " + obj.calcular_pi());
        long fin = System.nanoTime();
        float tiempo = (float) ((fin - inicio)/1e6);
        System.out.println(tiempo +" mili segundos");
        
    }
}
