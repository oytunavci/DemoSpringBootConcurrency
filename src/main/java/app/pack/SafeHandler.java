package app.pack;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SafeHandler{


    private HashSet<Integer> safesBeingCalculated = new HashSet<>();




    public synchronized void calculate(SafeDeposit safe, Person person)
    {
        System.out.println(Thread.currentThread().getId()+"\t in SafeHandler safe: " + safe.getId()+" person: "+person.getName()+" set: " +safesBeingCalculated);

        while(safesBeingCalculated.contains(safe.getId()))
        {
            try {
                System.out.println(Thread.currentThread().getId()+"\t "+ safe.getId()+" is already being calculated " + safesBeingCalculated);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        safesBeingCalculated.add(safe.getId());

        System.out.println(Thread.currentThread().getId()+"\t in calculation for safe: " + safe.getId()+" person: "+person.getName()+" set: " +safesBeingCalculated);
        //lock
        Double total=0.0;
        total = total + safe.getUSD();
        safe.setUSD(0.0);
        total = total + safe.getEUR()*(0.9);
        safe.setEUR(0.0);
        total = total + safe.getGBP()*(1.1);
        safe.setGBP(0.0);
        total = total + safe.getGOLD()*(50);
        safe.setGOLD(0.0);


        person.setTotalAssetInUSD(total);

        safesBeingCalculated.remove(safe.getId());

        //unlock

    }



}
