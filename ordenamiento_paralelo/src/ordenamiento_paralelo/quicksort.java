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
public class quicksort extends Thread{
    
    private static int array[];
    private final int inicio, fin;
    private final int hilos_totales = Runtime.getRuntime().availableProcessors();
    private static int hilos_usados = 0;
    
    private synchronized static void aumenta_hilo(int n) { 
        hilos_usados += n; 
    }

    private synchronized static void disminuye_hilo(int n) {
        hilos_usados -= n; 
    }

    private synchronized boolean hay_hilos_disponibles() {
        return hilos_usados < hilos_totales;
    }
    
    public int[] get_array (){
        return array;
    }
    
    public void cambio(int a, int b){
        int temp = array[a]; 
        array[a] = array[b]; 
        array[b] = temp; 
    }
    
    public quicksort(int numeros[], int inicio, int fin){
        this.array = numeros;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    int particion(int ini, int fin) 
    { 
        int pivot = array[ini];
        
        cambio(ini,fin);
        int i = (ini);
        
        for (int j=ini; j<fin; j++) 
        { 
            if (array[j] <= pivot) 
            {
                cambio(i,j);
                i++;
            } 
        } 
 
        int temp = array[i]; 
        array[i] = array[fin]; 
        array[fin] = temp; 
  
        return i; 
    } 
  
    void qsort(int ini, int fin) 
    { 
        if (ini < fin) 
        { 
            int k = particion(ini, fin);
            
            if(hay_hilos_disponibles()){
                aumenta_hilo(1);
                new quicksort(array, ini, k-1).start();
                disminuye_hilo(1);
            }else{
                qsort(ini, k-1); 
                //System.out.println(Arrays.toString(get_array())+" , "+ini+" , "+(k-1));
            }
            
            if(hay_hilos_disponibles()){
                aumenta_hilo(1);
                new quicksort(array, k+1, fin).start();
                disminuye_hilo(1);
            }else{
                qsort(k+1, fin);
                //System.out.println(Arrays.toString(get_array())+" , "+(k+1)+" , "+fin);
            }
        } 
    }
    
    void qsort_simple(int ini, int fin) 
    { 
        if (ini < fin) 
        { 
            int k = particion(ini, fin);
            qsort_simple(ini, k-1); 
            //System.out.println(Arrays.toString(get_array())+" , "+ini+" , "+(k-1));
            qsort_simple(k+1, fin);
            //System.out.println(Arrays.toString(get_array())+" , "+(k+1)+" , "+fin);
            
        } 
    }
    
    @Override
    public void run() {
        qsort(inicio,fin);
    }
    
}
