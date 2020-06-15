/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento_paralelo;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class Ordenamiento_paralelo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int max_num = 5000000;
        int min_num = 1;        
        int tam_array = 100000;
        
        int[] numeros = new int[tam_array];       

        for(int i=0;i<tam_array;i++){
            numeros[i] = (int) (Math.random()*(max_num-min_num))+min_num;
        }
        
        //System.out.println(Arrays.toString(numeros));
        
        
        
        quicksort a = new quicksort(numeros,0,tam_array-1);

        //
        long start = System.nanoTime();
        a.qsort(0, tam_array-1);
        //System.out.printf("Tiempo QS: %d || Tamaño: %d\n", System.nanoTime() - start, tam_array);
        System.out.printf("%d\t%d\n", System.nanoTime() - start, tam_array);
        
        //System.out.println(Arrays.toString(a.get_array()));

        
    }
    
}
