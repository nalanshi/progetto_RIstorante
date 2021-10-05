package main;

import com.sun.org.apache.xpath.internal.operations.Neg;
import model.Clienti;
import model.Negozio;
import model.Produttore;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.sound.midi.Soundbank;
import java.util.concurrent.Semaphore;

/**
 * @author Oniichan
 * @data 05/10/2021
 * @project ProgettoTps
 */
public class Main {
    public static void main(String[] args) {
        Semaphore produttore = new Semaphore(1);
        Semaphore consumatore = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        Negozio negozio = new Negozio(50);
        Clienti cliente = new Clienti(produttore,consumatore,mutex,"Marin",negozio);
        Produttore produttore1 = new Produttore(produttore,consumatore,mutex,"Davide",negozio);


        new Thread(cliente).start();
        new Thread(produttore1).start();
    }
}
