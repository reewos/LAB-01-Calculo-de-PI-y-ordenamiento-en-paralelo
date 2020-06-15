/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlohilos;

/**
 *
 * @author user
 */
public class Main {
      public static void main(String[] args) {
        // TODO code application logic here
     
        MontecarloHilos obj = new MontecarloHilos(4,(int)1e7);
        System.out.println("numero pi " + obj.Generar_PI());
     
    }
}
