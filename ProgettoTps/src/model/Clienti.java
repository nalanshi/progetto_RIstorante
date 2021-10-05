package model;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Oniichan
 * @data 05/10/2021
 * @project ProgettoTps
 */
public class Clienti implements Runnable{
    String nome;
    Semaphore produttore;
    Semaphore consumatore;
    Semaphore mutex;
    Negozio negozio;
    public Clienti(Semaphore p,Semaphore c , Semaphore m,String n,Negozio ne){
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
                consumatore.acquire();
                mutex.acquire();
            } catch (InterruptedException e) {
            }
            int qty = ThreadLocalRandom.current().nextInt(5) + 1;
            String response = negozio.buyPro(qty);
            System.out.println(nome + " : " + response);
            mutex.release();
            produttore.release();
        }
    }
}
