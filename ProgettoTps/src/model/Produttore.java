package model;

import sun.awt.Mutex;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Oniichan
 * @data 05/10/2021
 * @project ProgettoTps
 */
public class Produttore implements Runnable{
    String nome;
    Semaphore produttore;
    Semaphore consumatore;
    Semaphore mutex;
    Negozio negozio;
    public Produttore(Semaphore p,Semaphore c ,Semaphore m ,String n ,Negozio ne){
        produttore = p;
        consumatore = c;
        mutex = m;
        nome = n;
        negozio = ne;
    }
    @Override
    public void run() {
            while(true){
                try {
                    produttore.acquire();
                    mutex.acquire();
                } catch (InterruptedException e) {
                }
                int qty = ThreadLocalRandom.current().nextInt(8) + 1;
                String result = negozio.chargePro(qty);
                try {
                    System.out.println(nome + " : To be continued...........");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                System.out.println(nome + " : " + result);
                mutex.release();
                consumatore.release();
            }
    }
}
