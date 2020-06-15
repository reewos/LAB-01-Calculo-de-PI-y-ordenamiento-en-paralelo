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
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MontecarloHilos {

  
    private int cantidad_threads = 0;
    private int cantidad_random = 0;
    private LinkedList<HiloGenerarRandom> list_threads;
    private ExecutorService executor_threads;
    
    public MontecarloHilos( int cantidad_threads, int cantidad_random){
        this.cantidad_threads = cantidad_threads;
        this.cantidad_random = cantidad_random;
        list_threads = new LinkedList();
        executor_threads = Executors.newFixedThreadPool(cantidad_threads);
        init_threads();
       
        
    }
    public void init_threads(){
        Random number = new Random();
       int  count = 0;
       while(count <cantidad_threads){
           list_threads.add(new HiloGenerarRandom(number,cantidad_random/cantidad_threads));
           count +=1;
       }
        
    }
    
    public void init_total(){
        for(HiloGenerarRandom h : list_threads){
            executor_threads.execute(h);
        }
        executor_threads.shutdown();
    }
    
    public double Generar_PI(){
        init_total();
        long total_in_c =0;
        long total_random= 0;
        while(!executor_threads.isTerminated());
        for(HiloGenerarRandom h : list_threads){
                total_in_c +=h.get_cantidaIn();
                total_random+=h.get_cantidadT();
            }
        return 4.0*total_in_c / total_random; 
    }
    
   
    
}
